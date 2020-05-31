package leetCodeMay2020;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FirstUniqueCharacterInAString5 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "eelelttt";
		int ans = run(s);
		System.out.println(ans);
	}

	private static int run(String s) {
		Map<Character, Boolean> map = new HashMap<Character, Boolean>();
		List<Obj5> queue = new LinkedList<Obj5>();
		Boolean tempBoolean;
		Character tempChar;
		
		for (int i = 0; i < s.length(); i++) {
			tempChar = s.charAt(i);
			tempBoolean = map.get(tempChar);
			if (tempBoolean == null) {
				map.put(tempChar, false);
				queue.add(new Obj5(tempChar, i));
			}else {
				map.put(tempChar, true);
			}
		}
		
		for(Obj5 obj:queue) {
			if (! map.get(obj.character)) {
				return obj.index;
			}
		}
		
		return -1;
	}

}
class Obj5{
	Character character;
	int index;

	public Obj5(Character character, int index) {
		this.character = character;
		this.index = index;
	}
}
