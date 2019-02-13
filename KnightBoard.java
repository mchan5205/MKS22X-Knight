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
}
