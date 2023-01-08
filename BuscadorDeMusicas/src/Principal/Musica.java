package Principal;

import java.util.Objects;

public class Musica {
	private Genero genero;
	private String artista;
	private String nome;
	private String link;

	public Musica(Genero genero, String artista, String nome, String link) {
		this.genero = genero;
		this.artista = artista;
		this.nome = nome;
		this.link = link;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtist(String artista) {
		this.artista = artista;
	}

	public String getNome() {
		return nome;
	}

	public void setName(String nome) {
		this.nome = nome;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public int hashCode() {
		return Objects.hash(artista, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Musica other = (Musica) obj;
		return Objects.equals(artista, other.artista) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Genero: " + getGenero() + " Artista: " + getArtista() + " Nome: " + getNome();
	}
}
