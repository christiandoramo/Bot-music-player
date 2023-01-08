package Principal;

import java.util.Objects;

public class Musica {
	private Genero genero;
	private String artist;
	private String name;
	
	public Musica(Genero genero, String artist, String name) {
		this.genero = genero;
		this.artist = artist;
		this.name = name;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(artist, genero, name);
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
		return Objects.equals(artist, other.artist) && genero == other.genero && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Musica [artist=" + artist + ", name=" + name + "]";
	}
	
	
	
	
}
