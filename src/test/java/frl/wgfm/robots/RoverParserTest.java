package frl.wgfm.robots;

import frl.wgfm.robots.nasa.RoverParser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by wgfm on 29/10/16.
 */
public class RoverParserTest {

  private RoverParser parser;

  @Before
  public void setup() {
    parser = new RoverParser();
  }

  @Test
  public void passingTwoNumbersShouldYieldRover() {
    Rover rover = parser.parse("4 2 N");
    Position pos = rover.position();
    assertEquals(pos.x(), 4);
    assertEquals(pos.y(), 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void passingTooFewArgsShouldThrow() {
    Rover rover = parser.parse("4");
  }

  @Test(expected = IllegalArgumentException.class)
  public void passingTooManyArgsShouldThrow() {
    Rover rover = parser.parse("1 3 4 5");
  }

  @Test(expected = IllegalArgumentException.class)
  public void passingNonNumbersShouldThrowForXAndY() {
    Rover rover = parser.parse("1 A E");
  }

  @Test(expected = IllegalArgumentException.class)
  public void passingInvalidDirectionShouldThrow() {
    Rover rover = parser.parse("1 4 P");
  }
}

