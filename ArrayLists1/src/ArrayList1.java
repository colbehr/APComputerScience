/** 
 * @author Colbehr
 * @since 12/1/2014
 */

import java.util.*;

public class ArrayList1 {

//	 Adult Airplane Air Airport Album Alphabet Apple Arm Army Baby Backpack
//	 Balloon Banana Bank Barbecue Bathroom Bathtub Bed Bird Bomb Book Boss
//	 Bottle Bowl Box Boy Brain Bridge Butterfly Button Car Car Carpet Carrot
//	 Cave Chair Chief Child Chisel Chocolates Church Circle Circus Clock Clown
//	 Coffee Coffee Comet Compact Compass Computer Crystal Cup Database Desk
//	 Diamond Dress Drill Drink Drum Dung Ears Earth Egg Electricity Elephant
//	 Eraser Explosive Eyes Family Fan Feather Festival Film Finger Fire
//	 Floodlight Flower Foot Fork Freeway Fruit Fungus Game Garden Gas Gate
//	 Gemstone Girl Gloves God Grapes Guitar Hammer Hat Hieroglyphics Highway
//	 Horse Hose Ice Insect Jet Junk Kaleidoscope Kitchen Knife Leather Leg
//	 Library Liquid Magnet Man Map Maze Meat Meteor Microscope Milk Milkshake
//	 Mist Money Monster Mosquito Mouth Nail Navy Necklace Needle Onion
//	 Paintbrush Pants Parachute Passport Pebble Pendulum Pepper Perfume Pillow
//	 Plane Planet Pocket Potato Printer Prison Pyramid Radar Rainbow Record
//	 Restaurant Rifle Ring Robot Rock Rocket Roof Room Rope Saddle Sandpaper
//	 Sandwich Satellite School Ship Shoes Shop Shower Signature Skeleton Slave
//	 Snail Software Solid Space Shuttle Spectrum Sphere Spice Spiral Spoon
//	 Sports SpotLight Square Staircase Star Stomach Sun Sunglasses Surveyor
//	 Sword Table Tapestry Teeth Telescope Television Tennis Thermometer Tiger
//	 Toilet Tongue Torch Torpedo Train Treadmill Triangle Tunnel Typewriter
//	 Umbrella Vacuum Vampire Videotape Vulture Water Weapon Web Wheelchair
//	 Window Woman Worm X-ray
//	 Chestnuts roasting over an open fire go!

	public static void main(String[] args) {

		System.out.print("Enter some words (end with go!): ");
		ArrayList<String> wordList = getWords();

		analyzeWordList(wordList);
	}

	public static ArrayList<String> getWords() {
		Scanner input = new Scanner(System.in);
		String nextWord;

		ArrayList<String> tempList = new ArrayList<String>();

		while (true) {
			nextWord = input.next();
			if (nextWord.equals("go!"))
				break;

			tempList.add(nextWord);
		}

		input.close();
		return tempList;
	}

	public static void analyzeWordList(ArrayList<String> myList) {
		int myListSize = myList.size();
		int myListCharsLength = 0;
		String myListLongestWord = "";
		String myListShortestWord = "Some long text";
		for (int i = 0; i < myListSize; i++) {
			System.out.print(myList.get(i) + " ");
			myListCharsLength += myList.get(i).length();
			if (myList.get(i).length() > myListLongestWord.length()) {
				myListLongestWord = myList.get(i);
			} else if (myList.get(i).length() < myListShortestWord.length()) {
				myListShortestWord = myList.get(i);
			}
		}
		int myListAverageCharCount = 0;
		myListAverageCharCount = myListCharsLength / myList.size();
		;

		System.out.println();
		System.out.println(myListAverageCharCount);
		System.out.println();
		System.out.println("Longest: " + myListLongestWord);
		System.out.println();
		System.out.println("Shortest: " + myListShortestWord);

		// 1) use a for loop to display each word

		// 2) calculate the average word length and display at end of list.
		// use a double or a CAST to get a decimal value!

		// 3) for extra fun, get the longest and shortest word in the list also,
		// and display those at the end of the list

		// 4) Build an ArrayList of all the words of the shortest length. For
		// example if the
		// shortest words are 3 characters, the list should contain all three
		// character words.

		// 5) Build an ArrayList of all the words of the longest length. For
		// example if the
		// longest words are 10 characters, the list should contain all ten
		// character words.

	}

}