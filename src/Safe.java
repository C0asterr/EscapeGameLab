import java.util.ArrayList;

public class Safe extends Item {
	private boolean isOpen;

	public Safe(String name, String description) {
			super(name, description); // Call the constructor of the superclass (Item)
			this.isOpen = false; // Initially, the safe is closed
			}
	
	
		boolean hasCombination = false;
		
		if (hasCombination) {
			isOpen = true; // Set the safe to open
			System.out.println("Using the combination, you open the safe and find a diamond inside! Naturally, you pocket the diamond.");
			Item diamond = new Item("Diamond", "A sparkling diamond."); // Create a new diamond item
			playerInventory.add(diamond); // Add the diamond to the player's inventory
			} else {
				System.out.println("The safe is locked and you don't have the combination.");
				}
		}
	
