package name.alexkosarev.tutorials.todo.rest;

import lombok.Data;

@Data
public final class TodoPayload {

    private boolean done;

    private String task;
}
