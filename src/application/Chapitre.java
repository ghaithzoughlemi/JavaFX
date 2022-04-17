package application;

import java.io.Serializable;

public class Chapitre implements Serializable {

	private String nom;

	public Chapitre(String nom) {
		this.nom = nom;
	}

	public Chapitre() {
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String n) {
		this.nom = n;
	}

	@Override
	public String toString() {
		return nom;
	}
}
