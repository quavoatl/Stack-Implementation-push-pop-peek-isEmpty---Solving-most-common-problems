package com.example;

public class Main {

    public static void main(String[] args) {
        Stackk stackk = new Stackk();

        stackk.isEmpty(stackk);
        stackk.push(2);
        stackk.isEmpty(stackk);
        stackk.pop();
        stackk.isEmpty(stackk);
        stackk.push(3);
        stackk.push(5);
        int peek = stackk.peek(stackk);

        String exp = "a+b*(c^d-e)^(f+g*h)-i";

        System.out.println(stackk.postfix2(exp));

        String reverseIt = "Stack is easy" ;
        System.out.println(stackk.reverseString(reverseIt));

        TwoStacks twoStacks = new TwoStacks(5);

        twoStacks.push1(5);
        twoStacks.push2(10);
        twoStacks.push2(15);
        twoStacks.push1(11);
        twoStacks.push2(7);
        System.out.println("popped from first stack " + twoStacks.pop1());
        twoStacks.push2(40);
        System.out.println("popped from second stack " + twoStacks.pop2());

        String paranthesis = "{()}[]";
        stackk.isBalanced(paranthesis);

    }
}
