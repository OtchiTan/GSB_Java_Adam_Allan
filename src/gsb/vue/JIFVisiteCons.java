package gsb.vue;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import gsb.modele.Offrir;
import gsb.modele.Visite;
import gsb.modele.dao.OffrirDao;
import gsb.modele.dao.VisiteDao;

public class JIFVisiteCons extends JInternalFrame implements ActionListener {
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
	
	protected JButton JBmodif;

	protected String reference;
	
	protected JTable JToffres;
	protected JPanel JPoffres;

	protected ArrayList<Offrir> lesOffres;
	
	public JIFVisiteCons(MenuPrincipal uneFenetreContainer, String reference) {
		
		this.reference = reference;
		
		p = new JPanel(new GridLayout(7, 1));

		fenetreContainer = uneFenetreContainer;
		
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
		JTcommentaire.setEditable(false);
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
		
		JBmodif = new JButton("Modifier");
		JBmodif.addActionListener(this);
		
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
		p.add(JBmodif);

		Container contentPane = getContentPane();
		contentPane.add(p);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == JBmodif) {
			fenetreContainer.ouvrirFenetre(new JIFVisiteModif(fenetreContainer, reference));
		}
	}

}
