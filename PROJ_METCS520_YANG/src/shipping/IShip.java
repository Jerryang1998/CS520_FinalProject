package shipping;

import java.util.List;

public interface IShip {
	
	/**
	 * Returns the ship's unique registration id.  
	 * <p>
	 * @return A string value indicating the ship's registration id.
	 */

	public String getRegistration();

	/**
	 * Sets the ship's unique registration id.  
	 * <p>
	 * @param id A string value indicating the ship's registration id.
	 */

	public void setRegistration(String id);

	/**
	 * Adds a container to the ship.  
	 * <p>
	 * @return Nothing.
	 * @see IContainer
	 */

	public void addContainer(IContainer container);
	
	/**
	 * Returns a list of the containers that are on the ship.  
	 * <p>
	 * @return A list of containers currently on the ship.
	 * @see List
	 * @see IContainer
	 */

	public List<IContainer> containers();
	
	/**
	 * Offloads the containers from the ship and returns the list of containers.  
	 * <p>
	 * @return A list of containers that are offloaded.
	 * @see List
	 * @see IContainer
	 */

	public List<IContainer> offload();
	
	/**
	 * Print the details of the ship to the console including the ship 
	 * registration number and the number of containers currently on the ship.  
	 * <p>
	 * @return Nothing.
	 */

	public void printDetails();

}