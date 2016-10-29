package frl.wgfm.robots.command;

import frl.wgfm.robots.Rover;

/**
 * Created by wgfm on 29/10/16.
 */
public interface Command {
  boolean execute(Rover rover);
}
