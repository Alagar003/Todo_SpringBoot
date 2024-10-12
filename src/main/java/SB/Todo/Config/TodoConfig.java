package SB.Todo.Config;

import SB.Todo.Dal.Dbrep;
import SB.Todo.Dal.InMemory;
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

    public TodoConfig(TodoRep mongoRep, InMemory inmemory) {
        this.mongoRep = mongoRep;
        this.inmemory = inmemory;
    }

    @Bean(name = "todorepository")
    public Dbrep TodoRep () {
        if ("inMemory".equalsIgnoreCase(dbType)) {
            return inmemory;
        } else {
            return  mongoRep;
        }
    }
}
