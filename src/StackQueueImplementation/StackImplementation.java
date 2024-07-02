package StackQueueImplementation;

import java.util.PriorityQueue;
import java.util.Stack;

public class StackImplementation {
    public static void main(String[] args) {
        System.out.println(getMin());
        System.out.println(top());
        System.out.println(top());

    }
    static PriorityQueue<Integer> pq  = new PriorityQueue<>();
    static Stack<Integer> st = new Stack<>();
    public static void push(int x) {
        st.push(x);
        pq.add(x);
    }
    public static void pop() {
            pq.remove(st.peek());
            st.pop();
    }
    public static int top() {
        if(!st.isEmpty()) return st.peek();
        return -1;
    }

    public static int getMin() {
        if(!pq.isEmpty())
          return pq.peek();
        return -1;
    }
}
