package _01_TestMatchingBrackets;

import java.util.Stack;

public class TestMatchingBrackets {
    /*
     * Use a Stack to complete the method for checking if every opening bracket
     * has a matching closing bracket
     */
    public static boolean doBracketsMatch(String b) {
    	int closed = 0;
    	System.out.println(b);
    	Stack<String> brack = new Stack<String>();
    	for (int i = b.length()-1; i >= 0; i--) {
			brack.add(b.charAt(i) + "");
		}
    	while( ! brack.isEmpty() ) {
    		String popped = brack.pop();
    		System.out.println(popped);
    		if (popped.equalsIgnoreCase("{")) {
				closed += 1;
			} else if (popped.equalsIgnoreCase("}")) {
				closed -= 1;
			}
    		if (closed < 0) {
				return false;
			}
    	}
        if (closed == 0) {
        	return true;
		}
    	return false;
    }
}