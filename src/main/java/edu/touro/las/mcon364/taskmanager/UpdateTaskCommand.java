package edu.touro.las.mcon364.taskmanager;

import java.util.Optional;

public final class UpdateTaskCommand implements Command {
    private final TaskRegistry registry;
    private final String taskName;
    private final Priority newPriority;

    public UpdateTaskCommand(TaskRegistry registry, String taskName, Priority newPriority) {
        this.registry = registry;
        this.taskName = taskName;
        this.newPriority = newPriority;
    }
        @Override
        public void execute() {
            Task existing = registry.get(taskName)
                    .orElseThrow(() -> new TaskNotFoundException(
                            "Task '" + taskName + "' not found"));

            Task updated = new Task(existing.name(), newPriority);
            registry.add(updated);
        }
}
