package frl.wgfm.robots.nasa;

import frl.wgfm.robots.Plateau;
import frl.wgfm.robots.Rover;
import frl.wgfm.robots.command.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by wgfm on 29/10/16.
 */
public class Houston {

  private RoverParser roverParser = new RoverParser();
  private CommandsParser commandsParser = new CommandsParser();

  private BufferedReader reader = new BufferedReader(
      new InputStreamReader(System.in)
  );

  public static void main(String[] args) throws IOException {
    new Houston().run();
  }

  private Plateau initPlateau() throws IOException {
    out.println("Welcome to the Mars Rover control center");
    out.println("Enter the size of the plateau:");

    PlateauParser plateauParser = new PlateauParser();
    String plateauInitString = reader.readLine();
    return plateauParser.parse(plateauInitString);
  }

  public void commandRover(Plateau plateau) throws IOException {
    out.println("Enter the Rover's coordinates:");
    String roverInitString = reader.readLine();
    Rover rover = roverParser.makeRover(roverInitString, plateau);

    out.println("Enter the rover's commands: ");
    String roverCommandsString = reader.readLine();
    List<Command> commands = commandsParser.parse(roverCommandsString);

    for (Command command : commands) {
      rover.executeCommand(command);
    }

    out.println(rover);
  }

  public void run() throws IOException {
    Plateau plateau = initPlateau();
    while (true) {
      commandRover(plateau);
    }
  }
}
