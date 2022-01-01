package gsb.modele;

public class Stocker {
	protected int qteStock;
	public Visiteur unVisiteur;
	public Medicament unMedicament;

	/**
	 *
	 * @param qteStock
	 * @param unVisiteur
	 * @param unMedicament
	 */
	public Stocker(int qteStock, Visiteur unVisiteur, Medicament unMedicament) {
		super();
		this.qteStock = qteStock;
		this.unVisiteur = unVisiteur;
		this.unMedicament = unMedicament;
	}

	/**
	 *
	 * @return
	 */
	public int getQteStock() {
		return qteStock;
	}

	/**
	 *
	 * @param qteStock
	 */
	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}

	/**
	 *
	 * @return
	 */
	public Visiteur getUnVisiteur() {
		return unVisiteur;
	}

	/**
	 *
	 * @param unVisiteur
	 */
	public void setUnVisiteur(Visiteur unVisiteur) {
		this.unVisiteur = unVisiteur;
	}

	/**
	 *
	 * @return
	 */
	public Medicament getUnMedicament() {
		return unMedicament;
	}

	/**
	 *
	 * @param unMedicament
	 */
	public void setUnMedicament(Medicament unMedicament) {
		this.unMedicament = unMedicament;
	}
}
