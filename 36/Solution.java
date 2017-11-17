import java.util.*;
import java.io.*;
class Solution {
public static boolean isValidSudoku(char[][] board) {
	HashMap<String, Boolean> map = new HashMap<>();
	for(int i = 0; i< 9; i++) {
		map.put(Integer.toString(i+1), true);
	}
	map.put(".", true);
	//System.out.println("before rows");
	//rows
	for(int i=0; i<9; i++) {
		ArrayList<Character> al = new ArrayList<>();
		for(int j=0; j<9; j++) {
			Character c = board[i][j];
			if (map.containsKey(c)) return false;
			al.add(c);
		}
		if(!isValid9(al)) return false;
	}
	System.out.println("after rows");
	//cols
	for(int i=0; i<9; i++) {
		ArrayList<Character> al = new ArrayList<>();
		for(int j=0; j<9; j++) {
			Character c = board[j][i];
			if (map.containsKey(c)) return false;
			al.add(c);
		}
		if(!isValid9(al)) return false;
	}
	//System.out.println("after cols");
	//sub
	for(int i=0; i<9; i++) {
		ArrayList<Character> al = new ArrayList<>();
		for(int j=0; j<9; j++) {
			int first, second;
			first = (i/3)*3 + j/3;
			second = (i%3)*3 + j%3;
			Character c = board[first][second];
			if (map.containsKey(c)) return false;
			al.add(c);
		}
		if(!isValid9(al)) return false;
	}
	//System.out.println("after subs");
	return true;
}

public static boolean isValid9(ArrayList<Character> l) {
	//System.out.println(l.toString());
	HashMap<Character, Boolean> map = new HashMap<>();
	for(int i=0; i<l.size(); i++) {
		Character c = l.get(i);
		if(c == '.') continue;
		if(!map.containsKey(c))
			map.put(c, true);
		else return false;
	}
	return true;
}

// a solution find in leetcode
// it uses the idea that the sudoku can only have nine number rather than
// unlimited number , so we can pre assigan the area, so that we don't need to assign it
// dynamically.
public boolean faster(char[][] board) {
	int n = board.length;
	boolean[][] rowIsVisited = new boolean[n][10];
	boolean[][] columnIsVisited = new boolean[n][10];
	boolean[][] boxIsVisited = new boolean[n][10];

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (board[i][j] != '.') {
				int num = board[i][j] - '0';
				if (rowIsVisited[i][num] || columnIsVisited[j][num] || boxIsVisited[(i / 3) * 3  + j / 3][num]) {
					return false;
				}
				rowIsVisited[i][num] = true;
				columnIsVisited[j][num] = true;
				boxIsVisited[(i / 3) * 3  + j / 3][num] = true;
			}
		}
	}
	return true;
}
}
