package Principal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Repositorio {
	private Map<String, Musica> musicas = new HashMap<String, Musica>();

	public void lerArquivo() throws FileNotFoundException {
		FileInputStream Arquivo = new FileInputStream(new File("src\\Principal\\files\\musicas.txt"));
		ArrayList<String> linhas = new ArrayList<String>();
		Scanner leitor = new Scanner(Arquivo, "UTF-8");
		while (leitor.hasNext()) {
			String l = leitor.nextLine();
			if (l != null && !l.isEmpty()) {
				linhas.add(l);
			}
		}
		leitor.close();
		addMusicas(linhas);
	}

	private void addMusicas(ArrayList<String> linhas) {
		Genero genero = Genero.Unknown;
		for (String linha : linhas) {
			char primeiraLetra = linha.charAt(0);
			char ultimaLetra = linha.charAt(linha.length() - 1);
			if (linha.contains("https")) {
				String[] arrayLinha = linha.split(";");
				String artista = arrayLinha[0].trim();
				String nome = arrayLinha[1].trim();
				String link = arrayLinha[2].trim();
				Musica musica = new Musica(genero, artista, nome, link);
				musicas.put(artista + nome, musica);
			} else if (primeiraLetra == 'ç' && ultimaLetra == 'ç') {
				String generoString = linha.replaceAll("ç", "").trim();
				System.out.println(generoString);
				
				genero = retornaGenero(generoString);
			}
		}
	}

	public void tocar() {
		Tocador tocador = new Tocador();
		for (Musica musica : musicas.values()) {
			System.out.println(musica);
			tocador.tocarMusica(musica);
		}
			
	}

	private Genero retornaGenero(String genero) {
		if (genero.equals("Ambience"))
			return Genero.Ambience;
		if (genero.equals("Dreamcore"))
			return Genero.Dreamcore;
		if (genero.equals("Epic"))
			return Genero.Epic;
		if (genero.equals("ElectronicOrDance"))
			return Genero.ElectronicOrDance;
		if (genero.equals("HipHop"))
			return Genero.HipHop;
		if (genero.equals("IndiePop"))
			return Genero.IndiePop;
		if (genero.equals("IndieOrAltRock"))
			return Genero.IndieOrAltRock;
		if (genero.equals("JazzOrBlack"))
			return Genero.JazzOrBlack;
		if (genero.equals("JRock"))
			return Genero.JRock;
		if (genero.equals("LoFi"))
			return Genero.LoFi;
		if (genero.equals("Metal"))
			return Genero.Metal;
		if (genero.equals("Phonk"))
			return Genero.Phonk;
		if (genero.equals("Poop"))
			return Genero.Poop;
		if (genero.equals("Pop"))
			return Genero.Pop;
		if (genero.equals("Rock"))
			return Genero.Rock;
		if (genero.equals("ShoegazeOrChill"))
			return Genero.ShoegazeOrChill;
		if (genero.equals("SadBoy"))
			return Genero.SadBoy;
		if (genero.equals("Vaporwave"))
			return Genero.Vaporwave;
		if (genero.equals("Weirdcore"))
			return Genero.Weirdcore;
		return Genero.Unknown;
	}

}