package frl.wgfm.robots.nasa;

/**
 * Created by wgfm on 29/10/16.
 */
public interface Parser<T> {
  T parse(String str);

  default void throwUnparsable(String unparsable) {
    throw new IllegalArgumentException(
        "Could not parse input: " + unparsable);
  }
}
