package Controller;

import Model.SecondDegre;
import View.IViewSecondDegre;
import View.JDialogNouvelleEquation;

import javax.swing.*;
import java.awt.event.*;

public class Controleur extends WindowAdapter implements ActionListener
{
    private SecondDegre secondDegre;
    private IViewSecondDegre viewSecondDegre;

    public Controleur(SecondDegre secondDegre, IViewSecondDegre viewSecondSegre) {
        this.secondDegre = secondDegre;
        this.viewSecondDegre = viewSecondSegre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == ActionSecondDegre.NOUVELLE_EQUATION)
            onNouvelleEquation();

        if (e.getActionCommand().equals(ActionSecondDegre.QUITTER))
            onQuitter();

        if (e.getActionCommand().equals(ActionSecondDegre.RESET))
            onReset();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        onQuitter();
    }

    private void onQuitter()
    {
        int ret = JOptionPane.showConfirmDialog(null,"Êtes-vous certain de vouloir quitter ?");
        if (ret == JOptionPane.YES_OPTION)
            System.exit(0);
    }

    private void onNouvelleEquation()
    {
        viewSecondDegre.reset();
        JDialogNouvelleEquation dialog = new JDialogNouvelleEquation();
        dialog.setVisible(true);
        if (dialog.isOk())
        {
            secondDegre.setA(dialog.getA());
            secondDegre.setB(dialog.getB());
            secondDegre.setC(dialog.getC());

            secondDegre.resoudre();

            viewSecondDegre.setABC(secondDegre.getA(),secondDegre.getB(),secondDegre.getC());
            if (secondDegre.getNbRacines() == 2)
                viewSecondDegre.setDeuxSolutions(secondDegre.getRacines()[0], secondDegre.getRacines()[1]);
            if (secondDegre.getNbRacines() == 1)
                viewSecondDegre.setUneSolution(secondDegre.getRacines()[0]);
            if (secondDegre.getNbRacines() == 0)
                viewSecondDegre.setZeroSolution();
        }
    }

    private void onReset()
    {
        viewSecondDegre.reset();
    }
}
