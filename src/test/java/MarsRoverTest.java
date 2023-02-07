import Exceptions.InstructionFailedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MarsRoverTest {

    @Test
    void shouldReturnTheLocationWhenNoDirectionsGivenToMove() throws InstructionFailedException {
        Plateau plateau = new Plateau(5, 5);
        MarsRover marsRover = new MarsRover(2, 2, Direction.N, plateau);
        char[] instructions = {};
        String expected = "Rover is at (2, 2) and facing N";

        assertEquals(expected, marsRover.followInstructions(instructions));
    }

    @Test
    void shouldReturnTheLocationWhenDirectionsGivenToMove() throws InstructionFailedException {
        Plateau plateau = new Plateau(5, 5);
        MarsRover marsRover = new MarsRover(2, 2, Direction.N, plateau);
        char[] instructions = {'M', 'L', 'M'};
        String expected = "Rover is at (1, 1) and facing W";

        assertEquals(expected, marsRover.followInstructions(instructions));
    }

    @Test
    void shouldThrowErrorIfRoverCannotMoveFurther() {
        Plateau plateau = new Plateau(5, 5);
        MarsRover marsRover = new MarsRover(2, 2, Direction.N, plateau);
        char[] instructions = {'M', 'M', 'M'};

        assertThrows(InstructionFailedException.class, () -> marsRover.followInstructions(instructions));
    }

    @Test
    void shouldChangeDirectionOnLOrRInstructions() throws InstructionFailedException {
        MarsRover marsRover = new MarsRover(1,2,Direction.W, new Plateau(0,0));
        char[] instructionsSet1 = {'R', 'R'};
        char[] instructionsSet2 = {'L', 'L', 'R'};
        char[] instructionsSet3 = {'L'};
        char[] instructionsSet4 = {'L', 'R', 'L'};

        assertEquals("Rover is at (1, 2) and facing E", marsRover.followInstructions(instructionsSet1));
        assertEquals("Rover is at (1, 2) and facing N", marsRover.followInstructions(instructionsSet2));
        assertEquals("Rover is at (1, 2) and facing W", marsRover.followInstructions(instructionsSet3));
        assertEquals("Rover is at (1, 2) and facing S", marsRover.followInstructions(instructionsSet4));

    }

}