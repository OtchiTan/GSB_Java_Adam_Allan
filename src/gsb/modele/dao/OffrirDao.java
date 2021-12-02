package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.TreeMap;

import gsb.modele.Medicament;
import gsb.modele.Offrir;
import gsb.modele.Visite;

public class OffrirDao {
	public static int creer(Offrir offre) {
		int result = 0;
		String requeteInsertion;
		String medDepot = offre.getUnMedicament().getMedDepotLegal();
		String reference = offre.getUneVisite().getReference();
		int quantite = offre.getQteOfferte();
		requeteInsertion = "INSERT INTO `OFFRIR` (`MED_DEPOTLEGAL`, `REFERENCE`, `QUANTITE`) VALUES ('"+medDepot+"', '"+reference+"', '"+quantite+"')";
		try {
			result = ConnexionMySql.execReqMaj(requeteInsertion);
		} catch (Exception e) {
			System.out.println("echec insertion Client");
		}
		ConnexionMySql.fermerConnexionBd();
		return result;
	}

	public static ArrayList<Offrir> rertournerOffre(String reference){
		ArrayList<Offrir> lesOffres = new ArrayList<Offrir>();
		
		ResultSet reqSelection = ConnexionMySql.execReqSelection("SELECT * FROM OFFRIR WHERE REFERENCE = '"+reference+"'");
		
		try {
			while(reqSelection.next()) {
				Medicament medicament = MedicamentDao.rechercher(reqSelection.getString(1));
				Visite visite = VisiteDao.rechercher(reqSelection.getString(2));
				Offrir offre = new Offrir(medicament, visite, reqSelection.getInt(3));
				lesOffres.add(offre);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lesOffres;
	}
	
	public static int modifier(Offrir offre) {
		int result = 0;
		String requeteInsertion;
		String medDepot = offre.getUnMedicament().getMedDepotLegal();
		String reference = offre.getUneVisite().getReference();
		int quantite = offre.getQteOfferte();
		requeteInsertion = "UPDATE `OFFRIR` SET `MED_DEPOTLEGAL` = '"+medDepot+"', `QUANTITE` = '"+quantite+"' WHERE MED_DEPOTLEGAL = '3MYC7' AND REFERENCE = 'v0001'";
		try {
			result = ConnexionMySql.execReqMaj(requeteInsertion);
		} catch (Exception e) {
			System.out.println("echec insertion Client");
		}
		ConnexionMySql.fermerConnexionBd();
		return result;
	}

}
