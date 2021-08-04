package dataAlgoAssingment;

public class Item implements Comparable<Item>{
	
	int size = 0;
	
	public Item() {
		this.size = 0;
	}
	
	public Item(int size) {
		this.size = size;
	}
	
	public String toString() {
		return "" + this.size;
	}

	
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int compareTo(Item item) {
		if (this.size > item.size)
			return 1;
		else if (this.size < item.size)
			return -1;
		else
			return 0;
	}
	
}
