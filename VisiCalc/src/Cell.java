public class Cell {
	String name = "";
	public Cell(String inName) {
		name = inName;
	}
	public static Cell newCell(String name2){
		Cell cell = new Cell(name2 + "        ");
		return cell;
	}
	@Override
	public String toString() {

		return "Cell [name=" + name + "]";
	}
	
}
