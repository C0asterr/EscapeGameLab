import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
public class Game {
	private static ArrayList<Item> inventory = new ArrayList();
	public static void main(String[] args) {
		runGame();
	}
	public static void print(Object obj) {
		System.out.println(obj.toString());
	}
    public static Object getCurrentRoom() {
        return getCurrentRoom();
    }
	public static void runGame() {
		Room currentRoom = World.buildWorld();
		Scanner input = new Scanner(System.in);
		
		String command;
		do {
			System.out.println(currentRoom);
			System.out.println("what do you want to do? ");
			command = input.nextLine();
			String[] words = command.split(" ");

			switch(words[0]) {
			case "e":
			case "w":
			case "n":
			case "s":
			case "u":
			case "d":
				Room nextRoom = currentRoom.getExit(command.charAt(0));
				
				if (nextRoom != null && nextRoom.isLocked()) {
                    Game.print("The door is locked. You cannot enter.");
                } else if (nextRoom != null) {
                    currentRoom = nextRoom;
                } else {
                    Game.print("There is no exit in that direction.");
                }
                break;
				
				//handle the take command to pick up an item
			case "take":
				if (words.length > 1) { 
					Item i = currentRoom.getItem(words[1]);
				if (i == null) {
				System.out.println("There's no " + words[1] + " to take.");
				}else{
				inventory.add(i);
				currentRoom.removeItem(words[1]);
				System.out.println("You pick up the " + i.getName());
				}
				}
				else {
					System.out.println("Specify an item to take.");
				}
				break;

				
			case "look":
				if(words.length > 1) {
					String iname = words[1]; // stores the items name
					System.out.println("Looking at: " + iname);
					Item item = null; // item is equal to null
					
					for (Item it: inventory) { //loops through the inventory
						if(it.getName().equals(iname)) {
			     			item = it;
							break;
						}
					}	
						//if its not found in the inventory 
					if (item == null) {
						item = currentRoom.getItem(iname);
					}
					
					if (item != null) {
						System.out.println(item.getDescription());
					}else {
						System.out.println("There is no "+ iname + " here");
			    	}
				}
				break;
			case "i":
				if(inventory.size()==0) {   //check if inventory is empty by size
					System.out.println("Your inventory is empty");
				}else {
					System.out.println("Inventory: ");
					for(Item it : inventory) {
						System.out.println("- " + it.getName());
					}
				}
				break;
			case "open":
				if (words.length > 1) {
                    String itemName = words[1];
                    Item itemToOpen = currentRoom.getItem(itemName);

                    if (itemToOpen != null && itemToOpen.getName().equals("safe")) {
                        itemToOpen.Open();
                    } else {
                        System.out.println("There's nothing to open here.");
                    }
                }
				break;
			case "use":
				if (words.length > 1) {
                    String itemName = words[1];
                    boolean itemFound = false;
                    for (Item item : inventory) {
                        if (item.getName().equals(itemName)) {
                            item.Use();
                            itemFound = true;
                            break;
                        }
                    }
                    if (!itemFound) {
                        System.out.println("You don't have that item or you can't use it.");
                    }
                }
                break;
			case "x":
				System.out.println("Bye! Thanks for walking through my game.");
				break;
			default:
				System.out.println("I dont know what you mean.");
			}
		} while(!command.equals("x"));
		
		input.close();
		
		
	}


}
