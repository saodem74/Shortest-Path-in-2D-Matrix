package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Harry Tran on 3/30/19.
 * @project ShortestPathFinding
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class FileUtils {
	public static Matrix read2DMatrixFromFile(String filename) {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String firstLine = br.readLine();
			String[] nums = firstLine.split(" ");
			int n = Integer.parseInt(nums[0]);
			int m = Integer.parseInt(nums[1]);

			Matrix data = new Matrix(n, m);
			for (int i = 0; i < n; ++i) {
				String line = br.readLine();
				String[] cells = line.split(" ");
				for (int j = 0; j < m; ++j) {
					data.update(i, j, cells[j].charAt(0));
				}
			}

			return data;
		}
		catch (Exception e) {
			System.out.println("ERROR FILE READING!!!");
		}
		return new Matrix(0, 0);
	}
}
