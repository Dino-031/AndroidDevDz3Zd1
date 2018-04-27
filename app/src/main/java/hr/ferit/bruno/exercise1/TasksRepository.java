package hr.ferit.bruno.exercise1;

import java.util.List;

import hr.ferit.bruno.exercise1.model.Task;
import hr.ferit.bruno.exercise1.persistance.FakeDatabase;

public class TasksRepository {

	private static TasksRepository sInstance = null;

	private FakeDatabase mDatabase;

	private TasksRepository(){
		mDatabase = new FakeDatabase();
	}

	public static synchronized TasksRepository getInstance(){
		if(sInstance == null){
			sInstance = new TasksRepository();
		}
		return sInstance;
	}

	public void addTask(Task task){
		mDatabase.addTask(task);
	}

	public List<Task> getTasks(){
		return mDatabase.getTasks();
	}
}
