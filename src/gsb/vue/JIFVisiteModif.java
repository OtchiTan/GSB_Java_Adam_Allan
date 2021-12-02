package gsb.vue;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import gsb.modele.Medecin;
import gsb.modele.Offrir;
import gsb.modele.Visite;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.OffrirDao;
import gsb.modele.dao.VisiteDao;
import gsb.modele.dao.VisiteurDao;

public class JIFVisiteModif extends JInternalFrame implements ActionListener{
	protected JPanel p;

	protected MenuPrincipal fenetreContainer;

	protected JLabel JLreference;
	protected JLabel JLdate;
	protected JLabel JLcommentaire;
	protected JLabel JLmatricule;
	protected JLabel JLcode;

	protected JTextField JTreference;
	protected JTextField JTdate;
	protected JTextField JTcommentaire;
	protected JTextField JTmatricule;
	protected JTextField JTcode;
	
	protected JButton JBvalide;
	
	protected JTable JToffres;
	protected JPanel JPoffres;

	protected String reference;
	
	protected JTable JTstocker;

	protected ArrayList<Offrir> lesOffres;
	
	public JIFVisiteModif(MenuPrincipal fenetreContainer, String reference) {
		
		this.reference = reference;
		
		p = new JPanel(new GridLayout(7, 1));

		this.fenetreContainer = fenetreContainer;
		
		Visite uneVisite = VisiteDao.rechercher(reference);

		JLreference = new JLabel("Référence");
		p.add(JLreference);
		JTreference = new JTextField(uneVisite.getReference());
		JTreference.setEditable(false);
		p.add(JTreference);

		JLdate = new JLabel("Date Visite");
		p.add(JLdate);
		JTdate = new JTextField(uneVisite.getDate());
		JTdate.setEditable(false);
		p.add(JTdate);

		JLcommentaire = new JLabel("Commentaire");
		p.add(JLcommentaire);
		JTcommentaire = new JTextField(uneVisite.getCommentaire());
		p.add(JTcommentaire);

		JLmatricule = new JLabel("Matricule");
		p.add(JLmatricule);
		JTmatricule = new JTextField(uneVisite.getVisiteur().getMatricule());
		JTmatricule.setEditable(false);
		p.add(JTmatricule);

		JLcode = new JLabel("Code");
		p.add(JLcode);
		JTcode = new JTextField(uneVisite.getMedecin().getCodeMed());
		JTcode.setEditable(false);
		p.add(JTcode);
		
		JBvalide = new JButton("Valider");
		JBvalide.addActionListener(this);
		p.add(JBvalide);
		
		JPanel listPanel = new JPanel();
		
		lesOffres = OffrirDao.rertournerOffre(uneVisite.getReference());
		
		String[][] lignes = new String[lesOffres.size()][2];
		
		lignes[0][0] = lesOffres.get(0).getUnMedicament().getMedDepotLegal();
		lignes[0][1] = String.valueOf(lesOffres.get(0).getQteOfferte());	
		lignes[1][0] = lesOffres.get(1).getUnMedicament().getMedDepotLegal();
		lignes[1][1] = String.valueOf(lesOffres.get(1).getQteOfferte());

		String[] columnsName = {"Dépot légal","Quantité"};
		JToffres = new JTable(lignes,columnsName);
		JToffres.getSelectionModel().addListSelectionListener(JToffres);
		
		JScrollPane scrollPane = new JScrollPane(JToffres);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		
		listPanel.add(scrollPane);
		
		JPoffres = new JPanel();
		JPoffres.add(JToffres);
		p.add(JPoffres);
		p.add(JBvalide);

		Container contentPane = getContentPane();
		contentPane.add(p);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == JBvalide) {
			String reference = JTreference.getText();
			String date = JTdate.getText();
			String commentaire = JTcommentaire.getText();
			String codeMed = JTcode.getText();
			String matricule = JTmatricule.getText();
			Medecin medecin = MedecinDao.rechercher(codeMed);
			Visiteur visiteur = VisiteurDao.rechercher(matricule);
			Visite visite = new Visite(reference, date, commentaire, medecin, visiteur);
			
			VisiteDao.modifierVisite(visite);
			
			fenetreContainer.ouvrirFenetre(new JIFVisiteCons(fenetreContainer, reference));
		}
	}
}
