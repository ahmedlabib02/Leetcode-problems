class Solution {
    public boolean isValidSudoku(char[][] board) {
      HashSet<Character>[] rows=  new HashSet[9];
      HashSet<Character>[] columns = new HashSet[9];
      HashSet<Character>[] blocks = new HashSet[9];
      int p1 = -1;
      int p2 = -1;  
      for(int i=0; i<board.length;i++){
          if(i%3==0)
            p1=(p1+1)%3;  
          if(rows[i]==null)
              rows[i] = new HashSet<Character>();
          HashSet<Character> rowSet = rows[i];
          for(int j=0;j<board[i].length;j++){
              if(j%3==0)
                p2=(p2+1)%3; 
              int blockIndex = (3*p2)+p1;
              if(blocks[blockIndex]==null)
                   blocks[blockIndex]= new HashSet<Character>();
              HashSet<Character> blockSet = blocks[blockIndex];
               if(columns[j]==null)
                 columns[j] = new HashSet<Character>();
              HashSet<Character> columnSet = columns[j];
              if(board[i][j]!='.'){
                 if(rowSet.contains(board[i][j]))
                      return false;
                  else
                      rowSet.add(board[i][j]); 
                  if(columnSet.contains(board[i][j]))
                      return false;
                  else
                      columnSet.add(board[i][j]);
                  if(blockSet.contains(board[i][j]))
                      return false;
                  else 
                      blockSet.add(board[i][j]);
              }
                  
              
          }
      }
        return true;
    }
}