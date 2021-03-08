package lab5.view;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author ...
 */
public abstract class SimView implements Observer {

    public abstract void update(Observable o, Object arg);
}
