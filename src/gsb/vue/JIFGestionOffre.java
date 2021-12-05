package gsb.vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JIFGestionOffre extends JInternalFrame implements ActionListener {
    protected JPanel p;
    protected MenuPrincipal fenetreContainer;

    protected JLabel JLreference;
    protected JTextField JTreference;

    protected String reference;

    public JIFGestionOffre(MenuPrincipal uneFenetreContainer, String reference){
        fenetreContainer = uneFenetreContainer;
        this.reference = reference;

        p = new JPanel();

        JLreference = new JLabel("Reference");
        JTreference = new JTextField(reference);
        JTreference.setEditable(false);
        p.add(JLreference);
        p.add(JTreference);

        Container contentPane = getContentPane();
        contentPane.add(p);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
