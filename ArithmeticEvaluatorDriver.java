package edu.mtc.egr283.project06;

/**
 * Simple program to evaluate algebra expressions and covet them to postfix format
 * @author Jacob Vaught
 * @professor William Sims
 * @DueDate 03/31/2021
 * @version 1.00 03.24.2021
 * Copyright(c) 2021 Jacob C. Vaught. All rights reserved.
 */
public class ArithmeticEvaluatorDriver {

	public static void main(String[] args){
		System.out.println("Original Expression: (198+202)*1/(5-1)");
		System.out.print("Postfix Expression: ");
		System.out.println(ArithmeticEvaluator.postfix("(198+202)*1/(5-1)"));
		System.out.print("Solution: ");
		System.out.println(ArithmeticEvaluator.evaluation(ArithmeticEvaluator.postfix("((198 + 202) * 1) / (5 - 1)")));

	}//main method ending bracket

}//ending bracket of class
