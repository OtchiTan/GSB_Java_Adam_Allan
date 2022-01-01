package gsb.service;

import gsb.modele.Visite;
import gsb.modele.dao.VisiteDao;

import java.util.TreeMap;

public class VisiteService {
	/**
	 *
	 * @param uneVisite
	 * @return
	 */
	public static int creer(Visite uneVisite) {
		int result = 0;
		try {
			if (uneVisite.getReference() == null || uneVisite.getDate() == null || uneVisite.getCommentaire() == null
				|| uneVisite.getVisiteur()== null || uneVisite.getMedecin() == null) {
				throw new Exception("Paramètre du visiteur invalid");
			}
			if (VisiteDao.rechercher(uneVisite.getReference()) != null) {
				throw new Exception("La visite existe déjà");
			}
			result = VisiteDao.creer(uneVisite);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	/**
	 *
	 * @param reference
	 * @return
	 */
	public static Visite rechercherVisite(String reference){
		Visite uneVisite = null;
		try{
		if (reference==null) {
            throw new Exception("Donnée obligatoire : reference");
        }
		uneVisite = VisiteDao.rechercher(reference);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return uneVisite;
	}

	/**
	 *
	 * @param uneVisite
	 * @return
	 */
	public static int modifierVisite(Visite uneVisite) {
		int result = 0;
		try {
			if (uneVisite.getReference() == null || uneVisite.getDate() == null || uneVisite.getCommentaire() == null
					|| uneVisite.getVisiteur()== null || uneVisite.getMedecin() == null) {
				throw new Exception("Paramètre du visiteur invalid");
			}
			if (VisiteDao.rechercher(uneVisite.getReference()) == null) {
				throw new Exception("La visite n'existe pas");
			}
			result = VisiteDao.modifierVisite(uneVisite);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	/**
	 *
	 * @param matricule
	 * @return
	 */
	public static TreeMap<String,Visite> rechercherParVisiteur(String matricule) {
		TreeMap<String, Visite> visites = new TreeMap<String,Visite>();
		try{
			if (matricule==null) {
				throw new Exception("Donnée obligatoire : reference");
			}
			visites = VisiteDao.rechercherParVisiteur(matricule);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return visites;
	}

	/**
	 *
	 * @param date
	 * @return
	 */
	public static TreeMap<String,Visite> rechercherParDate(String date) {
		TreeMap<String, Visite> visites = new TreeMap<String,Visite>();
		try{
			if (date==null) {
				throw new Exception("Donnée obligatoire : reference");
			}
			visites = VisiteDao.rechercherParDate(date);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return visites;
	}
}
