package RoyalBengalAI.testing.github.action;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers // 1. Activates Testcontainers
@SpringBootTest
class TestingGithubActionApplicationTests {

    // 2. Creates a MongoDB container for the test
    @Container
    static MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:latest"));

    // 3. Dynamically sets the database URI for the test
    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }

    @Test
    void contextLoads() {
        // This test will now pass because it can connect to the temporary database
        System.out.println("Application context loaded successfully with Testcontainers!");
    }
}