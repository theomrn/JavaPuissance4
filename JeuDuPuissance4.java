package application;

import java.util.Scanner;

public class JeuDuPuissance4 {
	static final int VIDE = 0;
	static final int ROUGE = 1;
	static final int JAUNE = 2;
	static final int WIDTH = 7;
	static final int HEIGHT = 6;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		/* test show grid function 
		grid[1][1] = 2;
		grid[0][0] = 1;
		System.out.println();
		afficheGrille(grid,width,height);
		
		// test winGridFunction
		// test top right
		grid[0][0] = 1;
		grid[1][1] = 1;
		grid[2][2] = 1;
		grid[3][3] = 0;
		afficheGrille(grid,width,height);
		System.out.println(grilleGagnante(grid));
		grid[0][0] = 0;
		grid[1][1] = 0;
		grid[2][2] = 0;
		grid[3][3] = 0;
		
		// test top 
		grid[0][0] = 1;
		grid[1][0] = 1;
		grid[2][0] = 1;
		grid[3][0] = 1;
		afficheGrille(grid,width,height);
		System.out.println(grilleGagnante(grid));
		grid[0][0] = 0;
		grid[1][0] = 0;
		grid[2][0] = 0;
		grid[3][0] = 0;
		
		// test top left  
		grid[0][3] = 1;
		grid[1][2] = 1;
		grid[2][1] = 1;
		grid[3][0] = 2;
		afficheGrille(grid,width,height);		
		System.out.println(grilleGagnante(grid));
		grid[0][3] = 0;
		grid[1][2] = 0;
		grid[2][1] = 0;
		grid[3][0] = 0;
		
		// test right  
		grid[0][0] = 1;
		grid[1][0] = 1;
		grid[2][0] = 1;
		grid[3][0] = 1;
		afficheGrille(grid,width,height);		
		System.out.println(grilleGagnante(grid));
		grid[0][0] = 0;
		grid[1][0] = 0;
		grid[2][0] = 0;
		grid[3][0] = 0;
		*/
		
		// main program
		int [][] grid = nouvelleGRille(WIDTH,HEIGHT);
		boolean isDraw = false;
		boolean isGridWon = false;
		boolean isPlayer1playing = true;
		System.out.println("Nom du joueur 1 :");
		String player1 = scanner.nextLine();
		System.out.println("Nom du joueur 2 :");
		String player2 = scanner.nextLine();
		
		while (isDraw == false || isGridWon == false) {
			isDraw = isGridDraw(grid);
			if (isPlayer1playing) {
				isGridWon = tourJoueur(scanner,grid,player1,1);
			} 
			else {
				isGridWon = tourJoueur(scanner,grid,player2,2);
			}
			isPlayer1playing = !isPlayer1playing;
		}
		if (isDraw && !isGridWon) {
			System.out.println("La partie est nulle");
		}
		else if (isPlayer1playing) {
			System.out.println("Le joueur " + player2 + " a gagner la partie");
		}
		else {
			System.out.println("Le joueur " + player1 + " a gagner la partie");
		}
	}

	
	public static int[][] nouvelleGRille(int width, int height) {
		int [] [] grid = new int [width] [height];
		
		for (int i = 0; i<width; i++) {
			for (int j = 0; j<height ; j++) {
				grid[i][j] = 0;
			}
		}
		
		return grid;
	}
	
	public static void afficheGrille(int[][] grid, int width, int height) {
		for (int i = height-1 ; i>=0; i--) {
			for (int j = 0; j<width ; j++) {
				if (grid[j][i] == 0) {
					System.out.print("| |");
				}
				else if (grid[j][i] == 1) {
					System.out.print("|X|");
				}
				else {
					System.out.print("|O|");
				}
				
			}
			System.out.println();
		}
	}
	
	public static boolean checkLine(int[][] grid, int x, int y) {
		/*
		 * check if a point is the start of a wining line 
		 * x and y are the coordinates of the point
		 * the function only check 4 directions the others one being check before 
		 * when the grilleGagnante function pass in the first raws
		 */
		int isGridWonTopLeft = 1;
		int isGridWonTop = 1;
		int isGridWonTopRight = 1;
		int isGridWonRight = 1;
		
		// top left
		for (int i=1 ; i<4 ; i++) {
			if ((x-i >= 0) && (y-i >= 0)) {
				if (grid[x-i][y-i] == grid[x][y]) {
					isGridWonTopLeft++;
				}
				else {
					isGridWonTopLeft = -10;
				}
			}
			if (y-i >= 0) {
				if (grid[x][y-i] == grid[x][y]) {
					isGridWonTop++;
				}
				else {
					isGridWonTop = -10;
				}
			}
			if ((x+i < 6) && (y-i >= 0)) {
				if (grid[x+i][y-i] == grid[x][y]) {
					isGridWonTopRight++;
				}
				else {
					isGridWonTopRight = -10;
				}
			}
			if (x+i < 6) {
				if (grid[x+i][y] == grid[x][y]) {
					isGridWonRight++;
				}
				else {
					isGridWonRight = -10;
				}
			}
		}
		if (isGridWonTopLeft == 4 || isGridWonTop == 4 || isGridWonTopRight == 4 || isGridWonRight == 4) {
			return true;
		}
		
		return false;
	}
	
	public static Boolean grilleGagnante(int[][] grid) {
		Boolean isGridWon = false;
		
		for (int i=0; i<7 ; i++) {
			for (int j=5; j>=0 ; j--) {
				if (grid[i][j] != 0) {
					isGridWon = checkLine(grid,i,j);
					if (isGridWon) {
						return true;
					}
				}
			}
		}
		// default case
		return false;
	}
	
	public static int[][] joueJeton(int [][] grid, int colone, int couleur) {
		int y = 0;
		while (grid[colone][y] != 0) {
			y++;
		}
		grid[colone][y] = couleur;
		return grid;
	}
	
	public static boolean tourJoueur(Scanner scanner, int [][] grid, String nomJoueur, int couleur) {
		System.out.println(nomJoueur + " Dans quelle colones voulez vous placer votre jeton");
		int colone = scanner.nextInt();
		while (grid[colone][5] != 0) {
			System.out.println(nomJoueur + " La colone que vous avez choisis est pleine, veillez en donner une autre");
			colone = scanner.nextInt();
		}
		grid = joueJeton(grid,colone,couleur);
		afficheGrille(grid,WIDTH,HEIGHT);
		return grilleGagnante(grid);
	}
	
	public static boolean isGridDraw(int [][] grid) {
		boolean isDraw = true;
		for (int i=0;i<WIDTH; i++) {
			if (grid[i][HEIGHT-1] != 0) {
				return false;
			}
		}
		return true;
	}
	
}
