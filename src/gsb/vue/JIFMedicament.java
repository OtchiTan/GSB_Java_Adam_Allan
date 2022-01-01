/*
 * Cr�� le 22 mars 2012
 *
 * TODO Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
package gsb.vue;

import gsb.modele.Medicament;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JIFMedicament extends JInternalFrame {
	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	
	protected String medDepotLegal;
	protected String nomCommercial;
	protected String medComposition;
	protected String medEffets;
	protected String famCode;
	protected String famLibelle;
	
	private static final long serialVersionUID = 1L;
	protected JPanel p;

	protected JLabel JLmedDepotLegal;
	protected JLabel JLnomCommercial;
	protected JLabel JLmedComposition;
	protected JLabel JLmedEffets;
	protected JLabel JLfamCode;
	protected JLabel JLfamLibelle;
	

	protected JTextField JTmedDepotLegal;
	protected JTextField JTfamCode;
	protected JTextField JTfamLibelle;
	protected JTextField JTnomCommercial;
	protected JTextField JTmedComposition;
	protected JTextField JTmedEffets;

	/**
	 *
	 */
	public JIFMedicament() {
		p = new JPanel(new GridLayout(6,1)); // panneau principal de la fen�tre

		JLmedDepotLegal = new JLabel("D�pot l�gal");
		JLnomCommercial = new JLabel("Nom Commercial");
		JLmedComposition = new JLabel("Composition");
		JLmedEffets = new JLabel("Contre-Effets");
		JLfamCode = new JLabel("Code Famille");
		JLfamLibelle = new JLabel("Libelle");


		JTmedDepotLegal = new JTextField(20);
		JTnomCommercial = new JTextField();
		JTmedComposition = new JTextField();
		JTmedEffets = new JTextField();
		JTfamCode = new JTextField();
		JTfamLibelle = new JTextField();

		p.add(JLmedDepotLegal);
		p.add(JTmedDepotLegal);
		p.add(JLnomCommercial);
		p.add(JTnomCommercial);
		p.add(JLmedComposition);
		p.add(JTmedComposition);
		p.add(JLmedEffets);
		p.add(JTmedEffets);
		p.add(JLfamCode);
		p.add(JTfamCode);
		p.add(JLfamLibelle);
		p.add(JTfamLibelle);

		// mise en forme de la fen�tre
;
		Container contentPane = getContentPane();
		contentPane.add(p);
	}

	/**
	 *
	 * @param unMedicament
	 */
	public void remplirText(Medicament unMedicament) { // m�thode qui permet de remplir les zones de texte � partir des
													// valeurs pass�es en param�tres
		JTmedDepotLegal.setText(unMedicament.getMedDepotLegal());
		JTnomCommercial.setText(unMedicament.getNomCommercial());
		JTmedComposition.setText(unMedicament.getMedComposition());
		JTmedEffets.setText(unMedicament.getMedEffets());
		JTfamCode.setText(unMedicament.getFamCode());
		JTfamLibelle.setText(unMedicament.getFamLibelle());
	}

	/**
	 *
	 */
	public void viderText() { // m�thode qui permet de vider les zones de texte
		JTmedDepotLegal.setText("");
		JTnomCommercial.setText("");
		JTmedComposition.setText("");
		JTmedEffets.setText("");
		JTfamCode.setText("");
		JTfamLibelle.setText("");
	}

}
