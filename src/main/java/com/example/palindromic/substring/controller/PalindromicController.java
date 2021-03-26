package com.example.palindromic.substring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromicController {
	
	@Autowired
	private PalindromicService palindromicService;
	
	@RequestMapping(path= "/get", method = RequestMethod.GET)
	public ResponseEntity<String> getPalindrome(){
		
		return ResponseEntity.ok(palindromicService.getPalandrome());
	}
	
	@RequestMapping(path= "/store" ,method = RequestMethod.GET)
	public ResponseEntity<String> storePalindrome(@RequestParam(name = "inputdata") String name){
		
		palindromicService.storeLongestPalindrome(name);
		
		return ResponseEntity.ok(palindromicService.getPalandrome());
	}

}
