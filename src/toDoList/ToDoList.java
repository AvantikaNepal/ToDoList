package toDoList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
	public  boolean taskIncomplete() {
		return isComplete = false;
	}
	public void counter() {
		int complete = 0;
		int incomplete = 0;
		for(ToDoList tasks : taskList) {
			 if(tasks.isComplete) {
				 complete ++;
			 }
			 else {
				 incomplete++;
			 }
		}
		System.out.println("Completed tasks: " + complete);
		System.out.println("Pending tasks: " + incomplete);
	}
	public void editTask() {
		System.out.println("CurrentTask:" + description);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Edited Description");
		String edited = scanner.nextLine();
		this.description = edited;;	
	}
	public void deleteTask(int index) {
		taskList.remove(index);
	}
	static void saveTask() {
		System.out.println("Saving the file....");
		 try (BufferedWriter writer = new BufferedWriter(new FileWriter("C://Users//acer//Desktop//JAVA/tasks.txt"))) {
		        for (ToDoList task : taskList) {
		            writer.write(task.toString());
		            writer.newLine();
		            System.out.println("File saved succesfully!");
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
	}
	static void loadTask() {
		System.out.println("File loading......");
		 try (BufferedReader reader = new BufferedReader(new FileReader("C://Users//acer//Desktop//JAVA/tasks.txt"))) {
		        String line;
		        while ((line = reader.readLine()) != null) {
		            taskList.add(new ToDoList(line)); // assuming your ToDoList constructor takes a String
		            System.out.println("File loaded succesfully!");
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
	}
	@Override
	public String toString() {  //overriding the object troString() method to directly print the object task1
		return description+(isComplete ? "(complete)" : "(pending)");
	}
	static void printTask() {
		for(int i =0 ; i < taskList.size(); i++) {
			ToDoList currentobj = taskList.get(i);
		System.out.println(i+1 + "." + currentobj.description+ (currentobj.isComplete ? "(complete)" : "(pending)"));
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;
		while(!exit) {
			System.out.println("\n\n\n1. Add a new task");
			System.out.println("2. List tasks");
			System.out.println("3. Mark a task as complete");
			System.out.println("4. Mark a task as incomplete");
			System.out.println("5. Count complete and incomplete tasks");
			System.out.println("6. Edit Task");
			System.out.println("7. Delete Task");
			System.out.println("8. Save File");
			System.out.println("9. Load File");
			System.out.println("10. Exit");
			System.out.println("=========CHOOSE AN OPTION========");
			
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			
			switch(choice) {
			case 1:
				System.out.println("Enter the task description:");
				String desc=scanner.nextLine();
				taskList.add(new ToDoList(desc));
				break;
				
				
			case 2:
				printTask();
				break;
				
			case 3:
				
				printTask();
				System.out.println("Enter the task to mark complete:");
				int number = scanner.nextInt();
				taskList.get(number-1).taskComplete();
				printTask();
				break;
				
			case 4:
				printTask();
				System.out.println("Enter the task to mark incomplete:");
				int number2 = scanner.nextInt();
				taskList.get(number2-1).taskIncomplete();
				printTask();
				break;
				
			case 5:
				ToDoList tasks = new ToDoList("");
				tasks.counter();
				break;
				
			case 6:
				printTask();
				System.out.println("Enter the number to edit");
				int j = scanner.nextInt();
				taskList.get(j-1).editTask();
				break;
				
				
			case 7:
				printTask();
				System.out.println("Enter the number to delete");
				int k = scanner.nextInt();
				taskList.get(k-1).deleteTask(k-1);
				printTask();
				break;
				
			case 8:
				saveTask();
				break;	
			case 9:
				loadTask();
				break;	
			case 10:
				exit = true;
				System.out.println("Exiting.....");
				break;
			
			default:
				System.out.println("Invalid option, try again...");
			}
			
		}
		scanner.close();

	}
}
