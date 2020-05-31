package leetCodeMay2020;

public class Solution1 {
	static int max = 2126753390, first = 1702766719;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int ans = run(max);
		System.out.println(ans);
	}
	private static int run(int n) throws Exception {
		long left = 1, right = n, mid;
		int tempFirstBadVer = 1;
		
		while(right - left > 1) {
			mid = (left+right)/2;
			if (isBadVersion((int)mid)) {
				tempFirstBadVer = (int)mid;
				right = mid;
			}else {
				left = mid;
			}
		}
		
		if (isBadVersion((int)left)) {
			tempFirstBadVer = (int)left;
		}else if (isBadVersion((int)right)){
			tempFirstBadVer = (int)right;
		}
		
		return tempFirstBadVer;
	}
	private static boolean isBadVersion(int n) throws Exception {
		return n >= first;
		
	}

}
