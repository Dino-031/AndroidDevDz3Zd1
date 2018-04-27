package hr.ferit.bruno.exercise1.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hr.ferit.bruno.exercise1.R;
import hr.ferit.bruno.exercise1.TasksRepository;
import hr.ferit.bruno.exercise1.model.Task;

public class MainActivity extends AppCompatActivity {

	TasksRepository mRepository;

	@BindView(R.id.edittext_newtask_importance)
    EditText etNewTaskImportance;
	@BindView(R.id.edittext_newtask_summary)
    EditText etNewTaskSummary;
	@BindView(R.id.edittext_newtask_title)
    EditText etNewTaskTitle;

	@BindView(R.id.button_newtask_save)
    Button btnNewTaskSave;

	@BindView(R.id.textview_newtask_display)
    TextView tvNewTaskDisplay;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initializeUI();

		mRepository = TasksRepository.getInstance();
	}

	private void initializeUI() {
        ButterKnife.bind(this);
	}

	@OnClick(R.id.button_newtask_save)
	public void storeTask(View view){

		// ToDo: 	store the task
		// Parse data from the widgets and store it in a task
		// Store the task in the fake database using the repository

        Integer taskImportance = Integer.parseInt(etNewTaskImportance.getText().toString());
        String taskTitle = etNewTaskTitle.getText().toString();
        String taskSummay = etNewTaskSummary.getText().toString();

        mRepository.addTask(new Task(taskImportance,taskTitle,taskSummay));


		// ToDo:	clear the UI for the new task
		// Clear all of the editText controls

        ClearEditTexts();

		// ToDo: 	define a method
		// Create a method for displaying the tasks in the textview as strings
		// one below the other and call it on each new task.
        AddTasksToScrollView();
	}

    private void AddTasksToScrollView() {
        tvNewTaskDisplay.setText("");
        for(Task t:mRepository.getTasks())
        {
            String importance = String.valueOf(t.getImportance());
            String title = t.getTitle();
            String summary = t.getSummary();

            tvNewTaskDisplay.append(importance + " " + title + " " + summary + "\n");
        }
    }

    private void ClearEditTexts()
    {
        etNewTaskImportance.setText("");
        etNewTaskSummary.setText("");
        etNewTaskTitle.setText("");
    }
}
