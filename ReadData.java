
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadData {
		
		public char[][] labrinth;
		ReadData(String fileName) {
			labrinth = readFile(fileName);
		}
	
		public  char[][] readFile(String fileName) {
			try {
				
				File file = new File(fileName);
				FileInputStream filein = new FileInputStream(file);
				DataInputStream in = new DataInputStream(filein);
				BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
				String readLine;
				int rows;
				int columns;
				readLine = buffer.readLine();
				rows = Integer.parseInt(readLine.substring(0, readLine.indexOf(' ')));
				columns = Integer.parseInt(readLine.substring(readLine.indexOf(' ') + 1));
				char[][] labrinth = new char[rows][columns];
				int countRows = 0;
				readLine = buffer.readLine();
				while (readLine != null)
				{
					int i;
					for(i = 0; i < columns; i++) {
						labrinth[countRows][i] = readLine.charAt(i);
					}
					++countRows;
					readLine = buffer.readLine();
				}
				buffer.close();
				return labrinth;
				
			} catch (Exception e) {
				System.out.println("Error : " + e.getMessage());
				return new char[0][0];
			}

	}

}
