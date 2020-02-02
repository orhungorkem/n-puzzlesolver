import java.util.Arrays;

public class Table {
	
	int[][]configuration;
	int i0;
	int j0;
	static int[][]goal;
	
	public Table(String input) {  //INITIATE THE TABLE configuration and 0 spots
		
		String[]elements=input.split("-");
		int[][]config=new int[(int)Math.sqrt(elements.length)][(int)Math.sqrt(elements.length)];
		int count=0;
		for(int i=0;i<config.length;i++) {
			for(int j=0;j<config.length;j++) {
				int cur=Integer.parseInt(elements[count]);
				count++;
				if(cur==0) {
					i0=i;
					j0=j;
				}
				config[i][j]=cur;
			}
		}
		goal=new int[config.length][config.length];
		for(int i=0;i<goal.length;i++) {
			for(int j=0;j<goal.length;j++) {
				goal[i][j]=i*goal.length+j+1;
			}
		}
		goal[goal.length-1][goal.length-1]=0;
		configuration=config;
		
	}
	public Table(int[][]config,int i0,int j0) {
		this.configuration=config;
		this.i0=i0;
		this.j0=j0;
	}
	
	
	
	
	
	public static Table right(Table parent) { 
		
		int[][]child=new int[parent.configuration.length][parent.configuration.length];
		
		for(int i=0;i<child.length;i++) {
			child[i]=Arrays.copyOf(parent.configuration[i], child.length);
		}
		
		
		
		if(parent.j0<child[0].length-1) {
			child[parent.i0][parent.j0]=child[parent.i0][parent.j0+1];
			child[parent.i0][parent.j0+1]=0;
			return new Table(child,parent.i0,parent.j0+1);
		}
		return null;
		
	}
	public static Table left(Table parent) {
			
		int[][]child=new int[parent.configuration.length][parent.configuration.length];
		
		for(int i=0;i<child.length;i++) {
			child[i]=Arrays.copyOf(parent.configuration[i], child.length);
		}
		
		if(parent.j0>0) {
			child[parent.i0][parent.j0]=child[parent.i0][parent.j0-1];
			child[parent.i0][parent.j0-1]=0;
			return new Table(child,parent.i0,parent.j0-1);
		}
		return null;
		
	}
	public static Table up(Table parent) {
		
		
		int[][]child=new int[parent.configuration.length][parent.configuration.length];
		
		for(int i=0;i<child.length;i++) {
			child[i]=Arrays.copyOf(parent.configuration[i], child.length);
		}
		
		
		if(parent.i0>0) {
			child[parent.i0][parent.j0]=child[parent.i0-1][parent.j0];
			child[parent.i0-1][parent.j0]=0;
			return new Table(child,parent.i0-1,parent.j0);
		}
		return null;
		
	}
	public static Table down(Table parent) {
		
		
		int[][]child=new int[parent.configuration.length][parent.configuration.length];
		
		
		for(int i=0;i<child.length;i++) {
			child[i]=Arrays.copyOf(parent.configuration[i], child.length);
		}
		
		
		if(parent.i0<child[0].length-1) {
			child[parent.i0][parent.j0]=child[parent.i0+1][parent.j0];
			child[parent.i0+1][parent.j0]=0;
			return new Table(child,parent.i0+1,parent.j0);
		}
		return null;
		
	}
	
	
	public boolean isGoal2() {
		return Arrays.deepEquals(configuration, goal);
	}
	
	
	
	

}
