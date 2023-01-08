package Principal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;

public class Tocador {
	private WebDriver navegador;

	public Tocador() {
		esperar(3000);
		navegador = new ChromeDriver();
	}

	public void tocarMusica(Musica musica) {
		String musicaUrl = musica.getLink();
		navegador.get(musicaUrl);
		try {
			ArrayList<WebElement> botoes = (ArrayList<WebElement>) navegador
					.findElements(By.className("ytp-large-play-button"));
			for (WebElement botao : botoes) {
				botao.click();
				System.out.println("CLICKOU NO PLAY DA MUSICA");
			}
		} catch (Exception e) {
			System.out.println("NÃO PEGOU O PLAY DA MUSICA " + e);
		}
		checarAnuncio();
		esperar(contadorMusica());
	}

	private void checarAnuncio() {
		ArrayList<WebElement> anunciosPreview = (ArrayList<WebElement>) navegador
				.findElements(By.className("ytp-ad-preview-text"));
		for (int i = 0; i < 2; i++) { // ATE 2 ANUNCIOS
			for (WebElement elementoEsperavel : anunciosPreview) {
				try {
					String duracaoString = elementoEsperavel.getAttribute("innerHTML");
					System.out.println("tempo de anuncio: " + duracaoString);
					int milesimos = Integer.parseInt(duracaoString);
					esperar(milesimos);
					System.out.println("ESPEROU TEMPO DO ANUNCIO");
					esperar(500); // tempo de animação do botão
					// antes do temporizador o botao não existe
					// botao existira apenas quando o temporizador do anuncio acabar
					ArrayList<WebElement> anunciosPulavel = (ArrayList<WebElement>) navegador
							.findElements(By.className("ytp-ad-skip-button-text"));
					for (WebElement elementoPulavel : anunciosPulavel) {
						try {
							System.out.println(elementoPulavel);
							elementoPulavel.click();
							System.out.println("PULOU ANUNCIO");
						} catch (Exception e) {
							System.out.println("NÃO PEGOU O BOTAO DO ANUNCIO" + e);
						}
					}
				} catch (Exception e) {
					System.out.println("NÃO PEGOU A DURACAO DO ANUNCIO" + e);
					System.out.println("NÃO CLICKOU NO ANUNCIO" + e);
				}
				esperar(1000); // CARREGARÁ PROXIMO ANUNCIO?? OU CARREGAMENTO DO TXT DO TEMPO DE MUSICA
			}
		}
	}

	private int contadorMusica() {
		ArrayList<WebElement> duracoes = (ArrayList<WebElement>) navegador
				.findElements(By.className("ytp-time-duration"));
		for (WebElement elemento : duracoes) {
			try {
				System.out.println(elemento.getAttribute("innerHTML"));
				String duracaoString = elemento.getAttribute("innerHTML");
				System.out.println("tempo da musica: " + duracaoString);
				String[] arrayValores = duracaoString.split(":");
				int milesimos = Integer.parseInt(arrayValores[0]) * 1000 * 60
						+ Integer.parseInt(arrayValores[1]) * 1000;
				return milesimos;
			} catch (Exception e) {
				System.out.println("Contador Musica não pego: " + e);
			}
		}
		return 0;
	}

	public void esperar(int miselesimos) {
		try {
			Thread.sleep(miselesimos);
		} catch (Exception e) {
			System.out.println("BUG EM ESPERAR" + e);
		}
	}

	public void encerrarMusicas() {
		navegador.close();
	}
}
