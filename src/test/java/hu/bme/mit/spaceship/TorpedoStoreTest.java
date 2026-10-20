package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void fire_Fail() {
        TorpedoStore store = new TorpedoStore(1, 1.0);
        boolean result = store.fire(1);
        assertEquals(false, result);
    }
    @Test
    void fire_None() {
        TorpedoStore store = new TorpedoStore(0);
        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(1);
        });
    }
    @Test
    void fire_More() {
        TorpedoStore store = new TorpedoStore(5);
        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(100);
        });
    }
    @Test
    void empty() {
        TorpedoStore store = new TorpedoStore(0);
        assertTrue(store.isEmpty());
    }
    @Test
    void notEmpty() {
        TorpedoStore store = new TorpedoStore(1);
        assertFalse(store.isEmpty());
    }
    @Test
    void getTorpedoCount() {
        TorpedoStore store = new TorpedoStore(15);
        assertEquals(15, store.getTorpedoCount());
        assertTrue(store.fire(7));
        assertEquals(8, store.getTorpedoCount());
        assertTrue(store.fire(8));
        assertEquals(0, store.getTorpedoCount());
    }
}
