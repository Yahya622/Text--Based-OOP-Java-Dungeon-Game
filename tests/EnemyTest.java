import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnemyTest {

    @Test
    public void testGoblinInitialHealth() {
        Goblin goblin = new Goblin();
        assertEquals(100, goblin.getHealth());
    }

    @Test
    public void testDragonInitialHealth() {
        Dragon dragon = new Dragon();
        assertEquals(200, dragon.getHealth());
    }


    @Test
    public void testEnemyFactoryReturnsEnemy() {
        Enemy enemy = EnemyFactory.createEnemy();
        assertNotNull(enemy);
    }

    @Test
    public void testEnemyFactoryReturnsDragonOrGoblin() {
        Enemy enemy = EnemyFactory.createEnemy();
        assertTrue(enemy instanceof Dragon || enemy instanceof Goblin); //Dragon or Goblin
    }
}