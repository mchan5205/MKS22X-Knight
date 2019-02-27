public class KnightBoard{
  private int[][] board;
  private int[] moves;
  public KnightBoard(int rows, int cols){
    board = new int[rows][cols];
    for (int r = 0; r < rows; r++){
      for (int c = 0; c < cols; c++){
        board[r][c] = 0;
      }
    }
    moves = new int[] {1, 2, 2, 1, 2, -1, 1, -2, -1, -2, -2, -1, -2, 1, -1, 2};
  }
  public String toString(){
    boolean great = false;
    String s = "";
    if (board[0][0] == 0){
      for (int r = 0; r < board.length; r++){
        for (int c = 0; c < board[r].length; c++){

        }
      }
    }
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
    for (int r = 0; r < board.length; r ++){
      for (int c = 0; c < board.length; c ++){
        if (board[r][c] != 0){
          throw new IllegalStateException();
        }
      }
    }
    if (startingRow < 0 || startingCol < 0 || startingRow >= board.length || startingRow >= board[0].length){
      throw new IllegalArgumentException();
    }
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
    for (int i = 0; i < 16; i = i + 2){
      if (solveH(row + moves[i], col + moves[i + 1], level + 1)){
        return true;
      }
      else{
        if (!(row + moves[i] < 0 || col + moves[i + 1] < 0 || row + moves[i] >= board.length || col + moves[i + 1] >= board[0].length)){
          if (board[row + moves[i]][col + moves[i + 1]] == level + 1){
            board[row + moves[i]][col + moves[i + 1]] = 0;
          }
        }
      }
    }
    return false;
  }
  public int countSolutions(int startingRow, int startingCol){
    int total = 0;
    for (int r = 0; r < board.length; r ++){
      for (int c = 0; c < board.length; c ++){
        if (board[r][c] != 0){
          throw new IllegalStateException();
        }
      }
    }
    if (startingRow < 0 || startingCol < 0 || startingRow >= board.length || startingRow >= board[0].length){
      throw new IllegalArgumentException();
    }
    total = countSolutionsh(startingRow, startingCol, 1);
    board[startingRow][startingCol] = 0;
    return total;
  }
  public int countSolutionsh(int row, int col, int level){
    int sum = 0;
    int a = 0;
    if (row < 0 || col < 0 || row >= board.length || col >= board[0].length){
      return 0;
    }
    if (board[row][col] == 0){
      board[row][col] = level;
    }
    else{
      return 0;
    }
    if (level == board.length * board[0].length){
      return 1;
    }
    for (int i = 0; i < 16; i = i + 2){
      a = countSolutionsh(row + moves[i], col + moves[i + 1], level + 1);
      sum += a;
      if (!(row + moves[i] < 0 || col + moves[i + 1] < 0 || row + moves[i] >= board.length || col + moves[i + 1] >= board[0].length)){
        if (board[row + moves[i]][col + moves[i + 1]] == level + 1){
          board[row + moves[i]][col + moves[i + 1]] = 0;
        }
      }
    }
    return sum;
  }
  public static void main(String args[]){
    KnightBoard x = new KnightBoard(5,5);
    System.out.println(x);
    System.out.println(x.countSolutions(0,0));
    System.out.println(x);
  }
}
