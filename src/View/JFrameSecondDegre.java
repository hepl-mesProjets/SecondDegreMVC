package View;

import Controller.Controleur;

import javax.swing.*;
import java.awt.*;

public class JFrameSecondDegre extends JFrame
{
    private JPanel mainPanel;
    private JPanel panelDeuxSolutions;
    private JPanel panelUneSolution;
    private JPanel panelZeroSolution;
    private JTextField textFieldA;
    private JTextField textFieldB;
    private JTextField textFieldC;
    private JTextField textFieldX1;
    private JTextField textFieldX2;
    private JTextField textFieldX;
    private JMenuItem menuItemNouvelleEquation;

    public JFrameSecondDegre()
    {
        super();
        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Résolution de l'équation du second degré");

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu menu = new JMenu("Résoudre");
        menuBar.add(menu);
        menuItemNouvelleEquation = new JMenuItem("Nouvelle équation...");
        menu.add(menuItemNouvelleEquation);
        menu.addSeparator();
        JMenuItem menuItemQuitter = new JMenuItem("Quitter");
        menu.add(menuItemQuitter);

        setSize(800,500);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2);
    }

    public void setControleur(Controleur c)
    {
        menuItemNouvelleEquation.addActionListener(c);
    }

    public static void main(String[] args) {
        JFrameSecondDegre frame = new JFrameSecondDegre();
        frame.setVisible(true);
    }
}
