import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Tree {
	
	Node root;
	Set<Node>past;
	
	public Tree(String input) { //Takes input and initiates table,node, makes it root
		Table initial=new Table(input);
		root=new Node(initial,"X");
		past=new HashSet<Node>();
		past.add(root);
	}
	
	public Node process() { //Creates nodes for possiblities and returns the goal node 
		
		Queue<Node>q=new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()) {
			
			Node current=q.poll();
			
			if(!current.type.equals("L")) {
				Node r=new Node(Table.right(current.table),"R");
				if(r.table!=null) {
					if(!past.contains(r)) {
						r.parent=current;
						current.right=r;
						q.add(r);
						past.add(r);
						if(r.table.isGoal2()) {
							return r;
						}
					}
					
				}
			}
			if(!current.type.equals("R")) {
				Node l=new Node(Table.left(current.table),"L");
				if(l.table!=null) {
					if(!past.contains(l)) {
						l.parent=current;
						current.left=l;
						q.add(l);
						past.add(l);
						if(l.table.isGoal2()) { //ISGOAL 1-2 FARKMAZ
							return l;
						}
					}
					
				}
			}
			
			if(!current.type.equals("D")) {
				Node u=new Node(Table.up(current.table),"U");
				if(u.table!=null) {
					if(!past.contains(u)) {
						u.parent=current;
						current.up=u;
						q.add(u);
						past.add(u);
						if(u.table.isGoal2()) {
							return u;
						}
					}
					
				}
			}
			
			if(!current.type.equals("U")) {
				Node d=new Node(Table.down(current.table),"D");
				if(d.table!=null) {
					if(!past.contains(d)) {
						d.parent=current;
						current.down=d;
						q.add(d);
						past.add(d);
						if(d.table.isGoal2()) {
							return d;
						}
					}
					
				}
			}
			
		}
		return null;
		
	}

	
	
	
	
	public String getTrajectory(Node goal) { //Returns output for goal node
		
		if(goal==null) {
			return "N";
		}
		if(goal.equals(root)) {
			return "";
		}
		Node next=goal.parent;
		if(next.down!=null) {
			if(next.down.equals(goal)) {
				return getTrajectory(next)+"D";
			}
		}
		if(next.up!=null) {
			if(next.up.equals(goal)) {
				return getTrajectory(next)+"U";
			}
		}
		if(next.left!=null) {
			if(next.left.equals(goal)) {
				return getTrajectory(next)+"L";
			}
		}
		
		return getTrajectory(next)+"R";
		
	
	}
	
	
	
	
}







