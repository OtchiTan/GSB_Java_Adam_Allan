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

	protected JTable JTstocker;

	public JIFVisiteCons(MenuPrincipal uneFenetreContainer) {
		p = new JPanel(new GridLayout(6, 1));

		fenetreContainer = uneFenetreContainer;

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

		Container contentPane = getContentPane();
		contentPane.add(p);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
