package kolanen;

import java.io.Serializable;
import java.util.*;

public class Player implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private ArrayList<Item> inventory;
	private Car currentLocation;
/**
 * Player is created in GameController.
 * @param name
 * @param currentLocation
 */
	public Player(String name, Car currentLocation) {
		this.name = name;
		this.currentLocation = currentLocation;
		inventory = new ArrayList<Item>();
	}

	public void setLocation(Car nextLocation) {
		currentLocation = nextLocation;
	}

	public Car getLocation() {
		return currentLocation;
	}

	public String getName() {
		return name;
	}

	public Car location() {
		return currentLocation;
	}

	public void addToInventory(Item item) {
		inventory.add(item);
		System.out.println("***AN ITEM WAS ADDED TO YOUR INVENTORY***");
	}

	public void removeFromInventory(Item item) {
		inventory.remove(item);
	}

	public void addToInventoryStation(Item item) {

		inventory.add(item);
	}

	public boolean getFromInventory(String item) {
		boolean contains = false;
		String s = getInventory();
		String[] arr = s.split(" ");

		if (item != null) {
			for (String str : arr) {
				if (str.trim().contains(item)) {
					contains = true;
				}
			}
		}
		return contains;
	}

	public String getInventory() {
		String s = "";
		for (Item item : inventory) {
			if (item.getName().equals("invention")) {
				s += item.getName() + "	| " + item.getDescription() + "\n";
			} else {
				s += item.getName() + "		| " + item.getDescription() + "\n";
			}
		}
		if (s == "") {
			s = ("Your inventory is empty");
		}
		return s;
	}
}