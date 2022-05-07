package solution;

import java.util.ArrayList;
import java.util.List;

import shipping.IContainer;

public class Ship implements shipping.IShip{
	
	// Properties
	private ArrayList<IContainer> containers;
	private String registration;
	
	// Constructor
	public Ship(String id) {
		setRegistration(id);
		containers = new ArrayList<>();
	}

	@Override
	public String getRegistration() {
		return registration;
	}

	@Override
	public void setRegistration(String id) {
		this.registration = id;
	}

	@Override
	public void addContainer(IContainer container) {
		containers.add(container);
	}

	@Override
	public List<IContainer> containers() {
		return containers;
	}

	@Override
	public List<IContainer> offload() {
		// copy a temporary containers value
		ArrayList<IContainer> offload = new ArrayList<>(containers);
		containers.clear();
		return offload;
	}

	@Override
	public void printDetails() {
		// Example: Ship S123 has 0 containers.
		System.out.println("Ship " + getRegistration() + " has " 
							+ containers.size() + " containers.");
	}

}
