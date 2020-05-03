package com.joker;

public class MinStack {

    public static void main(String[] args) {
        int re = 0;
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        re = minStack.getMin(); // return -3
        minStack.pop();
        re = minStack.top();    // return 0
        re = minStack.getMin(); // return -2

        System.out.println("");
    }


    public MinStack() {

    }

    private JokerStack<Integer> mainStack = new JokerStack<>();
    private JokerStack<Integer> minStack = new JokerStack<>();

    public void push(int x) {
        mainStack.push(x);
        Integer tempMin = minStack.getTop();
        if (tempMin == null) {
            minStack.push(x);
        } else {
            minStack.push(tempMin < x ? tempMin : x);
        }
    }

    public void pop() {
        mainStack.pop();
        minStack.pop();
    }

    public int top() {
        return mainStack.getTop();
    }

    public int getMin() {
        return minStack.getTop();
    }


    static class JokerStack<T> {
        JokerLinkedList<T> linkedList = null;

        public void push(T value) {
            linkedList = new JokerLinkedList<T>(value, linkedList);
        }

        public void pop() {
            if (linkedList != null) {
                linkedList = linkedList.next;
            }
        }

        public T getTop() {
            if (linkedList == null) {
                return null;
            } else {
                return linkedList.value;
            }
        }
    }

    static class JokerLinkedList<T> {
        T value;
        JokerLinkedList<T> next;

        public JokerLinkedList(T value) {
            this.value = value;
        }

        public JokerLinkedList(T value, JokerLinkedList<T> next) {
            this.value = value;
            this.next = next;
        }
    }

}
