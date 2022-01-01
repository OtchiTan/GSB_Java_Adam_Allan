
package gsb.tests;

import gsb.modele.Medicament;
import gsb.service.MedicamentService;

public class MedicamentTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Medicament unMedicament = MedicamentService.rechercherMedicament("3MYC7");
		System.out.println(unMedicament.getMedDepotLegal());
		System.out.println(unMedicament.getNomCommercial());
		System.out.println(unMedicament.getMedComposition());
		System.out.println(unMedicament.getMedEffets());
		System.out.println(unMedicament.getMedPrixEchantillon());
		System.out.println(unMedicament.getFamCode());
		System.out.println(unMedicament.getFamLibelle());

	}

}