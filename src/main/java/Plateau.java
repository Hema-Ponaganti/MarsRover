public class Plateau {
    private final int xCoordinate;
    private final int yCoordinate;

    public Plateau(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }
    public boolean isRoverWithinBoundary(int x, int y) {
        return x >= 1 && x <= xCoordinate && y >= 1 && y <= yCoordinate;
    }
}
