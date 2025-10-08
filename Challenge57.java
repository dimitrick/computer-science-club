import java.util.Scanner;
import java.util.Stack;


public class Challenge57 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String parentheses = scan.nextLine();
        Stack<Character> stack = new Stack<Character>();
        boolean isValid = true;
        
        for (int i = 0; i < parentheses.length(); i++) {
            //add opening parentheses to stack
            if (parentheses.charAt(i) == '(' || parentheses.charAt(i) == '[' || parentheses.charAt(i) == '{') {
                stack.push(parentheses.charAt(i));
            } else if (parentheses.charAt(i) == ')' || parentheses.charAt(i) == ']' || parentheses.charAt(i) == '}') {
                //check if closing parentheses matches the last opening parentheses or if stack is empty
                if (stack.isEmpty()) {
                    isValid = false;
                    break;
                } else {
                    char topOfStack = stack.pop();
                    if ((parentheses.charAt(i) == ')' && topOfStack != '(') || (parentheses.charAt(i) == ']' && topOfStack != '[') || (parentheses.charAt(i) == '}' && topOfStack != '{')) {
                        isValid = false;
                        break;
                    }
                }
                
            }
        }
        //if stack is empty and isValid didn't change, its true
        if (isValid && stack.isEmpty()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        scan.close();
    }
}
