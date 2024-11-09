import java.util.HashMap;

public class Room {
	private HashMap<String,Item> items;
	private String description;
	private String name;
	private Room east;
	private Room west;
	private Room north;
	private Room south;
	private Room up;
	private Room down;
	private boolean locked;
	public Room(String d, String n) {
		description = d;
		name = n;
		items = new HashMap<>();
	}
	
	public Room getExit(char direction) {
		if (direction == 'e') 
			return east;
		else if (direction == 'w') 
			return west;
		else if (direction == 'n') 
			return north;
		else if (direction == 's') 
			return south;
		else if (direction == 'u') 
			return up;
		else if (direction == 'd') 
			return down;
		else
			return null;
	}
	
	public void addExit(Room room, char direction) {
		if (direction == 'e') 
			east = room;
		else if (direction == 'w') 
			west = room;
		else if (direction == 'n') 
			north = room;
		else if (direction =='s') 
			south = room;
		else if (direction == 'u') 
			up = room;
		else if (direction == 'd')
			down = room;
	}
	public Item getItem(String name) {
		return items.get(name);
	}
	 public void setItem(Item i) {
	        items.put(i.getName(), i);
	    }
	public void removeItem(String itemname){
		items.remove(itemname);
	}
	public String toString() {
		return description;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
