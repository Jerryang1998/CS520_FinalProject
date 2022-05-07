package solution;

public class Container implements shipping.IContainer{

	// Properties
	private String id;
	private String destinationCity;
	private String description;
	
	// Constructors
	public Container(String id, String destinationCity) {
		this(id, destinationCity, "");
	}
	
	public Container(String id, String destinationCity, String description) {
		this.id = id;
		this.destinationCity = destinationCity;
		this.description = description;
	}
	
	@Override
	public String id() {
		return id;
	}

	@Override
	public String description() {
		return description;
	}

	@Override
	public String destinationCity() {
		return destinationCity;
	}

}