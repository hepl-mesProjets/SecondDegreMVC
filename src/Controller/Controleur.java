package Controller;

import Model.SecondDegre;
import View.JDialogNouvelleEquation;
import View.JFrameSecondDegre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur implements ActionListener
{
    public Controleur(SecondDegre secondDegre, JFrameSecondDegre fenetre) {
        this.secondDegre = secondDegre;
        this.fenetre = fenetre;
    }

    private SecondDegre secondDegre;
    private JFrameSecondDegre fenetre;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Nouvelle équation...")
        {
            JDialogNouvelleEquation dialog = new JDialogNouvelleEquation();
            dialog.setVisible(true);
            if (dialog.isOk())
            {
                secondDegre.setA(dialog.getA());
                secondDegre.setB(dialog.getB());
                secondDegre.setC(dialog.getC());
            }
        }
    }
}
