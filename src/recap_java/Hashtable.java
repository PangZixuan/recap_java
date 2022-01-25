package recap_java;

import java.net.PasswordAuthentication;
import java.security.Key;
import java.text.Collator;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Stream;

public class Hashtable {
	//TODO Hashtable
	static private class ListNode {
		Object key;
		Object value;
		ListNode next;
	}
	private ListNode[] table;
	//private int count;
	private int size;

	public Hashtable(int size){
		this.size = size;
		this.table = new ListNode[this.size];
	}
	public void put(Object key, Object value){
		int index;
		if(key != null){
			index = key.hashCode() % this.size;
			//System.out.println(index);
			ListNode listNode = table[index]; //set a location for the data pair in table.
			if(listNode == null){
				ListNode newNode = new ListNode();
				newNode.key = key;
				newNode.value = value;
				table[index] = newNode;
				//System.out.println(table[index].value);
			}
			while(listNode != null){
				if(listNode.key.equals(key)){
					listNode.value = value;//handles the situation where the key already exists.
					break;
				}
				if(listNode.next != null){listNode = listNode.next;}
				else{
						ListNode newNode = new ListNode();
						newNode.key = key;
						newNode.value = value;
						listNode.next = newNode;
						break;
				}
					
			}
		} 

	}

	public Object get(Object key){
		int index = key.hashCode()% this.size;
		ListNode listNode = table[index];
		while(listNode != null && listNode.key != key){
			listNode=listNode.next;
		}
		if(listNode != null){return listNode.value;}else{return null;}
	}

	public void remove(Object key){
		int index = key.hashCode()% this.size;
		ListNode listNode = table[index];
		ListNode prevListNode = null;
		while(listNode != null && listNode.key != key){
			prevListNode = listNode;
			listNode = listNode.next;
		}
		if(listNode != null){//we found the data to be deleted
			if( listNode.next == null){ // if this data pair is at the begaining of it's list
				if(prevListNode == null){ // this data pair is the only data pair in this index of the table
					table[index] = null;
				}else{prevListNode.next = null;}	
			}else{
				if(prevListNode == null){ // this data pair is the only data pair in this index of the table
					table[index] = null;
				}
				if(prevListNode != null){
					prevListNode.next = listNode.next;
					listNode.next = null;
				}else{
					table[index] = listNode.next;
					listNode.next = null;
				}
			}
		}
	}

	public int getSize(){
		return this.table.length;
	}

	public void print(){
		for(int i=0; i<table.length; i++){
			System.out.println(i+":");
			ListNode list = table[i];
			while(list != null){
				System.out.println("(" + list.key +"," + list.value + ")");
				list = list.next;
			}
			System.out.println("\n");	
		}
	}

	public static void main(String[] args) {
		Hashtable table = new Hashtable(10);
		Random random = new Random();
		for(int i=0; i <15 ; i++){
			int key = random.nextInt(1,100);
			String value = "value is:" + String.valueOf(key);
			table.put(key,value);
			table.put(i,value+" this item is to be removed");
		}
		table.print();
		System.out.println(table.getSize());
		for(int i=0; i<15; i++){
			System.out.println("deleting key : "+ i + " " +table.get(i));
			table.remove(i);
		}
		table.print();
	}
}
