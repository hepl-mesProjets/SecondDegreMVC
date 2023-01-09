import Controller.Controleur;
import Model.SecondDegre;
import View.IViewSecondDegre;
import View.JFrameSecondDegre;
import View.JFrameSecondDegreConsole;

public class Main
{
    public static void main(String[] args) {
        SecondDegre secondDegre = SecondDegre.getInstance();
        JFrameSecondDegreConsole fenetre = new JFrameSecondDegreConsole();
        //JFrameSecondDegre fenetre = new JFrameSecondDegre();

        Controleur controleur = new Controleur(secondDegre,fenetre);
        fenetre.setControleur(controleur);

        fenetre.setVisible(true);
    }
}
