package gsb.modele;

public class Visite {
	protected String reference;
	protected String date;
	protected String commentaire;
	protected Medecin Medecin;
	protected Visiteur Visiteur;

	/**
	 *
	 * @param reference
	 * @param date
	 * @param commentaire
	 * @param medecin
	 * @param visiteur
	 */
	public Visite(String reference, String date, String commentaire, Medecin medecin, Visiteur visiteur) {
		super();
		this.reference = reference;
		this.date = date;
		this.commentaire = commentaire;
		Medecin = medecin;
		Visiteur = visiteur;
	}

	/**
	 *
	 * @return
	 */
	public String getReference() {
		return reference;
	}

	/**
	 *
	 * @param reference
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 *
	 * @return
	 */
	public String getDate() {
		return date;
	}

	/**
	 *
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 *
	 * @return
	 */
	public String getCommentaire() {
		return commentaire;
	}

	/**
	 *
	 * @param commentaire
	 */
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	/**
	 *
	 * @return
	 */
	public Medecin getMedecin() {
		return Medecin;
	}

	/**
	 *
	 * @param medecin
	 */
	public void setMedecin(Medecin medecin) {
		Medecin = medecin;
	}

	/**
	 *
	 * @return
	 */
	public Visiteur getVisiteur() {
		return Visiteur;
	}

	/**
	 *
	 * @param visiteur
	 */
	public void setVisiteur(Visiteur visiteur) {
		Visiteur = visiteur;
	}	
}
