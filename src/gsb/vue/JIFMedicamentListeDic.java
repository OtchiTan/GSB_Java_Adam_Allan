package gsb.vue;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;
import gsb.service.MedicamentService;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;


public class JIFMedicamentListeDic extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	// private ArrayList<Medecin> lesMedicaments;
	private HashMap<String, Medicament> diccoMedicament;

	protected JPanel p;
	protected JScrollPane scrollPane;
	protected JPanel pSaisie;
	protected JTextField JTcodeMedicament;
	protected JButton JBafficherFiche;
	protected MenuPrincipal fenetreContainer;
	protected JTable table;

	/**
	 *
	 * @param uneFenetreContainer
	 */
	public JIFMedicamentListeDic(MenuPrincipal uneFenetreContainer) {

		fenetreContainer = uneFenetreContainer;
		// récupération des données Medicament dans la collection
		// lesMedicaments = MedicamentDao.retournerCollectionDesMedicaments();

		// int nbLignes = lesMedicaments.size();
		diccoMedicament = MedicamentDao.retournerDictionnaireDesMedicaments();
		int nbLignes = diccoMedicament.size();

		p = new JPanel(); // panneau principal de la fenêtre

		int i = 0;
		String[][] data = new String[nbLignes][4];
		// for(Medicament unMedicament : lesMedicaments){

		for (Map.Entry<String, Medicament> uneEntree : diccoMedicament.entrySet()) {
			data[i][0] = uneEntree.getValue().getMedDepotLegal();
			data[i][1] = uneEntree.getValue().getNomCommercial();
			data[i][2] = uneEntree.getValue().getMedComposition();
			data[i][3] = uneEntree.getValue().getMedEffets();
			i++;
		}
		String[] columnNames = { "Dépot légal", "Nom commercial", "Composition", "Contre effets" };
		table = new JTable(data, columnNames);
		table.getSelectionModel().addListSelectionListener(table);

		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		p.add(scrollPane);

		pSaisie = new JPanel();
		JTcodeMedicament = new JTextField(20);
		JTcodeMedicament.setMaximumSize(JTcodeMedicament.getPreferredSize());
		JBafficherFiche = new JButton("Fiche Médicament détaillée");
		JBafficherFiche.addActionListener(this); // source d'évenement
		pSaisie.add(JTcodeMedicament);
		pSaisie.add(JBafficherFiche);
		p.add(pSaisie);

		// mise en forme de la fenêtre
		Container contentPane = getContentPane();
		contentPane.add(p);
	}

	/**
	 * 
	 * @param arg0
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (source == JBafficherFiche) {
			if (diccoMedicament.containsKey(JTcodeMedicament.getText())) {
				Medicament unMedicament = diccoMedicament.get(JTcodeMedicament.getText());
				fenetreContainer.ouvrirFenetre(new JIFMedicamentFiche(unMedicament));
			}
		}
		if (source == table) {
			JTcodeMedicament.setText((String) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));

		}
	}
}
