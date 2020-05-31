package leetCodeMay2020;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindTheTownJudge10 {

	public static void main(String[] args) {
		int N = 1;
		int [][] trust = {};
		
		int ans = findJudge(N, trust);
		System.out.println(ans);

	}

	private static int findJudge(int N, int[][] trust) {
		if (trust == null || trust.length == 0) {
			return 1;
		}
		
		if (trust.length == 1 && N == 1) {
			return -1;
		}
		
		if (trust.length < N-1) {
			return -1;
		}
		
		Map<Integer,Integer> valueMap = new HashMap<Integer,Integer>();
		Set<Integer> keySet = new HashSet<Integer>();
		Integer temp = null; 
		
		for (int i = 1; i <= N; i++) {
			keySet.add(i);
		}
		
		for (int i = 0; i < trust.length; i++) {
			keySet.remove(trust[i][0]);
			
			temp = valueMap.get(trust[i][1]);
			if (temp == null) {
				valueMap.put(trust[i][1], 1);
			}else {
				valueMap.put(trust[i][1], temp+1);
			}	
		}
		
		if (keySet.isEmpty()) {
			return -1;
		}
		
		temp = (Integer)keySet.toArray()[0];
		if (valueMap.get(temp) == N-1) {
			return temp;
		}
		
		return -1;
	}

}
