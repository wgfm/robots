package frl.wgfm.robots;

public enum Direction {
  NORTH('N'), EAST('E'), SOUTH('S'), WEST('W');

  private char repr;

  Direction(char repr) {
    this.repr = repr;
  }

  public String representation() {
    return "" + repr;
  }

  public Direction left() {
    switch(this) {
      case NORTH:
        return WEST;
      case EAST:
        return NORTH;
      case SOUTH:
        return EAST;
      case WEST:
        return SOUTH;
      default:
        throw new AssertionError("No such direction: " + this);
    }
  }

  public Direction right() {
    switch(this) {
      case NORTH:
        return EAST;
      case EAST:
        return SOUTH;
      case SOUTH:
        return WEST;
      case WEST:
        return NORTH;
      default:
        throw new AssertionError("No such direction: " + this);
    }
  }

  public static Direction fromChar(char ch) {
    switch (ch) {
      case 'N':
      case 'n':
        return NORTH;
      case 'E':
      case 'e':
        return EAST;
      case 'S':
      case 's':
        return SOUTH;
      case 'W':
      case 'w':
        return WEST;
      default:
        throw new IllegalArgumentException("No such direction: " + ch);
    }
  }
}
