package com.example.binaryreversal;

public class BinaryReversa {

	public static String getReversalString(String input) {
		
		System.out.println("Input String : "+ input);

		String binaryStr = Integer.toBinaryString(Integer.parseInt(input));
		
		System.out.println("Binary String  : "+binaryStr);

		int remainder = binaryStr.length() % 8;

		if (remainder > 0) {
			for (int i = 0; i < (8 - remainder); i++) {
				binaryStr = "0" + binaryStr;
			}
		}
		
		System.out.println("Binary String padded to the nearest N * 8 bits : "+binaryStr);

		String reverseStr = new StringBuilder(binaryStr).reverse().toString();
		
		System.out.println("Reversed Binary String : "+reverseStr);

		return String.valueOf(Integer.parseInt(reverseStr, 2));

	}
	
	
	public static void main(String[] args) {
		
		String output = getReversalString("47");
		
		System.out.println("Decimal version of binary string : " + output);
		
		
	}
}
