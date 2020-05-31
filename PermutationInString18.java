package leetCodeMay2020;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString18 {

	public static void main(String[] args) {
		String s1 = "adc", s2 = "dcda";
		boolean ans = checkInclusion(s1,s2);
		System.out.println(ans);

	}

	private static boolean checkInclusion(String s1, String s2) {
		if (s1 == null || s1.length() == 0) return true;
        
        if ( s2 == null || s2.length() == 0) return false;
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		// put the target characters of the s1 into map
		for (int i = 0; i < s1.length(); i++) {
			char tempChar = s1.charAt(i);
			if (map.containsKey(tempChar))
				map.put(tempChar, map.get(tempChar) + 1);
			else
				map.put(tempChar, 1);
		}
		
		int startIndex = 0, endIndex = 0;
		int notFindNumber = map.size();
		
		while (endIndex != s2.length()) {
			char tempChar = s2.charAt(endIndex);
			Integer tempInt = map.get(tempChar);
			if ( tempInt != null ) {
				map.put(tempChar, tempInt-1);
				if ( (tempInt-1) == 0 ) notFindNumber--;
				
			}

			while ( notFindNumber == 0) {
				if( (endIndex - startIndex + 1) != s1.length() ) {
					char temp = s2.charAt(startIndex);
					if (map.containsKey(temp)) {
						map.put(temp, map.get(temp)+1);
						if (map.get(temp) > 0) notFindNumber++;
					}
					startIndex++;

				}else {
					return true;
				}
			}
			
			endIndex++;
		}
		
		return false;
	}

}
