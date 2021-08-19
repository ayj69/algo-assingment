package algoass;

import java.util.ArrayList;



public class ItemSet<T>{
	//create a concrete item class and put it in array list
	//so in this object it should have only concrete item 
	//for example [Integer,Double,Long]
	int numberOfItem ;
	ArrayList<T> itemList = new ArrayList<T>();
	
	public ItemSet() {
		this.numberOfItem = 0;
	}
	
	public ItemSet(int numberOfItem) {
		this.numberOfItem = numberOfItem;
	}
	
	public ItemSet(ArrayList<T> list) {
		this.itemList = list;
	}
	
	public ItemSet(int numberOfItem,ArrayList<T> list) {
		this.numberOfItem = numberOfItem;
		this.itemList = list;
	}
		
	public String toString() {
		return "There are " + this.numberOfItem + " item in the set right now.\n" +
				"All item = " + (itemList.iterator().hasNext()?itemList.toString(): "no item in set")+ " in teh set.\n";
	}
	
	
	//increasing sort//this shit will not work
	//todo: make a BETTER sorting system..//postpone postpone
	public <E extends Comparable<E>> ArrayList<E> shittySort(ArrayList<E> list){
		//find minimum then replace it
		//loop 1
		for (int i=0;i < list.size();i++) {
			E min = list.get(i);
			//loop 2
			for (int j = 0;j<list.size();j++) {
				if (list.get(i).compareTo(list.get(j)) > 0) {
					min = list.get(j);
					list.set(j, list.get(i));
					list.set(i, min);
				}
			}
		}
		return list;
	}
	
}

