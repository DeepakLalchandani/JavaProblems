package com.meennujaiswal.javaproblems.medium;

import java.util.Stack;

public class QueueUsing2Stacks<T> {
	private Stack<T> enqueueStack; // for enqueue
    private Stack<T> dequeueStack; // for dequeue

    public QueueUsing2Stacks() {
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }

    // Add an element to the rear of the queue
    public void enqueue(T item) {
        enqueueStack.push(item);
    }

    // Remove and return the front element of the queue
    public <T> T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }

        return (T) dequeueStack.pop();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }

    // Get the size of the queue
    public int size() {
        return enqueueStack.size() + dequeueStack.size();
    }

    public static void main(String[] args) {
        QueueUsing2Stacks<Integer> queue = new QueueUsing2Stacks<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());

        queue.enqueue(4);

        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
    }
}
