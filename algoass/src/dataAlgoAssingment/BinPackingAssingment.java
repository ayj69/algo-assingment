package dataAlgoAssingment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;

public class BinPackingAssingment{
	
	public static void main(String[] args) {
		int itemn = 0;
		int choice = 0;
		int size = 0;
		UnsortItemSet itemSet;
		SortedBin Sbin;
		Scanner scan = new Scanner(System.in);
		System.out.print("Walcome to bin packing algoritherm assingment!!!XDXD\n");
		System.out.print("we need to read numbers of item you have so pls enter it below haha\n");
		System.out.print("pls enter your number of item: ");
		try {
			itemn = scan.nextInt();
		}catch(Exception e) {
			System.out.print("ERROR\n");
			System.out.print("Press any key to continue . . .\n ");
		    scan.nextLine();
		}
		System.out.print("you have " + itemn + " item\n");
		System.out.print("i will now make a constructor based on this numbers!\n");
		System.out.print("you have " + itemn + " item.\n");
		System.out.print("then pls decide if you want to enter the number of the item one by one or generate it automaticaly: \n");
		System.out.print("\t\t1:i will do it by myself.\n");
		System.out.print("\t\t2:fine, i will let computer generate it for me.\n");
		try {
			do {
				System.out.print("pls enter your choice: ");
				choice = scan.nextInt();
			}while(!(choice == 1 || choice == 2));
		}catch(Exception e) {
			System.out.print("ERROR\n");
			System.out.print("Press any key to continue . . .\n ");
		    scan.nextLine();
		}
		//create a array list to store the unsorted item;
		ArrayList<Item> itemArray = new ArrayList<Item>();
		
		//if choice one 
		if (choice == 1) {
			for (int i = 0;i < itemn;i++) {
				try {
					System.out.print("pls enter the size for current item " + (i+1) + " : ");
					size = scan.nextInt();
				}catch(Exception e) {
					System.out.print("ERROR\n");
					System.out.print("Press any key to continue . . .\n ");
				    scan.nextLine();
				}
				itemArray.add(new Item(size));
			}
		}
		else {
			for (int i = 0;i < itemn;i++) {
				itemArray.add(new Item((int)((Math.random())*100)+1));
			}
			
		}
		itemSet = new UnsortItemSet(itemn,itemArray);
		System.out.print(itemSet.toString());
		System.out.print(itemSet.shittySort(itemSet.itemList).toString() + "\n");//it works
		Collections.sort(itemSet.itemList);
		
		try {
			System.out.print("pls enter your Bin size : ");
			size = scan.nextInt();
		}catch(Exception e) {
			System.out.print("ERROR\n");
			System.out.print("Press any key to continue . . .\n ");
		    scan.nextLine();
		}
		Bin bin = new Bin(size);
		bin.toString();
		//we are doing first fit decreasing and next fit
		System.out.print("pls chose a method to arrange your set :\n");
		System.out.print("\t\t1.first fit decreasing\n");
		System.out.print("\t\t2.next fit\n");
		System.out.print("pls enter your choice: ");
		try {
			do {
				choice = scan.nextInt();
			}while(!(choice == 1 || choice == 2));
		}catch(Exception e) {
			System.out.print("ERROR\n");
			System.out.print("Press any key to continue . . .\n ");
		    scan.nextLine();
		}
		
		if (choice == 1) {
			System.out.print("hvent implement yett \n");
			itemSet.itemList = itemSet.shittySort(itemSet.itemList);
			for (int i = 0;i < itemSet.itemList.size();i++ ) {

			}
			//do first fit decreasing
			//put in increase order
			//put in bin
		}
		else {
			//do next fit
		}	
		scan.close();
	}



}
