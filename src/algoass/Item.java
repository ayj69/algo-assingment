package algoass;


public class Item <T extends Number & Comparable<T>> implements Comparable<Item<T>>{
	
	//data field
	T size;
	
	//constructor
	public Item() {
		this.size = null;
	}
	
	public Item(T size) {
		this.size = size;
	}
	
	//getter and setter
	public T getSize() {
		return size;
	}

	public void setSize(T size) {
		this.size = size;
	}
	
	//method


	@Override
	public int compareTo(Item<T> o) {
		if (getSize().intValue() > o.getSize().intValue())
			return 1;
		else if (getSize().intValue() < o.getSize().intValue())
			return -1;
		else
			return 0;
	}
	
	public String toString() {
		return "" + this.size;
	}


}
