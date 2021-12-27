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

	protected Visite visite;
	
	public JIFVisiteModif(MenuPrincipal fenetreContainer, Visite visite) {
		
		p = new JPanel(new GridLayout(7, 1));

		this.fenetreContainer = fenetreContainer;

		this.visite = visite;

		JLreference = new JLabel("Référence");
		p.add(JLreference);
		JTreference = new JTextField(visite.getReference());
		JTreference.setEditable(false);
		p.add(JTreference);

		JLdate = new JLabel("Date Visite");
		p.add(JLdate);
		JTdate = new JTextField(visite.getDate());
		JTdate.setEditable(false);
		p.add(JTdate);

		JLcommentaire = new JLabel("Commentaire");
		p.add(JLcommentaire);
		JTcommentaire = new JTextField(visite.getCommentaire());
		p.add(JTcommentaire);

		JLmatricule = new JLabel("Matricule");
		p.add(JLmatricule);
		JTmatricule = new JTextField(visite.getVisiteur().getMatricule());
		JTmatricule.setEditable(false);
		p.add(JTmatricule);

		JLcode = new JLabel("Code");
		p.add(JLcode);
		JTcode = new JTextField(visite.getMedecin().getCodeMed());
		JTcode.setEditable(false);
		p.add(JTcode);
		
		JBvalide = new JButton("Valider");
		JBvalide.addActionListener(this);
		p.add(JBvalide);

		Container contentPane = getContentPane();
		contentPane.add(p);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == JBvalide) {
			visite.setCommentaire(JTcommentaire.getText());
			
			VisiteDao.modifierVisite(visite);
			
			fenetreContainer.ouvrirFenetre(new JIFVisiteCons(fenetreContainer, visite));
		}
	}
}
