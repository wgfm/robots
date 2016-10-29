package frl.wgfm.robots;

/**
 * Created by wgfm on 29/10/16.
 */
public class Position {

  private final int x;
  private final int y;

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Position(Position old, int dx, int dy) {
    this(old.x + dx, old.y + dy);
  }

  public int x() {
    return x;
  }

  public int y() {
    return y;
  }

  public int stepsBetween(Position other) {
    return Math.abs(x - other.x) + Math.abs(y - other.y);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Position position = (Position) o;

    return x == position.x && y == position.y;
  }

  @Override
  public int hashCode() {
    int result = x;
    result = 31 * result + y;
    return result;
  }
}
