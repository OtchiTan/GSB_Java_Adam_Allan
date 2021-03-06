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

public class JIFMedicamentAjout extends JInternalFrame implements ActionListener {

	protected JPanel p;

	protected JLabel JLmedDepotLegal;
	protected JLabel JLnomCommercial;
	protected JLabel JLmedEffets;
	protected JLabel JLmedprixEchantillon;
	protected JLabel JLfamCode;
	protected JLabel JLfamLibelle;

	protected JTextField JTmedDepotLegal;
	protected JTextField JTnomCommercial;
	protected JTextField JTmedEffets;
	protected JTextField JTmedprixEchantillon;
	protected JTextField JTfamCode;
	protected JTextField JTfamLibelle;
	protected JButton JBajout;

	/**
	 *
	 */
	public JIFMedicamentAjout() {
		p = new JPanel(new GridLayout(7, 1));

		JLmedDepotLegal = new JLabel("MedDepotlegal");
		p.add(JLmedDepotLegal);
		JTmedDepotLegal = new JTextField();
		p.add(JTmedDepotLegal);

		JLnomCommercial = new JLabel("Nom Commercial");
		p.add(JLnomCommercial);
		JTnomCommercial = new JTextField();
		p.add(JTnomCommercial);

		JLmedEffets = new JLabel("MedEffets");
		p.add(JLmedEffets);
		JTmedEffets = new JTextField();
		p.add(JTmedEffets);

		JLmedprixEchantillon = new JLabel("MedprixEchantillon");
		p.add(JLmedprixEchantillon);
		JTmedprixEchantillon = new JTextField();
		p.add(JTmedprixEchantillon);

		JLfamCode = new JLabel("FamCode");
		p.add(JLfamCode);
		JTfamCode = new JTextField();
		p.add(JTfamCode);

		JLfamLibelle = new JLabel("FamLibelle");
		p.add(JLfamLibelle);
		JTfamLibelle = new JTextField();
		p.add(JTfamLibelle);

		JBajout = new JButton("Ajouter");
		p.add(JBajout);

		Container contentPane = getContentPane();
		contentPane.add(p);
	}

	/**
	 *
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}