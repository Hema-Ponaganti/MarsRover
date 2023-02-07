import Exceptions.InstructionFailedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MarsRoverTest {

    @Test
    void shouldReturnTheLocationWhenNoDirectionsGivenToMove() throws InstructionFailedException {
        Plateau plateau = new Plateau(5, 5);
        MarsRover marsRover = new MarsRover(2, 2, 'N', plateau);
        char[] instructions = {};
        String expected = "Rover is at (2, 2) and facing N";

        assertEquals(expected, marsRover.followInstructions(instructions));
    }

    @Test
    void shouldReturnTheLocationWhenDirectionsGivenToMove() throws InstructionFailedException {
        Plateau plateau = new Plateau(5, 5);
        MarsRover marsRover = new MarsRover(2, 2, 'N', plateau);
        char[] instructions = {'M', 'L', 'M'};
        String expected = "Rover is at (1, 1) and facing W";

        assertEquals(expected, marsRover.followInstructions(instructions));
    }

    @Test
    void shouldThrowErrorIfRoverCannotMoveFurther() {
        Plateau plateau = new Plateau(5, 5);
        MarsRover marsRover = new MarsRover(2, 2, 'N', plateau);
        char[] instructions = {'M', 'M', 'M'};

        assertThrows(InstructionFailedException.class, () -> marsRover.followInstructions(instructions));
    }

}