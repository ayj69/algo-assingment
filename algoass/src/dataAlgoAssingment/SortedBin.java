package dataAlgoAssingment;

import java.util.ArrayList;

public class SortedBin extends Bin {

	ArrayList<Bin> binlist = new ArrayList<Bin>();
	
	public SortedBin(){
	}
	
	public SortedBin(ArrayList<Bin> list){
		this.binlist = list;
	}
	
	public boolean checkSum(ArrayList<Bin> list) {
		int total = 0;
		System.out.print(super.size);
		for(int i = 0;i < list.size();i++) {
			total += list.get(i).size;
			}
		if (total > super.size)
			return false;
		else 
			return true;
	}
		
	
	public String toString () {
		return "the size of your bin is" + super.size;
	}
	
	
}
