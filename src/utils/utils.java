package utils;

import javafx.util.Pair;

import java.util.ArrayList;

/**
 * @author Harry Tran on 3/30/19.
 * @project ShortestPathFinding
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class utils {
	public static final int[] rr = new int[]{-1, 1, 0, 0};
	public static final int[] cc = new int[]{0, 0, -1, 1};


	public static void printOutCell(int x, int y) {
		System.out.print("(" + Integer.toString(x) + ", " + Integer.toString(y) + ") --> ");
	}
	public static void printOutCellLast(int x, int y) {
		System.out.println("(" + Integer.toString(x) + ", " + Integer.toString(y) + ")");
	}


	public static void tracking(Matrix data, Cell[][] par) {
		Cell curr = data.getDestinationCell();
		ArrayList<Pair<Integer, Integer>> trace = new ArrayList<>();
		while (curr != null) {
			trace.add(new Pair<>(curr.x, curr.y));
			curr = par[curr.x][curr.y];
		}
		for (int i = trace.size() - 1; i >= 1; --i) {
			utils.printOutCell(trace.get(i).getKey(), trace.get(i).getValue());
		}
		utils.printOutCellLast(trace.get(0).getKey(), trace.get(0).getValue());
	}

	public static void copyData(Cell[][] from, Cell[][] to) {
		for (int i = 0; i < from.length; ++i)
			for (int j = 0; j < from[0].length; ++j)
				to[i][j] = from[i][j];
	}
}
