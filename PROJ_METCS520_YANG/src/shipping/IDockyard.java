package shipping;

public interface IDockyard {
	
	/**
	 * Adds a Container to the dockyard.  
	 * <p>
	 * This method assumes there is no maximum number of containers that the dockyard can hold. 
	 * The implementation needs to be able to handle any number of containers. 
	 *
	 * @param  IContainer a container
	 * @see IContainer
	 */
	
	public void addContainer(IContainer container);

	/**
	 * Loads a truck with the next container available based on the truck's destination.  
	 * <p>
	 * This methods adds the container to the dockyard in an efficient organized way so that containers can be 
	 * loaded onto trucks later in a very efficient manner based on the truck's destination.
	 * 
	 * @param  ITruck A truck used to load a single container.
	 * @return A boolean value indicating whether or not the truck was loaded.
	 * @see ITruck
	 */
	
    public boolean loadTruck(ITruck truck);
    
	/**
	 * Counts the number of containers in the overall dockyard.  
	 * <p>
	 * The implementation needs to be able to return the total number of containers currently stored in the dockyard. 
	 *
	 * @return The total number of containers in the dockyard.
	 */
    
	public int containerCount();

	/**
	 * Counts the number of containers in the overall dockyard.  
	 * <p>
	 * The implementation needs to be able to return the total number of containers currently stored in the dockyard. 
	 *
	 * @param String destination city
	 * @return The total number of containers in the dockyard.
	 */
	
	public int containerCount(String destinationCity);
	
	/**
	 * Prints the details of the current dockyard status.  
	 * <p>
	 * This method prints the total number of containers and then the number of containers destined for each city.
	 *
	 * @return Nothing.
	 */
	
	public void printDetails();
	
}