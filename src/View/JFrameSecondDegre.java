package View;

import Controller.ActionSecondDegre;
import Controller.Controleur;

import javax.swing.*;
import java.awt.*;

public class JFrameSecondDegre extends JFrame implements IViewSecondDegre
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
    private JButton buttonNouvelleEquation;
    private JButton buttonReset;
    private JButton buttonQuitter;
    private JMenuItem menuItemNouvelleEquation;
    private JMenuItem menuItemQuitter;
    private JMenuItem menuItemReset;


    public JFrameSecondDegre()
    {
        super();
        setContentPane(mainPanel);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Résolution de l'équation du second degré");

        buttonReset.setText(ActionSecondDegre.RESET);
        buttonQuitter.setText(ActionSecondDegre.QUITTER);
        buttonNouvelleEquation.setText(ActionSecondDegre.NOUVELLE_EQUATION);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu menu = new JMenu("Résoudre");
        menuBar.add(menu);
        menuItemNouvelleEquation = new JMenuItem(ActionSecondDegre.NOUVELLE_EQUATION);
        menu.add(menuItemNouvelleEquation);
        menuItemReset = new JMenuItem(ActionSecondDegre.RESET);
        menu.add(menuItemReset);
        menu.addSeparator();
        menuItemQuitter = new JMenuItem(ActionSecondDegre.RESET);
        menu.add(menuItemQuitter);

        setSize(800,500);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2);
    }

    public void setControleur(Controleur c)
    {
        menuItemNouvelleEquation.addActionListener(c);
        menuItemQuitter.addActionListener(c);
        menuItemReset.addActionListener(c);

        buttonNouvelleEquation.addActionListener(c);
        buttonQuitter.addActionListener(c);
        buttonReset.addActionListener(c);

        this.addWindowListener(c);
    }

    @Override
    public void setABC(double a, double b, double c)
    {
        textFieldA.setText(String.valueOf(a));
        textFieldB.setText(String.valueOf(b));
        textFieldC.setText(String.valueOf(c));
    }

    @Override
    public void setUneSolution(double x)
    {
        panelUneSolution.setBackground(Color.green);
        textFieldX.setText(String.valueOf(x));
    }

    @Override
    public void setDeuxSolutions(double x1, double x2)
    {
        panelDeuxSolutions.setBackground(Color.green);
        textFieldX1.setText(String.valueOf(x1));
        textFieldX2.setText(String.valueOf(x2));
    }

    @Override
    public void setZeroSolution()
    {
        panelZeroSolution.setBackground(Color.green);
    }

    @Override
    public void reset()
    {
        Color c = new Color (236,236,236);
        panelZeroSolution.setBackground(c);
        panelUneSolution.setBackground(c);
        panelDeuxSolutions.setBackground(c);
        textFieldX.setText("");
        textFieldX1.setText("");
        textFieldX2.setText("");
        textFieldA.setText("");
        textFieldB.setText("");
        textFieldC.setText("");
    }

    public static void main(String[] args) {
        JFrameSecondDegre frame = new JFrameSecondDegre();
        frame.setVisible(true);
    }
}
