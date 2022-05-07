package shipping;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

public abstract class ShippingProcessorBase {

		private IDockyard dockyard;

		/**
		 * Class constructor.  
		 * <p>
		 * @param IDockyard A dockyard object that is used in the processing of events.
		 * @see IDockyard
		 */

		public ShippingProcessorBase(IDockyard dockyard) {
			this.dockyard = dockyard;
		}

		
		/**
		 * Returns a reference to the dockyard used by the processor.  
		 * <p>
		 * @return A dockyard reference used by the processor.
		 * @see IDockyard
		 */

		protected IDockyard getDockyard() {
			return dockyard;
		}
		
		/**
		 * Processes all of the events in the file.
		 * <p>
		 * @param String The name of the file to process.
		 * @return Nothing.
		 */
		
		public void processEvents(String fileName) {
			
			this.getDockyard().printDetails();
			
			FileReader fileReader = null;
			try {
				fileReader = new FileReader(fileName);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			BufferedReader reader = new BufferedReader(fileReader);
			String input;

			// Read each event and process it
			try {
				input = reader.readLine();
				while (input != null)
				{
					processShippingEvent(input);
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
			
			this.getDockyard().printDetails();
		};
		
		/**
		 * This method processes a single shipping event.
		 * <p>
		 * The implementation needs to take the String value and process the event. 
		 * 
		 * A "Ship" event represents a ship arriving to the port whereby the containers 
		 * need to be offloaded into the dockyard. You will need to look at the ship manifest 
		 * (based on the Ship's Id) to understand the list of containers on the ship and move 
		 * them to the dockyard by invoking the processShip method.
		 *  
		 * A "Truck" event reprsents a truck arriving at the dockyard to pickup a container that is destined 
		 * for the same city where the truck is headed. In order to process the truck, the implementation should
		 * invoke the processTruck method.
		 *  
		 * @param String The name of the file to process.
		 * @return Nothing.
		 */

		protected  void processShippingEvent(String input)
		{
			StringTokenizer st = new StringTokenizer(input, ",");
			String eventType = st.nextToken();
			
			if (eventType.equalsIgnoreCase("SHIP")) {
				
				System.out.println("A new ship has arrived. Processing...");
				
				processShip(st.nextToken().trim());
				
				// output the current dockyard status.
				System.out.println();
				dockyard.printDetails();
				
			} else if (eventType.equalsIgnoreCase("TRUCK")) {

				System.out.println("A new truck has arrived. Processing...");

				processTruck(st.nextToken().trim(), st.nextToken().trim());
			
				dockyard.printDetails();
			}
		}
		
		protected abstract List<IContainer> readManifest(String shipId);
		
		/**
		 * This method processes a single truck event.
		 * <p>
		 * The implementation needs to use the registration and destination and process the truck. This involves finding the next 
		 * for the truck's destination and loading it onto the truck from the shipyard.  
		 * 
		 * @param String The truck's registration.
		 * @param String The truck's destination city.
		 * @return Nothing.
		 * @see ITruck
		 */
		
		protected abstract void processTruck(String registration, String destination);
		
		/**
		 * This method processes a single shipping event.
		 * <p>
		 * The implementation needs to use the ship passed in to unload containers to the dockyard. Goal is to get all 
		 * of the containers off the ship and add them to the shipyard. The containers need to be added so that the
		 * containers are queued up for shipping to the destination city when the appropriate truck arrives. 
		 * 
		 * @param String The registration for the arriving ship..
		 * @return IShip
		 * @see IShip
		 */
		
		protected abstract IShip processShip(String registration);
		
}
