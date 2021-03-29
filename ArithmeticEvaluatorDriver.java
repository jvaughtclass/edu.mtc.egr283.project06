package edu.mtc.egr283.project06;

/**
 * Simple program to evaluate algebra expressions and convert them to postfix format
 * @author Jacob Vaught
 * @professor William Sims
 * @DueDate 03/31/2021
 * @version 1.00 03.24.2021
 * Copyright(c) 2021 Jacob C. Vaught. All rights reserved.
 */
public class ArithmeticEvaluatorDriver {

	public static void main(String[] args){
		System.out.println("Single Digit Evaluator Test");
		System.out.println("Original Expression: ((3+2)*4)/(5-1)");
		System.out.println("Postfix Expression: "+ArithmeticEvaluator.postfix("((3+2)*4)/(5-1)"));
		System.out.println("Solution: "+ArithmeticEvaluator.evaluation(ArithmeticEvaluator.postfix("((3+2)*4)/(5-1)")));
	
		System.out.println("\nMulti Digit Evaluator Test");
		System.out.println("Original Expression: (198+202)/(5-1)");
		System.out.print("Postfix Expression: ");
		System.out.println(ArithmeticEvaluatorMultiDigit.postfix("(198+202)/(5-1) "));
		System.out.print("Solution: ");
		System.out.println(ArithmeticEvaluatorMultiDigit.evaluation(ArithmeticEvaluatorMultiDigit.postfix("(198+202)/(5-1) ")));
		
		System.out.println("\nMulti Digit & Decimal & Exponent Evaluator Test");
		System.out.println("Original Expression: 2*(3+4/2)^0.5");
		System.out.println("Postfix Expression: "+ArithmeticEvaluatorMultiDigit_NoParentheses.postfix("2.5*(3+4/2)^0.5"));
		System.out.println("Solution: "+ArithmeticEvaluatorMultiDigit_NoParentheses.evaluation(ArithmeticEvaluatorMultiDigit_NoParentheses.postfix("2.5*(3+4/2)^0.5")));
	}//ending bracket of main method

}//ending bracket of class
