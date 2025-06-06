import java.util.Scanner;

public class sorting_Array {
    
    public static void sort_array(int[] numbers){
        for(int i=0;i<numbers.length;i++){
            for(int j=numbers.length-1;j>i;j--){
                if(numbers[j]<numbers[j-1]){
                    int temp=numbers[j];
                    numbers[j]=numbers[j-1];
                    numbers[j-1]=temp;
                }
            }
        }
        for(int n: numbers){
            System.out.print(n+" ");
        }
        
        
    }
    
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        int arrayLength=input.nextInt();
        int[] arr =new int[arrayLength];
        for(int i=0;i<arrayLength;i++){
            arr[i]=input.nextInt();
            
        }
        for(int n: arr){
        System.out.print(n+" ");
        }
        System.out.println();
        sort_array(arr);
          
    }
    
    
    
    
} 