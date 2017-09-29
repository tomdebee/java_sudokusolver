package sudoku;

import java.util.ArrayList;

public class Solver {
	
	
	
	static int[][] bruteForceDepth(Sudoku sudokuToSolve) {
		int[][] solvedSudoku = sudokuToSolve.getSudoku();
			 
			for(int xy=0;xy<81;xy++) {	
				int y = xy % 9;
				int x = xy / 9;
		
				int value=0; 
				if(solvedSudoku[x][y]==0) {
					for(value=1;value<=10;value++) {
						if(value==10) {
							break;
						}
						solvedSudoku[x][y] = value;						
						if(hasIntegrity(solvedSudoku)) {
							break;
						} 
						sudokuToSolve.displaySudoku();
						System.out.println();
					} 
					
				}
				
				if(value==10){
					xy--;
					xy--;
				}
			}
	//	}
		
		
		return solvedSudoku;
	}
	
	
	static int[][] bruteRecursive(Sudoku sudokuToSolve) {
		int[][] solvedSudoku = sudokuToSolve.getSudoku();
			 
			for(int xy=0;xy<81;xy++) {	
				int y = xy % 9;
				int x = xy / 9;
		
				int value=0; 
				if(solvedSudoku[x][y]==0) {
					for(value=1;value<=10;value++) {
						if(value==10) {
							break;
						}
						solvedSudoku[x][y] = value;						
						if(hasIntegrity(solvedSudoku)) {
							break;
						} 
						sudokuToSolve.displaySudoku();
						System.out.println();
					} 
					
				}
				
				if(value==10){
					xy--;
					xy--;
				}
			}
	//	}
		
		
		return solvedSudoku;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static boolean hasIntegrity(int[][] sudoku) {
		if(hasBlockIntegrity(sudoku) && hasRowIntegrity(sudoku) && hasColumnIntegrity(sudoku)) {
			return true;
		} else {
			return false;
		}
		
	}
	
	static boolean hasBlockIntegrity(int[][] sudoku) {
		
		boolean integrity = true;
		
		for(int xblock=0;xblock<3;xblock++) {
			for(int yblock=0;yblock<3;yblock++) {
				ArrayList<Integer> block = new ArrayList<Integer>();
				for(int x=0;x<3;x++) {
					for(int y=0;y<3;y++) {
						int checkNo = sudoku[x+(xblock*3)][y+(yblock*3)];
						if(checkNo!=0 && !block.contains(checkNo)) {
							block.add(checkNo);
						} else if (block.contains(checkNo)) {
							System.out.println("Integrity failed on block " + (yblock+1) + "," + (xblock+1)
									+ " (" + (y+1) + "," + (x+1) + ")" 
									);
							integrity = false;
						}
					}
				}
			}
		}
		
		
		return integrity;
	}
	
	static boolean hasColumnIntegrity(int[][] sudoku) { 
		
		boolean integrity = true;
		
		for(int x=0;x<9;x++) {
			ArrayList<Integer> row = new ArrayList<Integer>();
			for(int y=0;y<9;y++) {
				int checkNo = sudoku[x][y];
				if(checkNo!=0 && !row.contains(checkNo)) {
					row.add(checkNo);
				} else if (row.contains(checkNo)) {
					System.out.println("Integrity failed on column " + (y+1));
					integrity = false;
				}
			}
		}
		return integrity; 
	}
	
	static boolean hasRowIntegrity(int[][] sudoku) { 
		
		boolean integrity = true;
		
		for(int y=0;y<9;y++) {
			ArrayList<Integer> column = new ArrayList<Integer>();
			for(int x=0;x<9;x++) {
				int checkNo = sudoku[x][y];
				if(checkNo!=0 && !column.contains(checkNo)) {
					column.add(checkNo);
				} else if (column.contains(checkNo)) {
					System.out.println("Integrity failed on row " + (x+1));
					integrity = false;
				}
			}
		}
		return integrity; 
	} 

}
