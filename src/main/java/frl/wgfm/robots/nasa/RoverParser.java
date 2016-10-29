package frl.wgfm.robots.nasa;

import frl.wgfm.robots.Direction;
import frl.wgfm.robots.Plateau;
import frl.wgfm.robots.Position;
import frl.wgfm.robots.Rover;

/**
 * Created by wgfm on 29/10/16.
 */
public class RoverParser implements Parser<Rover> {

  @Override
  public Rover parse(String str) {
    return makeRover(str, null);
  }

  public Rover makeRover(String str, Plateau plateau) {
    String[] roverArgs = str.split(" ");
    if (roverArgs.length != 3) {
      throwUnparsable(str);
    }

    try {
      int x = Integer.parseInt(roverArgs[0]);
      int y = Integer.parseInt(roverArgs[1]);
      char direction = roverArgs[2].charAt(0);

      return new Rover(
          new Position(x, y),
          Direction.fromChar(direction),
          plateau
      );
    } catch (NumberFormatException e) {
      throwUnparsable(str);
    }

    throw new AssertionError("Unreachable code");
  }
}
