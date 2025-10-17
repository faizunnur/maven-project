package RoyalBengalAI.testing.github.action;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {

    @Test
    void testItemCreationAndGetter() {
        // 1. Setup: Define the expected name
        String expectedName = "My Test Item";

        // 2. Action: Create a new Item instance
        Item item = new Item(expectedName);

        // 3. Assertion: Check if the getName() method returns the correct value
        assertEquals(expectedName, item.getName());
    }
}