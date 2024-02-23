package org.example.DataStructure.code;

import java.util.LinkedList;

public class QueueExample {
    private LinkedList<Integer> queue;

    public QueueExample() {
        queue = new LinkedList<>();
    }

    // 요소 추가
    public void enqueue(int item) {
        queue.addLast(item);
        System.out.println("Enqueued: " + item);
    }

    // 요소 제거
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int item = queue.removeFirst();
        System.out.println("Dequeued: " + item);
        return item;
    }

    // 큐의 맨 앞 요소 확인(peek)
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.getFirst();
    }

    // 큐가 비어있는지 확인
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        QueueExample queue = new QueueExample();

        // 요소 추가
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // 요소 제거
        queue.dequeue();

        // 큐의 맨 앞 요소 확인
        System.out.println("Front element: " + queue.peek());

        // 큐가 비어있는지 확인
        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}
