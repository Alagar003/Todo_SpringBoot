package SB.Todo.Service;

import SB.Todo.Model.Todo;
import SB.Todo.Dal.TodoRep; // Update the import statement
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRep todoRep;

    public List<Todo> getAllTodos() {
        return todoRep.getTodoList();
    }

    public Todo createTodo(Todo todo) {
        return todoRep.addTodo(todo);
    }

    public Todo updateTodo(String id, Todo newTodo) {
        return todoRep.updateTodo(id, newTodo);
    }

    public void deleteTodoById(String id) {
        todoRep.deletetodo(id);
    }


}
