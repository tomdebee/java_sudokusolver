package sudoku;

import java.util.ArrayList;

public class Solver {
	
	static int[][] solvedSudoku;
	
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
					} 
					
				}
				
				if(value==10){
					xy--;
					xy--;
				}
			}
		return solvedSudoku;
	}
	
	static int lookupX(int xy) {
		return xy / 9;
	}
	
	static int lookupY(int xy) {
		return xy % 9;
	}
	
	static void displaySudokuArray(int[][] arraySudoku) {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(arraySudoku[i][j]<0) {
					System.out.print(arraySudoku[i][j]*-1 + " ");
				} else {
					System.out.print(arraySudoku[i][j] + " ");
				}

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
	
	static int guessIter(int[][] arraySudoku, int xy) {
		int x = lookupX(xy);
		int y = lookupY(xy);
		
		int value = 1;
		if(arraySudoku[x][y]<0) {
			value = arraySudoku[x][y];
			guessIter(arraySudoku, xy+1);
		} 
		
		if(value>0) {
			for(value=1;value<=10;value++) {
				if(value==10) {
					break;
				}
				arraySudoku[x][y] = value;
				solvedSudoku=arraySudoku;
				if(hasIntegrity(arraySudoku)) {
					if(guessIter(arraySudoku, xy+1)==10) {
						continue;
					} else if (value>0) {
						value++;
					}
				} 
			} 
		}
		
		
		if(value==10) {
			arraySudoku[x][y] = 0;
			return value;
		} else {
			return 10;
		}
	}
	
	static void iterInit(Sudoku sudokuToSolve) {
		try {
		guessIter(sudokuToSolve.getSudoku(),0);
		} catch (Exception e) {
		} finally {
			displaySudokuArray(solvedSudoku);
		}
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
						int checkNo;
						if(sudoku[x+(xblock*3)][y+(yblock*3)]<0) {
							checkNo = (sudoku[x+(xblock*3)][y+(yblock*3)])*-1;
						} else {
							checkNo = sudoku[x+(xblock*3)][y+(yblock*3)];
						}
						
						if(checkNo!=0 && !block.contains(checkNo)) {
							block.add(checkNo);
						} else if (block.contains(checkNo)) {
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
				int checkNo;
				if(sudoku[x][y]<0) {
					checkNo = sudoku[x][y]*-1; 
				} else {
					checkNo = sudoku[x][y];
				}
				
				if(checkNo!=0 && !row.contains(checkNo)) {
					row.add(checkNo);
				} else if (row.contains(checkNo)) {
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
				int checkNo;
				if(sudoku[x][y]<0) {
					checkNo = sudoku[x][y]*-1; 
				} else {
					checkNo = sudoku[x][y];
				}
				if(checkNo!=0 && !column.contains(checkNo)) {
					column.add(checkNo);
				} else if (column.contains(checkNo)) {
					integrity = false;
				}
			}
		}
		return integrity; 
	} 

}
