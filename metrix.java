public class metrix{
    public static void main(String[] args) {

        int[][] matrix1 = {
            {6, 2, 3},
            {4, 5, 7},
            {7, 5, 9}
        };

        int[][] matrix2 = {
            {9, 2, 7},
            {6, 5, 4},
            {3, 4, 1}
        };

        int[][] resultMatrix = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        System.out.println("The sum of the matrices is:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
