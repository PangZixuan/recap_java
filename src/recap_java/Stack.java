package recap_java;

import java.util.Objects;
import java.util.Random;

public class Stack {
    Object top;
    Object stack[];
    int index = -1;
    public Stack(int size){
        stack = new Object[size];
        top = null;
    }
    public boolean isEmpty(){
        return (top == null);
    }
    public void push(Object item){
        top = item;
        index ++;
        stack[index] = top;
    }
    public Object pop(){
        Object value= top;
        index--;
        if(index < 0){
            top = null;
        }else{
        top = stack[index];
        }
        return  value;
    }
    public Object peek(){
        return top;
    }
    public void print(){
        int cursor = index ;
        while(cursor >= 0){
            System.out.println(stack[cursor]);
            cursor--;
        }
       
    }

    public static void main(String[] args) {
        Stack stack = new Stack(20);
        Random random = new Random();
		for(int i=0; i <15 ; i++){
			int value = random.nextInt(0,100);
            stack.push(value);
            System.out.println("add value: "+ value);
        }
        stack.print();
        //System.out.println(stack.peek());
        stack.pop();
        //System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        for(int i=0; i <14 ; i++){
			stack.pop();
        }
        System.out.println(stack.isEmpty());
    }

}
