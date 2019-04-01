package searchAlgorithms.heuristicSearch;

import javafx.util.Pair;
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
	private static final int BEAM_SIZE = 2;
	public static void runSearch(Matrix data) {
		System.out.println("=== Beam Search ===");
		long startTime = System.nanoTime();
		int[][] mark = new int[data.getN()][data.getM()];

		mark[data.getiSource()][data.getjSource()] = 1;
		Queue<Cell> q = new LinkedList<>();
		q.offer(data.getCell(data.getiSource(), data.getjSource()));

		while (!q.isEmpty()) {
			Cell curr = q.poll();

			ArrayList<Pair<Integer, Integer>> h_value = new ArrayList<>();
			for (int i = 0; i < 4; ++i) {
				int newX = curr.x + utils.rr[i];
				int newY = curr.y + utils.cc[i];

				if (!data.isValidToGo(newX, newY)) continue;
				if (mark[newX][newY] != 0) continue;

				int value = data.getHeuristicFrom(newX, newY);
				h_value.add(new Pair<>(i, value));
			}

			Collections.sort(h_value, new Comparator<Pair<Integer, Integer>>() {
				@Override
				public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
					return o1.getValue() - o2.getValue();
				}
			});

			for (int i = 0; i < Math.min(BEAM_SIZE, h_value.size()); ++i) {
				Pair p = h_value.get(i);
				int newX = curr.x + utils.rr[(int) p.getKey()];
				int newY = curr.y + utils.cc[(int) p.getKey()];

				mark[newX][newY] = mark[curr.x][curr.y] + 1;
				q.offer(data.getCell(newX, newY));

				if (data.isDestination(newX, newY)) break;
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
