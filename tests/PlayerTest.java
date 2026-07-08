import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void testPlayerInitialHealth() {
        Player player = new Player("Test", 100, 50);
        assertEquals(100, player.getHealth());
    }
}