package com.example.palindromic.substring.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PalindromicRepo extends JpaRepository<Palindrome, Integer> {

}
