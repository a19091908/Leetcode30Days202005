package leetCodeMay2020;

public class NumberComplement4 {

	public static void main(String[] args) {
		int num = 2;
		int ans = findComplement(num);
		System.out.println(ans);
	}
	
	public static int findComplement(int num) {
		String binStr = Integer.toBinaryString(num);
		int ans = 0 ;
		
		for (int i = binStr.length()-1, j = 0 ; i >= 0  ; i--,j++) {
			if(binStr.charAt(i)=='0')
				ans += Math.pow(2, j);
		}
		
		return ans;
	}

}
