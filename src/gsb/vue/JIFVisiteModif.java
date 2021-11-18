package gsb.vue;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class JIFVisiteModif extends JIFVisiteCons {
	protected JButton JBmodif;

	public JIFVisiteModif(MenuPrincipal fenetreContainer) {
		super(fenetreContainer, "");
		JBmodif = new JButton("Modifier");
		JBmodif.addActionListener(this);

		p.add(JBmodif);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == JBmodif) {
			fenetreContainer.ouvrirFenetre(new JIFVisiteCons(fenetreContainer, ""));
		}
	}
}
