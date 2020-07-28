package niuke;

import java.util.Stack;

/**
 * @author Administrator
 * @date 2020/2/18 22:35
 */

public class Test20 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minstack = new Stack<>();
    int min = 0;

    public void push(int node) {
        if(stack.isEmpty()){
            min = node;
            stack.push(node);
            minstack.push(min);
        }
        else{
            if(node < min){
                min = node;
            }
            stack.push(node);
            minstack.push(min);
        }
    }

    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
            min = minstack.pop();
        }
    }

    public int top() {
        if(stack.isEmpty())
            return 0;
        return stack.peek();
    }

    public int min() {
        /*int min = 0;
        if(stack == null)
            return min;
        while(stack1 != null){
            stack1.pop();
        }
        min = stack.pop();
        stack1.push(min);
        int next = 0;
        while(stack != null){
            next = stack.pop();
            stack1.push(next);
            if(min > next){
               min = next;
            }
        }
        while(stack1 != null){
            stack.push(stack1.pop());
        }*/
        System.out.println(min);
        return min;
    }

    public static void main(String[] args) {
        Test20 test20 = new Test20();
        test20.push(3);
        test20.min();
        test20.push(4);
        test20.min();
        test20.push(2);
        test20.min();
        test20.push(3);
        test20.min();
        test20.pop();
        test20.min();
        test20.pop();
        test20.min();
        test20.push(0);
        test20.min();
    }
}
