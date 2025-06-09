import com.example.storageservice.controller.UserHomeController; // Add this import
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = com.example.storageservice.StorageServiceApplication.class)
public class StorageServiceApplicationTests {

    @Autowired
    private UserHomeController userHomeController;

    @Test
    void testCreateUserHome() {
        String userId = "testuser123";
        ResponseEntity<String> response = userHomeController.createUserHome(userId);
        assertEquals(201, response.getStatusCodeValue());
        assertEquals("User home created for: " + userId, response.getBody());
    }

    @Test
    void testCreateUserHomeInvalidUserId() {
        String userId = "InvalidUser@123";
        ResponseEntity<String> response = userHomeController.createUserHome(userId);
        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Invalid user ID", response.getBody());
    }
}