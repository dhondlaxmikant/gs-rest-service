package models;

public class Word {
	
	private String word;
	private boolean palindrome;
	private boolean anagramOfPalindrome;
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public boolean isPalindrome() {
		return palindrome;
	}

	public void setPalindrome(boolean palindrome) {
		this.palindrome = palindrome;
	}

	public boolean isAnagramOfPalindrome() {
		return anagramOfPalindrome;
	}

	public void setAnagramOfPalindrome(boolean anagramOfPalindrome) {
		this.anagramOfPalindrome = anagramOfPalindrome;
	}

	public Word(String word, boolean palindrome, boolean anagramOfPalindrome) {
		super();
		this.word = word;
		this.palindrome = palindrome;
		this.anagramOfPalindrome = anagramOfPalindrome;
	}
	
	
}
