import Exceptions.InstructionFailedException;

public class MarsRover {
    private int x;
    private int y;
    private Character direction;
    private final Plateau plateau;

    public MarsRover(int x, int y, Character direction, Plateau plateau){
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.plateau = plateau;
    }

    public String followInstructions(char[] instructions) throws InstructionFailedException {
        for (Character instruction : instructions) {
            if (instruction == 'M') {
                newLocation();
            }
            if (instruction == 'L') {
                changeDirection(instruction);
            }
            if (instruction == 'R') {
                changeDirection(instruction);
            }
        }
        return location();
    }

    private void newLocation() throws InstructionFailedException {
        if (direction == 'N' && plateau.isRoverWithinBoundary(x-1, y)) {
            x--;
        } else if (direction == 'S' && plateau.isRoverWithinBoundary(x+1, y)) {
            x++;
        } else if (direction == 'W' && plateau.isRoverWithinBoundary(x, y-1)) {
            y--;
        } else if (direction == 'E' && plateau.isRoverWithinBoundary(x, y+1)) {
            y++;
        }
        else {
            throw new InstructionFailedException("you have reached to the end");
        }
    }

    private void changeDirection(Character instruction) {
        if (instruction == 'L') {
            if (direction == 'N')
                direction = 'W';
            else if (direction == 'W')
                direction = 'S';
            else if (direction == 'S')
                direction = 'E';
            else if (direction == 'E')
                direction = 'N';
        } else if (instruction == 'R') {
            if (direction == 'N')
                direction = 'E';
            else if (direction == 'W')
                direction = 'N';
            else if (direction == 'S')
                direction = 'W';
            else if (direction == 'E')
                direction = 'S';
        }
    }

    public String location() {
        System.out.println("Rover is at ("+ x + ", " + y+") and facing " + direction);
        return "Rover is at ("+ x + ", " + y+") and facing " + direction;
    }
}
