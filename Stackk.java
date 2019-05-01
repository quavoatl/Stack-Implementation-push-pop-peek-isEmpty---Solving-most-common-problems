package com.example;

import java.util.Stack;

public class Stackk {


    public static final int MAX = 100;
    int top = -1;
    int[] stackSize = new int[MAX];


    public boolean isEmpty(Stackk stackk) {

        if (top < 0) {
            System.out.println("Stack is empty");
            return true;
        } else {
            System.out.println("Stack has elements");
            return false;
        }
    }

    public boolean push(int value) {

        if (top >= MAX - 1) {
            System.out.println("Stack Overflow");
            return false;
        } else {
            top++;
            stackSize[top] = value;
            System.out.println(value + " value added");
            return true;
        }
    }

    public int pop() {
        if (top < 0) {
            System.out.println("Nothing to pop off");
            return -1;
        } else {
            int result = stackSize[top];
            System.out.println(result + " popped off");
            top--;
            return result;
        }
    }

    public int peek(Stackk stackk) {
        if (top < 0) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            int result = stackSize[top];
            return result;
        }
    }


    public int prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public String postfix2(String exp) {

        String resultExp = "";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                resultExp += c;
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    resultExp += stack.pop();
                }
                if (stack.peek() == '(') {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && prec(c) <= prec(stack.peek())) {
                    resultExp += stack.pop();
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            resultExp += stack.pop();
        }
        return resultExp;

    }

    public String reverseString(String exp) {
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            stack.push(c);
        }

        while (!stack.isEmpty()) {
            char d = stack.pop();
            sb.append(d);
        }
        return sb.toString();

    }


    public void isBalanced(String exp) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char nextChar = exp.charAt(i);

            if (nextChar == '(' || nextChar == '[' || nextChar == '{') {
                stack.push(nextChar);
            } else if (!stack.isEmpty()) {
                char peekToCompare = stack.peek();

                if (peekToCompare == '(' && nextChar == ')') {
                    stack.pop();
                } else if (peekToCompare == '[' && nextChar == ']') {
                    stack.pop();
                } else if (peekToCompare == '{' && nextChar == '}') {
                    stack.pop();
                } else {
                    break;
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("Exp is balanced");
        } else {
            System.out.println("Exp not balanced");
        }
    }


}
