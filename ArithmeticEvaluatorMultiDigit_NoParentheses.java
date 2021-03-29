package edu.mtc.egr283.project06;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import edu.mtc.egr283.Stack.Stack;
/**
 * Simple program to evaluate algebra expressions and covet them to postfix format
 * @author Jacob Vaught
 * @professor William Sims
 * @DueDate 03/31/2021
 * @version 1.21 03.29.2021
 * Copyright(c) 2021 Jacob C. Vaught. All rights reserved.
 */
public class ArithmeticEvaluatorMultiDigit_NoParentheses {

	/**
	 * @param String string
	 * @return true if string is a number
	 */
	static boolean isNumber(String string) {
		try{
			Double.valueOf(string);
			return true;
		} catch(Exception e){
			return false;
		}//ending bracket of
	}//ending bracket of isNumber

	/**
	 * @param String inFix
	 * @return Queue of Strings 
	 */
	static Queue<String> postfix(String inputString) {
		String [] infixNotation=spaceCorrection(inputString).split(" ");
		Map<String, Integer> prededence = new HashMap<>();
		prededence.put("^",6);
		prededence.put("/", 5);
		prededence.put("*", 5);
		prededence.put("+", 4);
		prededence.put("-", 4);
		prededence.put("(", 0);

		Queue<String> Q = new LinkedList<>();
		Stack<String> S = new Stack<>();
		for (String token : infixNotation) {
			if(token.equals("")) {
				continue;
			}else if ("(".equals(token)) {
				S.push(token);
				continue;
			}else if (")".equals(token)) {
				while (!"(".equals(S.peek())) {
					Q.add(S.pop());
				}//ending bracket of while
				S.pop();
				continue;
			}else if (prededence.containsKey(token)) {
				while (!S.isEmpty() && prededence.get(token) <= prededence.get(S.peek())) {
					Q.add(S.pop());
				}//ending bracket of while
				S.push(token);
				continue;
			}else if (isNumber(token)) {
				Q.add(token);
				continue;
			}//ending bracket of else if
			throw new IllegalArgumentException("Invalid input");
		}//ending bracket of
		// at the end, pop all the elements in S to Q
		while (!S.isEmpty()) {
			Q.add(S.pop());
		}//ending bracket of while
		return Q;
	}//ending bracket of postfix

	/**
	 * @param Double right
	 * @param Double left
	 * @param String operator
	 * @return Double answer
	 */
	static Double calculate(Double rightnumber, Double leftnumber, String operator){
		if("+".equals(operator)) {
			return leftnumber + rightnumber;
		}else if ("-".equals(operator)) {
			return leftnumber - rightnumber;
		}else if("*".equals(operator)) {
			return leftnumber * rightnumber;
		}else if ("/".equals(operator)) {
			return leftnumber / rightnumber;
		}else if ("^".equals(operator)) {
			return Math.pow(leftnumber,rightnumber);
		}//ending bracket of else if
		throw new IllegalArgumentException("Invalid input");
	}//ending bracket of calculate

	/**
	 * @param String inputExpression
	 * @return String correctedInputExpression
	 */
	static String spaceCorrection(String inputExpression) {
		StringBuffer stringBuffer = new StringBuffer();
		for(int i=0; i<inputExpression.length(); i++) {
			String character = String.valueOf(inputExpression.charAt(i));
			if(isNumber(character)||character.equalsIgnoreCase(".")) {
				stringBuffer.append(character);
			}else if(character.equalsIgnoreCase("+")||character.equalsIgnoreCase("-")||character.equalsIgnoreCase("*")||character.equalsIgnoreCase("/")||character.equalsIgnoreCase("^")||character.equalsIgnoreCase(")")||character.equalsIgnoreCase("(")) {
				stringBuffer.append(" "+character+" ");
			}//ending bracket of else if
		}//Ending bracket of for loop
		return stringBuffer.toString();
	}//ending bracket of spaceCorrection
	
	/**
	 * @param Queue String postfixExpression
	 * @return Double answer
	 */
	static Double evaluation(Queue<String> postfixExpression) {
		Stack<Double> doubleStack = new Stack<>();
		do {
			String character = postfixExpression.remove();
			if(character.contains("+")||character.contains("-")||character.contains("*")||character.contains("/")||character.contains("^")) {
				doubleStack.push(calculate(doubleStack.pop(), doubleStack.pop(), character));
			} else if(isNumber(character)){
				doubleStack.push(Double.parseDouble(character));
			}//ending bracket of else if 
		}while(!postfixExpression.isEmpty());
		return doubleStack.pop();
	}//ending bracket of method Evaluator

}//ending bracket of class arithmetic Evaluator1

