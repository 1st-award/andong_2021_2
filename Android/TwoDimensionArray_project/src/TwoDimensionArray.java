public class TwoDimensionArray {
    public static void main(String[] args) {
         int [][]two_dimension_array = new int [3][3];
         int count = 0;

         for(int i=0; i<3; ++i) {
             for(int j=0; j<3; ++j) {
                 two_dimension_array[i][j] = 100 + count * 10;
                 count++;
             }
         }

        for(int i=0; i<3; ++i) {
            for(int j=0; j<3; ++j) {
                System.out.printf("two_dimension_array[%d][%d] = %d\n", i, j, two_dimension_array[i][j]);
            }
        }
    }
}
