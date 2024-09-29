package toDoList;

public class ToDoList {
	String description;
	boolean isComplete;
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
	public static void main(String[] args) {
		ToDoList task1 = new ToDoList("buy groceries");
		System.out.println(task1);
		task1.taskComplete();
		System.out.println(task1);
	}
}
