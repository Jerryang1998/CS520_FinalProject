package solution;

import shipping.IContainer;

public class Truck implements shipping.ITruck{
	
	// Properties
	private String registration;
	private String destinationCity;
	private IContainer container;
	
	// Constructor
	public Truck(String id, String destinationCity) {
		this.registration = id;
		this.destinationCity = destinationCity;
	}

	@Override
	public String registration() {
		return registration;
	}

	@Override
	public String destinationCity() {
		return destinationCity;
	}

	@SuppressWarnings("null")
	@Override
	public boolean addContainer(IContainer container) {
		if(hasContainer()) {
			return true;
		}
		this.container = new Container(container.id(), container.destinationCity(), container.description());
		return false;
	}

	@Override
	public IContainer offloadContainer() {
		if (hasContainer()) {
			IContainer offloadContainer = new Container(container.id(), container.destinationCity(), container.description());
			container = null;
			return offloadContainer;
		}
		return null;
	}

	@Override
	public boolean hasContainer() {
		if (container != null) {
			return true;
		}
		return false;
	}

	@Override
	public void printDetails() {
		// Example: "Truck T223 is headed to BOS with "
		System.out.print("Truck " + registration() + " is headed to " 
							+ destinationCity() + " with ");
		// if there is a container on the truck, 
		// then print "container C123."
		if (hasContainer()) {
			System.out.println("container " + container.id() + ".");
		}
		// else print "no container."
		else { 
			System.out.println("no container.");
		}
	}

}

