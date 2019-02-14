public class KnightBoard{
  private int[][] board;
  public KnightBoard(int rows, int cols){
    board = new int[rows][cols];
    for (int r = 0; r < rows; r++){
      for (int c = 0; c < cols; c++){
        board[r][c] = 0;
      }
    }
  }
  public String toString(){
    boolean great = false;
    String s = "";
    for (int r = 0; r < board.length; r++){
      for (int c = 0; c < board[r].length; c++){
        if (board[r][c] > 9){
          great = true;
        }
      }
    }
    for (int x = 0; x < board.length; x++){
      for (int y = 0; y < board[x].length; y++){
        if (great && board[x][y] < 10){
          s += " " + board[x][y] + " ";
        }
      //  else if (board[x][y] == 0){
      //  s += "_ ";
      //  }
        else{
          s += board[x][y] + " ";
        }
      }
    s += "\n";
    }
    return s;
  }
  public boolean solve(int startingRow, int startingCol){
    return solveH(startingRow, startingCol, 1);
  }
  private boolean solveH(int row, int col, int level){
    if (row < 0 || col < 0 || row >= board.length || col >= board[0].length){
      return false;
    }
    if (board[row][col] == 0){
      board[row][col] = level;
    }
    else{
      return false;
    }
    if (level == board.length * board[0].length){
      return true;
    }
    if (solveH(row + 1, col + 2, level + 1)){
      return true;
    }
    else{
      if (!(row + 1 < 0 || col + 2 < 0 || row + 1 >= board.length || col + 2 >= board[0].length)){
        if (board[row + 1][col + 2] == level + 1){
          board[row + 1][col + 2] = 0;
        }
      }
    }
    if (solveH(row - 1, col - 2, level + 1)){
      return true;
    }
    else{
      if (!(row - 1 < 0 || col - 2 < 0 || row - 1 >= board.length || col - 2 >= board[0].length)){
        if (board[row - 1][col - 2] == level + 1){
          board[row - 1][col - 2] = 0;
        }
      }
    }
    if (solveH(row + 1, col - 2, level + 1)){
      return true;
    }
    else{
      if (!(row + 1 < 0 || col - 2 < 0 || row + 1 >= board.length || col - 2 >= board[0].length)){
        if (board[row + 1][col - 2] == level + 1){
          board[row + 1][col - 2] = 0;
        }
      }
    }
    if (solveH(row - 1, col + 2, level + 1)){
      return true;
    }
    else{
      if (!(row - 1 < 0 || col + 2 < 0 || row - 1 >= board.length || col + 2 >= board[0].length)){
        if (board[row - 1][col + 2] == level + 1){
          board[row - 1][col + 2] = 0;
        }
      }
    }
    if (solveH(row + 2, col + 1, level + 1)){
      return true;
    }
    else{
      if (!(row + 2 < 0 || col + 1 < 0 || row + 2 >= board.length || col + 1 >= board[0].length)){
        if (board[row + 2][col + 1] == level + 1){
          board[row + 2][col + 1] = 0;
        }
      }
    }
    if (solveH(row - 2, col - 1, level + 1)){
      return true;
    }
    else{
      if (!(row - 2 < 0 || col - 1 < 0 || row - 2 >= board.length || col - 1 >= board[0].length)){
        if (board[row - 2][col - 1] == level + 1){
          board[row - 2][col - 1] = 0;
        }
      }
    }
    if (solveH(row + 2, col - 1, level + 1)){
      return true;
    }
    else{
      if (!(row + 2 < 0 || col - 1< 0 || row + 2 >= board.length || col - 1 >= board[0].length)){
        if (board[row + 2][col - 1] == level + 1){
          board[row + 2][col - 1] = 0;
        }
      }
    }
    if (solveH(row - 2, col + 1, level + 1)){
      return true;
    }
    else{
      if (!(row - 2 < 0 || col + 1 < 0 || row - 2 >= board.length || col + 1 >= board[0].length)){
        if (board[row - 2][col + 1] == level + 1){
          board[row - 2][col + 1] = 0;
        }
      }
    }
    return false;
  }
  public int countSolutions(int startingRow, startingCol){
    return countSolutionsh(startingRow, startingCol, 1);
  }
  public int countSolutionsh(int row, int col, int level){
    int count = 0;
    if (row < 0 || col < 0 || row >= board.length || col >= board[0].length){
      return false;
    }
    if (board[row][col] == 0){
      board[row][col] = level;
    }
    else{
      return false;
    }
    if (level == board.length * board[0].length){
      return true;
    }
    if (solveH(row + 1, col + 2, level + 1)){
      return true;
    }
    else{
      if (!(row + 1 < 0 || col + 2 < 0 || row + 1 >= board.length || col + 2 >= board[0].length)){
        if (board[row + 1][col + 2] == level + 1){
          board[row + 1][col + 2] = 0;
        }
      }
    }
    if (solveH(row - 1, col - 2, level + 1)){
      return true;
    }
    else{
      if (!(row - 1 < 0 || col - 2 < 0 || row - 1 >= board.length || col - 2 >= board[0].length)){
        if (board[row - 1][col - 2] == level + 1){
          board[row - 1][col - 2] = 0;
        }
      }
    }
    if (solveH(row + 1, col - 2, level + 1)){
      return true;
    }
    else{
      if (!(row + 1 < 0 || col - 2 < 0 || row + 1 >= board.length || col - 2 >= board[0].length)){
        if (board[row + 1][col - 2] == level + 1){
          board[row + 1][col - 2] = 0;
        }
      }
    }
    if (solveH(row - 1, col + 2, level + 1)){
      return true;
    }
    else{
      if (!(row - 1 < 0 || col + 2 < 0 || row - 1 >= board.length || col + 2 >= board[0].length)){
        if (board[row - 1][col + 2] == level + 1){
          board[row - 1][col + 2] = 0;
        }
      }
    }
    if (solveH(row + 2, col + 1, level + 1)){
      return true;
    }
    else{
      if (!(row + 2 < 0 || col + 1 < 0 || row + 2 >= board.length || col + 1 >= board[0].length)){
        if (board[row + 2][col + 1] == level + 1){
          board[row + 2][col + 1] = 0;
        }
      }
    }
    if (solveH(row - 2, col - 1, level + 1)){
      return true;
    }
    else{
      if (!(row - 2 < 0 || col - 1 < 0 || row - 2 >= board.length || col - 1 >= board[0].length)){
        if (board[row - 2][col - 1] == level + 1){
          board[row - 2][col - 1] = 0;
        }
      }
    }
    if (solveH(row + 2, col - 1, level + 1)){
      return true;
    }
    else{
      if (!(row + 2 < 0 || col - 1< 0 || row + 2 >= board.length || col - 1 >= board[0].length)){
        if (board[row + 2][col - 1] == level + 1){
          board[row + 2][col - 1] = 0;
        }
      }
    }
    if (solveH(row - 2, col + 1, level + 1)){
      return true;
    }
    else{
      if (!(row - 2 < 0 || col + 1 < 0 || row - 2 >= board.length || col + 1 >= board[0].length)){
        if (board[row - 2][col + 1] == level + 1){
          board[row - 2][col + 1] = 0;
        }
      }
    }
    return false;
  }
  }
  public static void main(String args[]){
    KnightBoard x = new KnightBoard(5,5);
    System.out.println(x);
    x.countSolutions(0,0);
    System.out.println(x);
  }
}
