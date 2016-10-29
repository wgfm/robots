package frl.wgfm.robots;

import frl.wgfm.robots.command.Command;
import frl.wgfm.robots.command.SpinRightCommand;
import frl.wgfm.robots.nasa.CommandsParser;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by wgfm on 29/10/16.
 */
public class CommandsParserTest {

  private CommandsParser parser;

  @Before
  public void setup() {
    parser = new CommandsParser();
  }

  @Test
  public void passingCorrectArgsShouldGiveCommandList() {
    String comStr = "RLLMMRL";
    List<Command> commands = parser.parse(comStr);

    assertEquals(comStr.length(), commands.size());
    assertEquals(commands.get(0).getClass(), SpinRightCommand.class);
  }

  @Test(expected = IllegalArgumentException.class)
  public void passingNumbersShouldThrow() {
    List<Command> commands = parser.parse("4");
  }

  @Test(expected = IllegalArgumentException.class)
  public void passingInvalidCommandsShouldThrow() {
    List<Command> commands = parser.parse("AOFIODF");
  }
}
