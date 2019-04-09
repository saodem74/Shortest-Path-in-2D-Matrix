import searchAlgorithms.blindSearch.BreadthFirstSearch;
import searchAlgorithms.blindSearch.DepthFirstSearch;
import searchAlgorithms.blindSearch.DepthLimited;
import searchAlgorithms.blindSearch.IterativeDeepening;
import searchAlgorithms.heuristicSearch.AStar;
import searchAlgorithms.heuristicSearch.BeamSearch;
import searchAlgorithms.heuristicSearch.BestFirstSearch;
import searchAlgorithms.heuristicSearch.HillClimbing;
import utils.FileUtils;
import utils.Matrix;

/**
 * @author Harry Tran on 3/30/19.
 * @project ShortestPathFinding
 * @email trunghieu.tran@utdallas.edu
 * @organization UTDallas
 */
public class ShortestPathFindingApplication {

	private static final String input1 = "./src/input/input1.txt";

	public static void main(String[] args) {
		Matrix m = FileUtils.read2DMatrixFromFile(input1);
		m.printOutMaxtix();

		BreadthFirstSearch.runSearch(m);
		DepthFirstSearch.runSearch(m);
		DepthLimited.runSearch(m);
		IterativeDeepening.runSearch(m);

		HillClimbing.runSearch(m);
		BeamSearch.runSearch(m);
		BestFirstSearch.runSearch(m);
		AStar.runSearch(m);
	}
}
