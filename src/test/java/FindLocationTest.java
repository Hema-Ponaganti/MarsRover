import Exceptions.InstructionFailedException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindLocationTest {

    @Test
    void shouldReturnTheLocationWhenNoDirectionsGivenToMove() throws InstructionFailedException {
        FindLocation findLocation = new FindLocation();
        List<Integer> plateau = new ArrayList<Integer>();
        plateau.add(5);
        plateau.add(5);
        List<Integer> locOfRover = new ArrayList<Integer>();
        locOfRover.add(2);
        locOfRover.add(2);
        Character direction = 'N';
        List<Character> instructions = new ArrayList<>();

        List<Integer> currentLoc = findLocation.locationOfRover(plateau, locOfRover, direction, instructions);

        assertEquals(currentLoc, locOfRover);
    }
    @Test
    void shouldReturnTheLocationWhenDirectionsGivenToMove() throws InstructionFailedException {
        FindLocation findLocation = new FindLocation();
        List<Integer> plateau = new ArrayList<Integer>();
        plateau.add(5);
        plateau.add(5);
        List<Integer> locOfRover = new ArrayList<Integer>();
        locOfRover.add(2);
        locOfRover.add(2);
        Character direction = 'N';
        List<Character> instructions = new ArrayList<>();
        instructions.add('M');
        instructions.add('L');
        instructions.add('M');

        List<Integer> currentLoc = findLocation.locationOfRover(plateau, locOfRover, direction, instructions);

        assertEquals(currentLoc, locOfRover);
    }

    @Test
    void shouldThrowErrorIfRoverCannotMoveFurther(){
        FindLocation findLocation = new FindLocation();
        List<Integer> plateau = new ArrayList<Integer>();
        plateau.add(5);
        plateau.add(5);
        List<Integer> locOfRover = new ArrayList<Integer>();
        locOfRover.add(2);
        locOfRover.add(2);
        Character direction = 'N';
        List<Character> instructions = new ArrayList<>();
        instructions.add('M');
        instructions.add('M');
        instructions.add('M');

        assertThrows(InstructionFailedException.class, () -> findLocation.locationOfRover(plateau, locOfRover, direction, instructions));
    }

}