import java.util.ArrayList;
import java.util.List;

/**
 * Dies ist die Hauptklasse eines Spiels. Sie enthält die Hauptmethode, die zum
 * Starten des Spiels aufgerufen werden muss.
 *
 * @author Thomas Röfer
 */
abstract class PI1Game extends Game
{
    /** Das Spiel beginnt durch Aufruf dieser Methode. */
    public static void main(String[] args)
    {
        // Den Level erzeugen
        final Level level = new Level("levels/1.lvl");

        // Die Hauptschleife des Spiels
        while (level.getActors().get(0).isVisible()) {
            for (final Actor actor : level.getActors()) {
                 actor.act();
            }
        }

        level.hide();
    }
}
