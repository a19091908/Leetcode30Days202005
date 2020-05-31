package leetCodeMay2020;

import java.util.HashSet;
import java.util.Set;

public class NumJewelsInStones2 {

	public static void main(String[] args) {
		String J = "aA", S = "aAAbbbb";
		int ans = run(J,S);
		System.out.println(ans);

	}

	private static int run(String J, String S) {
		Set<Character> set = new HashSet<Character>();
		int ans = 0;
		
		for (int i = 0; i < J.length(); i++) {
			set.add(J.charAt(i));
		}
		
		for (int i = 0; i < S.length(); i++) {
			if (set.contains(S.charAt(i))) {
				ans++;
			}
		}

		return ans;
	}

}
