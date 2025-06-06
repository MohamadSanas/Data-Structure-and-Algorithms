import java.util.Scanner;

public class checkArray {
    public static boolean check(int [] num, int X,int a,int l){
        if(a>l){
            return false;
        }
        if(num[(a+l)/2]==X){
            return true;
        }
        else if(num[(a+l)/2] >X){
            return check(num,X,a,(a+l)/2-1);
        }
        
        else{
            return check (num,X,(a+l)/2+1,l);
        }
        
        
        
    }
    public static void main(String [] args){
        Scanner input= new Scanner(System.in);
        System.out.print("Size of Array: ");
        int N = input.nextInt();
        
        System.out.print("Num of queries: ");
        int Q =input.nextInt();
        
        int [] A= new int[N];
        //array input in accending order
        for(int i=0;i<N;i++){
            A[i]=input.nextInt();
        }
        int[] queries=new int [Q];
        
        for(int i=0;i<Q;i++){
            queries[i]=input.nextInt();
        }
        
        for(int i=0;i<Q;i++){
            System.out.println(check(A,queries[i],0,N-1));
        }
    }
    
}