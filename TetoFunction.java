public class TetoFunction {

    public static double teto(double x) {
        return Math.ceil(x);
    }

    public static void main(String[] args) {
        double x1 = 3.8;
        double x2 = -2.5;
        double x3 = 7;

        System.out.println("[x1] = " + teto(x1)); // Saída: [x1] = 4.0
        System.out.println("[x2] = " + teto(x2)); // Saída: [x2] = -2.0
        System.out.println("[x3] = " + teto(x3)); // Saída: [x3] = 7.0
    }
}
