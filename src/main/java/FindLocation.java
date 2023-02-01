import Exceptions.InstructionFailedException;

import java.util.List;

public class FindLocation {
    public List<Integer> locationOfRover(List<Integer> plateau, List<Integer> locOfRover, Character direction, List<Character> instructions) throws InstructionFailedException {
        if (instructions.isEmpty()) {
            return locOfRover;
        }
            for (Character instruction : instructions) {
                if (instruction == 'M') {
                    locOfRover = newLocation(plateau, locOfRover, direction);
                }
                if (instruction == 'L') {
                    direction = changeDirection(instruction, direction);
                }
                if (instruction == 'R') {
                    direction = changeDirection(instruction, direction);
                }
            }

        return locOfRover;
    }

    private List<Integer> newLocation(List<Integer> plateau, List<Integer> locOfRover, Character direction) throws InstructionFailedException {
        if (direction == 'N' && (locOfRover.get(0) - 1) >= plateau.get(0)) {
            locOfRover.add(0, (locOfRover.get(0) - 1));
        } else if (direction == 'S' && (locOfRover.get(0) + 1) <= plateau.get(0)) {
            locOfRover.add(0, (locOfRover.get(0) + 1));
        } else if (direction == 'W' && (locOfRover.get(1) - 1) >= plateau.get(1)) {
            locOfRover.add(0, (locOfRover.get(1) - 1));
        } else if (direction == 'E' && (locOfRover.get(1) + 1) <= plateau.get(1)) {
            locOfRover.add(0, (locOfRover.get(1) + 1));
        }
        else {
            throw new InstructionFailedException("you have reached to the end");
        }

        return locOfRover;
    }

    private Character changeDirection(Character instruction, Character oldDirection) {
        if (instruction == 'L') {
            if (oldDirection == 'N')
                oldDirection = 'W';
            else if (oldDirection == 'W')
                oldDirection = 'S';
            else if (oldDirection == 'S')
                oldDirection = 'E';
            else if (oldDirection == 'E')
                oldDirection = 'N';
        } else if (instruction == 'R') {
            if (oldDirection == 'N')
                oldDirection = 'E';
            else if (oldDirection == 'W')
                oldDirection = 'N';
            else if (oldDirection == 'S')
                oldDirection = 'W';
            else if (oldDirection == 'E')
                oldDirection = 'S';
        }
        return oldDirection;
    }
}
