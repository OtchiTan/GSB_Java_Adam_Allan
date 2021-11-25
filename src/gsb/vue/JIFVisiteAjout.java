package gsb.vue;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.VisiteDao;
import gsb.modele.dao.VisiteurDao;

public class JIFVisiteAjout extends JInternalFrame implements ActionListener {

	protected JPanel p;

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

	protected JButton JBajout;

	public JIFVisiteAjout() {
		p = new JPanel(new GridLayout(6, 1));

		JLreference = new JLabel("Référence");
		p.add(JLreference);
		JTreference = new JTextField();
		p.add(JTreference);

		JLdate = new JLabel("Date Visite");
		p.add(JLdate);
		JTdate = new JTextField();
		p.add(JTdate);

		JLcommentaire = new JLabel("Commentaire");
		p.add(JLcommentaire);
		JTcommentaire = new JTextField();
		p.add(JTcommentaire);

		JLmatricule = new JLabel("Matricule");
		p.add(JLmatricule);
		JTmatricule = new JTextField();
		p.add(JTmatricule);

		JLcode = new JLabel("Code");
		p.add(JLcode);
		JTcode = new JTextField();
		p.add(JTcode);

		JBajout = new JButton("Ajouter");
		JBajout.addActionListener(this);
		p.add(JBajout);

		Container contentPane = getContentPane();
		contentPane.add(p);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == JBajout) {
			String reference = JTreference.getText();
			String date = JTdate.getText();
			String commentaire = JTcommentaire.getText();
			String codeMed = JTcode.getText();
			String matricule = JTmatricule.getText();
			Medecin medecin = MedecinDao.rechercher(codeMed);
			Visiteur visiteur = VisiteurDao.rechercher(matricule);
			Visite visite = new Visite(reference, date, commentaire, medecin, visiteur);
			
			VisiteDao.creer(visite);
		}

	}
}