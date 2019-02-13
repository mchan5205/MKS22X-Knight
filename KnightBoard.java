public class KnightBoard{
  private int[][] board;
  public KnightBoard(int rows, int cols){
    board == new int[rows][cols];
    for (int r = 0; r < rows; r++){
      for (int c = 0; c < cols; c++){
        board[r][c] = 0;
      }
    }
  }
}
