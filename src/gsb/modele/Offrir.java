package gsb.modele;

public class Offrir {
	protected Medicament unMedicament;
	protected Visite uneVisite;
	protected int qteOfferte;

	/**
	 *
	 * @param unMedicament
	 * @param uneVisite
	 * @param qteOfferte
	 */
	public Offrir(Medicament unMedicament, Visite uneVisite, int qteOfferte) {
		super();
		this.unMedicament = unMedicament;
		this.uneVisite = uneVisite;
		this.qteOfferte = qteOfferte;
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

	/**
	 *
	 * @return
	 */
	public Visite getUneVisite() {
		return uneVisite;
	}

	/**
	 *
	 * @param uneVisite
	 */
	public void setUneVisite(Visite uneVisite) {
		this.uneVisite = uneVisite;
	}

	/**
	 *
	 * @return
	 */
	public int getQteOfferte() {
		return qteOfferte;
	}

	/**
	 *
	 * @param qteOfferte
	 */
	public void setQteOfferte(int qteOfferte) {
		this.qteOfferte = qteOfferte;
	}
}
