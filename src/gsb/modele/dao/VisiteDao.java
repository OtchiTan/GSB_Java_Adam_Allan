package gsb.modele.dao;

import java.sql.ResultSet;
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
		requeteInsertion = "insert into CLIENT values('" + reference + "','" + date + "','" + commentaire + "','"
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
				.execReqSelection("select * from CLIENT where codeClient='" + reference + "'");
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
}
