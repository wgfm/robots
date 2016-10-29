package frl.wgfm.robots;

import org.junit.Test;

/**
 * Created by wgfm on 29/10/16.
 */
public class PlateauTest {

  @Test(expected = IllegalArgumentException.class)
  public void creatingPlateauWithInvalidWidth() {
    new Plateau(0, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void creatingPlateauWithInvalidHeight() {
    new Plateau(4, -1);
  }
}
