package leetCodeMay2020;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortCharactersByFrequency22 {

	public static void main(String[] args) {
		String s = "raaeaedere";
		String ans = frequencySort(s);
		System.out.println(ans);
	}

	private static String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (int i = 0; i < s.length(); i++) {
			char tempChar = s.charAt(i);
			if (map.containsKey(tempChar)) {
				map.put(tempChar, map.get(tempChar)+1);
			}else {
				map.put(tempChar, 1);
			}
		}
		
		Queue<WordCount> queue = new PriorityQueue<WordCount>(new Comparator<WordCount>() {
			@Override
			public int compare(WordCount o1, WordCount o2) {
				return o2.count - o1.count;
			}
		});
		
		map.forEach((key,value)-> queue.add(new WordCount(key, value)));
		
		StringBuilder sb = new StringBuilder();
		
		while ( !queue.isEmpty()) {
			WordCount wordCount = queue.remove();
			for (int i = 0; i < wordCount.count; i++) {
				sb.append(wordCount.word);
			}
		}
		
		return sb.toString();
	}

}

class WordCount{
	char word;
	int count;
	public WordCount(char word, int count) {
		super();
		this.word = word;
		this.count = count;
	}
}
