package leetCodeMay2020;

public class CountingBits28 {

	public static void main(String[] args) {
		int num = 6;
		int[] ans = countBits(num);
		for (int n:ans)
			System.out.println(n);
	}

	private static int[] countBits(int num) {
		int[] ans = new int[num+1];
		int index = 0, loopMax = 1;
		
		while (index + loopMax <= num ) {
			
			for (int j = 0; j < loopMax; j++) {
				ans[++index] = ans[j]+1;
			}
			
			loopMax = loopMax*2;
		}
		
		if(index != num) {
			int max = num-index;
			for (int j = 0; j < max; j++) {
				ans[++index] = ans[j]+1;
			}
		}

		return ans;
	}

}
