package frl.wgfm.robots;

import frl.wgfm.robots.command.MoveForwardCommand;
import frl.wgfm.robots.command.SpinLeftCommand;
import frl.wgfm.robots.command.SpinRightCommand;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Created by wgfm on 29/10/16.
 */
public class RoverTest {

  private Rover rover;

  @Before
  public void setup() {
    Random random = new Random();
    Direction randomDirection = Direction.values()[random.nextInt(4)];
    Position randomPosition = new Position(
        random.nextInt(10),
        random.nextInt(10)
    );

    Plateau plateau = new Plateau(10, 10);

    rover = new Rover(randomPosition, randomDirection, plateau);
  }

  @Test
  public void spinLeftShouldFaceRoverCorrectly() {
    Direction old = rover.direction();
    rover.executeCommand(new SpinLeftCommand());
    assertEquals(old.left(), rover.direction());
  }

  @Test
  public void spinRightShouldFaceRoverCorrectly() {
    Direction old = rover.direction();
    rover.executeCommand(new SpinRightCommand());
    assertEquals(old.right(), rover.direction());
  }

  @Test
  public void spinningEastShouldFaceRoverEast() {
    rover.spin(Direction.EAST);
    assertEquals(Direction.EAST, rover.direction());
  }

  @Test
  public void movingForwardShouldMoveRoverOneStep() {
    Position old = rover.position();
    rover.executeCommand(new MoveForwardCommand());
    assertEquals(1, old.stepsBetween(rover.position()));
  }

  @Test
  public void movingForwardShouldCorrectlyUpdatePostition() {
    Position oldPos = rover.position();
    Direction direction = rover.direction();

    rover.executeCommand(new MoveForwardCommand());
    Position expected;
    switch(direction) {
      case NORTH:
        expected = new Position(oldPos.x(), oldPos.y() + 1);
        break;
      case EAST:
        expected = new Position(oldPos.x() + 1, oldPos.y());
        break;
      case SOUTH:
        expected = new Position(oldPos.x(), oldPos.y() - 1);
        break;
      case WEST:
        expected = new Position(oldPos.x() - 1, oldPos.y());
        break;
      default:
        throw new AssertionError("No such direction");
    }
    assertEquals(expected, rover.position());
  }

  @Test
  public void jumpingToPositionShouldUpdateRoversPosition() {
    Position newPos = new Position(7, 4);
    rover.setPosition(newPos);
    assertEquals(newPos, rover.position());
  }

  @Test(expected = IllegalStateException.class)
  public void jumpingOutsidePlateauShouldThrowException() {
    Position newPos = new Position(13, 37);
    rover.setPosition(newPos);
    assertEquals(newPos, rover.position());
  }
}
