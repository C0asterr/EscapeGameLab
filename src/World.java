public class World {
	//Builds the game world.
	//Returns the room the player starts in.

	public static Room buildWorld() {
		Room livingRoom = new Room("Living Room","You are in the living room.");
		Room kitchen = new Room("Kitchen","You are in the kitchen.");
		Room kidsRoom = new Room ("Kids Bedroom","You are in the kids room.");
		Room restRoom = new Room ("Restroom","You are in the rest room.");
		Room upstairsHall = new Room ("Upstairs Hallway","You are in the hallway");
		Room masterBed = new Room ("Master Bedroom","You are now in the master bedroom");
		Room officeSpace = new Room("Office","You are in the Office");
		Room storageRoom = new Room("Storage Room", "You are now in the Storage Room");
		Room gameRoom = new Room("Game Room","You are now in the Game Room");
		Room guestBed = new Room("Guest Bedroom", "You are now in the Guest Bedroom");
		Room atticSpace = new Room("Attic","You are now in the Attic");
		Room gymSpace = new Room("Gym","You are now in the Gym");
		Room playRoom = new Room("Playroom", "You are now in the Playroom");
		Room masterBath = new Room("Master Bathroom", "You are in the Master Bathroom");
		
		Item key = new Item("Key","A shiny new key");
		Item chest = new Item ("Chest", "a beaten up treasure chest");
		Item bible = new Item ("Bible", "an old bible");
		Item hammer = new Item("Hammer", "a rusty hammer");
		Item axe = new Item ("Axe", "a heavy axe");
		Item pickingtool = new Item ("Picking Kit", "A kit that will help you pick a lock");
		Item newspaper = new Item("A NewsPaper", "The newspaper tells you where the combination is");
		Item bluekey = new Item("A Blue Key", "A beaten up blue key");
		
        Combination combination = new Combination("Combination", "A combination to a safe.");
        Safe safe = new Safe("Safe", "It's an impressive safe!");
		
		livingRoom.addExit(kitchen, 'e');//living room to kitchen
		kitchen.addExit(livingRoom, 'w');//kitchen to living room
		
		kidsRoom.addExit(livingRoom, 'e');//kids room to living room
		livingRoom.addExit(kidsRoom, 'w');//living room to kids room
		
		upstairsHall.addExit(livingRoom, 'd');//upstairs to living room
		livingRoom.addExit(upstairsHall, 'u');//living room to upstairs hall
		
		upstairsHall.addExit(masterBed, 'e');//upstairs to master bedroom
		masterBed.addExit(upstairsHall,'w');//master bedroom to upstairs hall
		
		kitchen.addExit(restRoom, 's');//kitchen to restroom
		restRoom.addExit(kitchen, 'n');//restroom to kitchen
		
		upstairsHall.addExit(officeSpace, 'w'); //upstairs hall to office space
		officeSpace.addExit(upstairsHall, 'e'); //office to upstairs hall
		
		officeSpace.addExit(atticSpace, 'u'); //office space to attic
		atticSpace.addExit(officeSpace, 'd'); //attic to office
		
		atticSpace.addExit(storageRoom, 'w'); //attic to storage room
		storageRoom.addExit(atticSpace, 'e'); //storage room to attic
		
		atticSpace.addExit(gameRoom, 'n'); // attic to game room
		gameRoom.addExit(atticSpace, 's'); // game room to attic
		
		atticSpace.addExit(guestBed, 'e'); // attic to guest Bed room
		guestBed.addExit(atticSpace, 'w'); // guest bedroom to attic
		
		masterBed.addExit(masterBath, 'n'); // master bedroom to master bathroom
		masterBath.addExit(masterBed, 's'); // master bathroom to master bedroom
		
		kidsRoom.addExit(playRoom, 's'); // kids room to the play room
		playRoom.addExit(kidsRoom, 'n'); // play room to the kids room
		
		playRoom.addExit(gymSpace, 'w'); // play room to gym
		gymSpace.addExit(playRoom, 'e'); // gym to play room 
		
		masterBed.setLocked(true);
		gameRoom.setLocked(true);
		officeSpace.setLocked(true);
		atticSpace.setLocked(true);		
		guestBed.setLocked(true);
		restRoom.setLocked(true);
		playRoom.setLocked(true);
		gymSpace.setLocked(true);
		storageRoom.setLocked(true);
		
		kidsRoom.setItem(key);
		upstairsHall.setItem(chest); 
		masterBed.setItem(bible);
		kitchen.setItem(hammer);
		atticSpace.setItem(axe);
		livingRoom.setItem(pickingtool);
		gameRoom.setItem(newspaper);
		restRoom.setItem(bluekey);
		masterBed.setItem(safe);
		officeSpace.setItem(combination);

		
		return livingRoom;

		
	}
}
