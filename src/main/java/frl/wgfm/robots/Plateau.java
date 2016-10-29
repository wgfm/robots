package frl.wgfm.robots;

/**
 * The plateau on Mars. Assuming that the plateau is large enough that multiple rovers
 * can have the same coordinates.
 *
 * Created by wgfm on 29/10/16.
 */
public class Plateau {
  private final int width;
  private final int height;

  public Plateau(int width, int depth) {
    if (width < 1 || depth < 1) {
      throw new IllegalArgumentException(
          "Could not build a plateau with width " + width + " and depth " + depth);
    }

    this.width = width;
    height = depth;
  }

  public int width() {
    return width;
  }

  public int height() {
    return height;
  }
}
