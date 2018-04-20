package hr.ferit.bruno.exercise1.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import hr.ferit.bruno.exercise1.R;
import hr.ferit.bruno.exercise1.TasksRepository;

public class MainActivity extends AppCompatActivity {

	TasksRepository mRepository;

	EditText mTitle, mSummary, mImportance;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initializeUI();

		mRepository = TasksRepository.getInstance();
	}

	private void initializeUI() {
		mTitle = findViewById(R.id.edittext_newtask_title);
		mSummary = findViewById(R.id.edittext_newtask_title);
	}

	public void storeTask(View view){

		// ToDo: 	store the task
		// Parse data from the widgets and store it in a task
		// Store the task in the fake database using the repository

		// ToDo:	clear the UI for the new task
		// Clear all of the editText controls

		// ToDo: 	define a method
		// Create a method for displaying the tasks in the textview as strings
		// one below the other and call it on each new task.
	}
}
