import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

// Task interface
interface TaskCompletable {
    void markComplete();
}

// Task class
class Task implements TaskCompletable, Comparable<Task> {
    private int taskID;
    private String description;
    private LocalDate dueDate;
    private int priority;
    private boolean completed;

    public Task(int taskID, String description, LocalDate dueDate, int priority) {
        this.taskID = taskID;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.completed = false;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public void markComplete() {
        this.completed = true;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return String.format("Task ID: %d, Description: %s, Due Date: %s, Priority: %d, Completed: %b",
                taskID, description, dueDate, priority, completed);
    }
}

// WorkTask class extending Task
class WorkTask extends Task {
    private String project;

    public WorkTask(int taskID, String description, LocalDate dueDate, int priority, String project) {
        super(taskID, description, dueDate, priority);
        this.project = project;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Project: %s", project);
    }
}

// PersonalTask class extending Task
class PersonalTask extends Task {
    private String category;

    public PersonalTask(int taskID, String description, LocalDate dueDate, int priority, String category) {
        super(taskID, description, dueDate, priority);
        this.category = category;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Category: %s", category);
    }
}

// TaskManager class implementing TaskCompletable
class TaskManager {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void scheduleTask(Task task, LocalDate date) {
        task.setDueDate(date);
    }

    public void viewTasks() {
        Collections.sort(tasks);
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void completeTask(TaskCompletable task) {
        task.markComplete();
    }
}
// Main class for console interaction
public class TaskManagementApp {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        // Example tasks
        WorkTask workTask = new WorkTask(1, "Complete project report", LocalDate.of(2023, 10, 30), 2, "Project X");
        PersonalTask personalTask = new PersonalTask(2, "Buy groceries", LocalDate.of(2023, 10, 20), 1, "Shopping");

        // Adding tasks to the manager
        taskManager.addTask(workTask);
        taskManager.addTask(personalTask);

        // Scheduling tasks
        taskManager.scheduleTask(new WorkTask(1, "Complete project report", LocalDate.of(2023, 10, 28), 2, "Project X"), LocalDate.of(2023, 10, 28));
        taskManager.scheduleTask(new PersonalTask(2, "Buy groceries", LocalDate.of(2023, 10, 20), 1, "Shopping"), LocalDate.of(2023, 10, 15));

        // Viewing tasks before completion
        System.out.println("Tasks before completion:");
        taskManager.viewTasks();

        // Completing a task
        taskManager.completeTask(personalTask);

        // Viewing tasks after completion
        System.out.println("\nTasks after completion:");
        taskManager.viewTasks();
    }
}
