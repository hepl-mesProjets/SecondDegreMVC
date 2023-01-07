package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDialogNouvelleEquation extends JDialog
{
    private JPanel mainPanel;
    private JTextField textFieldA;
    private JTextField textFieldB;
    private JTextField textFieldC;
    private JButton buttonOk;
    private JButton buttonAnnuler;

    private double a;
    private double b;
    private double c;
    private boolean ok;

    public JDialogNouvelleEquation()
    {
        super();
        setModal(true);
        setContentPane(mainPanel);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Nouvelle équation...");
        pack();
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2);

        ok = false;
        buttonAnnuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    a = Double.parseDouble(textFieldA.getText());
                }
                catch(NumberFormatException ex)
                {
                    textFieldA.setBackground(Color.ORANGE);
                    JOptionPane.showMessageDialog(null,"Paramètre a invalide !","Erreur !!!",JOptionPane.ERROR_MESSAGE);
                    textFieldA.setBackground(Color.WHITE);
                    textFieldA.setText("");
                    return;
                }
                try
                {
                    b = Double.parseDouble(textFieldB.getText());
                }
                catch(NumberFormatException ex)
                {
                    textFieldB.setBackground(Color.ORANGE);
                    JOptionPane.showMessageDialog(null,"Paramètre b invalide !","Erreur !!!",JOptionPane.ERROR_MESSAGE);
                    textFieldB.setBackground(Color.WHITE);
                    textFieldB.setText("");
                    return;
                }
                try
                {
                    c = Double.parseDouble(textFieldC.getText());
                }
                catch(NumberFormatException ex)
                {
                    textFieldC.setBackground(Color.ORANGE);
                    JOptionPane.showMessageDialog(null,"Paramètre c invalide !","Erreur !!!",JOptionPane.ERROR_MESSAGE);
                    textFieldC.setBackground(Color.WHITE);
                    textFieldC.setText("");
                    return;
                }
                ok = true;
                setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        JDialogNouvelleEquation dialog = new JDialogNouvelleEquation();
        dialog.setVisible(true);
        if (dialog.isOk())
        {
            System.out.println("a = " + dialog.getA());
            System.out.println("b = " + dialog.getB());
            System.out.println("c = " + dialog.getC());
        }
        dialog.dispose();
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public boolean isOk() {
        return ok;
    }
}
