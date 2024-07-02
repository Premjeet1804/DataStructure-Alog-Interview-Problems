package StackQueueProblems;

import java.util.Stack;

public class ProblemsOnStackQueue {

    public static void main(String[] args) {
//        System.out.println(balancedParanthesis(")(("));
        System.out.println(balancedParanthesis2("{([])"));
    }
    private static int balancedParanthesis(String s)
    {

        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray())
        {
            if(st.size()==0 && c==')') return 0;
            if(c=='(') st.push(c);
            else if(!st.isEmpty() && c==')' && st.peek()=='(') st.pop();

        }
        return st.size()>0?0:1;
    }
    private static int balancedParanthesis2(String s)
    {
        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray())
        {
            if(st.size()==0 && c==')') return 0;
            if(st.size()==0 && c=='}') return 0;
            if(st.size()==0 && c==']') return 0;
            if(c=='(') st.push(c);
            else if(!st.isEmpty() && c ==')' && st.peek() == '(') st.pop();
            if(c=='{') st.push(c);
            else if(!st.isEmpty() && c =='}' && st.peek() == '{') st.pop();
            if(c=='[') st.push(c);
            else if(!st.isEmpty() && c ==']' && st.peek() == '[') st.pop();
        }
        return st.size()>0?0:1;
    }
}
