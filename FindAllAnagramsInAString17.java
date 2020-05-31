package leetCodeMay2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindAllAnagramsInAString17 {

	public static void main(String[] args) {
		String s = "abacbabc", p = "abc";
		List<Integer> ansList = findAnagrams(s, p);
		ansList.forEach(x->System.out.print(x));
	}

	private static List<Integer> findAnagrams(String s, String p) {
		if (s == null) 	return null;
		
		int lengthP = p.length();
		
		// put the p String into a map
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < lengthP; i++) {
			Integer tempInt = map.get(p.charAt(i));
			if (tempInt != null) {
				map.put(p.charAt(i), tempInt+1);
			}else {
				map.put(p.charAt(i), 1);
			}
		}
		
		Map<Character, Integer> tempMap = null;
		List<Integer> ansList = new ArrayList<Integer>();
		Queue<Integer> queue = new PriorityQueue<Integer>();
		// find
		int startIndex = -1;
		int matchChar = lengthP;
		for (int i = 0; i < s.length();) {
			
			// initialize
			if (startIndex == -1) {
				startIndex = i;
				matchChar = lengthP;
				queue.clear();
				tempMap = getMapClone(map);
			}
			
			Character tempChar = s.charAt(i);
			Integer tempInteger = tempMap.get(tempChar);
			if (tempInteger != null) {
				if (tempInteger > 0) {
					queue.add(i);
					tempMap.put(tempChar, tempInteger-1);
					matchChar --;
					
					if (matchChar == 0) {
						ansList.add(startIndex);
						tempMap.put(s.charAt(startIndex), tempMap.get(s.charAt(startIndex))+1);
						startIndex = queue.poll()+1;
						matchChar ++;
					}
					i = i + 1;
				}else{
					tempMap.put(s.charAt(startIndex), tempMap.get(s.charAt(startIndex))+1);
					startIndex = queue.poll()+1;
					matchChar ++;
				}
			}else{
				startIndex = -1;
				i = i + 1;
			}
		}
		
		return ansList;
	}

	private static Map<Character, Integer> getMapClone(Map<Character, Integer> map) {
		Map<Character, Integer> returnMap = new HashMap<Character, Integer>();
		
		map.forEach((x,y)->returnMap.put(new Character(x), new Integer(y)));
		
		return returnMap;
	}

}
