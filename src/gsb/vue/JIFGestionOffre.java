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

public class JIFGestionOffre extends JInternalFrame implements ActionListener {
    protected JPanel p;
    protected JPanel JPButtons;
    protected JPanel JPAjout;

    protected MenuPrincipal fenetreContainer;

    protected JLabel JLreference;
    protected JLabel JLdepot;
    protected JLabel JLquantite;


    protected JTextField JTreference;
    protected JTextField JTdepot;
    protected JTextField JTquantite;

    protected JButton JBannuler;
    protected JButton JBmodifier;

    protected JTable JTliste;

    protected Offrir[] offrirs;

    protected String reference;

    public JIFGestionOffre(MenuPrincipal uneFenetreContainer, String reference) {

        fenetreContainer = uneFenetreContainer;
        this.reference = reference;

        p = new JPanel(new GridLayout(4,1));

        JLreference = new JLabel("Reference");
        JTreference = new JTextField(reference);
        JTreference.setEditable(false);
        p.add(JLreference);
        p.add(JTreference);

        JPButtons = new JPanel();

        JBannuler = new JButton("Annuler");
        JBannuler.addActionListener(this);
        JPButtons.add(JBannuler);
        JBmodifier = new JButton("Modifier");
        JBmodifier.addActionListener(this);
        JPButtons.add(JBmodifier);

        p.add(JPButtons);

        JPAjout = new JPanel();

        JLdepot = new JLabel("Depot légal");
        JPAjout.add(JLdepot);
        JTdepot = new JTextField();
        JPAjout.add(JTdepot);

        JLquantite = new JLabel("Quantite");
        JPAjout.add(JLquantite);
        JTquantite = new JTextField();
        JPAjout.add(JTquantite);

        p.add(JPAjout);

        offrirs = OffrirDao.rertournerOffre(reference);
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

        Container contentPane = getContentPane();
        contentPane.add(p);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == JBannuler) {
            fenetreContainer.ouvrirFenetre(new JIFVisiteCons(fenetreContainer, reference));
        } else if (source == JBmodifier) {
            Visite visite = VisiteDao.rechercher(reference);

            if (validOffre(0)) {
                String referenceUne = JTliste.getValueAt(0, 0).toString();
                Medicament medicamentUn = MedicamentDao.rechercher(referenceUne);
                int quantiteUne = Integer.valueOf(JTliste.getValueAt(0, 1).toString());
                Offrir offreUne = new Offrir(medicamentUn, visite, quantiteUne);

                if (offrirs[0] == null) {
                    System.out.println("Creer");
                    OffrirDao.creer(offreUne);
                } else {
                    OffrirDao.modifier(offreUne);
                }
            }

            if (validOffre(1)) {
                String referenceDeux = JTliste.getValueAt(1, 0).toString();
                Medicament medicamentDeux = MedicamentDao.rechercher(referenceDeux);
                int quantiteDeux = Integer.valueOf(JTliste.getValueAt(1, 1).toString());
                Offrir offreDeux = new Offrir(medicamentDeux, visite, quantiteDeux);

                
                if (offrirs[1] == null) {
                    System.out.println("Creer");
                    OffrirDao.creer(offreDeux);
                } else {
                    OffrirDao.modifier(offreDeux);
                }
            }

            fenetreContainer.ouvrirFenetre(new JIFVisiteCons(fenetreContainer, reference));
        }
    }

    private boolean validOffre ( int rowNumber){
        if (JTliste.getValueAt(rowNumber, 0) == null) return false;
        if (JTliste.getValueAt(rowNumber, 1) == null) return false;
        return true;
    }
}

