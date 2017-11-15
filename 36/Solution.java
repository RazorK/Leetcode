import java.util.*;
import java.io.*;
class Solution {
    public static boolean isValidSudoku(char[][] board) {
      HashMap<String, Boolean> map = new HashMap<>();
      for(int i = 0; i< 9; i++) {
        map.put(Integer.toString(i+1), true);
      }
      map.put(".", true);
      System.out.println();
      //rows
      for(int i=0; i<9; i++) {
        ArrayList<Character> al = new ArrayList<>();
        for(int j=0; j<9;j++) {
          Character c = board[i][j];
          if (!map.containsKey(c)) return false;
          al.add(c);
        }
        if(!isValid9(al)) return false;
      }
      System.out.println("after rows");
      //cols
      for(int i=0; i<9; i++) {
        ArrayList<Character> al = new ArrayList<>();
        for(int j=0; j<9;j++) {
          Character c = board[j][i];
          if (!map.containsKey(c)) return false;
          al.add(c);
        }
        if(!isValid9(al)) return false;
      }
      System.out.println("after cols");
      //sub
      for(int i=0; i<9; i++) {
        ArrayList<Character> al = new ArrayList<>();
        for(int j=0; j<9;j++) {
          int first, second;
          first = (i/3)*3 + j/3;
          second = (i%3)*3 + j%3;
          Character c = board[first][second];
          if (!map.containsKey(c)) return false;
          al.add(c);
        }
        if(!isValid9(al)) return false;
      }
      System.out.println("after subs");
      return true;
    }

    public static boolean isValid9(ArrayList<Character> l) {
      System.out.println(l.toString());
      HashMap<Character, Boolean> map = new HashMap<>();
      for(int i=0;i<l.size();i++) {
        Character c = l.get(i);
        if(c == '.') continue;
        if(!map.containsKey(c))
          map.put(c, true);
        else return false;
      }
      return true;
    }
}
