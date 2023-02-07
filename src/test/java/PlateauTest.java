import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlateauTest {

    @Test
    void shouldReturnTrueIfCoordinatesAreWithinPlateau() {
        Plateau plateau = new Plateau(5,5);

        assertTrue(plateau.isRoverWithinBoundary(1,5));
        assertTrue(plateau.isRoverWithinBoundary(3,1));
        assertTrue(plateau.isRoverWithinBoundary(4,2));
    }

    @Test
    void shouldReturnFalseIfCoordinatesAreNotWithinPlateau() {
        Plateau plateau = new Plateau(5,5);

        assertFalse(plateau.isRoverWithinBoundary(0,3));
        assertFalse(plateau.isRoverWithinBoundary(5,0));
        assertFalse(plateau.isRoverWithinBoundary(-1,2));
        assertFalse(plateau.isRoverWithinBoundary(4,-1));
    }
}