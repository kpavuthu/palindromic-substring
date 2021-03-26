package com.example.palindromic.substring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PalindromicService {
	
	
	@Autowired
	private PalindromicRepo palindromicRepo;
	
	private String getLongestPalindrome(String input) {
		
		String longestPalindrome = null;
		
		int strLength = input.length();
		
		for(int i=0; i<strLength; i++) {
			
			for(int j=i+1; j<=strLength; j++) {
				
				String subStr = input.substring(i, j); 
				
				if(isPalindrome(subStr) ) {
					if(longestPalindrome == null || subStr.length() > longestPalindrome.length()) {
						longestPalindrome = subStr;	
					} 
					 
				}
			}
		}
		
		return longestPalindrome;
	}
	
	private boolean isPalindrome(String input) {
		StringBuilder strBuilder = new StringBuilder(input);
		return input.equalsIgnoreCase(strBuilder.reverse().toString());
	}
	
	public void storeLongestPalindrome(String restInput) {
		
		String longPalindrome = getLongestPalindrome(restInput);
		
		if(longPalindrome != null) {
			palindromicRepo.deleteAll();
			Palindrome input = new Palindrome();
			input.setName(longPalindrome);
			palindromicRepo.save(input);
		}
	}
	
	public String getPalandrome() {
		
		List<Palindrome> list = palindromicRepo.findAll();
		String output = "";
		if(list != null && !list.isEmpty()) {
			output = list.get(0).getName();
		}
		
		return output;
	}
}
