package gsb.service;

import gsb.modele.Offrir;
import gsb.modele.dao.OffrirDao;
import gsb.modele.dao.VisiteDao;

public class OffrirService {
    /**
     *
     * @param offre
     * @return
     */
    public static int creer(Offrir offre) {
        int result = 0;
        try {
            if (offre.getQteOfferte() <= 0 || offre.getUneVisite() == null || offre.getUnMedicament() == null) {
                throw new Exception("Paramètre de l'offre invalid");
            }
            result = OffrirDao.creer(offre);
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
    public static Offrir[] rertournerOffre(String reference) {
        Offrir[] offrirs = new Offrir[2];
        try {
            if (reference == null) {
                throw new Exception("Reference offre invalide");
            }
            if (VisiteDao.rechercher(reference) == null) {
                throw new Exception("L'offre n'existe pas");
            }
            offrirs = OffrirDao.rertournerOffre(reference);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return offrirs;
    }

    /**
     *
     * @param offre
     * @return
     */
    public static int modifier(Offrir offre) {
        int result = 0;
        try {
            if (offre.getQteOfferte() <= 0 || offre.getUneVisite() == null || offre.getUnMedicament() == null) {
                throw new Exception("Paramètre de l'offre invalid");
            }
            result = OffrirDao.modifier(offre);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
