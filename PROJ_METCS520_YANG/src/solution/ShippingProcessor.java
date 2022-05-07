package solution;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import shipping.IContainer;
import shipping.IDockyard;
import shipping.IShip;
import shipping.ITruck;

public class ShippingProcessor extends shipping.ShippingProcessorBase{

	public ShippingProcessor(IDockyard dockyard) {
		super(dockyard);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected List<IContainer> readManifest(String shipId) {
		// TODO Auto-generated method stub
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(shipId + "-Manifest");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		BufferedReader reader = new BufferedReader(fileReader);
		String input;
		ArrayList<IContainer> abc = new ArrayList();
		// Read each event and process it
		try {
			input = reader.readLine();
			while (input != null)
			{
				StringTokenizer st = new StringTokenizer(input, ",");
				String containerId = st.nextToken().trim();
				String destinationCity = st.nextToken().trim();
				IContainer con = new Container(containerId, destinationCity);
				abc.add(con);
				input = reader.readLine();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Close the input
		try {
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return abc;
	}

	@Override
	protected void processTruck(String registration, String destination) {
		// Create a new truck
		ITruck truck = new Truck(registration, destination);
		System.out.printf("\nBefore loading:\t");
		truck.printDetails();
		
		// Load the containter onto the truck
		System.out.printf("After loading:\t");
		truck.printDetails();
		truck.offloadContainer();
	}

	@Override
	protected IShip processShip(String registration) {
		// Create a new ship
		IShip ship = new Ship(registration);
		
		// Add each container into the ship
		for (IContainer c : readManifest(registration)) {
			ship.addContainer(c);
		}
		System.out.print("Before unloading:\t");
		ship.printDetails();
		
		// Load all the containers onto the dockyard
		for (IContainer c : ship.offload()) {
			getDockyard().addContainer(c);
		}
		System.out.print("After unloading:\t");
		ship.printDetails();
		return ship;
	}
}
