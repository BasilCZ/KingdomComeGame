package important;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntityTest {

    @Test
    void attack() {
        Armor.loadArmor();
        Entity e = new Entity();
        e.setHp(100);
        e.setMaxHp(200);
        assertEquals(8,e.attack(10, Armor.getArmors().get(0), 0));
        assertEquals(92, e.getHp());
        e.attack(10000, Armor.getArmors().get(0), 0);
        assertEquals(0,e.getHp());
    }

    @Test
    void changeStamina() {
        Entity e = new Entity();
        e.setStamina(10);
        e.changeStamina(10);
        assertEquals(20,e.getStamina());
        e.changeStamina(-30);
        assertEquals(0, e.getStamina());
    }

    @Test
    void changeHp() {
        Entity e = new Entity();
        e.setHp(100);
        e.setMaxHp(200);
        e.changeHp(100);
        assertEquals(200,e.getHp());
        e.changeHp(100);
        assertEquals(300,e.getHp());
        e.changeStamina(-1000);
        assertEquals(0, e.getStamina());
    }
}