package utils;

/**
 * @author Harry Tran on 3/30/19.
 * @project ShortestPathFinding
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class Cell {
	public int x;
	public int y;
	char val;

	public Cell(int i, int j, char val) {
		this.x = i;
		this.y = j;
		this.val = val;
	}
}
