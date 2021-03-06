package gsb.service;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;

public class MedicamentService {
	/**
	 *
	 * @param medDepotLegal
	 * @return
	 */
	public static Medicament rechercherMedicament(String medDepotLegal) {
		Medicament unMedicament = null;
		try {
			if (medDepotLegal == null) {
				throw new Exception("Donn?e obligatoire : DepotLegal");
			}
			unMedicament = MedicamentDao.rechercher(medDepotLegal);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return unMedicament;
	}

}
