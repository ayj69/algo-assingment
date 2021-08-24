package algoass;

import java.io.File;
import java.util.ArrayList;



public class ItemSet<T> extends Item implements Algo{
	
	//Data Field
	private int numberOfItem ;
	private int binSize;
	private ArrayList<T> itemList = new ArrayList<T>();
	
	
	//Constructor
	public ItemSet() {
		this.setNumberOfItem(0);
	}
	
	public ItemSet(int numberOfItem) {
		this.setNumberOfItem(numberOfItem);
	}
	
	public ItemSet(ArrayList<T> list) {
		this.setItemList(list);
	}
	
	public ItemSet(int numberOfItem,ArrayList<T> list) {
		this.setNumberOfItem(numberOfItem);
		this.setItemList(list);
	}
	
	public ItemSet(int binsize , int numberOfItem,ArrayList<T> list) {
		this.setNumberOfItem(numberOfItem);
		this.setItemList(list);
		this.binSize = binsize;
	}
	
	
	//getter and setter
	public int getBinSize() {
		return binSize;
	}

	public void setBinSize(int binSize) {

		this.binSize = binSize;
	}
	
	public ArrayList<T> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<T> itemList) {
		this.itemList = itemList;
	}

	public int getNumberOfItem() {
		return numberOfItem;
	}

	public void setNumberOfItem(int numberOfItem) {
		this.numberOfItem = numberOfItem;
	}
	
	
	
	public String toString() {
		String str = "There are " + this.getItemList().size() + " item in the set right now.\n";
		
		for(int i = 0; i < getItemList().size();i++) {
				System.out.println("Bin " + (i+1) + " = " + getItemList().get(i).toString());
		}
		
		return str;
	}
	
	//Sort the array list based on descending order
	public <E extends Comparable<E>> ArrayList<E> simpleSort(ArrayList<E> list){
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
	
	//get the list of item via manual input
	public ItemSet<Item<Integer>> getItemListManual() {
		
		ItemSet<Item<Integer>> is = new ItemSet<Item<Integer>>();
		ArrayList<Item<Integer>> itemArray = new ArrayList<Item<Integer>>();
		
		int binSize = Algo.getUserInput(1, 1000000,"Pls enter your Bin size : ");
		int itemNumber = Algo.getUserInput(1, 1000000,"Pls enter your number of item : ");
		
		is = new ItemSet<Item<Integer>>(binSize,itemNumber,itemArray);
		
		for (int i = 0;i < is.getNumberOfItem();i++) {
			int size = Algo.getUserInput(0, is.binSize,"pls enter your size of the item : ");
			is.getItemList().add(new Item<Integer>(size));
		}
		
		return is;
		
	}
	
	//get the list of item via computer auto generation
	public  ItemSet<Item<Integer>> getItemListAutoGen() {
		
		ItemSet<Item<Integer>> is = new ItemSet<Item<Integer>>();
		ArrayList<Item<Integer>> itemArray = new ArrayList<Item<Integer>>();
		
		int binSize = Algo.getUserInput(1, 1000000,"Pls enter your Bin size : ");
		int itemNumber = Algo.getUserInput(1, 1000000,"Pls enter your number of item : ");
		
		is = new ItemSet<Item<Integer>>(binSize,itemNumber,itemArray);
		
		for (int i = 0;i < is.getNumberOfItem() /4 ;i++) {
			is.getItemList().add(new Item<Integer>(Algo.autoGenInt(1, binSize/4*3)));
		}
		
		for (int i = 0;i < (is.getNumberOfItem() / 4 * 3) + (is.getNumberOfItem() % 4);i++) {
			is.getItemList().add(new Item<Integer>(Algo.autoGenInt(1, binSize/4)));
		}
		
		return is;
	}
	
	//get the list of item via scanning file locate in Data directory
	public  ItemSet<Item<Integer>> getItemListScanFile() {
		
		ItemSet<Item<Integer>> is = new ItemSet<Item<Integer>>();
		ArrayList<File> file = new ArrayList<File>(Algo.readFilePath("src/algoass/data"));
		
		int fileChoice = 0;
		
		fileChoice = Algo.getUserInput(1, file.size(), "Pls enter your another file choice : ");
        fileChoice -= 1;
        
        System.out.println("Your choice is : " + file.get(fileChoice).getName());
        
        while(!(Algo.readFile(file.get(fileChoice)))) {
        	fileChoice = Algo.getUserInput(1, file.size(), "Pls enter your another file choice : ");
            fileChoice -= 1;
            System.out.println("Your choice is : " + file.get(fileChoice).getName());
        }
        
		ArrayList<Item<Integer>> itemArray = new ArrayList<Item<Integer>>();

		itemArray.addAll(Algo.readDataFile(file.get(fileChoice)));
        is = new ItemSet<Item<Integer>>(Algo.findMax(itemArray).size,itemArray.size(),itemArray);
        
        System.out.print(is.toString());
        System.out.println("Automaticaly set the maximun bin size to " +Algo.findMax(itemArray));
        
		return is;
	}



	
	
}

