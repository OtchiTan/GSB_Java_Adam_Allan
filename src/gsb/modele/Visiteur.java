package gsb.modele;

public class Visiteur {
	protected String matricule;
	protected String nom;
	protected String prenom;
	protected String login;
	protected String mdp;
	protected String adresse;
	protected Localite uneLocalite;
	protected String dateEntree;
	protected String codeUnite;
	protected String nomUnite;

	/**
	 *
	 * @param matricule
	 * @param nom
	 * @param prenom
	 * @param login
	 * @param mdp
	 * @param adresse
	 * @param uneLocalite
	 * @param dateEntree
	 * @param codeUnite
	 * @param nomUnite
	 */
	public Visiteur(String matricule, String nom, String prenom, String login, String mdp, String adresse,
			Localite uneLocalite, String dateEntree, String codeUnite, String nomUnite) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.mdp = mdp;
		this.adresse = adresse;
		this.uneLocalite = uneLocalite;
		this.dateEntree = dateEntree;
		this.codeUnite = codeUnite;
		this.nomUnite = nomUnite;
	}

	/**
	 *
	 * @return
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 *
	 * @param matricule
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**
	 *
	 * @return
	 */
	public String getNom() {
		return nom;
	}

	/**
	 *
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 *
	 * @return
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 *
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 *
	 * @return
	 */
	public String getLogin() {
		return login;
	}

	/**
	 *
	 * @param login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 *
	 * @return
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 *
	 * @param mdp
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 *
	 * @return
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 *
	 * @param adresse
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 *
	 * @return
	 */
	public Localite getUneLocalite() {
		return uneLocalite;
	}

	/**
	 *
	 * @param uneLocalite
	 */
	public void setUneLocalite(Localite uneLocalite) {
		this.uneLocalite = uneLocalite;
	}

	/**
	 *
	 * @return
	 */
	public String getDateEntree() {
		return dateEntree;
	}

	/**
	 *
	 * @param dateEntree
	 */
	public void setDateEntree(String dateEntree) {
		this.dateEntree = dateEntree;
	}

	/**
	 *
	 * @return
	 */
	public String getCodeUnite() {
		return codeUnite;
	}

	/**
	 *
	 * @param codeUnite
	 */
	public void setCodeUnite(String codeUnite) {
		this.codeUnite = codeUnite;
	}

	/**
	 *
	 * @return
	 */
	public String getNomUnite() {
		return nomUnite;
	}

	/**
	 *
	 * @param nomUnite
	 */
	public void setNomUnite(String nomUnite) {
		this.nomUnite = nomUnite;
	}
}
