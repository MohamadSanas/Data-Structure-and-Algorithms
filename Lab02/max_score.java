import java.util.Scanner;

public class max_score {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the number of questions and number of queries:");
        
        int N = input.nextInt();  // number of questions
        int Q = input.nextInt();  // number of queries (not used yet)

        // time to complete each question
        int[] T = new int[N];
        for (int i = 0; i < N; i++) {
            T[i] = input.nextInt();
        }

        // total score for each question
        int[] S = new int[N];
        for (int i = 0; i < N; i++) {
            S[i] = input.nextInt();
        }

        // 0th row: score per minute, 1st row: question index
        Double[][] scorPerMnt = new Double[2][N];
        for (int i = 0; i < N; i++) {
            scorPerMnt[0][i] = (double)S[i] / T[i];
            scorPerMnt[1][i] = (double)i;
        }

        // sort and print
        sort_array(scorPerMnt);
    }

    public static void sort_array(Double[][] numbers) {
        int N = numbers[0].length;

        // Bubble sort based on score per minute
        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j > i; j--) {
                if (numbers[0][j] > numbers[0][j - 1]) {
                    // swap scores
                    Double temp = numbers[0][j];
                    numbers[0][j] = numbers[0][j - 1];
                    numbers[0][j - 1] = temp;

                    // swap indices
                    Double ind = numbers[1][j];
                    numbers[1][j] = numbers[1][j - 1];
                    numbers[1][j - 1] = ind;
                }
            }
        }

        // print the sorted array
        System.out.println("Sorted by score per minute (descending):");
        for (int i = 0; i < numbers[0].length; i++) {
            System.out.println("Question " + numbers[1][i] + ": " + numbers[0][i] + " pts/min");
        }
    }
}
