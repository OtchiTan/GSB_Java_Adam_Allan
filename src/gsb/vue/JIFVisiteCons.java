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
	protected JButton JBoffres;

	protected Visite visite;

	/**
	 *
	 * @param uneFenetreContainer
	 * @param visite
	 */
	public JIFVisiteCons(MenuPrincipal uneFenetreContainer, Visite visite) {

		p = new JPanel(new GridLayout(7, 1));

		fenetreContainer = uneFenetreContainer;

		this.visite = visite;

		JLreference = new JLabel("R�f�rence");
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
		JTcommentaire.setEditable(false);
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

		JBoffres = new JButton("Offres");
		JBoffres.addActionListener(this);
		p.add(JBoffres);

		JBmodif = new JButton("Modifier");
		JBmodif.addActionListener(this);
		p.add(JBmodif);

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
		if (source == JBmodif) {
			fenetreContainer.ouvrirFenetre(new JIFVisiteModif(fenetreContainer, visite));
		} else if (source == JBoffres) {
			fenetreContainer.ouvrirFenetre(new JIFGestionOffre(fenetreContainer, visite));
		}
	}

}
