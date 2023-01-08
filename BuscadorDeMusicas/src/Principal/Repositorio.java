package Principal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Repositorio {
	ArrayList<Musica> listaDeMusicas;

	public void LerArquivo() throws FileNotFoundException {
		FileInputStream Arquivo = new FileInputStream(new File("src\\Principal\\myLib\\musicas.txt"));
		Scanner leitor = new Scanner(Arquivo, "UTF-8");
		List<String> linhas = new ArrayList<String>();
		while (leitor.hasNext()) {
			String linha = leitor.nextLine();
			if(linha!=null && !linha.isBlank()) {
				linhas.add(leitor.nextLine());
			}
		}
		leitor.close();
	}
	
}