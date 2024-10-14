package SB.Todo.Config;

import SB.Todo.Dal.DbRepository;
import SB.Todo.Dal.InMemory;
import SB.Todo.Dal.PostgresTodoRepository;
import SB.Todo.Dal.TodoRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TodoConfig {

    @Value("${db.type}")
    private String dbType;

    @Autowired
    private TodoRep mongoRep;

    @Autowired
    private InMemory inmemory;

    @Autowired
    private PostgresTodoRepository postgresTodoRepository;

    public TodoConfig(TodoRep mongoRep, InMemory inmemory) {
        this.mongoRep = mongoRep;
        this.inmemory = inmemory;
    }

    @Bean(name = "todorepository")
    public DbRepository TodoRep () {
        if ("inMemory".equalsIgnoreCase(dbType)) {
            return inmemory;
        } else if ("mongo".equalsIgnoreCase(dbType)) {
            return  mongoRep;
        }
        else {
            return postgresTodoRepository;
        }
    }
}