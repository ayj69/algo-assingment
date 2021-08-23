package algoass;

import java.util.Stack;

public class Bin<E extends Number> extends Item implements Algo{
	
	//data field
	private Stack<Stack<E>> stack = new Stack<Stack<E>>(); 
		
	//constructor
	Bin(Stack<Stack<E>> lol){
		this.setStack(lol);
	}
	
	//getter and setter
	public Stack<Stack<E>> getStack() {
		return stack;
	}

	public void setStack(Stack<Stack<E>> stack) {
		this.stack = stack;
	}
	
	//to string
	public String toString() {
		String str = "There are " + this.getStack().size() + " array in the set right now.\n";
		String str2 = "";
		for(int i = 0; i < getStack().size();i++) {
				str2 = "Bin " + (i+1) + " = " + getStack().get(i).toString() + "  Sum = " + Algo.calSum(this.getStack().get(i)) + "\n" ;
				str = str.concat(str2);
		}

		return str;
	}



	

	
}
