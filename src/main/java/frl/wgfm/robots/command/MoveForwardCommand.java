package frl.wgfm.robots.command;

import frl.wgfm.robots.Direction;
import frl.wgfm.robots.Position;
import frl.wgfm.robots.Rover;

/**
 * Created by wgfm on 29/10/16.
 */
public class MoveForwardCommand implements Command {

  @Override
  public boolean execute(Rover rover) {
    Direction facing = rover.direction();
    Position oldPos = rover.position();

    Position newPos;
    switch (facing) {
      case NORTH:
        newPos = new Position(oldPos, 0, 1);
        break;
      case EAST:
        newPos = new Position(oldPos, 1, 0);
        break;
      case SOUTH:
        newPos = new Position(oldPos, 0, -1);
        break;
      case WEST:
        newPos = new Position(oldPos, -1, 0);
        break;
      default:
        throw new AssertionError("No such direction: " + facing);
    }

    rover.setPosition(newPos);
    return true;
  }
}
