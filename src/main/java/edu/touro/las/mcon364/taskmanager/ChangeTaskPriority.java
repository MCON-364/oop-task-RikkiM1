package edu.touro.las.mcon364.taskmanager;

import java.util.Optional;

public final class ChangeTaskPriority implements Command {
    private final TaskRegistry registry;
    private final String taskName;
    private final Priority newPriority;


    public ChangeTaskPriority(TaskRegistry registry, String taskName, Priority newPriority) {
        this.registry = registry;
        this.taskName = taskName;
        this.newPriority = newPriority;
    }

    @Override
    public void execute() {

        Optional<Task> maybeTask = registry.get(taskName);
        maybeTask.ifPresent(task -> {
            Task updated = new Task(task.name(), newPriority); // records are immutable
            registry.add(updated); // replaces the old task
        });
    }


}
