package SB.Todo.Service;

import SB.Todo.Model.Todo;
import SB.Todo.Dal.Dbrep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final Dbrep dbrep;

    // Constructor injection is preferred
    @Autowired
    public TodoService(@Qualifier("todorepository") Dbrep dbrep) {
        this.dbrep = dbrep;
    }

    public List<Todo> getAllTodos() {
        return dbrep.gettodo();
    }

    public Todo createTodo(Todo todo) {
        return dbrep.createtodo(todo);
    }

    public Todo updateTodo(String id, Todo newTodo) {
        return dbrep.updateTodo(id, newTodo);
    }

    public void deleteTodoById(String id) {
        dbrep.deleteById(id);
    }
}
