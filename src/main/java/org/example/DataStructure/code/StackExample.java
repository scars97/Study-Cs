package org.example.DataStructure.code;

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

    public void push(int item) {
        if (isFull()) {
            System.out.println("스택이 가득 찼습니다.");
            return;
        }
        stackArray[++top] = item;
        System.out.println("Pushed: " + item);
    }

    // 스택이 가득 찼는지 확인
    public boolean isFull() {
        return top == capacity - 1;
    }
}
