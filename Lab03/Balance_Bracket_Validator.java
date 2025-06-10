
import java.util.Scanner;
import java.util.Stack;


public class Balance_Bracket_Validator {
    public static void main(String [] argd){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the num of test cases(1<=N<=10): ");
        int N =input.nextInt();
        input.nextLine();

        String[] bracket = new String[N];
        String[] result =new String[N];

        //  to take brackets input
        for(int i=0;i<N;i++){
            bracket[i]=input.nextLine();
        }

        //check
        for(int i=0;i<N;i++){
            result[i] =check(bracket[i]) ? "YES" : "NO";
        }

        //print output
        for(int i=0;i<N;i++){
            System.out.println(result[i]);
        }



    }

    public static boolean check (String bracket){
        Stack<Character> bracketStart = new Stack<>();
        int length = bracket.length();
            
            for(int j=0;j<bracket.length();j++){
                if(bracket.charAt(j)=='('||bracket.charAt(j)=='{'||bracket.charAt(j)=='['){
                    bracketStart.push(bracket.charAt(j));
                }

                else if(bracket.charAt(j)==')'||bracket.charAt(j)=='}'||bracket.charAt(j)==']'){
                    if(bracketStart.isEmpty()){
                        return false;
                    }
                    else{
                        char temp =bracketStart.pop();
                        if (!matching(temp,bracket.charAt(j)))
                            return false;
                    }
                }

                
            }
            return bracketStart.isEmpty();
    }

    public static boolean matching(char open, char close){
        return (open=='(' && close==')')||
                (open=='[' && close==']')||
                (open=='{' && close=='}');
    }
    
}
