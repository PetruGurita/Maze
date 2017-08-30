
import java.util.ArrayDeque;
import java.util.Queue;

public class Bfs {

	private int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	private int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
	protected int[][] distance;
	private Queue<String> q;

	Bfs(ReadData data, char who) {

		int rows = data.labrinth.length;
		int columns = data.labrinth[0].length;
		distance = new int[rows][columns];
		int i;
		int j;
		for (i = 0; i < rows; i++) {
			for (j = 0; j < columns; j++) {
				distance[i][j] = Integer.MAX_VALUE;
			}
		}
		int[] startingPoint = searchLover(data, who);
		distance[startingPoint[0]][startingPoint[1]] = 0;
		q = new ArrayDeque<String>();
		q.add(QueueCoordonates_toString(startingPoint[0], startingPoint[1]));
		DoBfs(data);

	}
	
	void DoBfs(ReadData data) {
		
		while(! q.isEmpty() ) {
			String s = q.poll();
			int space = s.indexOf(' ');
			int i = Integer.parseInt(s.substring(0, space));
			int j = Integer.parseInt(s.substring(space + 1));
			int d;
			for(d = 0; d < 8; d++) {
				int ii = i + dx[d];
				int jj = j + dy[d];
				if(validNeighbour(ii, jj,  data.labrinth.length,  data.labrinth[0].length, data)) {
					
					if(distance[ii][jj] > distance[i][j] + 1) {
						distance[ii][jj] = distance[i][j] + 1;
						q.add(QueueCoordonates_toString(ii, jj));
					}
				}
					
			}
		}
	}
	boolean validNeighbour(int ii, int jj, int rows, int columns, ReadData data) {
		return !(ii < 0 || ii >= rows || jj < 0 || jj >= columns  || data.labrinth[ii][jj] == 'X');
	}
	
	
	int[] searchLover(ReadData data, char c) {
		int[] positions = new int[2];
		int rows = data.labrinth.length;
		int columns = data.labrinth[0].length;
		int i, j;
		for (i = 0; i < rows; i++) {
			for (j = 0; j < columns; j++) {
				if (data.labrinth[i][j] == c) {
					positions[0] = i;
					positions[1] = j;
				}
			}
		}
		return positions;
	}
	
	String QueueCoordonates_toString(int x, int y) {
		String coordonates = x + " " + y;
		return coordonates;
	}
	
}
