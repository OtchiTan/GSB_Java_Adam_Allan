package gsb.tests;

import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.VisiteDao;
import gsb.modele.dao.VisiteurDao;

import static org.junit.jupiter.api.Assertions.*;

class VisiteDaoTest {

    private Visite visite;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Medecin medecin = MedecinDao.rechercher("m001");
        Visiteur visiteur = VisiteurDao.rechercher("a131");
        visite = new Visite("v0026","2021-12-27","",medecin,visiteur);
    }

    @org.junit.jupiter.api.Test
    void creer() {
        assertEquals(1, VisiteDao.creer(visite));
    }

    @org.junit.jupiter.api.Test
    void rechercher() {
        assertEquals(visite.getReference(),VisiteDao.rechercher("v0026").getReference());
    }

    @org.junit.jupiter.api.Test
    void retournerLesVisites() {
        assertEquals(25,VisiteDao.retournerLesVisites().size());
    }

    @org.junit.jupiter.api.Test
    void modifierVisite() {
        visite.setCommentaire("Test");
        assertEquals(1,VisiteDao.modifierVisite(visite));
    }

    @org.junit.jupiter.api.Test
    void rechercherParVisiteur() {
        assertEquals(2,VisiteDao.rechercherParVisiteur("a131").size());
    }

    @org.junit.jupiter.api.Test
    void rechercherParDate() {
        assertEquals(1,VisiteDao.rechercherParDate("2021-12-27").size());
    }
}