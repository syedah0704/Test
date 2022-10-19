import java.util.Stack;

public class BalancedParentheses {
	public static void main(String[] args) {
		System.out.println(isValid("((())))"));
	}
	
	  public static boolean isValid(String sample) {
	        Stack<Character> stack = new Stack<>();
	        char[] sampleChars = sample.toCharArray();
	        for (char parenthese : sampleChars) {
	            if (stack.isEmpty()) {
	                if (parenthese == ')') {
	                    return false;
	                }
	                stack.push(parenthese);
	            } else {
	                Character poppedParenthese = stack.peek();
	                if (!poppedParenthese.equals(parenthese)
	                		&& poppedParenthese== '('
	                		&& parenthese == ')') {
	                    stack.pop();
	                } else {
	                    stack.push(parenthese);
	                }
	            }
	        }
	        return stack.isEmpty();
	    }

}
