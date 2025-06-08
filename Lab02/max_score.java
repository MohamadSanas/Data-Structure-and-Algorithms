import java.awt.im.InputContext;
import java.util.Scanner;

public class max_score {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the number of questions and number of queries:");
        
        int N = input.nextInt();  // number of questions
        int Q = input.nextInt();
        int[] Question=new int [Q];   // number of queries (not used yet)

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

        System.out.print("Enter the number of Questions");
        for (int i = 0;i<Q; i++) {
            Question[i]=input.nextInt();
        }

        // 0th row: score per minute, 1st row: question index
        int[][] mergArr = new int[2][N];
        for (int i = 0; i < N; i++) {
            mergArr[0][i] = S[i];
            mergArr[1][i] = T[i];
        }

        int [][] SortedbyScore=sort_array(mergArr);
        int totTime=0;
        //Count total time taken for each queries


        for (int j=0;j<Q;j++){
            for(int i=0;i<Question[j];i++){
            int index =  SortedbyScore[0][j];  // safer and more readable
            totTime += T[index];
            }
            System.out.println(totTime);
            totTime=0;
        }
        

    }

    public static int [][]  sort_array(int[][] numbers) {
        int N = numbers[0].length;

        // Bubble sort based on score per minute
        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j > i; j--) {
                if (numbers[0][j] > numbers[0][j - 1]) {
                    // swap scores
                    int temp = numbers[0][j];
                    numbers[0][j] = numbers[0][j - 1];
                    numbers[0][j - 1] = temp;

                    // swap indices
                    int ind = numbers[1][j];
                    numbers[1][j] = numbers[1][j - 1];
                    numbers[1][j - 1] = ind;
                }
            }
        }

        // print the sorted array
        for (int i = 0; i < numbers[0].length; i++) {
            System.out.println("Question " + numbers[1][i] + ": " + numbers[0][i] + " pts/min");
        }
        return numbers;
    }
}
