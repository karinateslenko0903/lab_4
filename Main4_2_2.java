import java.lang.Math;

public class Main4_2_2 {

    public static double f(double x) {
        return 1.5 * Math.pow(x, 5) - 3 * x * Math.cos(Math.pow(x, 2)) - 3;
    }

    public static double fDerivative(double x) {
        return 7.5 * Math.pow(x, 4) - 3 * Math.cos(Math.pow(x, 2)) + 6 * x * x * Math.sin(Math.pow(x, 2));
    }


    public static double findCriticalPoint(double initialGuess, double epsilon) {
        double x0 = initialGuess;
        double x1;
        while (true) {

            double fDeriv = fDerivative(x0);
            double fSecondDeriv = 30 * Math.pow(x0, 3) - 12 * x0 * Math.sin(Math.pow(x0, 2)) + 12 * Math.pow(x0, 3) * Math.cos(Math.pow(x0, 2));
            if (Math.abs(fSecondDeriv) < epsilon) {
                break;
            }
            x1 = x0 - fDeriv / fSecondDeriv;
            if (Math.abs(x1 - x0) < epsilon) {
                return x1;
            }
            x0 = x1;
        }
        return x0;
    }

    public static void main(String[] args) {
        double epsilon = 1e-6;
        double intervalStart = -12;
        double intervalEnd = 15;
        double step = 0.1;

        double globalMin = Double.MAX_VALUE;
        double globalMax = -Double.MAX_VALUE;


        double fStart = f(intervalStart);
        double fEnd = f(intervalEnd);
        globalMin = Math.min(globalMin, fStart);
        globalMin = Math.min(globalMin, fEnd);
        globalMax = Math.max(globalMax, fStart);
        globalMax = Math.max(globalMax, fEnd);

        System.out.println("Поиск локальных экстремумов:");
        for (double x = intervalStart; x <= intervalEnd; x += step) {
            double criticalPoint = findCriticalPoint(x, epsilon);
            if (criticalPoint >= intervalStart && criticalPoint <= intervalEnd) {
                double fCritical = f(criticalPoint);
                globalMin = Math.min(globalMin, fCritical);
                globalMax = Math.max(globalMax, fCritical);
                System.out.printf("Критическая точка: x = %.6f, f(x) = %.6f\n", criticalPoint, fCritical);
            }
        }


        System.out.printf("Глобальный минимум: f(x) = %.6f\n", globalMin);
        System.out.printf("Глобальный максимум: f(x) = %.6f\n", globalMax);
    }
}
