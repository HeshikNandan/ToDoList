package toDoList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.stream.Collectors;

public class ToDoList {
private HashMap<String, Task> tasks = new HashMap<String, Task>();

	public void addTask (Task task) {
		if (!task.getDescription().isEmpty())
			tasks.put(task.getDescription(), task);
	}
	public void completeTask(String description) {
		tasks.get(description).setComplete(true);
	}
	public boolean getStatus(String description) {
		return tasks.get(description).isComplete();
		//return false;
	}
	public Task getTask(String description) {
		return tasks.get(description);
		//return null;
	}
	public Task removeTask(String description) {
		return tasks.remove(description);
		//return null;
	}
	//== chek duplicate
	public boolean validateTask(Task task) {
		if ( tasks.get(task.getDescription()) != null )
		{
			return false;
		}
		else
		{
			return true;
		}
     // flag to store result 
  
	  	}
	public Collection<Task> getAllTasks() {
		return tasks.values();
		//return null;
	}
	public Collection<Task> getCompletedTasks() {
		return tasks.entrySet().stream().filter(e -> e.getValue().isComplete()).map(m -> m.getValue()).collect(Collectors.toList());
		//return null;
	}
}
