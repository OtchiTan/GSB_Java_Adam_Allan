package gsb.vue;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import gsb.modele.Visite;
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
	
	protected JTable JTstocker;

	public JIFVisiteCons(MenuPrincipal uneFenetreContainer, String reference) {
		
		this.reference = reference;
		
		p = new JPanel(new GridLayout(7, 1));

		fenetreContainer = uneFenetreContainer;
		
		Visite uneVisite = VisiteDao.rechercher(reference);

		JLreference = new JLabel("Référence");
		p.add(JLreference);
		JTreference = new JTextField(uneVisite.getReference());
		p.add(JTreference);

		JLdate = new JLabel("Date Visite");
		p.add(JLdate);
		JTdate = new JTextField(uneVisite.getDate());
		p.add(JTdate);

		JLcommentaire = new JLabel("Commentaire");
		p.add(JLcommentaire);
		JTcommentaire = new JTextField(uneVisite.getCommentaire());
		p.add(JTcommentaire);

		JLmatricule = new JLabel("Matricule");
		p.add(JLmatricule);
		JTmatricule = new JTextField(uneVisite.getVisiteur().getMatricule());
		p.add(JTmatricule);

		JLcode = new JLabel("Code");
		p.add(JLcode);
		JTcode = new JTextField(uneVisite.getMedecin().getCodeMed());
		p.add(JTcode);
		
		JBmodif = new JButton("Modifier");
		JBmodif.addActionListener(this);
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
