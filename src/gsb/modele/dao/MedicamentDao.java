package gsb.modele.dao;

import gsb.modele.Medicament;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class MedicamentDao {
	/**
	 *
	 * @param medDepotLegal
	 * @return
	 */
	public static Medicament rechercher(String medDepotLegal) {

		Medicament unMedicament = null;
		ResultSet reqSelection = ConnexionMySql
				.execReqSelection("select * from MEDICAMENT where MED_DEPOTLEGAL ='" + medDepotLegal + "'");
		try {
			if (reqSelection.next()) {
				unMedicament = new Medicament(reqSelection.getString(1), reqSelection.getString(2),
						reqSelection.getString(3), reqSelection.getString(4), reqSelection.getFloat(6),
						reqSelection.getString(7), reqSelection.getString(8));
			}
			;
		} catch (Exception e) {
			System.out.println(
					"erreur reqSelection.next() pour la requête - select * from MEDICAMENT where MED_DEPOTLEGAL ='"
							+ medDepotLegal + "'");
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return unMedicament;
	}

	/**
	 *
	 * @return
	 */
	public static ArrayList<Medicament> retournerCollectionDesMedicaments() {
		ArrayList<Medicament> collectionDesMedicaments = new ArrayList<Medicament>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select MED_DEPOTLEGAL from MEDICAMENT");
		try {
			while (reqSelection.next()) {
				String medDepotLegal = reqSelection.getString(1);
				collectionDesMedicaments.add(MedicamentDao.rechercher(medDepotLegal));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesMedicaments()");
		}
		return collectionDesMedicaments;
	}

	/**
	 *
	 * @return
	 */
	public static HashMap<String, Medicament> retournerDictionnaireDesMedicaments() {
		HashMap<String, Medicament> diccoDesMedicaments = new HashMap<String, Medicament>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select MED_DEPOTLEGAL from MEDICAMENT");
		try {
			while (reqSelection.next()) {
				String medDepotLegal = reqSelection.getString(1);
				diccoDesMedicaments.put(medDepotLegal, MedicamentDao.rechercher(medDepotLegal));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerDiccoDesMedicaments()");
		}
		return diccoDesMedicaments;

	}
}