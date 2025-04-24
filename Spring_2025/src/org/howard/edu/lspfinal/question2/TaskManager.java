package org.howard.edu.lspfinal.question2;

import java.util.HashMap;
import java.util.Map;


public class TaskManager {
    private final Map<String, Task> tasks = new HashMap<>();

    /**
     * Adds a new task
     *
     * @param name     task name
     * @param priority priority of task
     * @param status   initial status of task
     * @throws DuplicateTaskException  if name already exists
     */
    public void addTask(String name, int priority, String status) throws DuplicateTaskException {
        if (tasks.containsKey(name)) {
            throw new DuplicateTaskException("Task '" + name + "' already exists.");
        }
        Task t = new Task(name, priority, status);
        tasks.put(name, t);
    }

    /**
     * Retrieves a task by its name
     *
     * @param name 		name of the task
     * @return the task with passed name
     * @throws TaskNotFoundException if task not found
     */
    public Task getTaskByName(String name) throws TaskNotFoundException {
        Task t = tasks.get(name);
        if (t == null) {
            throw new TaskNotFoundException("Task '" + name + "' not found.");
        }
        return t;
    }

    /**
     * Updates the status of existing task
     *
     * @param name      name of the task
     * @param newStatus new task status
     * @throws TaskNotFoundException   if no task is found
     * @throws IllegalArgumentException if newStatus is invalid
     */
    public void updateStatus(String name, String newStatus) throws TaskNotFoundException {
        Task t = tasks.get(name);
        if (t == null) {
            throw new TaskNotFoundException("Task '" + name + "' not found.");
        }
        t.setStatus(newStatus);
    }

    /**
     * Prints all tasks grouped under each status heading.
     */
    public void printTasksGroupedByStatus() {
        System.out.println("Tasks grouped by status:");
        String[] order = { "TODO", "IN_PROGRESS", "DONE" };
        for (String status : order) {
            System.out.println(status + ":");
            for (Task t : tasks.values()) {
                if (t.getStatus().equals(status)) {
                    System.out.println("  " + t);
                }
            }
        }
    }
}
