package gsb.service;

import gsb.modele.Visite;
import gsb.modele.dao.VisiteDao;

public class VisiteService {
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
}
