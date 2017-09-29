package sudoku;

public class SudokuInit {
	public static void main (String[] args) {
		
		//String input = args[0];
		String input = "000820090500000000308040007100000040006402503000090010093004000004035200000700900";
		
		Sudoku sudokuToSolve = new Sudoku(input);
		sudokuToSolve.displaySudoku();
		
//		boolean result = Solver.hasRowIntegrity(sudokuToSolve.getSudoku());
//		boolean result2 = Solver.hasColumnIntegrity(sudokuToSolve.getSudoku());
//		boolean result3 = Solver.hasBlockIntegrity(sudokuToSolve.getSudoku());
//		System.out.println(result);
//		System.out.println(result2);
//		System.out.println(result3);
		
		System.out.println(Solver.hasIntegrity(sudokuToSolve.getSudoku()));
		Solver.bruteForceDepth(sudokuToSolve);
		sudokuToSolve.displaySudoku();
		
		
	}
}
