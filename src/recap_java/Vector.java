package recap_java;

import java.util.Arrays;

public class Vector {
    private int size = 0;
    private static final int defaultSize = 10;
    private Object items[];

    public Vector() {
        items = new Object[defaultSize];
    }

    public void add(Object item) {
        if (size == items.length) {
            reSize();
        }
        items[size++] = item;
    }

    private void reSize() {
        int newSize = items.length * 2;
        items = Arrays.copyOf(items, newSize);
    }
    public void print(){
        for (Object item : items){
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        Vector vector = new Vector();
        for(int i=0; i <15 ; i++){
            vector.add("item");
        }
        vector.print();
        
    }


}
