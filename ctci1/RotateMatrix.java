public class RotateMatrix {
    public void rotateInPlace(int[][] matrix) {
        if(matrix == null) {
            return;
        }
        int n = matrix.length;
        for(int layer = 0 ; layer < n/2; layer++) {
            int first = layer;
            int last = n-1-layer;
            for(int i = first; i < last; i++) {
                int offset = i-first;
                int temp = matrix[first][i-offset];
                matrix[first][i] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[i][last];
                matrix[i][last] = temp;
            }

        }

    }
}
