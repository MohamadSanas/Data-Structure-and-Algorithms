public class bubble_sort{
    public static void main(String[] args) {
        int[]numbers={2,5,1,98,45,23,5,67,93,43,26,9};

        int length=numbers.length;


    }

    public void bubble_sort(int[] numbers, int length){
        int temp=0,swap=0;
        for(int i=0;i<length-1;i++){
            if(number[i]>number[i+1]){
                temp=number[i];
                number[i]=number[i+1];
                number[i+1]=temp;
                swap++;

            }
        }

    }
}