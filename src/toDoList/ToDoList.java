package toDoList;

import java.util.ArrayList;

public class ToDoList {
	String description;
	boolean isComplete;
	static ArrayList<ToDoList> taskList = new ArrayList<>();   //static so that all the instances of the class can access it  and it can be accessed without creating an instance of a class.
	public ToDoList(String description) {
		this.description = description;
		this.isComplete = false;
	}
	public  boolean taskComplete() {
		return isComplete = true;
	}
	@Override
	public String toString() {  //overriding the object troString() method to directly print the object task1
		return description+(isComplete ? "(complete)" : "(pending)");
		
	}
	public void printTask() {
		System.out.println(description);
	
	}
	public static void main(String[] args) {
		taskList.add(new ToDoList("buy groceries"));
		taskList.add(new ToDoList("Do tha laundry"));
		taskList.add(new ToDoList("Exercise for 30 mins"));
		taskList.get(0).printTask();  //prints the first description
		for(ToDoList tasks : taskList) {
			tasks.printTask();    //print all the description
			System.out.println(tasks); //directly object reference  is passed so it will by default call toString() method
		}

	}
}
