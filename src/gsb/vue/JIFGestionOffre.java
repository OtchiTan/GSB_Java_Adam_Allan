package gsb.vue;

import gsb.modele.Medicament;
import gsb.modele.Offrir;
import gsb.modele.Visite;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.OffrirDao;
import gsb.modele.dao.VisiteDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JIFGestionOffre extends JInternalFrame implements ActionListener {
    protected JPanel p;
    protected JPanel JPButtons;
    protected JPanel JPAjout;

    protected MenuPrincipal fenetreContainer;

    protected JLabel JLreference;
    protected JLabel JLdepot;
    protected JLabel JLquantite;


    protected JTextField JTreference;
    protected JComboBox JCBdepot;
    protected JTextField JTquantite;

    protected JButton JBannuler;
    protected JButton JBmodifier;
    protected JButton JBajouter;

    protected JTable JTliste;

    protected Offrir[] offrirs;

    protected Visite visite;

    /**
     *
     * @param uneFenetreContainer
     * @param visite
     */
    public JIFGestionOffre(MenuPrincipal uneFenetreContainer, Visite visite) {

        fenetreContainer = uneFenetreContainer;

        p = new JPanel();

        this.visite = visite;

        JLreference = new JLabel("Reference");
        JTreference = new JTextField(visite.getReference());
        JTreference.setEditable(false);
        p.add(JLreference);
        p.add(JTreference);

        JPAjout = new JPanel(new GridLayout(1,3));

        JLdepot = new JLabel("Depot légal");
        JPAjout.add(JLdepot);
        ArrayList<Medicament> medicaments = MedicamentDao.retournerCollectionDesMedicaments();
        String[] lesDepots = new String[medicaments.size()];
        for (int i = 0; i < medicaments.size(); i++) {
            lesDepots[i] = medicaments.get(i).getMedDepotLegal();
        }
        JCBdepot = new JComboBox(lesDepots);
        JPAjout.add(JCBdepot);

        JLquantite = new JLabel("Quantite");
        JPAjout.add(JLquantite);
        JTquantite = new JTextField();
        JPAjout.add(JTquantite);

        JBajouter = new JButton("Ajouter");
        JBajouter.addActionListener(this);
        JPAjout.add(JBajouter);

        p.add(JPAjout);

        offrirs = OffrirDao.rertournerOffre(visite.getReference());
        String[] columnsName = {"Depot Legal", "Quantite"};
        String[][] lignes = new String[2][2];

        if (offrirs[0] != null) {
            lignes[0][0] = offrirs[0].getUnMedicament().getMedDepotLegal();
            lignes[0][1] = String.valueOf(offrirs[0].getQteOfferte());
        }
        if (offrirs[1] != null) {
            lignes[1][0] = offrirs[1].getUnMedicament().getMedDepotLegal();
            lignes[1][1] = String.valueOf(offrirs[1].getQteOfferte());
        }

        JTliste = new JTable(lignes, columnsName);
        JTliste.getSelectionModel().addListSelectionListener(JTliste);

        p.add(JTliste);

        JPButtons = new JPanel();

        JBannuler = new JButton("Annuler");
        JBannuler.addActionListener(this);
        JPButtons.add(JBannuler);
        JBmodifier = new JButton("Modifier");
        JBmodifier.addActionListener(this);
        JPButtons.add(JBmodifier);

        p.add(JPButtons);

        Container contentPane = getContentPane();
        contentPane.add(p);
    }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == JBannuler) {
            fenetreContainer.ouvrirFenetre(new JIFVisiteCons(fenetreContainer, visite));
        } else if (source == JBajouter) {
            Medicament medicament = MedicamentDao.rechercher(JCBdepot.getSelectedItem().toString());
            Offrir offre = new Offrir(medicament,visite,Integer.valueOf(JTquantite.getText()));

            OffrirDao.creer(offre);
            fenetreContainer.ouvrirFenetre(new JIFVisiteCons(fenetreContainer,visite));
        } else if (source == JBmodifier) {
            if (validOffre(0)) {
                String referenceUne = JTliste.getValueAt(0, 0).toString();
                Medicament medicamentUn = MedicamentDao.rechercher(referenceUne);
                int quantiteUne = Integer.valueOf(JTliste.getValueAt(0, 1).toString());
                Offrir offreUne = new Offrir(medicamentUn, visite, quantiteUne);

                OffrirDao.modifier(offreUne);
            }

            if (validOffre(1)) {
                String referenceDeux = JTliste.getValueAt(1, 0).toString();
                Medicament medicamentDeux = MedicamentDao.rechercher(referenceDeux);
                int quantiteDeux = Integer.valueOf(JTliste.getValueAt(1, 1).toString());
                Offrir offreDeux = new Offrir(medicamentDeux, visite, quantiteDeux);

                OffrirDao.modifier(offreDeux);
            }

            fenetreContainer.ouvrirFenetre(new JIFVisiteCons(fenetreContainer, visite));
        }
    }

    /**
     *
     * @param rowNumber
     * @return
     */
    private boolean validOffre ( int rowNumber){
        if (JTliste.getValueAt(rowNumber, 0) == null) return false;
        if (JTliste.getValueAt(rowNumber, 1) == null) return false;
        return true;
    }
}

