
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Game {

	private ArrayList<String> distances = new ArrayList<String> ();
	Game(String fileIn) throws IOException {
		
		ReadData data = new ReadData(fileIn);
		Bfs Romeo = new Bfs(data, 'R');
		Bfs Julieta = new Bfs(data, 'J');
		distances = calculateTheSmallestDistances(Romeo, Julieta);
	}
	
	public ArrayList<String> calculateTheSmallestDistances(Bfs Romeo, Bfs Julieta) {
		int i,j;
		int rows = Romeo.distance.length;
		int columns = Romeo.distance[0].length;
		int min = Integer.MAX_VALUE;
		ArrayList<String> storeDistances = new ArrayList<String>();
		for(i = 0; i < rows; i++) {
			for(j = 0; j < columns; j++) {
			if(Romeo.distance[i][j] != Integer.MAX_VALUE && Romeo.distance[i][j] == Julieta.distance[i][j])
				if (min >= Julieta.distance[i][j]) {
					if( min > Julieta.distance[i][j]) {
						min = Julieta.distance[i][j];
						storeDistances.clear();;
					}
					storeDistances.add(storeCoordonates(min + 1, i + 1, j + 1));
				}
				
			}
		}
		return  storeDistances;
	}
	String storeCoordonates(int distance, int row, int column) {
		String store = distance + " " + row + " " + column;
		return store;
	}
	
	public void print(String fileIn) throws IOException {
		
		int i;
		int index = fileIn.indexOf('.');
		String fileOut = fileIn.substring(0, index + 1);
		fileOut = fileOut + "out";
		BufferedWriter outputWriter = new BufferedWriter(new FileWriter(fileOut));
		for (i = 0; i < distances.size(); i++) {
		    outputWriter.write(distances.get(i));
		    outputWriter.newLine();
		}
		if(distances.size() == 0)
			outputWriter.write("INF");
		outputWriter.flush();  
		outputWriter.close();  
		
	}
	public static void main(String[] args) throws IOException {
		Game maze = new Game("maze.in");
		maze.print("maze.in");
	}
}
