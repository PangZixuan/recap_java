package recap_java;

import java.util.Random;

public class Queue {
    Object Q[];
    int headPointer = 0;
    Object head;
    int index = -1;
    public Queue(int size){
        Q = new Object[size];
        index = size;
        headPointer = size -1;
        head = null;
    }
    public boolean isEmpty(){
        return (head == null);
    }
    public void push(Object item){
        index --;
        if(index >= 0){
            Q[index] = item;
            head =Q[headPointer];
        }
    }
    public Object pop(){
        if(headPointer<index | headPointer < 0){
            return null;
        }
        headPointer--;
        head =Q[headPointer];
        return  head;
    }
    public Object peek(){
        head =Q[headPointer];
        return head;
    }
    public void print(){
        int cursor = Q.length -1 ;
        while(cursor >= index){
            System.out.println(Q[cursor]);
            cursor--;
        }
    }

    public static void main(String[] args) {
        Queue Q = new Queue(20);
        Random random = new Random();
		for(int i=0; i <15 ; i++){
			int value = random.nextInt(0,100);
            Q.push(value);
            System.out.println("add value: "+value);
        }
        Q.print();
        System.out.println("head is :" +Q.peek());
        Q.pop();
        System.out.println("head is :" +Q.peek());
        for(int i=0; i <14 ; i++){
			Q.pop();
        }
        System.out.println(Q.isEmpty());
    }
}
