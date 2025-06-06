import java.util.Scanner;

public class max_score {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the number of questions and num of queries: !");
        
        //number of questions
        int N= input.nextInt();
        // number of queries
        int Q=input.nextInt();
        
        //to get time to complete each questions
        int [] T=new int[N];
        for (int i=0;i<N;i++){
            T[i]=input.nextInt();
        }
        
        //to get total marks to each questions
        int[] S= new int[N];
        for (int i=0;i<N;i++){
            S[i]=input.nextInt();
        }
        
        int[][] Arr=new int[2][N];
    }
    
}