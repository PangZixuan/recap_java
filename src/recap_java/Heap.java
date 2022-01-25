package recap_java;

public class Heap {
	private int capacity = 100;
	private int size = 0;
	//TODO minHeap and MaxHeap input Array and out put array(with multi layers)
	int[] items = new int[capacity];
	
	private int leftChildIndex(int parentIndex) {return 2* parentIndex +1;}
	private int rightChildIndex(int parentIndex) {return 2*parentIndex +2;}
	private int parentIndex(int childIndex) {return (childIndex -1 )/2;}
	
	private boolean hasLeftChild(int index) {return leftChildIndex(index) < size;}
	private boolean hasRightChild(int index) {return rightChildIndex(index) < size;}
	private boolean hasParent(int index) {return parentIndex(index) < size;}
	
	private int leftChild(int index) {return items[leftChildIndex(index)];}
	private int rightChild(int index) {return items[rightChildIndex(index)];}
	private int parent(int index) {return items[parentIndex(index)];}
	
	private void swap(int indexOne, int indexTwo) {
		int temp = items[indexOne];
		items[indexOne] = items[indexTwo];
		items[indexTwo] = temp;
	}
	
	public int peek() {
		if(size == 0) throw new IllegalStateException();
		return items[0];
	}
	
	public int poll() {
		if(size == 0) throw new IllegalStateException();
		int item = items[0];
		items[0] =items[size-1];
		size--;
		heapifyDown();
		return item;
	}
	public void add(int item) {
		items[size] = item;
		size++;
		heapifyUp();
	}
	public void heapifyUp() {
		int index = size -1;
		while(hasParent(index) && parent(index) > items[index]) {
			swap(parentIndex(index),index);
			index = parentIndex(index);
		}
	}
	public void heapifyDown() {
		int index = 0;
		while(hasLeftChild(index)) {
			int smallerChildIndex = leftChildIndex(index);
			if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
				smallerChildIndex = rightChildIndex(index);
			}
			if(items[index] < items[smallerChildIndex]) {
				break;
			}else {
				swap(index,smallerChildIndex);
			}
			index= smallerChildIndex;
		}
	}
	
	
	
	
}
