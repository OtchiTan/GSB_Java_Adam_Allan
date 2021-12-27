package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.TreeMap;
import gsb.modele.Visite;

public class VisiteDao {
	public static int creer(Visite uneVisite) {
		int result = 0;
		String requeteInsertion;
		String reference = uneVisite.getReference();
		String date = uneVisite.getDate();
		String commentaire = uneVisite.getCommentaire();
		String codeMed = uneVisite.getMedecin().getCodeMed();
		String matricule = uneVisite.getVisiteur().getMatricule();
		requeteInsertion = "insert into VISITE values('" + reference + "','" + date + "','" + commentaire + "','"
				+ matricule + "','" + codeMed + "')";
		try {
			result = ConnexionMySql.execReqMaj(requeteInsertion);
		} catch (Exception e) {
			System.out.println("echec insertion Client");
		}
		ConnexionMySql.fermerConnexionBd();
		return result;
	}

	public static Visite rechercher(String reference) {
		Visite uneVisite = null;
		ResultSet reqSelection = ConnexionMySql
				.execReqSelection("select * from VISITE where REFERENCE='" + reference + "'");
		try {
			if (reqSelection.next()) {
				uneVisite = new Visite(reqSelection.getString("REFERENCE"), reqSelection.getString("DATEVISITE"),
						reqSelection.getString("COMMENTAIRE"), MedecinDao.rechercher(reqSelection.getString("CODEMED")),
						VisiteurDao.rechercher(reqSelection.getString("MATRICULE")));
			}
		} catch (Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from CLIENT where codeClient='"
					+ reference + "'");
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return uneVisite;
	}
	
	public static TreeMap<String, Visite> retournerLesVisites(){
		TreeMap<String, Visite> lesVisites = new TreeMap<String,Visite>();
		
		ResultSet reqSelection = ConnexionMySql.execReqSelection("SELECT * FROM VISITE");
		
		try {
			while(reqSelection.next()) {
				Visite uneVisite = VisiteDao.rechercher(reqSelection.getString(1));
				lesVisites.put(uneVisite.getReference(), uneVisite);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lesVisites;
	}
	
	public static int modifierVisite(Visite visite) {
		int result = 0;
		
		String requete = "UPDATE `VISITE` SET `COMMENTAIRE` = '"+visite.getCommentaire()+"' WHERE REFERENCE = '"+visite.getReference()+"'";
		
		try {
			result = ConnexionMySql.execReqMaj(requete);
		} catch (Exception e) {
			System.out.println("echec insertion Client");
		}
		ConnexionMySql.fermerConnexionBd();
		return result;
	}

	public static TreeMap<String,Visite> rechercherParVisiteur(String matricule) {
		TreeMap<String,Visite> visites = new TreeMap<String,Visite>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from VISITE where MATRICULE like '%" + matricule + "%'");
		try {
			while(reqSelection.next()) {
				Visite uneVisite = VisiteDao.rechercher(reqSelection.getString(1));
				visites.put(uneVisite.getReference(), uneVisite);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return visites;
	}

	public static TreeMap<String,Visite> rechercherParDate(String date) {
		TreeMap<String,Visite> visites = new TreeMap<String,Visite>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("SELECT * FROM VISITE WHERE DATEVISITE LIKE '%"+date+"%'");
		try {
			while(reqSelection.next()) {
				Visite uneVisite = VisiteDao.rechercher(reqSelection.getString(1));
				visites.put(uneVisite.getReference(), uneVisite);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return visites;
	}
}
