package gsb.modele;

public class Medicament {
	protected String medDepotLegal;
	protected String nomCommercial;
	protected String medComposition;
	protected String medEffets;
	protected float medPrixEchantillon;
	protected String famCode;
	protected String famLibelle;

	/**
	 * @param medDepotLegal
	 * @param nomCommercial
	 * @param medComposition
	 * @param medEffets
	 * @param medPrixEchantillon
	 * @param famCode
	 * @param famLibelle
	 */

	public Medicament(String medDepotLegal, String nomCommercial, String medComposition, String medEffets,
			float medPrixEchantillon, String famCode, String famLibelle) {
		this.medDepotLegal = medDepotLegal;
		this.nomCommercial = nomCommercial;
		this.medComposition = medComposition;
		this.medEffets = medEffets;
		this.medPrixEchantillon = medPrixEchantillon;
		this.famCode = famCode;
		this.famLibelle = famLibelle;
	}

	/**
	 *
	 * @return
	 */
	public String getMedDepotLegal() {
		return medDepotLegal;
	}

	/**
	 *
	 * @param medDepotLegal
	 */
	public void setMedDepotLegal(String medDepotLegal) {
		this.medDepotLegal = medDepotLegal;
	}

	/**
	 *
	 * @return
	 */
	public String getNomCommercial() {
		return nomCommercial;
	}

	/**
	 *
	 * @param nomCommercial
	 */
	public void setNomCommercial(String nomCommercial) {
		this.nomCommercial = nomCommercial;
	}

	/**
	 *
	 * @return
	 */
	public String getMedComposition() {
		return medComposition;
	}

	/**
	 *
	 * @param medComposition
	 */
	public void setMedComposition(String medComposition) {
		this.medComposition = medComposition;
	}

	/**
	 *
	 * @return
	 */
	public String getMedEffets() {
		return medEffets;
	}

	/**
	 *
	 * @param medEffets
	 */
	public void setMedEffets(String medEffets) {
		this.medEffets = medEffets;
	}

	/**
	 *
	 * @return
	 */
	public float getMedPrixEchantillon() {
		return medPrixEchantillon;
	}

	/**
	 *
	 * @param medPrixEchantillon
	 */
	public void setMedPrixEchantillon(float medPrixEchantillon) {
		this.medPrixEchantillon = medPrixEchantillon;
	}

	/**
	 *
	 * @return
	 */
	public String getFamCode() {
		return famCode;
	}

	/**
	 *
	 * @param famCode
	 */
	public void setFamCode(String famCode) {
		this.famCode = famCode;
	}

	/**
	 *
	 * @return
	 */
	public String getFamLibelle() {
		return famLibelle;
	}

	/**
	 *
	 * @param famLibelle
	 */
	public void setFamLibelle(String famLibelle) {
		this.famLibelle = famLibelle;
	}

}