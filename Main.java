import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		long bas=System.currentTimeMillis();
		
		
		File f=new File(args[0]);
		Scanner input=new Scanner(f);
		Tree tree=new Tree(input.next());
		PrintStream output=new PrintStream(new File(args[1]));
		output.println(tree.getTrajectory(tree.process()));
		
		
		
		
	}

}
