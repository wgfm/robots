package frl.wgfm.robots.nasa;

import frl.wgfm.robots.command.Command;
import frl.wgfm.robots.command.MoveForwardCommand;
import frl.wgfm.robots.command.SpinLeftCommand;
import frl.wgfm.robots.command.SpinRightCommand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by wgfm on 29/10/16.
 */
public class CommandsParser implements Parser<List<Command>> {

  private static final Map<Character, Command> availableCommands =
      new HashMap<>();

  static {
    availableCommands.put('L', new SpinLeftCommand());
    availableCommands.put('R', new SpinRightCommand());
    availableCommands.put('M', new MoveForwardCommand());
  }

  @Override
  public List<Command> parse(String str) {
    List<Command> commands = str
        .trim()
        .chars()
        .mapToObj(ch -> (char) ch) // Sigh, java...
        .map(availableCommands::get)
        .collect(Collectors.toList());

    if (anyWrongCommands(commands)) {
      throwUnparsable(str);
    }

    return commands;
  }

  private boolean anyWrongCommands(List<Command> commands) {
    return commands
        .stream()
        .anyMatch(c -> c == null);
  }
}
