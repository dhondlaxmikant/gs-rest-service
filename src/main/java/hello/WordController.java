package hello;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import models.Word;

@RestController
public class WordController {

	@GetMapping("words/{word}")
	public final ResponseEntity<Word> getWordStatus(@PathVariable(value="word") String word){
		if (word == null || word.isEmpty()) {
			ResponseEntity.badRequest().build();
		}
		Word wordObj = new Word(word, false, false);
		if (isPalindrome(word)) {
			wordObj.setWord(word);
			wordObj.setPalindrome(true);
		}
		else if (isAnagramOfPalindrome(word)){
			wordObj.setWord(word);
			wordObj.setAnagramOfPalindrome(true);
		}
		return ResponseEntity.ok().body(wordObj);
	}
	
	private boolean isPalindrome(String word) {
		int midpoint = word.length()/2;
		boolean isPalindrome = true;
		for(int i = 0; i < midpoint; i++) {
			if ( word.charAt(i) != word.charAt(word.length() - 1 - i)) {
				isPalindrome = false;
				break;
			}
		}
		return isPalindrome;
	}
	
	private boolean isAnagramOfPalindrome(String word) {
		boolean isAnagram = true;
		HashMap<Character, Integer> map = new HashMap<>();		
		for(char c : word.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			}
			else {
				map.put(c, 1);
			}
		}
		int oddCharacterCount = 0;
		for (Character key : map.keySet()) {
		    Integer value = map.get(key);
		    int mod = value.intValue()%2;
			if (mod != 0) {
				oddCharacterCount++;
			}
		}
		if (oddCharacterCount > 1) {
			isAnagram = false;
		}
		return isAnagram;
	}
	
}
