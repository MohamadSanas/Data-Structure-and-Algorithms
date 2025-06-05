public class bubble_sort{
    public static void main(String[] args) {
        int[]numbers={1,2,5,98,45,23,5,67,93,43,26,9};

        int length=numbers.length;

        bubble_sort(numbers,length);


    }

    public static void bubble_sort(int[] numbers, int length){
        int temp=0,swap_count = 0;
        boolean swap;
        for(int i=0;i<length-1;i++){
            swap=false;
            for (int j=length-1;j>i;j--) {
                if(numbers[j]<numbers[j-1]){
                    temp=numbers[j];
                    numbers[j]=numbers[j-1];
                    numbers[j-1]=temp;
                    swap_count++;
                    swap=true;
                }
                
            }
            if(!swap) 
                break;
        }
        System.out.println("Sorted array is: ");
        for(int j: numbers){
            System.err.print(j+" ");
        }

        System.out.println("\nnumber of swaps: "+swap_count);
        System.out.println("First element of array: "+numbers[0]);
        System.out.println("Last element of sorted array: "+numbers[length-1]);

    }
}