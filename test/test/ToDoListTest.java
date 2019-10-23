package test;
import java.util.Collection;

import org.junit.*;
import org.junit.Test;
import junit.framework.*;
import toDoList.*;

public class ToDoListTest extends TestCase{
	// Define Test Fixtures

	ToDoList toDoList;
	Task task1;
	Task task2;
	Task task3;
	
	public ToDoListTest() {
		super();
	}
	@Before
	 public void setUp() throws Exception{
		//Initialise Test Fixtures
		toDoList = new ToDoList();
		task1 = new Task("Task 1", false);
		toDoList.addTask(task1);
		task2 = new Task("Task 2", true);
		toDoList.addTask(task2);
		task3 = new Task("Task 3", true);
		toDoList.addTask(task3);
		
	}
	@After
	 public void tearDown() throws Exception{
		toDoList = null;
	}

	@Test
	public void testAddTask() {
		assertTrue(toDoList.getTask("Task 1").equals(task1));
	}
	@Test
	public void testGetStatus() {
		assertTrue(toDoList.getStatus(task2.getDescription()) == true);
	}
	
	@Test
	public void testIsComplete() {
		toDoList.completeTask(task1.getDescription());
		assertTrue(toDoList.getTask(task1.getDescription()).isComplete());
	}
	
	@Test
	public void testGetCompletedTasks() {
		assertEquals(toDoList.getCompletedTasks().size(), 2);	
	}
	
	@Test
	public void testRemoveTask() {
		toDoList.removeTask(task1.getDescription());
		toDoList.removeTask(task2.getDescription());
		toDoList.removeTask(task3.getDescription());
		assertEquals(true, toDoList.getAllTasks().isEmpty());
	}
	
}
