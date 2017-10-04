package sudoku;

public class Sudoku {
	
	private int[][] sudoku = new int[9][9];
	
	//000820090
	//500000000
	//308040007
	//100000040
	//006402503
	//000090010
	//093004000
	//004035200
	//000700900
	
	public Sudoku(String sudokuList) {
		construct(sudokuList);
	}
	
	private void construct(String sudokuList) {		
		for(int i=0,ij=0;i<9;i++) {
			for(int j=0;j<9;j++,ij++) {
				if(Character.getNumericValue(sudokuList.charAt(ij))>0) {
					sudoku[i][j] = Character.getNumericValue(sudokuList.charAt(ij))*-1;
				} else {
					sudoku[i][j] = 0;
				}
				
				
			}
		}
	}
	
	public int[][] getSudoku() {
		return sudoku;
	}
	
	public void displaySudoku() {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(sudoku[i][j] + " ");
				if(j%3 == 2) { 
					System.out.print(" ");
				}
			}
			System.out.print("\n");
			if(i%3 == 2) {
				System.out.print("\n");
			}
		}
	}
}
