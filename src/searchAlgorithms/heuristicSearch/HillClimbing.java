package searchAlgorithms.heuristicSearch;

import javafx.util.Pair;
import utils.Matrix;
import utils.utils;
import utils.Cell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Harry Tran on 3/30/19.
 * @project ShortestPathFinding
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class HillClimbing {
	static private void DFS(Matrix data, int[][] mark, int currX, int currY, Cell[][] par, Cell[][] parCache) {
		if (data.isDestination(currX, currY)) {
			return;
		}

		ArrayList<Pair<Integer, Integer>> h_value = new ArrayList<>();
		for (int i = 0; i < 4; ++i) {
			int newX = currX + utils.rr[i];
			int newY = currY + utils.cc[i];
			if (!data.isValidToGo(newX, newY)) continue;
			int value = data.getHeuristicFrom(newX, newY);
			h_value.add(new Pair<>(i, value));
		}
		Collections.sort(h_value, new Comparator<Pair<Integer, Integer>>() {
			@Override
			public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
				return o1.getValue() - o2.getValue();
			}
		});
		for (Pair p : h_value) {
			int newX = currX + utils.rr[(int)p.getKey()];
			int newY = currY + utils.cc[(int)p.getKey()];

			if (data.isDestination(newX, newY)){
				if (mark[newX][newY] == 0 || mark[currX][currY] + 1 < mark[newX][newY]) {
					mark[newX][newY] = mark[currX][currY] + 1;
					par[newX][newY] = data.getCell(currX, currY);
					utils.copyData(par, parCache);
				}
				continue;
			}

			if (mark[newX][newY] != 0) continue;

			mark[newX][newY] = mark[currX][currY] + 1;
			par[newX][newY] = data.getCell(currX, currY);
			DFS(data, mark, newX, newY, par, parCache);
			mark[newX][newY] = 0;
			par[newX][newY] = null;
		}
	}

	static public void runSearch(Matrix data) {
		System.out.println("\n=== Hill Climbing Search ===");
		long startTime = System.nanoTime();
		int[][] mark = new int[data.getN()][data.getM()];
		Cell[][] par = new Cell[data.getN()][data.getM()];
		Cell[][] parCache = new Cell[data.getN()][data.getM()];

		mark[data.getiSource()][data.getjSource()] = 1;
		DFS(data, mark, data.getiSource(), data.getjSource(), par, parCache);

		if (mark[data.getiDes()][data.getjDes()] == 0) {
			System.out.println("Can not find path to the destination!!!");
		} else {
			System.out.println("Distance = " + Integer.toString(mark[data.getiDes()][data.getjDes()] - 1));
			utils.tracking(data, parCache);
		}
		long endTime   = System.nanoTime();
		System.out.println(Double.toString((double)(endTime - startTime)/1000000) + " miliseconds");
		System.out.println("=== Finished ===");
	}
}
