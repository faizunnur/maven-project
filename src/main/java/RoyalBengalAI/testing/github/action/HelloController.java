package RoyalBengalAI.testing.github.action;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Correction 1: Added this annotation
public class HelloController {

    private final ItemRepository itemRepository;

    // Spring automatically provides the ItemRepository instance
    public HelloController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/hello")
    public String sayHello() {
        // Create a new item and save it to the database
        Item newItem = new Item("Test Item from Controller");
        itemRepository.save(newItem);

        return "Hello, CI/CD! Saved a new item to the database. \n Welcome to Royal Bengal AI. working on feature main branch.";
    }
}