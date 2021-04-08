package MATRIX.将矩阵进行S型打印;

public class SstyleMatrix {
    //算法思想
    /*
    * 设置两个指针，A首先指向的是[0][0]位置的元素，然后B首先指向的是[0][0]位置的元素
    * A元素只能够向右移动，当移动不了了之后才能向下移动，然后B元素只能够向下进行移动，
    * 当移动不了了之后才能够向右进行移动，这样就能够画出一条一条的线。
    * */
    public static void printMatrixZigZag(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = 0;
        int dC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = false;
        // 当A指针的行号来到最后一行就说明
        // 已经到达了最右侧并且从最右侧到达了最下侧，这样就说明结束打印。
        while (tR != endR + 1) {
            printLevel(matrix, tR, tC, dR, dC, fromUp);
            tR = tC == endC ? tR + 1 : tR;//列数来到最后一列，我再进行我行号的变化
            tC = tC == endC ? tC : tC + 1;//当列数来到最后一列之后就不再变化否则进行列的递增
            dC = dR == endR ? dC + 1 : dC;//当列数没到最后一行的时候不变，当抵达最后一行后进行递增
            dR = dR == endR ? dR : dR + 1;//当行数没到最后一行的时候进行递增。行数到达最后一行之后保持不变
            fromUp = !fromUp;//进行斜向右上角和斜向左下角进行打印的切换。
        }
    }

    public static void printLevel(int[][] m, int tR, int tC, int dR, int dC,
                                  boolean f) {
        if (f) {
            while (tR != dR + 1) {
                System.out.print(m[tR++][tC--] + " ");
            }
        } else {
            while (dR != tR - 1) {
                System.out.print(m[dR--][dC++] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        printMatrixZigZag(matrix);

    }

}
