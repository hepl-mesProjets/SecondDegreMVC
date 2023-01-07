import Controller.Controleur;
import Model.SecondDegre;
import View.JFrameSecondDegre;

public class Main
{
    public static void main(String[] args) {
        SecondDegre secondDegre = new SecondDegre();
        JFrameSecondDegre fenetre = new JFrameSecondDegre();

        Controleur controleur = new Controleur(secondDegre,fenetre);
        fenetre.setControleur(controleur);

        fenetre.setVisible(true);
    }
}
