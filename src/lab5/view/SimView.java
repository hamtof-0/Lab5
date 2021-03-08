package lab5.view;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author ...
 * @author Axel Johansson
 */
public abstract class SimView implements Observer {

    public abstract void update(Observable o, Object arg);
}
