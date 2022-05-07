package solution;

import java.util.ArrayList;
import java.util.HashMap;

import shipping.IContainer;
import shipping.ITruck;

public class Dockyard implements shipping.IDockyard{
	
	// Properties
	private HashMap<String, ArrayList<IContainer>> queue;
	private int count;
	
	// Constructor
	public Dockyard() {
		queue = new HashMap<>();
		count = 0;
	}

	@Override
	public void addContainer(IContainer container) {
		String destinationCity = container.destinationCity();
//		if (!queue.containsKey(destinationCity)) {
//			queue.put(destinationCity, new ArrayList<>());
//		}
//		queue.get(destinationCity).add(container);
		queue.computeIfAbsent(destinationCity, k -> new ArrayList<>()).add(container);
		count++;
	}

	@Override
	public boolean loadTruck(ITruck truck) {
		String destinationCity = truck.destinationCity();
		
		// If there is a containers with the same destination,
		// then load it onto the truck and 
		if (queue.containsKey(destinationCity) 
				&& queue.get(destinationCity).size() > 0) {
			truck.addContainer(queue.get(destinationCity).remove(0));
			// minus the total count of the containers by one.
			count--;
			return true;
		}
		return false;
	}

	@Override
	public int containerCount() {
		if (count < 0) {
			throw new IndexOutOfBoundsException("The total count of the containers is lower than 0.");
		}
		return count;
	}

	@Override
	public int containerCount(String destinationCity) {
		if (!queue.containsKey(destinationCity)) {
			return 0;
		}
		return queue.get(destinationCity).size();
	}

	@Override
	public void printDetails() {
		// Example: "The dockyard contains 14 containers."
		System.out.println("The dockyard contains " + containerCount() + " containers.");
		//        LA: 2
		//       BOS: 4
		//       NYC: 4
		//       ATL: 4
		for(String destination : queue.keySet()) {
			int containerCount = queue.get(destination).size();
			System.out.printf("%10s: %d\n", destination, containerCount);
		}
		System.out.print("\n");
	}
	
}