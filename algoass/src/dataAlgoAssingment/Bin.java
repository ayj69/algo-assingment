package dataAlgoAssingment;

import java.util.ArrayList;

public class Bin {

	int size = 0;
	ArrayList<Integer> binlist = new ArrayList<Integer>();
	
	public Bin() {
		this.size = 0;
	}
	
	public Bin(int size) {
		this.size = size;
	}
	
	public String toString () {
		return "the size of your bin is" + this.size;
	}
}
