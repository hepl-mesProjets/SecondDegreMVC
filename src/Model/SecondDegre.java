package Model;

public class SecondDegre
{
    private double a;
    private double b;
    private double c;
    private int nbRacines;
    private double[] racines;

    private static final double EPSILON = 0.0000001;
    private static SecondDegre instance = null;

    private SecondDegre()
    {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.nbRacines = 0;
        this.racines = null;
    }

    public static SecondDegre getInstance()
    {
        if (instance == null)
            instance = new SecondDegre();
        return instance;
    }

    public void resoudre()
    {
        double delta = b*b - 4*a*c;
        if (estNegatif(delta))
        {
            nbRacines = 0;
            racines = null;
            return;
        }
        if (estNul(delta))
        {
            nbRacines = 1;
            racines = new double[1];
            racines[0] = -b/(2*a);
            return;
        }
        if (estPositif(delta))
        {
            nbRacines = 2;
            racines = new double[2];
            racines[0] = (-b-Math.sqrt(delta))/(2.0*a);
            racines[1] = (-b+Math.sqrt(delta))/(2.0*a);
        }
    }

    private boolean estNul(double val)
    {
        if (Math.abs(val) < EPSILON) return true;
        return false;
    }

    private boolean estPositif(double val)
    {
        if (val >= EPSILON) return true;
        return false;
    }

    private boolean estNegatif(double val)
    {
        if (val <= -EPSILON) return true;
        return false;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public int getNbRacines() {
        return nbRacines;
    }

    public double[] getRacines() {
        return racines;
    }

    public static void main(String[] args) {
        SecondDegre secondDegre = new SecondDegre();
        secondDegre.setA(1.0);
        secondDegre.setB(-5.0);
        secondDegre.setC(6.0);
        secondDegre.resoudre();
        if (secondDegre.getNbRacines() == 0)
            System.out.println("Pas de solution...");
        if (secondDegre.getNbRacines() == 1)
            System.out.println("1 solution :" + secondDegre.getRacines()[0]);
        if (secondDegre.getNbRacines() == 2)
            System.out.println("2 solutions :" + secondDegre.getRacines()[0] + " " + secondDegre.getRacines()[1]);
    }
}
