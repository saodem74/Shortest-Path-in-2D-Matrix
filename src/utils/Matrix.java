package utils;

/**
 * @author Harry Tran on 3/30/19.
 * @project ShortestPathFinding
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class Matrix {
	private int N;
	private int M;

	private int iSource, jSource;
	private int iDes, jDes;

	private char[][] data;

	public Matrix(int n, int m) {
		this.N = n;
		this.M = m;
		data = new char[N][M];
	}

	public void update(int i, int j, char val) {
		if (!isInside(i,j)) return;
		data[i][j] = val;
		if (val == 'S') {
			iSource = i;
			jSource = j;
		}
		if (val == 'D') {
			iDes = i;
			jDes = j;
		}
	}

	public int getN() {
		return N;
	}

	public int getM() {
		return M;
	}

	public int getiSource() {
		return iSource;
	}

	public int getjSource() {
		return jSource;
	}

	public int getiDes() {
		return iDes;
	}

	public int getjDes() {
		return jDes;
	}

	public boolean isValidToGo(int i, int j) {
		return isInside(i, j) && data[i][j] != '0';
	}

	public boolean isInside(int i, int j) {
		if (i < 0 || i >= N) return false;
		if (j < 0 || j >= M) return false;
		return true;
	}

	public Cell getCell(int i, int j) {
		Cell c = new Cell(i, j, data[i][j], getHeuristicFrom(i, j));
		return c;
	}

	public boolean isDestination(int i, int j) {
		return isInside(i, j) && data[i][j] == 'D';
	}
	public void printOutMaxtix() {
		System.out.print("N = " + Integer.toString(N) + "; ");
		System.out.println("M = " + Integer.toString(M));

		System.out.print("Source = (" + Integer.toString(iSource) + ", " + Integer.toString(jSource) + "); ");
		System.out.println("Destination = (" + Integer.toString(iDes) + ", " + Integer.toString(jDes) + ")");
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				System.out.print(data[i][j] +  " ");
			}
			System.out.println();
		}
	}

	public int getHeuristicFrom(int i, int j) {
		return Math.abs(getiDes() - i) + Math.abs(getjDes() - j);
	}
}
