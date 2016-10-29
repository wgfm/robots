package frl.wgfm.robots.command;

import frl.wgfm.robots.Direction;
import frl.wgfm.robots.Rover;

/**
 * Created by wgfm on 29/10/16.
 */
public class SpinRightCommand implements Command {

  @Override
  public boolean execute(Rover rover) {
    Direction facing = rover.direction();
    rover.spin(facing.right());
    return true;
  }
}
