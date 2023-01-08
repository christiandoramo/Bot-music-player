package Principal;

public class ClassePrincipal {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"src\\Principal\\myLib\\chromedriver.exe");
		String musicas[] = {
				"https://www.youtube.com/watch?v=8EQzx-OzQmU&list=PLbwbsDZRZvsQM932Jcu9pKvoOLbU5m6ei&index=5",
				"https://youtu.be/ZXcsNRNhHHY?list=PLbwbsDZRZvsQM932Jcu9pKvoOLbU5m6ei",
				"https://youtu.be/d020hcWA_Wg?list=PLbwbsDZRZvsQM932Jcu9pKvoOLbU5m6ei",
				"https://www.youtube.com/watch?v=ieW5WgeBLK8", "https://www.youtube.com/watch?v=sHaoia88RUU" };
		Tocador t = new Tocador();
		for (String musica : musicas) {
			t.tocarMusica(musica);
		}
		t.encerrarMusicas();
	}
}