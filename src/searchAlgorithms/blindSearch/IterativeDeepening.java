package searchAlgorithms.blindSearch;

import utils.Matrix;
import utils.utils;

/**
 * @author Harry Tran on 3/30/19.
 * @project ShortestPathFinding
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class IterativeDeepening {
	static private void ID(Matrix data, int[][] mark, int currX, int currY, int limited) {
		if (data.isDestination(currX, currY)) {
			return;
		}
		if (mark[currX][currY] >= limited) return;

		for (int i = 0; i < 4; ++i) {
			int newX = currX + utils.rr[i];
			int newY = currY + utils.cc[i];
			if (!data.isValidToGo(newX, newY)) continue;

			if (data.isDestination(newX, newY)){
				if (mark[newX][newY] == 0 || mark[currX][currY] + 1 < mark[newX][newY]) {
					mark[newX][newY] = mark[currX][currY] + 1;
				}
				continue;
			}

			if (mark[newX][newY] != 0) continue;

			mark[newX][newY] = mark[currX][currY] + 1;
			ID(data, mark, newX, newY, limited);
			mark[newX][newY] = 0;
		}
	}

	static public void runSearch(Matrix data) {
		System.out.println("\n=== Iterative Deepening Search ===");
		long startTime = System.nanoTime();
		int[][] mark = new int[data.getN()][data.getM()];

		mark[data.getiSource()][data.getjSource()] = 1;

		System.out.print("Depth Limit = ");
		for (int limited = 1; limited <= data.getN() * data.getM(); ++limited) {
			System.out.print(", " + Integer.toString(limited - 1));
			ID(data, mark, data.getiSource(), data.getjSource(), limited);
			if (mark[data.getiDes()][data.getjDes()] != 0) {
				System.out.println("\nDistance = " + Integer.toString(mark[data.getiDes()][data.getjDes()] - 1));
				break;
			}
		}

		if (mark[data.getiDes()][data.getjDes()] == 0) {
			System.out.println("\nCan not find path to the destination!!!");
		}

		long endTime   = System.nanoTime();
		System.out.println(Double.toString((double)(endTime - startTime)/1000000) + " miliseconds");
		System.out.println("=== Finished ===");
	}
}
