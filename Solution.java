public class Solution{
  private static void rotate_matrix_180(char[][] matrix){
    int size = matrix.length;
    for (int index1 = 0, cntSwap = 0, maxSwap = (size*size) /2; cntSwap < maxSwap; ++index1){
      for (int index2 = 0; index2 < size && cntSwap < maxSwap; ++index2, ++cntSwap){
          char temp = matrix[index1][index2];
          matrix[index1][index2] = matrix[size - index1 - 1][ size - index2 - 1];
          matrix[size - index1 - 1][ size - index2 - 1] = temp;
      }
    }
  }

  private static String unspiral_matrix(char[][] matrix){
    int matrix_size = matrix.length;
    char[] spiral = new char[matrix_size * matrix_size];
    int u = 0, d = matrix_size - 1, l = 0, r = matrix_size - 1, k = 0;
    while (true) {
      // up
      for (int col = l; col <= r; col++) spiral[k++] = matrix[u][col];
      if (++u > d) break;
      // right
      for (int row = u; row <= d; row++) spiral[k++] = matrix[row][r];
      if (--r < l) break;
      // down
      for (int col = r; col >= l; col--) spiral[k++] = matrix[d][col];
      if (--d < u) break;
      // left
      for (int row = d; row >= u; row--) spiral[k++] = matrix[row][l];
      if (++l > r) break;
    }
    return new String(spiral);
  }

  public static void main(String[] argv){
    String input = argv[0];
    int size = (int)Math.sqrt(input.length());
    char[][] matrix = new char[size][size];
    for(int i=0; i<size; ++i)
      for(int j=0; j<size; ++j)
        matrix[i][j] = input.charAt(i*size + j);
    rotate_matrix_180(matrix);
    System.out.print(unspiral_matrix(matrix));
  }
}
