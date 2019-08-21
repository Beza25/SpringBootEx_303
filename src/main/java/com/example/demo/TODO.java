package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class TODO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String taskName;

    @NotNull
    private int dueDate;

    @NotNull
    private String priority;

    public int getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public int getDueDate() {
        return dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setDueDate(int dueDate) {
        this.dueDate = dueDate;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
