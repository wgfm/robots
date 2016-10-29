package frl.wgfm.robots.nasa;

import frl.wgfm.robots.Plateau;

/**
 * Created by wgfm on 29/10/16.
 */
public class PlateauParser implements Parser<Plateau> {
  @Override
  public Plateau parse(String str) {
    String[] sizes = str.split(" ");
    if (sizes.length != 2) {
      throwUnparsable();
    }

    int width = 0;
    int height = 0;
    try {
      width = Integer.parseInt(sizes[0]);
      height = Integer.parseInt(sizes[1]);
    } catch (NumberFormatException e) {
      throwUnparsable();
    }
    return new Plateau(width, height);
  }

  public void throwUnparsable() {
    throw new IllegalArgumentException(
        "Invalid plateau size specification. Use two numbers, seperated by a space");
  }
}
