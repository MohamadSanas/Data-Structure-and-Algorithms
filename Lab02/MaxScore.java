import java.util.Scanner;

public class MaxScore {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the number of questions and number of queries:");
        int N = input.nextInt();  // Number of questions
        int Q = input.nextInt();  // Number of queries

        int[] T = new int[N];  // Time to complete each question
        int[] S = new int[N];  // Score for each question

        for (int i = 0; i < N; i++) {
            T[i] = input.nextInt();
        }

        for (int i = 0; i < N; i++) {
            S[i] = input.nextInt();
        }

        int[] queryChoices = new int[Q];
        System.out.println("Enter the number of choices for each query:");
        for (int i = 0; i < Q; i++) {
            queryChoices[i] = input.nextInt();
        }

        // 0th row: score per minute, 1st row: time taken
        double[][] scoreTimeArray = new double[3][N];
        for (int i = 0; i < N; i++) {
            scoreTimeArray[0][i] = (double) S[i] / T[i];  // score per minute
            scoreTimeArray[1][i] = T[i];                 // time
            scoreTimeArray[2][i] = S[i];                 // score (optional)
        }

        double[][] sorted = sortByScorePerMinute(scoreTimeArray);

        for (int q = 0; q < Q; q++) {
            int k = queryChoices[q];
            int totalTime = 0;

            for (int i = 0; i < k; i++) {
                totalTime += (int) sorted[1][i];
            }

            System.out.println("Total time for query " + (q + 1) + ": " + totalTime);
        }

        input.close();
    }

    public static double[][] sortByScorePerMinute(double[][] arr) {
        int N = arr[0].length;

        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j > i; j--) {
                if (arr[0][j] > arr[0][j - 1]) {
                    for (int k = 0; k < 3; k++) {
                        double temp = arr[k][j];
                        arr[k][j] = arr[k][j - 1];
                        arr[k][j - 1] = temp;
                    }
                }
            }
        }

        // Optional: print sorted result
        System.out.println("\nSorted Questions by Score/Minute:");
        for (int i = 0; i < N; i++) {
            System.out.printf("Q%d - Score/Min: %.2f, Time: %.0f, Score: %.0f\n", i + 1, arr[0][i], arr[1][i], arr[2][i]);
        }

        return arr;
    }
}
