import Exceptions.InstructionFailedException;

public class MarsRover {
    private int x;
    private int y;
    private Direction direction;
    private final Plateau plateau;

    public MarsRover(int x, int y, Direction direction, Plateau plateau){
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
        if (direction == Direction.N && plateau.isRoverWithinBoundary(x-1, y)) {
            x--;
        } else if (direction == Direction.S && plateau.isRoverWithinBoundary(x+1, y)) {
            x++;
        } else if (direction == Direction.W && plateau.isRoverWithinBoundary(x, y-1)) {
            y--;
        } else if (direction == Direction.E && plateau.isRoverWithinBoundary(x, y+1)) {
            y++;
        }
        else {
            throw new InstructionFailedException("you have reached to the end");
        }
    }

    private void changeDirection(Character instruction) {
        if (instruction == 'L') {
            if (direction == Direction.N)
                direction = Direction.W;
            else if (direction == Direction.W)
                direction = Direction.S;
            else if (direction == Direction.S)
                direction = Direction.E;
            else if (direction == Direction.E)
                direction = Direction.N;
        } else if (instruction == 'R') {
            if (direction == Direction.N)
                direction = Direction.E;
            else if (direction == Direction.W)
                direction = Direction.N;
            else if (direction == Direction.S)
                direction = Direction.W;
            else if (direction == Direction.E)
                direction = Direction.S;
        }
    }

    public String location() {
        System.out.println("Rover is at ("+ x + ", " + y+") and facing " + direction);
        return "Rover is at ("+ x + ", " + y+") and facing " + direction;
    }
}
