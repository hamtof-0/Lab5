package lab5.events;

/**
 * @author Hampus Toft
 * @author Malkolm Lundkvist
 * @author Billy Norman
 * @author Axel Johansson
 */
public abstract class Event {
    private double executeTime;
    public abstract void execute();
}
