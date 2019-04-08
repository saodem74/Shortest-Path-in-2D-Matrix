package searchAlgorithms.heuristicSearch;

import utils.Cell;
import utils.Matrix;
import utils.utils;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Harry Tran on 3/30/19.
 * @project ShortestPathFinding
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class AStar {
	public static void runSearch(Matrix data) {
		System.out.println("\n=== A-star Search ===");
		long startTime = System.nanoTime();
		int[][] mark = new int[data.getN()][data.getM()];
		Cell[][] par = new Cell[data.getN()][data.getM()];

		mark[data.getiSource()][data.getjSource()] = 1;
		Queue<Cell> q = new PriorityQueue<>(new Comparator<Cell>() {
			@Override
			public int compare(Cell o1, Cell o2) {
				return o1.h_value - o2.h_value;
			}
		});

		q.offer(data.getCell(data.getiSource(), data.getjSource(), 1));
		par[data.getiSource()][data.getjSource()] = null;

		while (!q.isEmpty()) {
			Cell curr = q.poll();
			for (int i = 0; i < 4; ++i) {
				int newX = curr.x + utils.rr[i];
				int newY = curr.y + utils.cc[i];
				if (!data.isValidToGo(newX, newY)) continue;
				if (mark[newX][newY] != 0) continue;

				mark[newX][newY] = mark[curr.x][curr.y] + 1;
				par[newX][newY] = curr;
				q.offer(data.getCell(newX, newY, mark[newX][newY]));

				if (data.isDestination(newX, newY)) break;
			}
		}

		if (mark[data.getiDes()][data.getjDes()] == 0) {
			System.out.println("Can not find path to the destination!!!");
		} else {
			System.out.println("Distance = " + Integer.toString(mark[data.getiDes()][data.getjDes()] - 1));
			utils.tracking(data, par);
		}
		long endTime = System.nanoTime();
		System.out.println(Double.toString((double) (endTime - startTime) / 1000000) + " miliseconds");
		System.out.println("=== Finished ===");
	}
}
