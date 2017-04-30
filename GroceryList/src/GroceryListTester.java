
public class GroceryListTester {

	public static void main(String[] args) {
		// testing GroceryList
		// a GroceryList with valid input
		GroceryList list1 = new GroceryList();
		list1.add(new GroceryItemOrder("Theo's Chocolate", 1, 3.99));
		list1.add(new GroceryItemOrder("Tropicana Grovestand Orange Juice", 1, 3.49));
		list1.add(new GroceryItemOrder("Gala Apple", 6, 0.35));
		print(list1);
		
		// a GroceryList with some invalid input
		GroceryList list2 = new GroceryList();
		list2.add(new GroceryItemOrder("Avenue Bread", -2, 0.332));
		list2.add(new GroceryItemOrder("Chocalate Chip Cookies", 200, -0.05));
		list2.add(new GroceryItemOrder("Milk Gallon", -1, -6));
		print(list2);
		
		// a GroceryList with too many items
		GroceryList list3 = new GroceryList();
		list3.add(new GroceryItemOrder("Apple", 1, 0.03));
		list3.add(new GroceryItemOrder("Banana", 1, 0.30));
		list3.add(new GroceryItemOrder("Orange", 1, 0.40));
		list3.add(new GroceryItemOrder("Pear", 1, 0.50));
		list3.add(new GroceryItemOrder("Mango", 1, 1.00));
		list3.add(new GroceryItemOrder("Box of Cookies", 1, 200));
		list3.add(new GroceryItemOrder("Cabbage", 1, 2.00));
		list3.add(new GroceryItemOrder("Salad Greens", 1, 5.00));
		list3.add(new GroceryItemOrder("Carrot Bag", 1, 2.00));
		list3.add(new GroceryItemOrder("Pie", 1, 3.14));
		list3.add(new GroceryItemOrder("Microwave Pizza", 1, 200));
		print(list3);
		
		// testing GroceryItemOrder
		GroceryItemOrder item = new GroceryItemOrder("Burger Buns", 6, 1.50);
		System.out.println(item);
		item.setQuantity(8);
		System.out.println(item.getCost());
		System.out.println(item);
		
	}
	
	private static void print(GroceryList list) {
		System.out.println(list.toString() + "\n");
	}
}