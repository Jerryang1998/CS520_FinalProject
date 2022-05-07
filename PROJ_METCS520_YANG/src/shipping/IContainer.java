package shipping;

public interface IContainer {
	
	/**
	 * Returns the container's unique id.
	 *   
	 * @return A string value indicating the container's id.
	 */

	public String id();
	
	
	/**
	 * Returns a description of container.  
	 * <p>
	 * @return A string value indicating the container's description.
	 */
	
	public String description();
	
	/**
	 * Returns the code that represents the destination city for the container.  
	 * <p>
	 * @return A string value indicating the destination for the container.
	 */
	
	public String destinationCity();
}
