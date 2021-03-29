package edu.mtc.egr283.project06;

import java.util.LinkedList;
import java.util.Queue;
import edu.mtc.egr283.Stack.Stack;


/**
 * Simple program to evaluate algebra expressions and covet them to postfix format
 * @author Jacob Vaught
 * @professor William Sims
 * @DueDate 03/31/2021
 * @version 1.00 03.24.2021
 * Copyright(c) 2021 Jacob C. Vaught. All rights reserved.
 */
public class ArithmeticEvaluatorMultiDigit {

	/**
	 * converts normal algebra expression to postfix expression
	 * @param String inputExpression
	 * @return String Postfix
	 */
	public static String postfix(String inputExpression) {

		StringBuffer stringBuffer= new StringBuffer();
		Stack<Character> characterStack = new Stack<>();

		for(int i=0; i<inputExpression.length()-1; i++) {
			char character = inputExpression.charAt(i);
			char nextCharacter = inputExpression.charAt(i+1);
			
			if(character=='0'||character=='1'||character=='2'||character=='3'||character=='4'||character=='5'||character=='6'||character=='7'||character=='8'||character=='9') {
				
				if(nextCharacter=='+'||nextCharacter=='-'||nextCharacter=='/'||nextCharacter=='*'||nextCharacter==' '||nextCharacter==')'||nextCharacter=='(') {
				stringBuffer.append(character+" ");
				
				}else {
					stringBuffer.append(character);
				}
			
			}else if(character=='+'||character=='-'||character=='/'||character=='*') {
				characterStack.push(character);
			
			}else if(character==')') {
				stringBuffer.append(characterStack.pop()+" ");
			}//ending bracket of else if
		}//Ending bracket of for loop
		stringBuffer.append(characterStack.toString());
		return stringBuffer.toString();
	}//ending bracket of postfix Method

	/**
	 * gives solution to postfix expression
	 * @param String postfixExpression
	 * @return int Answer
	 */
	public static int evaluation(String postfixExpression) {
		Stack<Integer> intStack = new Stack<>();
		
		for(int i=0; i<postfixExpression.length()-1; i++) {
			char character = postfixExpression.charAt(i);
			
			if(character=='0'||character=='1'||character=='2'||character=='3'||character=='4'||character=='5'||character=='6'||character=='7'||character=='8'||character=='9') {
				
				if (postfixExpression.charAt(i+1)==' ') {
					intStack.push(Character.getNumericValue(character));
				
				}else {
					Queue<Integer> queueForDeterminingIntegersLargerThanOne = new LinkedList<>();
					queueForDeterminingIntegersLargerThanOne.add(Character.getNumericValue(character));
					boolean areThereMoreNumbersInTheInteger=true;
					int nextCharLocation = i+1;
					
					do{
						char nextCharacter = postfixExpression.charAt(nextCharLocation);
					
						if(nextCharacter=='0'||nextCharacter=='1'||nextCharacter=='2'||nextCharacter=='3'||nextCharacter=='4'||nextCharacter=='5'||nextCharacter=='6'||nextCharacter=='7'||nextCharacter=='8'||nextCharacter=='9') {
							queueForDeterminingIntegersLargerThanOne.add(Character.getNumericValue(nextCharacter));
							char nextNextCharacter=postfixExpression.charAt(nextCharLocation+1);
							
							if (nextNextCharacter==' '||nextNextCharacter=='+'||nextNextCharacter=='-'||nextNextCharacter=='/'||nextNextCharacter=='*') {
								areThereMoreNumbersInTheInteger=false;
							}//end of if inside of if loop inside of while loop
						
						}else {
							areThereMoreNumbersInTheInteger=false;
						}//end of else inside while loop
						nextCharLocation++;
						
					}while(areThereMoreNumbersInTheInteger);
					int finalNumberToAddToStack = 0;
					
					for(int tensPower=queueForDeterminingIntegersLargerThanOne.size()-1; tensPower>=0; tensPower--){
						finalNumberToAddToStack = queueForDeterminingIntegersLargerThanOne.remove()*(int) Math.pow(10,tensPower)+finalNumberToAddToStack;
						i++;
					}//end of inner for loop() calculates tens
					intStack.push(finalNumberToAddToStack);
				}//end of inner else
				
			}else if(character=='+'||character=='-'||character=='/'||character=='*') {
				int number2=intStack.pop(), number1=intStack.pop();
				int answerAfterPerformingOperation = 0;

				switch(character) {
				case '+': 
					answerAfterPerformingOperation=number1+number2;
					break;
				case '-': 
					answerAfterPerformingOperation=number1-number2;
					break;
				case '/': 
					answerAfterPerformingOperation=number1/number2;
					break;
				case '*': 
					answerAfterPerformingOperation=number1*number2;
					break;
				case '^':
					answerAfterPerformingOperation=(int) Math.pow(number1,number2);
					break;
				}//end of switch
				intStack.push(answerAfterPerformingOperation);

			}//ending bracket of else if
		}//Ending bracket of for loop
		return intStack.pop();
	}//ending bracket of method Evaluator

}//ending bracket of class
