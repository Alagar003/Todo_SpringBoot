package SB.Todo.Dal;
import SB.Todo.Model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MongoRep extends MongoRepository <Todo,String> {
}
