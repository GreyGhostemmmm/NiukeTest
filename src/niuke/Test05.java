package niuke;

import java.util.Stack;

/**
 * @author Administrator
 * @date 2020/2/14 18:01
 */

public class Test05 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        int i = 0;
        if(stack2.empty()){
            stack2.push(node);
        }
        else{
            while(!stack2.empty()){
                i = stack2.pop();
                stack1.push(i);
            }
            stack2.push(node);
            while(!stack1.empty()){
                i = stack1.pop();
                stack2.push(i);
            }
        }
    }

    public int pop() {
        int i = 0;
        i = stack2.pop();
        System.out.println(i);
        return i;
    }

    public static void main(String args[]){
        Test05 test05 = new Test05();
        test05.push(1);
        test05.push(2);
        test05.push(3);
        test05.pop();
        test05.pop();
        test05.push(4);
        test05.pop();
        test05.push(5);
        test05.pop();
        test05.pop();
    }
}
