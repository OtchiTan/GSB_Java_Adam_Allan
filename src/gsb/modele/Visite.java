package gsb.modele;

public class Visite {
	protected String reference;
	protected String date;
	protected String commentaire;
	protected Medecin Medecin;
	protected Visiteur Visiteur;
	
	public Visite(String reference, String date, String commentaire, Medecin medecin, Visiteur visiteur) {
		super();
		this.reference = reference;
		this.date = date;
		this.commentaire = commentaire;
		Medecin = medecin;
		Visiteur = visiteur;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Medecin getMedecin() {
		return Medecin;
	}

	public void setMedecin(Medecin medecin) {
		Medecin = medecin;
	}

	public Visiteur getVisiteur() {
		return Visiteur;
	}

	public void setVisiteur(Visiteur visiteur) {
		Visiteur = visiteur;
	}	
}
