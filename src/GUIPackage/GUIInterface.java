package GUIPackage;

/**
 * This interface is the external API. This contains the information that the frontend
 * will pass to the backend. The backend will call these methods in order to change the
 * Model after receiving the commands that are typed into the console.
 *
 * @author David
 */
public interface GUIInterface {

    /**
     * Gives the backend the dimensions for the canvas so that they can create and
     * update the Model.
     *
     * @return
     */
    public int getWidth();

    public int getHeight();

    /**
     * This method notifies the observers of the TurtleObservable object that it
     * has changed. Once the observers see that the object has changed, it can
     * update itself and match the changes of the TurtleObservable object.
     */
    public void notifyAllObservers();
}
