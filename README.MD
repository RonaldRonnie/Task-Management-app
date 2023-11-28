# Task Management App

## Overview

The Task Management App is a straightforward Java console application that enables users to organize and manage their tasks. It allows users to create various tasks, schedule them, mark them as complete, and view their task lists.

## Classes

### 1. Task

- Represents a generic task with attributes like task ID, description, due date, priority, and completion status.

### 2. WorkTask

- Extends the Task class and includes an additional attribute, "project," to represent work-related tasks.

### 3. PersonalTask

- Extends the Task class and includes an additional attribute, "category," to represent personal tasks.

### 4. TaskManager

- Manages tasks and provides methods for adding tasks, scheduling tasks, completing tasks, and viewing the task list.

### 5. TaskCompletable

- Interface implemented by classes that can be marked as complete. Both Task and TaskManager implement this interface.

## Usage

### Creating Tasks

```java
WorkTask workTask = new WorkTask(1, "Complete project report", LocalDate.of(2023, 10, 30), 2, "Project X");
PersonalTask personalTask = new PersonalTask(2, "Buy groceries", LocalDate.of(2023, 10, 20), 1, "Shopping");
```

Add tasks to the TaskManager:

```java
taskManager.addTask(workTask);
taskManager.addTask(personalTask);
```

### Scheduling Tasks

```java
taskManager.scheduleTask(workTask, LocalDate.of(2023, 10, 28));
taskManager.scheduleTask(personalTask, LocalDate.of(2023, 10, 15));
```

### Completing Tasks

```java
taskManager.completeTask(personalTask);
```

### Viewing Tasks

```java
taskManager.viewTasks();
```

Tasks will be displayed in ascending order based on their priority.
