package Projeto8;

public class TempoRespostaMaximoCalculator {

    public static double calculateRi(double Ci, double Ji, double[] ehpValues, double[] PjValues) {
        double Wi = Ci;
        for (int j = 0; j < ehpValues.length; j++) {
            Wi += ehpValues[j] / PjValues[j];
        }
        return Wi + Ji;
    }

    public static void main(String[] args) {
        // Exemplo de valores das variáveis
        double Ci = 1.5;
        double Ji = 5.0;
        double[] ehpValues = {0.5, 0.8, 0.3};
        double[] PjValues = {1, 2, 1};

        double Ri = calculateRi(Ci, Ji, ehpValues, PjValues);
        System.out.println("Tempo de resposta máximo: " + Ri);
    }
}