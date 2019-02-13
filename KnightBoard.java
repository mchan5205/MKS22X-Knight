public class KnightBoard{
  private int[][] board;
  public KnightBoard(int rows, int cols){
    board == new int[rows][cols];
    for (int r = 0; r < rows; r++){
      for (int c = 0; c < cols; c++){
        board[r][c] = 0;
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
          if (great && board[x][y] < 10 && board[x][y] != 0){
            s += " " + board[x][y] + " ";
          }
          else if (board[x][y] == 0){
            s += "_ ";
          }
          else{
            s += board[x][y] + " "
          }
        }
        s += "\n"
      }
      return s;
    }
  }
  public boolean solve(int startingRow, int startingCol){

  }
  private boolean solveH(int row, int col, int level){
    if (row < 0 || col < 0 || row > board.length || col > board[0].length){
      return false;
    }
    if (board[row][col] == 0){
      board[row][col] == level;
    }
    else{
      return false;
    }
    if (level == board.length * board[0].length){
      return true;
    }
    for (int r = 1; r < 3; r++){
      for (int c = 1; c < 3; c++){
        if (solveH(row + r, col + c, level + 1)){
          return true;
        }
        else{
          if (!(row + r < 0 || col + c < 0 || row + r > board.length || col + c > board[0].length)){
            board[row + r][col + c] == 0;
          }
        }
        if (solveH(row - r, col - c, level + 1)){
          return true;
        }
        else{
          if (!(row - r < 0 || col - c < 0 || row - r > board.length || col - c > board[0].length)){
            board[row - r][col - c] == 0;
          }
        }
      }
    }
  }
}
