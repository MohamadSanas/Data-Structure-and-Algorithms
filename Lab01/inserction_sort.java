import java.util.Scanner;

public class inserction_sort {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        
        System.out.println("Number of test cases: ");
        int n=input.nextInt();

        int[][] outputs=new int[20][20];

        for(int i=0;i<n;i++){
            System.out.println("Length of array: ");
            int m=input.nextInt();
            System.out.println("Enter the numbers: ");
            int[] numbers = new int[m];

            for(int j=0;j<m;j++){
                numbers[j]=input.nextInt();

            }
            
            int count=countShifts(numbers);
            insert_sort(numbers);
            System.out.println(": "+count);
            

        }
    }

    public static  int countShifts(int[] numbers){
        int shiftCount=0;
        for(int i=1;i<numbers.length;i++){
            int key=numbers[i];
            int j=i-1;
            while(j>=0 && numbers[j]>key){
                numbers[j+1]=numbers[j];
                j--;
                shiftCount++; 
            }
            numbers[j+1]=key;
 
        }
        return shiftCount;

    }

    public static  void insert_sort(int[] numbers){
        
        for(int i=1;i<numbers.length;i++){
            int key=numbers[i];
            int j=i-1;
            while(j>=0 && numbers[j]>key){
                numbers[j+1]=numbers[j];
                j--;
                 
            }
            numbers[j+1]=key;
 
        }

        for(int j:numbers){
            System.out.print(j+" ");
        }

    }
    
}
