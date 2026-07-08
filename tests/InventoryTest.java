import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {

    @Test
    public void testSwordDamage() {
        Inventory sword = Inventory.createSword();
        assertEquals(50, sword.getdamage());
    }

    @Test
    public void testGunDamage() {
        Inventory gun = Inventory.createGun();
        assertEquals(70, gun.getdamage());
    }

    @Test
    public void testSwordName() {
        Inventory sword = Inventory.createSword();
        assertEquals("Sword", sword.getWeapon());
    }

    
    @Test
    public void testGunName() {
        Inventory gun = Inventory.createGun();
        assertEquals("Gun", gun.getWeapon());
    }
}