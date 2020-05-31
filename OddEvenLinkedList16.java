package leetCodeMay2020;

public class OddEvenLinkedList16 {

	public static void main(String[] args) {
		int[] intArr = {1,2,3,4,5};
		ListNode headNode = new ListNode(intArr[0]);
		ListNode tempNode = headNode;
		for (int i = 1; i < intArr.length; i++) {
			tempNode.next = new ListNode(intArr[i]);
			tempNode = tempNode.next;
		}
		
		ListNode ans = oddEvenList(headNode);
		
		while (ans != null) {
			System.out.print(ans.val);
			ans = ans.next;
		}

	}

	private static ListNode oddEvenList(ListNode head) {
		ListNode oddNodeTemp, evenNodeTemp;
		ListNode headOddNode;
		ListNode headEvenNode;
		
		ListNode tempNode = head;
		
		if (tempNode == null) {
			return null;
		}
		oddNodeTemp = tempNode;
		headOddNode = tempNode;
		tempNode = tempNode.next;
		
		if (tempNode == null) {
			return headOddNode;
		}
		evenNodeTemp = tempNode;
		headEvenNode = tempNode;
		tempNode = tempNode.next;

		
		boolean isOdd = true;
		
		while (tempNode != null) {
			if (isOdd) {
				oddNodeTemp.next = tempNode;
				oddNodeTemp = oddNodeTemp.next;
				isOdd = false;
			}else {
				evenNodeTemp.next = tempNode;
				evenNodeTemp = evenNodeTemp.next;
				isOdd = true;
			}
			tempNode = tempNode.next;	
		}
		
		oddNodeTemp.next = headEvenNode;
		evenNodeTemp.next = null;

		return headOddNode;
	}

}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
