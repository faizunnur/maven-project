package RoyalBengalAI.testing.github.action;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Correction 1: Added this annotation
public class HelloController {

    @GetMapping("/hello") // Correction 2: Moved this annotation to the method
    public String sayHello() {
        return "Hello, CI/CD! The pipeline is working! ";
    }
}