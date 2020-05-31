package leetCodeMay2020;

import java.util.ArrayList;
import java.util.List;

public class OnlineStockSpan19 {

	public static void main(String[] args) {
		int[] prices = {100, 80, 60, 70, 60, 75, 85};
		
		StockSpanner stockSpanner = new StockSpanner();
		for (int i = 0; i < prices.length; i++) {
			System.out.println(String.format("%s: %s",prices[i],stockSpanner.next(prices[i])));
		}
	}

}
class StockSpanner {
	List<StockNode> arrList = new ArrayList<StockNode>();
	int currIndex = 0;

    public StockSpanner() {
        
    	
    	
    }
    
    public int next(int price) {
    	
    	if (currIndex == 0) {
    		arrList.add(new StockNode(price, 1));
    		currIndex++;
    		return 1;
    	}
    	
    	int tempIndex = currIndex;
    	int span = 1;
        while (tempIndex > 0) {
        	StockNode tempNode = arrList.get(tempIndex-1);
        	if (price >= tempNode.price) {
				span += tempNode.span;
				tempIndex -= tempNode.span;
			}else {
				break;
			}
        }
    	
        arrList.add(new StockNode(price, span));
		currIndex++;
    	return span;
    }
}
class StockNode{
	int price;
	int span;
	public StockNode(int price, int span) {
		this.price = price;
		this.span = span;
	}
}