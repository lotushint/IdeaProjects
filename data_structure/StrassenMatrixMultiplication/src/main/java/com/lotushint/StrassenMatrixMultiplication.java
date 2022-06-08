package com.lotushint;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/3/15 20:06
 * @package com.lotushint
 * @description Strassen矩阵乘法（本程序只能计算2^k阶矩阵，其他阶可采用传统的计算方法或增加行列的方式再进行Strassen算法）
 */
public class StrassenMatrixMultiplication {

    public static void main(String[] args) {

        /**
         * n x n的矩阵乘法
         */
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入矩阵的阶数：");
        n = scanner.nextInt();
        int[][] matrixA = inputMatrix(n, n, "A");
        int[][] matrixB = inputMatrix(n, n, "B");

        System.out.println("矩阵A:");
        outputMatrix(matrixA);
        System.out.println("矩阵B:");
        outputMatrix(matrixB);
        System.out.println("C = A x B:\n矩阵C:");
        int[][] C = strassenMatrixMultiplication(matrixA, matrixB);
        outputMatrix(C);
    }

    /**
     * 输出矩阵
     *
     * @param matrix 一个矩阵
     */
    static void outputMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "  ");
                if (j == matrix[0].length - 1) {
                    System.out.println();
                }
            }
        }
    }

    /**
     * 输入矩阵
     *
     * @param m    矩阵行数
     * @param n    矩阵列数
     * @param name 矩阵名
     * @return 一个 m行 n列的矩阵
     */
    static int[][] inputMatrix(int m, int n, String name) {
        int[][] matrix = new int[m][n];
        Scanner scanner = new Scanner(System.in);
        System.out.println("请给" + name + "矩阵输入" + n * n + "个矩阵的元素：");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    /**
     * 将 一个 n x n 的矩阵沿着水平和垂直两条对称轴分成4个子矩阵
     *
     * @param matrix 一个 n x n的矩阵(n >= 2)
     * @return 分成的四个矩阵的列表
     */
    static Map divideMatrix(int[][] matrix) {
        int n = matrix.length;
        /**
         * 保存A11,A12,A21,A22 四个子矩阵
         */
        Map map = new HashMap();
        /**
         * 临时保存子矩阵
         */
        int[][] A11 = new int[n / 2][n / 2];
        int[][] A12 = new int[n / 2][n / 2];
        int[][] A21 = new int[n / 2][n / 2];
        int[][] A22 = new int[n / 2][n / 2];

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                A11[i][j] = matrix[i][j];
                A12[i][j] = matrix[i][j + n / 2];
                A21[i][j] = matrix[i + n / 2][j];
                A22[i][j] = matrix[i + n / 2][j + n / 2];
//                if (i < n / 2 && j < n / 2) {
//                    /*
//                    A11 采用相对位置赋值
//                     */
//                    A11[i][j] = matrix[i][j];
//                } else if (i < n / 2 && j >= n / 2) {
//                     /*
//                    A12
//                     */
//                    A12[i][j] = matrix[i][j + n / 2];
//                } else if (i >= n / 2 && j < n / 2) {
//                     /*
//                    A21
//                     */
//                    A21[i][j] = matrix[i + n / 2][j];
//                } else if (i >= n / 2 && j >= n / 2) {
//                     /*
//                    A22
//                     */
//                    A22[i][j] = matrix[i + n / 2][j + n / 2];
//                }
            }
        }
        map.put("A11", A11);
        map.put("A12", A12);
        map.put("A21", A21);
        map.put("A22", A22);
        return map;
    }

    /**
     * 将四个子矩阵还原成父矩阵
     *
     * @param divideMatrixA11 子矩阵A11
     * @param divideMatrixA12 子矩阵A12
     * @param divideMatrixA21 子矩阵A21
     * @param divideMatrixA22 子矩阵A22
     * @return
     */
    static int[][] restoreMatrix(int[][] divideMatrixA11, int[][] divideMatrixA12, int[][] divideMatrixA21, int[][] divideMatrixA22) {
        int n = divideMatrixA11.length * 2;
        int[][] matrixA = new int[n][n];
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                matrixA[i][j] = divideMatrixA11[i][j];
                matrixA[i][j + n / 2] = divideMatrixA12[i][j];
                matrixA[i + n / 2][j] = divideMatrixA21[i][j];
                matrixA[i + n / 2][j + n / 2] = divideMatrixA22[i][j];
            }
        }
        return matrixA;
    }

    /**
     * Strassen矩阵乘法
     *
     * @param matrixA 矩阵A
     * @param matrixB 矩阵B
     * @return
     */
    static int[][] strassenMatrixMultiplication(int[][] matrixA, int[][] matrixB) {
        /**
         * C = A * B
         */
        int[][] C;
        int[][] C11;
        int[][] C12;
        int[][] C21;
        int[][] C22;

        if (matrixA.length == 1) {
            /*
            1 x 1的矩阵乘法，再用divideMatrix()方法会造成索引越界
             */
            C = new int[][]{{matrixA[0][0] * matrixB[0][0]}};
        }
//        else if (matrixA.length == 2) {
//            /*
//             2 x 2的矩阵乘法，再用divideMatrix()方法会造成索引越界
//             */
//            int M1 = matrixA[0][0] * (matrixB[0][1] - matrixB[1][1]);
//            int M2 = (matrixA[0][0] + matrixA[0][1]) * matrixB[1][1];
//            int M3 = (matrixA[1][0] + matrixA[1][1]) * matrixB[0][0];
//            int M4 = matrixA[1][1] * (matrixB[1][0] - matrixB[0][0]);
//            int M5 = (matrixA[0][0] + matrixA[1][1]) * (matrixB[0][0] + matrixB[1][1]);
//            int M6 = (matrixA[0][1] - matrixA[1][1]) * (matrixB[1][0] + matrixB[1][1]);
//            int M7 = (matrixA[0][0] - matrixA[1][0]) * (matrixB[0][0] + matrixB[0][1]);
//            C = new int[][]{{M5 + M4 - M2 + M6, M1 + M2}, {M3 + M4, M5 + M1 - M3 - M7}};
//        }
        else {
            Map divideMatrixA = divideMatrix(matrixA);
            Map divideMatrixB = divideMatrix(matrixB);
            int[][] A11 = (int[][]) divideMatrixA.get("A11");
            int[][] A12 = (int[][]) divideMatrixA.get("A12");
            int[][] A21 = (int[][]) divideMatrixA.get("A21");
            int[][] A22 = (int[][]) divideMatrixA.get("A22");

            int[][] B11 = (int[][]) divideMatrixB.get("A11");
            int[][] B12 = (int[][]) divideMatrixB.get("A12");
            int[][] B21 = (int[][]) divideMatrixB.get("A21");
            int[][] B22 = (int[][]) divideMatrixB.get("A22");

            int[][] M1 = strassenMatrixMultiplication(A11, AdditionOrSubtractionOfMatrices(B12, B22, '-'));
            int[][] M2 = strassenMatrixMultiplication(AdditionOrSubtractionOfMatrices(A11, A12, '+'), B22);
            int[][] M3 = strassenMatrixMultiplication(AdditionOrSubtractionOfMatrices(A21, A22, '+'), B11);
            int[][] M4 = strassenMatrixMultiplication(A22, AdditionOrSubtractionOfMatrices(B21, B11, '-'));
            int[][] M5 = strassenMatrixMultiplication(AdditionOrSubtractionOfMatrices(A11, A22, '+'), AdditionOrSubtractionOfMatrices(B11, B22, '+'));
            int[][] M6 = strassenMatrixMultiplication(AdditionOrSubtractionOfMatrices(A12, A22, '-'), AdditionOrSubtractionOfMatrices(B21, B22, '+'));
            int[][] M7 = strassenMatrixMultiplication(AdditionOrSubtractionOfMatrices(A11, A21, '-'), AdditionOrSubtractionOfMatrices(B11, B12, '+'));

            C11 = AdditionOrSubtractionOfMatrices(AdditionOrSubtractionOfMatrices(AdditionOrSubtractionOfMatrices(M5, M4, '+'), M2, '-'), M6, '+');
            C12 = AdditionOrSubtractionOfMatrices(M1, M2, '+');
            C21 = AdditionOrSubtractionOfMatrices(M3, M4, '+');
            C22 = AdditionOrSubtractionOfMatrices(AdditionOrSubtractionOfMatrices(AdditionOrSubtractionOfMatrices(M5, M1, '+'), M3, '-'), M7, '-');
            C = restoreMatrix(C11, C12, C21, C22);
        }
        return C;
    }

    /**
     * 矩阵的加减
     *
     * @param matrixA  矩阵A
     * @param matrixB  矩阵B
     * @param addOrSub 加或减：‘+’或‘-’
     * @return 加减后的矩阵
     */
    static int[][] AdditionOrSubtractionOfMatrices(int[][] matrixA, int[][] matrixB, char addOrSub) {
        int[][] matrixC = new int[matrixA.length][matrixA[0].length];
        if (addOrSub == '+') {
            for (int i = 0; i < matrixA.length; i++) {
                for (int j = 0; j < matrixA[0].length; j++) {
                    matrixC[i][j] = matrixA[i][j] + matrixB[i][j];
                }
            }
        } else if (addOrSub == '-') {
            for (int i = 0; i < matrixA.length; i++) {
                for (int j = 0; j < matrixA[0].length; j++) {
                    matrixC[i][j] = matrixA[i][j] - matrixB[i][j];
                }
            }
        }
        return matrixC;
    }
}
