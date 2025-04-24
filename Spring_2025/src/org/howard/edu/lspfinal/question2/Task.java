package org.howard.edu.lspfinal.question2;


public class Task {
    private String name;
    private int priority;
    private String status;

    /**
     * Creates a Task
     *
     * @param name     name of the task
     * @param priority priority of task
     * @param status   represents "TODO", "IN_PROGRESS", or "DONE"
     * @throws IllegalArgumentException if name is null/empty or status invalid
     */
    public Task(String name, int priority, String status) {
        this.name = name;
        this.priority = priority;
        this.status = status;
    }
    
    /**
     * Returns if a status is in one of three valid states
     * @param s represents the status of the task
     * @return whether or not status is in a valid state
     */
    private boolean isValidStatus(String s) {
        return "TODO".equals(s) || "IN_PROGRESS".equals(s) || "DONE".equals(s);
    }
    /** 
     * Gets the name of the task
     * 
     * @return the task’s name */
    public String getName() {
        return name;
    }

    /** 
     * Gets the priority of the task
     * 
     * @return the task’s priority */
    public int getPriority() {
        return priority;
    }

    /**
     * Gets the status of the task
     *  
     *  @return the task’s status */
    public String getStatus() {
        return status;
    }

    /**
     * Sets a new status
     *
     * @param status one of "TODO", "IN_PROGRESS", or "DONE"
     * @throws IllegalArgumentException if status invalid
     */
    public void setStatus(String status) {
        if (!isValidStatus(status)) {
            throw new IllegalArgumentException("Invalid status: " + status);
        }
        this.status = status;
    }

    /**
     * toString override for object
     * 
     * @return string representation of task
     */
    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + ", status='" + status + "'}";
    }
}
