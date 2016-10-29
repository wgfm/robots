package frl.wgfm.robots;

import frl.wgfm.robots.command.Command;

/**
 * Created by wgfm on 29/10/16.
 */
public class Rover {

  private Position position;

  private Direction facing;

  private Plateau plateau;

  public Rover(Position position, Direction facing, Plateau plateau) {
    this.position = position;
    this.facing = facing;
    this.plateau = plateau;
  }

  public Position position() {
    return position;
  }

  public Direction direction() {
    return facing;
  }

  /**
   * Executes a command.
   * @return  whether the command could be completed successfully
   */
  public boolean executeCommand(Command command) {
    return command.execute(this);
  }

  public void setPosition(Position position) {
    if (fallingOff(position)) {
      throw new IllegalStateException("Rover fell off the plateau");
    }
    this.position = position;
  }

  public void spin(Direction direction) {
    this.facing = direction;
  }

  private boolean fallingOff(Position pos) {
    return pos.x() > plateau.width() ||
        pos.y() > plateau.height() ||
        pos.x() < 0 ||
        pos.y() < 0;
  }

  @Override
  public String toString() {
    return position.x() + " " + position.y() + " " + facing.representation();
  }
}
