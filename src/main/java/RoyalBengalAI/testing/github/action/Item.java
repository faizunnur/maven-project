package RoyalBengalAI.testing.github.action;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
@Document("items")

public class Item {
    @Id
    private String id;
    private String name;
    public Item(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

}