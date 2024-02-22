package org.example.DataStructure.code;

import java.util.EmptyStackException;

public class StackExample {

    private int[] stackArray;
    private int top; // 스택의 맨 위 요소의 인덱스
    private int capacity; // 스택의 용량

    // 스택의 크기를 지정하여 초기화
    public StackExample(int size) {
        this.stackArray = new int[size];
        this.top = -1; // 스택이 비어있을 때 top은 -1
        this.capacity = size;
    }

    // 요소 추가
    public void push(int item) {
        if (isFull()) {
            System.out.println("스택이 가득 찼습니다.");
            return;
        }
        stackArray[++top] = item;
        System.out.println("Pushed: " + item);
    }

    // 요소 제거
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int item = stackArray[top--];
        System.out.println("Popped: " + item);
        return item;
    }

    // 스택의 맨 위 요소 확인
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[top];
    }

    // 스택이 가득 찼는지 확인
    public boolean isFull() {
        return top == capacity - 1;
    }

    // 스택이 비어있는지 확인
    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        StackExample stack = new StackExample(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.pop();

        System.out.println("Top element: " + stack.peek());

        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
