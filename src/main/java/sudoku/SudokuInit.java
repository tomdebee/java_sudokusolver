package sudoku;

public class SudokuInit {
	public static void main (String[] args) {
		
		long time1 = System.nanoTime();
		int n=0;
		
		for(String sudokuString : args) {
			n++;
			
			sudokuString = sudokuString.trim();
			long timeN1 = System.nanoTime();
			
			Sudoku sudokuToSolve = new Sudoku(sudokuString);
			Solver.iterInit(sudokuToSolve);
			
			long timeN2 = System.nanoTime();
			int millisecs = (int)((timeN2-timeN1)/1000000);
			
			System.out.println("Sudoku no. " + n +" solved in: " + millisecs + "ms\n");
		}
		
		long time2 = System.nanoTime();
		int millisecs = (int)((time2-time1)/1000000);
		
		System.out.println("Solved all in: " + millisecs + " milliseconds");
		
	}
}
