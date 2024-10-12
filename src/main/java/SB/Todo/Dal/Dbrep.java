package SB.Todo.Dal;

import SB.Todo.Model.Todo;
import java.util.List;

public interface Dbrep {
      List<Todo> gettodo();
      Todo createtodo(Todo todo);
      Todo updateTodo(String id, Todo newTodo);
      void deleteById(String id);
}
