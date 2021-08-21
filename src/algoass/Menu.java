package algoass;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Menu implements Algo{

	public static void main(String arg[]) {
		ItemSet<Item<Integer>> is = new ItemSet<Item<Integer>>();
		
		System.out.println("Welcome to bin packing problem!");
		
		System.out.print("then pls decide if you want to enter the number of the item one by one or generate it automaticaly: \n");
		System.out.print("\t\t1:i will do it by myself.\n");
		System.out.print("\t\t2:fine, i will let computer generate it for me.\n");
		System.out.print("\t\t3:fine, i will let computer read from external file\n");
		
		int choice = Algo.getitemnumber(1, 3, "pls enter your choice : ");
		
		if (choice == 1) {
			is = is.getItemListManual();
		}else if(choice == 2) {
			is = is.getItemListAutoGen();
		}else if(choice == 3) {
			is = is.getItemListScanFile();
		}
		
		System.out.println("your item list is : " + is.itemList.toString());
		
		System.out.print("pls chose a method to arrange your set :\n");
		System.out.print("\t\t1.first fit decreasing\n");
		System.out.print("\t\t2.next fit\n");
		
		choice = Algo.getitemnumber(1, 2,"pls enter your choice: ");
		
		if (choice == 1 ) { 
			is.shittySort(is.itemList);
			System.out.println("Sorted list = " + is.itemList.toString());
			Algo.ffd(is.binSize,is.numberOfItem,is.itemList);
		}else if(choice == 2 ) { 
			Algo.nextFit(is.binSize,is.numberOfItem,is.itemList);
			
		}
		
		Scanner s = new Scanner(System.in);
		s.close();
	}
}
