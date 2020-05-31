package leetCodeMay2020;

import java.util.HashMap;
import java.util.Map;

public class RansomNote3 {

	public static void main(String[] args) {
		String ransomNote = "aa", magazine = "aab";
		boolean ans = canConstruct(ransomNote, magazine);
		System.out.println(ans);
	}
	
	public static boolean canConstruct(String ransomNote, String magazine) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		Integer tempInt;
		
		for (char s: magazine.toCharArray()) {
			tempInt = map.get(s);
			if (tempInt == null) {
				map.put(s,1);
			}else {
				map.put(s,tempInt+1);
			}
		}
		
		for (char s: ransomNote.toCharArray()) {
			tempInt = map.get(s);
			if (tempInt == null || tempInt == 0) {
				return false;
			}else {
				map.put(s,tempInt-1);
			}
		}
		return true;
		
		
	}

}
