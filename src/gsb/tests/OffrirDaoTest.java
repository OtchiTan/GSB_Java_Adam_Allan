package gsb.tests;

import gsb.modele.Medicament;
import gsb.modele.Offrir;
import gsb.modele.Visite;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.OffrirDao;
import gsb.modele.dao.VisiteDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OffrirDaoTest {

    protected Offrir offrir;

    @BeforeEach
    void setUp() {
        Medicament medicament = MedicamentDao.rechercher("AMOX45");
        Visite visite = VisiteDao.rechercher("v0026");
        offrir = new Offrir(medicament, visite, 2);
    }

    @Test
    void creer() {
        assertEquals(1, OffrirDao.creer(offrir));
    }

    @Test
    void rertournerOffre() {
        //assertEquals(1,OffrirDao.rertournerOffre("v0026"));
    }

    @Test
    void modifier() {
        offrir.setQteOfferte(5);
        assertEquals(1,OffrirDao.modifier(offrir));
    }
}