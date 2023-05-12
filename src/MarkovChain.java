import java.util.Scanner

public class MarkovChain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Inserir os valores do Vetor de Probabilidade de Estado
        System.out.println("Insira os valores do Vetor de Probabilidade de Estado: ");
        double[] initialState = readArray(sc);

        // Inserir os valores da Matriz de Transição de Estado
        System.out.println("Insira os valores da Matriz de Transição de Estado: ");
        double[][] transitionMatrix = readMatrix(sc);

        // Calcular os valores de Probabilidade de Estados finais
        double[] finalState = calculateFinalState(initialState, transitionMatrix);

        // Imprimir os arrays de entrada e saída
        System.out.println("Vetor de Probabilidade de Estado: ");
        printArray(initialState);
        System.out.println("Matriz de Transição de Estado: ");
        printMatrix(transitionMatrix);
        System.out.println("Probabilidade de Estados Finais: ");
        printArray(finalState);

        sc.close();
    }

    // Método para ler um array de doubles a partir do input do usuário
    public static double[] readArray(Scanner sc) {
        String input = sc.nextLine();
        String[] stringArray = input.split(" ");
        double[] doubleArray = new double[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            doubleArray[i] = Double.parseDouble(stringArray[i]);
        }
        return doubleArray;
    }

    // Método para ler uma matriz de doubles a partir do input do usuário
    public static double[][] readMatrix(Scanner sc) {
        String input = sc.nextLine();
        String[] rows = input.split(";");
        double[][] matrix = new double[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            String[] columns = rows[i].split(" ");
            matrix[i] = new double[columns.length];
            for (int j = 0; j < columns.length; j++) {
                matrix[i][j] = Double.parseDouble(columns[j]);
            }
        }
        return matrix;
    }

    // Método para calcular os valores de Probabilidade de Estados finais
    public static double[] calculateFinalState(double[] initialState, double[][] transitionMatrix) {
        int n = transitionMatrix.length;
        double[] finalState = new double[n];
        for (int i = 0; i < n; i++) {
            double sum = 0;
            for (int j = 0; j < n; j++) {
                sum += transitionMatrix[j][i] * initialState[j];
            }
            finalState[i] = sum;
        }
        return finalState;
    }

    // Método para imprimir um array de doubles
    public static void printArray(double[] array) {
        for (double d : array) {
            System.out.print(d + " ");
        }
        System.out.println();
    }

    // Método para imprimir uma matriz de doubles
    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double d : row) {
                System.out.print(d + " ");
            }
            System.out.println();
        }
    }
}
