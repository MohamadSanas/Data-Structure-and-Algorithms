public class Trace_Num{

    
    public static void main(String [] args){
        int[] numbers = {5,3,6,8,14,57,19,83,52,1};

        System.out.println(find_num(numbers,57));
        
    }

    public static boolean find_num(int[] array,int target){
        for(int i=0;i<array.length;i++){
            if(array[i]==target)
                return true;
        }

        return false;
    }
}