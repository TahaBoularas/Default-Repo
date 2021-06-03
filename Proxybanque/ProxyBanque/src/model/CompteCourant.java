package model;

import java.util.Date;

public class CompteCourant extends Compte {
	private float autorisationDecouvert;

	public CompteCourant() {
		
		this.autorisationDecouvert=1000;
	}
	
	
		
	public float getAutorisationDecouvert() {
		return autorisationDecouvert;
	}
	public void setAutorisationDecouvert(float autorisationDecouvert) {
		this.autorisationDecouvert = autorisationDecouvert;
	}
}
