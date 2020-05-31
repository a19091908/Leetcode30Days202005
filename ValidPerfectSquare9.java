package leetCodeMay2020;

public class ValidPerfectSquare9 {

	public static void main(String[] args) {
		
		int num = 1;
		boolean ans = isPerfectSquare(num);
		System.out.println(ans);
	}

	private static boolean isPerfectSquare(int num) {
		if (num == 0) return true;
		long head = 1, tail = num;
		long mid, temp;
		
		while (tail - head > 1) {
			mid = (head + tail) / 2;
			temp = mid*mid;
			if (temp > num) {
				tail = mid - 1;
			}else if (temp < num){
				head = mid + 1;
			}else {
				return true;
			}
			
		}
		
		if (tail*tail == num) {
			return true;
		}else if (head*head == num) {
			return true;
		}
		
		return false;
	}

}
