package algoass;

import java.util.ArrayList;

public class Item <T extends Number & Comparable<T>> implements Comparable<Item<T>>{
	
	T size;
	
	public Item() {
		this.size = null;
	}
	
	public Item(T size) {
		this.size = size;
	}
	
	public String toString() {
		return "" + this.size;
	}
	
	public T getSize() {
		return size;
	}

	public void setSize(T size) {
		this.size = size;
	}
	
	public void show() {
		System.out.println(this.size.getClass().getName());
		return ;
	}

	@Override
	public int compareTo(Item<T> o) {
		return getSize().compareTo(o.getSize());
	}
	
	

}
