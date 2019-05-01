package com.example;

public class TwoStacks {
    int size;
    int top1;
    int top2;
    int arr[];

    TwoStacks(int n) {
        size = n;
        arr = new int[n];
        top1 = -1;
        top2 = size;
    }

    public void push1 (int x) {
        if(top1 < top2 -1) {
            top1++;
            arr[top1] = x;
        }else {
            System.out.println("Overflow");
        }
    }

    public void push2 (int x) {
        if(top1 < top2 -1) {
            top2--;
            arr[top2] = x;

        }else {
            System.out.println("Overflow");
        }
    }

    public int pop1() {
        if(top1 >= 0) {
            int x = arr[top1];
            top1--;
            return x;
        }else {
            System.out.println("Underflow");
            return -1;
        }
    }

    public int pop2(){
        if(top1 < size) {
            int x = arr[top2];
            top2++;
            return x;
        }else {
            System.out.println("Underflow");
            return -1;
        }
    }
}
