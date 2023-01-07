package Principal;

//import java.util.Scanner;

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

	public void tocarMusica(String musicaUrl) {
		navegador.get(musicaUrl);
		checarAnuncio();
		String playCsspath = "#movie_player > div.ytp-cued-thumbnail-overlay > button";
		Object play = null;
		try {
			play = navegador.findElement(By.cssSelector(playCsspath));
			WebElement playElement = (WebElement) play;
			playElement.click();
		} catch (Exception e) {
			System.out.println("NÃO PEGOU O PLAY DA MUSICA" + e);
		}
		esperar(contadorMusica());

	}

	private void checarAnuncio() {
//		ArrayList<WebElement> anunciosPulavel = (ArrayList<WebElement>) navegador
//				.findElements(By.className("ytp-ad-text ytp-ad-skip-button-text"));
//		ArrayList<WebElement> anunciosPreview = (ArrayList<WebElement>) navegador
//				.findElements(By.className("ytp-ad-text ytp-ad-preview-text"));

		// n aceitou classe composta

		ArrayList<WebElement> anunciosPulavel = (ArrayList<WebElement>) navegador
				.findElements(By.className("ytp-ad-skip-button-text"));
		ArrayList<WebElement> anunciosPreview = (ArrayList<WebElement>) navegador
				.findElements(By.className("yytp-ad-preview-text"));
		for (int i = 0; i < 2; i++) {
			esperar(1000);
			for (WebElement elementoEsperavel : anunciosPreview) {
				try {
					System.out.println(elementoEsperavel.getAttribute("innerHTML"));
					String duracaoString = elementoEsperavel.getAttribute("innerHTML");
					int milesimos = Integer.parseInt(duracaoString);
					esperar(milesimos);
				} catch (Exception e) {
					System.out.println("NÃO PEGOU A DURACAO DO ANUNCIO" + e);
				}
			}
			for (WebElement elementoPulavel : anunciosPulavel) {
				try {
					System.out.println(elementoPulavel);
					elementoPulavel.click();
				} catch (Exception e) {
					System.out.println("NÃO PEGOU O BOTAO DO ANUNCIO" + e);
				}
			}
		}
	}

	private int contadorMusica() {
		ArrayList<WebElement> duracoes = (ArrayList<WebElement>) navegador
				.findElements(By.className("ytp-time-duration"));
		for (WebElement elemento : duracoes) {
			try {
				System.out.println(elemento.getAttribute("innerHTML"));
				if (elemento.getAttribute("innerHTML") != null) {
					String duracaoString = elemento.getAttribute("innerHTML");
					String[] arrayValores = duracaoString.split(":");
					int milesimos = Integer.parseInt(arrayValores[0]) * 1000 * 60
							+ Integer.parseInt(arrayValores[1]) * 1000;
					return 10000;
				}
			}catch(Exception e){
				System.out.println("Contador Musica não pego: "+ e);
			
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
