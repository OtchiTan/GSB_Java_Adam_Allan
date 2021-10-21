package gsb.vue;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import gsb.modele.Medecin;

public class JIFVisiteListe extends JInternalFrame implements ActionListener {

	protected JPanel p;
	protected JPanel pInputs;
	protected JPanel pList;
	protected JPanel pButtons;
	
	protected JLabel JLcode;
	protected JLabel JLdate;
	protected JLabel JLreference;
	
	protected JTextField JTcode;
	protected JTextField JTdate;
	protected JTextField JTreference;
	protected MenuPrincipal fenetreContainer;
	
	protected JButton JBvisite;
	protected JTable JTliste;
	
	public JIFVisiteListe(MenuPrincipal uneFenetreContainer) {
		
		fenetreContainer = uneFenetreContainer;
		
		p = new JPanel(new GridLayout(3,1));
		pInputs = new JPanel(new GridLayout(2,2));
		p.add(pInputs);
		pList = new JPanel(new GridLayout(1,1));
		p.add(pList);
		pButtons = new JPanel(new GridLayout(1,3));
		p.add(pButtons);
		
		JLcode = new JLabel("Code visiteur");
		pInputs.add(JLcode);
		JTcode = new JTextField();
		pInputs.add(JTcode);

		JLdate = new JLabel("Date visite");
		pInputs.add(JLdate);
		JTdate = new JTextField();
		pInputs.add(JTdate);
		
		String[][] lignes = new String[2][3];
		lignes[0][0] = "Test";
		lignes[0][1] = "Test";
		lignes[0][2] = "Test";
		String[] columnsName = {"Référence","Code medecin","Lieu"};
		JTliste = new JTable(lignes,columnsName);
		JTliste.getSelectionModel().addListSelectionListener(JTliste);
		
		JScrollPane scrollPane = new JScrollPane(JTliste);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		
		pList.add(scrollPane);
				
		JLreference = new JLabel("Reference");
		pButtons.add(JLreference);
		JTreference = new JTextField();
		pButtons.add(JTreference);
		JBvisite = new JButton("Visite détaillée");
		JBvisite.addActionListener(this);
		pButtons.add(JBvisite);

		Container contentPane = getContentPane();
		contentPane.add(p);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
   		if (source == JBvisite){
   			fenetreContainer.ouvrirFenetre(new JIFVisiteCons(fenetreContainer));
   		}
	}

}
