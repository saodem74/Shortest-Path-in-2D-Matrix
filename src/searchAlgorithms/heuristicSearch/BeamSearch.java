package searchAlgorithms.heuristicSearch;

import utils.Cell;
import utils.Matrix;
import utils.utils;

import java.util.*;

/**
 * @author Harry Tran on 3/30/19.
 * @project ShortestPathFinding
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class BeamSearch {
	public static void runSearch(Matrix data) {
		System.out.println("=== Beam Search ===");
		long startTime = System.nanoTime();
		int[][] mark = new int[data.getN()][data.getM()];

		int BEAM_SIZE = Math.max(data.getM(), data.getN());

		mark[data.getiSource()][data.getjSource()] = 1;
		Queue<Cell> q = new LinkedList<>();

		q.offer(data.getCell(data.getiSource(), data.getjSource()));

		while (!q.isEmpty()) {
			Queue<Cell> q2 = new PriorityQueue<>(new Comparator<Cell>() {
				@Override
				public int compare(Cell o1, Cell o2) {
					return o1.h_value - o2.h_value;
				}
			});

			while (!q.isEmpty()) {
				Cell curr = q.poll();
				for (int i = 0; i < 4; ++i) {
					int newX = curr.x + utils.rr[i];
					int newY = curr.y + utils.cc[i];
					if (!data.isValidToGo(newX, newY)) continue;
					if (mark[newX][newY] != 0) continue;

					mark[newX][newY] = mark[curr.x][curr.y] + 1;
					q2.offer(data.getCell(newX, newY));

					if (data.isDestination(newX, newY)) break;
				}
			}

			for (int i = 0; i < Math.min(q2.size(), BEAM_SIZE); ++i) {
				q.offer(q2.poll());
			}
		}

		if (mark[data.getiDes()][data.getjDes()] == 0) {
			System.out.println("Can not find path to the destination!!!");
		} else {
			System.out.println("Distance = " + Integer.toString(mark[data.getiDes()][data.getjDes()] - 1));
		}
		long endTime = System.nanoTime();
		System.out.println(Double.toString((double) (endTime - startTime) / 1000000) + " miliseconds");
		System.out.println("=== Finished ===");
	}
}
