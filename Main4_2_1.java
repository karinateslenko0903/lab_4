import java.lang.Math;
public class Main4_2_1 {
    public static double f(double x) {
        return 1.5 * Math.pow(x, 5) - 3 * x * Math.cos(Math.pow(x, 2)) - 3;
    }


    public static double fDerivative(double x) {
        return 7.5 * Math.pow(x, 4) - 3 * Math.cos(Math.pow(x, 2)) + 6 * x * x * Math.sin(Math.pow(x, 2));
    }

    public static void main(String[] args) {
        double epsilon = 1e-6;
        double x0 = -12;
        double x1;


        if (f(-12) * f(15) > 0) {
            System.out.println("На интервале [-12, 15] может отсутствовать корень или их несколько.");
            return;
        }

        while (true) {

            x1 = x0 - f(x0) / fDerivative(x0);


            if (Math.abs(x1 - x0) < epsilon) {
                break;
            }

            x0 = x1;
        }


        System.out.println("Найденный корень: " + x1);
    }
}