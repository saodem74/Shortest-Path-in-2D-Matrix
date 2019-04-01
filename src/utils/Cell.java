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
	public char val;
	public int h_value;

	public Cell(int i, int j, char val, int h_v) {
		this.x = i;
		this.y = j;
		this.val = val;
		this.h_value = h_v;
	}
}
