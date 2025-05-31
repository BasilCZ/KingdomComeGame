package important;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void changeHunger() {
        Player p = new Player();
        p.setHunger(10);
        p.changeHunger(-20);
        assertEquals(0, p.getHunger());
    }

    @Test
    void changeTiredness() {
        Player p = new Player();
        p.setTiredness(10);
        p.changeTiredness(-200);
        assertEquals(0, p.getTiredness());
    }
}