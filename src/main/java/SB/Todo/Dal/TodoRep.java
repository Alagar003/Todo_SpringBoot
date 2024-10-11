package SB.Todo.Dal;

import SB.Todo.Model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoRep {

    @Autowired
    private MongoRep mongoRep; // MongoRep should be an interface extending MongoRepository

    public List<Todo> getTodoList() {
        return mongoRep.findAll(); // Fetch all todos from MongoDB
    }

    public Todo addTodo(Todo todo) {
        return mongoRep.save(todo); // Save the new todo; MongoDB generates the ID
    }

    public Todo updateTodo(String id, Todo newTodo) {
        // Check if the Todo exists
        if (!mongoRep.existsById(id)) {
            throw new RuntimeException("Todo not found");
        }

        newTodo.setId(id); // Set the existing ID for the update
        return mongoRep.save(newTodo); // Update the existing todo
    }

    public void deletetodo(String id) {
        if (!mongoRep.existsById(id)) {
            throw new RuntimeException("Todo not found");
        }
        mongoRep.deleteById(id); // Delete the todo by ID
    }

    public Todo findById(String id) {
        return mongoRep.findById(id).orElse(null); // Return todo if found
    }
}
