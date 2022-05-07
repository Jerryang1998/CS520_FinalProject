package shipping;

public interface ITruck {
	
	/**
	 * The truck's registratrion number.  
	 * <p>
	 * @return A value that represents the truck's registration number.
	 */

	public String registration();
	
	/**
	 * Returns the code that represents the destination city for the truck.  
	 * <p>
	 * @return A string value indicating the destination for the truck.
	 */

	public String destinationCity();
	
	/**
	 * Adds a container to the truck.  
	 * <p>
	 * The implementation should only add the container if there is not already a container on the truck.
	 * @return True if the container was added and False otherwise.
	 */
	
	public boolean addContainer(IContainer container);
	
	/**
	 * Returns the container from the truck and removes it from the truck.  
	 * <p>
	 * @return A container reference for the container object being removed from the truck. If there is no container on the truck, the return value is null.
	 */
	
	public IContainer offloadContainer();
	
	/**
	 * Returns a boolean value indicating whether there is a container on the truck.  
	 * <p>
	 * @return True if the truck has a container and False otherwise.
	 */
	
	public boolean hasContainer();

	/**
	 * Prints the truck registration, destination city, and the truck contents.  
	 * <p>
	 * @return Nothing.
	 */
	
	public void printDetails();

}
