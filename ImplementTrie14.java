package leetCodeMay2020;

import java.io.UnsupportedEncodingException;

public class ImplementTrie14 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple"));// returns true
		System.out.println(trie.search("app"));// returns false
		System.out.println(trie.startsWith("app"));// returns true
		trie.insert("app");   
		System.out.println(trie.search("app"));// returns true
	}
}

class Trie {
	final private static int A_NUM = String.valueOf('a').getBytes()[0];
	Array trieArr;

    /** Initialize your data structure here. */
    public Trie() {
    	trieArr = new Array();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	int tempInt;
    	Array tempArr = trieArr;

		for (int i = 0; i < word.length(); i++) {
			tempInt = getCharInt(word.charAt(i));

			if (tempArr.arr[tempInt] == null) {
				tempArr.arr[tempInt] = new Array();
			}
			
			tempArr = tempArr.arr[tempInt];
		}
		tempArr.isString = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	Array tempArr = findString(word);
		return (tempArr == null)? false : tempArr.isString;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	Array tempArr = findString(prefix);
		return (tempArr == null)? false : true;
    }
    
    private Array findString(String str) {
    	Array tempArr = trieArr;

		for (int i = 0; i < str.length(); i++) {
			tempArr = tempArr.arr[getCharInt(str.charAt(i))];

			if (tempArr == null) {
				return null;
			}

		}
		return tempArr;
    	
    }
    
    static public int getCharInt(char charAt) {
		return String.valueOf(charAt).getBytes()[0] - A_NUM;
	}
	
}

class Array{
	Array[] arr;
	boolean isString; 
	public Array() {
		arr = new Array[26];
		isString = false;
	}
}
