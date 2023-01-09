package View;

import Controller.ActionSecondDegre;
import Controller.Controleur;

import javax.swing.*;
import java.awt.*;

public class JFrameSecondDegreConsole extends JFrame implements IViewSecondDegre
{
    private JPanel mainPanel;
    private JTextArea textArea1;
    private JButton buttonNouvelleEquation;
    private JButton buttonReset;
    private JButton buttonQuitter;

    public JFrameSecondDegreConsole()
    {
        super();
        setContentPane(mainPanel);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Résolution de l'équation du second degré");

        buttonReset.setText(ActionSecondDegre.RESET);
        buttonQuitter.setText(ActionSecondDegre.QUITTER);
        buttonNouvelleEquation.setText(ActionSecondDegre.NOUVELLE_EQUATION);

        setSize(500,300);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2);
    }

    public void setControleur(Controleur c)
    {
        buttonQuitter.addActionListener(c);
        buttonReset.addActionListener(c);
        buttonNouvelleEquation.addActionListener(c);
        this.addWindowListener(c);
    }
    public static void main(String[] args) {
        JFrameSecondDegreConsole fenetre = new JFrameSecondDegreConsole();
        fenetre.setVisible(true);
    }

    @Override
    public void setABC(double a, double b, double c) {
        String texte;
        texte = "Votre équation est : (" + a + ") x² + (" + b + ") x + (" + c + ") = 0";
        textArea1.append(texte + "\n");
    }

    @Override
    public void setUneSolution(double x) {
        String texte;
        texte = "La solution de votre équation est unique : x = " + x;
        textArea1.append(texte + "\n");
    }

    @Override
    public void setDeuxSolutions(double x1, double x2) {
        String texte;
        texte = "Les 2 solutions de votre équation sont : x1 = " + x1 + "   x2 = " + x2;
        textArea1.append(texte + "\n");
    }

    @Override
    public void setZeroSolution() {
        String texte;
        texte = "Votre équation n'a pas de solution...";
        textArea1.append(texte);
    }

    @Override
    public void reset() {
        textArea1.setText("");
    }
}
