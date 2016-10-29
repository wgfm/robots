package frl.wgfm.robots;

import frl.wgfm.robots.nasa.PlateauParser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by wgfm on 29/10/16.
 */
public class PlateauParserTest {

  private PlateauParser parser;

  @Before
  public void setup() {
    parser = new PlateauParser();
  }

  @Test
  public void parsingTwoNumbersShouldYieldPlateau() {
    Plateau plateau = parser.parse("4 2");
    assertEquals(plateau.width(), 4);
    assertEquals(plateau.height(), 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void parsingTooFewArgsShouldThrow() {
    Plateau plateau = parser.parse("4");
  }

  @Test(expected = IllegalArgumentException.class)
  public void parsingTooManyArgsShouldThrow() {
    Plateau plateau = parser.parse("1 3 4");
  }

  @Test(expected = IllegalArgumentException.class)
  public void parsingNonNumbersShouldThrow() {
    Plateau plateau = parser.parse("1 A");
  }
}
