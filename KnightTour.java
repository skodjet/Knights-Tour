/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN 
 * BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Tommy Skodje*/

import java.util.Stack;

// Do you know the chess piece that looks like a horse? It's called a "Knight",
// and the "Knight's Tour" is a famous problem where you want the Knight to move
// around a chess board such that it visits every position on the board exactly once.
// Recall that the Knight can move in the shape of the letter "L" in any direction
// IMPORTANT: See our A2 handout for examples and more detailed instructions/hints!

public class KnightTour {
	// TODO: Implement and print a Knight's Tour solution, using
	// the chess board defined in class KnightBoard. Your solution must
	// use a Stack to keep track of different possible sequences of moves
	// for the Knight, in order to discover and return a valid tour.

	// NOTE: There can be several distinct valid tours; your job is to find
	// and print only one valid tour (the first valid one you discover).
	// Please do NOT attempt to discover all possible valid tours! To get
	// a sense of how many valid board configurations exist for different
	// board sizes, see "The Knight's Paths" table here:
	// http://www.behnel.de/knight.html

	/**
	 * tour method is where you add your code for implementing a Knight Tour's
	 * solution for an n*n chess board
	 * 
	 * @param n size of the board
	 * @return KnightBoard object with a valid Knight Tour
	 */
	public static KnightBoard tour(int n) {
		// Your solution must utilize the stack "candidates" below,
		// to keep track of different possible sequences of Knight moves
		Stack<KnightBoard> candidates = new Stack<KnightBoard>();
		KnightBoard kb = new KnightBoard(n); // create initial board of size n*n
		candidates.push(kb); // push the initial board onto the stack
		// TODO: ...... Add your solution code here ..... /
		KnightBoard temp = new KnightBoard(n);
		while (!candidates.isEmpty()) {
			kb = candidates.pop();
			
			
			boolean isSolved = true;

			for (int i = 0; i < n; i++) { // This nested for loop checks whether all spaces on the board have been
											// visited.
				for (int j = 0; j < n; j++) {
					if (kb.board[i][j] == -1) {
						isSolved = false;
					}
				}
			}

			if (isSolved) { //If no spaces are blank, the tour is solved.
				System.out.println("Tour solved!");
				return kb;
				
			} else { //If there are blank spaces, new moves need to be tried.
				//Each one of the 8 possible moves a knight can make will be tried in succession, with possible moves being pushed to the stack.
				temp = kb.copyBoard();
				
				if(temp.move(kb.getCurrentX() + 1, kb.getCurrentY() + 2)) {
					candidates.push(temp);
				}
				
				temp = kb.copyBoard();
				
				if(temp.move(kb.getCurrentX() + 2, kb.getCurrentY() + 1)) {
					candidates.push(temp);
				}
				
				temp = kb.copyBoard();
					
				if(temp.move(kb.getCurrentX() + 1, kb.getCurrentY() - 2)) {
					candidates.push(temp);
				}
				
				temp = kb.copyBoard();
				
				if(temp.move(kb.getCurrentX() + 2, kb.getCurrentY() - 1)) {
					candidates.push(temp);
				}
				
				temp = kb.copyBoard();
				
				if(temp.move(kb.getCurrentX() - 1, kb.getCurrentY() - 2)) {
					candidates.push(temp);
				}
				
				temp = kb.copyBoard();
				
				if(temp.move(kb.getCurrentX() - 2, kb.getCurrentY() - 1)) {
					candidates.push(temp);
				}
				
				temp = kb.copyBoard();
				
				if(temp.move(kb.getCurrentX() - 2, kb.getCurrentY() + 1)) {
					candidates.push(temp);
				}
				
				temp = kb.copyBoard();
				
				if(temp.move(kb.getCurrentX() - 1, kb.getCurrentY() + 2)) {
					candidates.push(temp);
				}
				
				//Do this for all 8 possible knight moves
				
				
				
				
				
			}
		}
		
		
		if (candidates.isEmpty()) { //If the stack is empty, then the max number of possible squares for the tour has been reached.
			return kb;
		}	
				
			
			

		return null; // TODO: return a KnightBoard object with a valid Knight Tour
	}

	// Do NOT modify this main method. If you need to add code for
	// testing your solution, just make sure to comment it out before submission
	public static void main(String[] args) {
		int n = 3; // default board size if user didn't specify
		// pass in parameter n from command line
		if (args.length == 1) {
			n = Integer.parseInt(args[0].trim());
			if (n < 3) {
				System.out.println("Incorrect parameter (n must be >= 3)");
				System.exit(-1);
			}
		}
		long startTime = System.nanoTime();
		KnightBoard winner = KnightTour.tour(n);
		long endTime = System.nanoTime();
		double delta = (endTime - startTime) / 1e6;
		// Display the solution you discovered:
		System.out.println("\nPossible Knight Tour with max #squares visited in this (" + n + "x" + n + ") board:");
		winner.printChessBoard();
		System.out.println("\n(Time to find this solution = " + delta + " milliseconds)");
	}
}
