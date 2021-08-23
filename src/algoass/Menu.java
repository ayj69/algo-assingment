package algoass;

import java.util.Scanner;


public class Menu implements Algo{
	
	public static void main(String arg[]) {
		Boolean loopFlag = false;
		ItemSet<Item<Integer>> is = new ItemSet<Item<Integer>>();
		Scanner s = new Scanner(System.in);

		System.out.println("Welcome to truck loading problem!");
		
		do {
			
			loopFlag = false;
			
			System.out.print(
					"then pls decide if you want to enter the number of the item one by one or generate it automaticaly: \n"
							+ "\t\t1:Menual input.\n" + "\t\t2:Computer generate.\n" + "\t\t3:Read from file\n");
			
			int choice = Algo.getUserInput(1, 3, "Pls enter your choice : ");
			
			switch (choice) {
			case 1:
				is = is.getItemListManual();
				break;
			case 2:
				is = is.getItemListAutoGen();
				break;
			case 3:
				is = is.getItemListScanFile();
				break;
			}
			
			System.out.println("\nYour item list is : " + is.getItemList().toString() + "\n");
			System.out.print("pls chose a method to arrange your set :\n" +
					"\t\t1.First Fit Decreasing\n" +
					"\t\t2.Next Fit\n");
			
			choice = Algo.getUserInput(1, 2, "Pls enter your choice: ");
			
			if (choice == 1) {

				long startTime = System.currentTimeMillis();
				is.simpleSort(is.getItemList());
				long sortEndTime = System.currentTimeMillis();

				System.out.println("\nSorted list = " + is.getItemList().toString() + "\n");

				Algo.ffd(is.getBinSize(), is.getNumberOfItem(), is.getItemList());

				long endTime = System.currentTimeMillis();

				long timeElapsed = endTime - startTime;
				long sortTimeElapsed = sortEndTime - startTime;

				System.out.println("Sorted in milliseconds: " + sortTimeElapsed);
				System.out.println("Packed in milliseconds: " + timeElapsed);

			} else if (choice == 2) {

				long startTime = System.currentTimeMillis();
				Algo.nextFit(is.getBinSize(), is.getNumberOfItem(), is.getItemList());
				long endTime = System.currentTimeMillis();

				long timeElapsed = endTime - startTime;
				System.out.println("Packed in milliseconds: " + timeElapsed);
			} 
			
			System.out.print("Press any button to continue.");
			s.nextLine();
			
			System.out.print("\nDo you want to exit the program? :\n" +
							"\t\t 1:Continue the program.\n" +
							"\t\t 2:Exit the program.\n");
			choice = Algo.getUserInput(1, 2,"Pls enter your choice :");
			if(choice == 1)
				loopFlag = true;
			
		} while (loopFlag);
		
		System.out.println("\n\n\t\t<<The programe operate sucessfully!>>");
		
		s.close();
	}
}
