package model;



public class CompteEpargne extends Compte{
	private float tauxRemuneration;
	
	public CompteEpargne () {
		this.tauxRemuneration=(float) 0.03;
	}
	public float getTauxRemuneration() {
		return tauxRemuneration;
	}


	public void setTauxRemuneration(float TauxRemuneration) {
		this.tauxRemuneration = TauxRemuneration;
	}
}
