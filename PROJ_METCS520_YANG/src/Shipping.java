import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import shipping.*;
import solution.*;


// Once you have your code implemented in the solution
// package, you need to uncomment the following line
// and comment out the import for example1.* above

//import solution.*;

public class Shipping {

	public static void main(String[] args) {

		// On any given day, a dockyard will accept incoming containers that arrive on ships. The ships will be unloaded and the containers
		// placed into a loading area to be ready for transit. At any point, trucks will enter the dockyard to pick up containers that are 
		// headed for a particular city. The truck is loaded with the appropriate container and then starts navigating to the destination city.
		// This goal of this program is to manage the containers that come into and out of the dockyard.
		
		// A data file containing today's shipping events is provided. You need to complete the program so that the dockyard can store the incoming 
		// containers and process the containers as trucks arrive to take the containers to a destination city.
		// You need to read each row in the ShippingEvents file and process the incoming ships and any trucks that are picking up containers. 
		// For each ship, you need to load the containers into the dockyard. This means you need to create a class that implements
		
		/* Uncomment this section to start your work*/

		String inputFileName = "ShippingEvents.txt";

		IDockyard dockyard = new Dockyard();  // need to instantiate an object of your class
		
		ShippingProcessor processor = new ShippingProcessor(dockyard);
		
		processor.processEvents("ShippingEvents");	
		
		
		
	}
	 
}
