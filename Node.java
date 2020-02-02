import java.util.Arrays;
import java.util.Random;

public class Node {

	Table table;
	Node parent;
	Node left;
	Node right;
	Node up;
	Node down;
	String type; // R FOR RIGHT CHILD U FOR UP CHILD.....X FOR ROOT
	
	
	public Node(Table table,String type) {
		this.table=table;
		this.type=type;
	}
	
	
	
	public boolean equals(Object other1) {
		if(other1 instanceof Node) {
			Node other=(Node)other1;
			if(this.table.j0==other.table.j0&&this.table.i0==other.table.i0) {
				return Arrays.deepEquals(this.table.configuration,other.table.configuration);
					
			}
		}
		return false;
	}
	
	
	public int hashCode() {
		
		
		return Arrays.deepHashCode(table.configuration);
		
	}

	
	
	
}
