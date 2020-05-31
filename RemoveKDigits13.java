package leetCodeMay2020;

import java.util.Stack;

public class RemoveKDigits13 {

	public static void main(String[] args) {
		String num = "112";
		int k = 1;
		String ans = removeKdigits(num, k);
		System.out.println(ans);
	}

	private static String removeKdigits(String num, int k) {
		Stack<Character> stack = new Stack<Character>();
		
		if (num.length() == k) return "0";
		
		for (int i = 0; i < num.length(); i++) {
			
			while ( ! stack.isEmpty() && k>0 && stack.peek() > num.charAt(i)) {
				stack.pop();
				k--;
			}
			
			stack.push(num.charAt(i));
		}
		
		while (k>0) {
			stack.pop();
			k--;
		}
		
		StringBuilder sb = new StringBuilder();
		stack.forEach(x-> sb.append(x));
		while (1 < sb.length() && sb.charAt(0)=='0') {
			sb.deleteCharAt(0);
		}
		
		
		return sb.toString();
	}

}
