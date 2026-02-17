package edu.touro.las.mcon364.taskmanager;

public class InvalidTaskPriorityException extends RuntimeException {
    public InvalidTaskPriorityException(String Name) {

        super("Priority not found: " + Name);
    }
}
