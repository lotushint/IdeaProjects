package com.lotushint;

import java.util.Scanner;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/1 14:53
 * @package com.lotushint
 * @description 棋盘覆盖
 * 特殊点在矩阵的值为 0
 * 相同数字形成的 L 型骨牌，数字表示第几次覆盖
 */
public class ChessboardCoverage {
    public static void main(String[] args) {
        /**
         * 矩阵的阶数
         */
        int n;
        /**
         * 特殊点的行下标
         */
        int sRowIndex;
        /**
         * 特殊点的列下标
         */
        int sColumnIndex;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入矩阵的阶数：");
        n = scanner.nextInt();
        System.out.println("请输入特殊点的行、列下标（空格隔开）：");
        sRowIndex = scanner.nextInt();
        sColumnIndex = scanner.nextInt();
        ChessboardCoverageHandler chessboardCoverageHandler = ChessboardCoverageHandler.getInstance(n);
        chessboardCoverageHandler.printChessboard(sRowIndex, sColumnIndex, n);
    }
}

/**
 * 棋盘覆盖处理类
 */
class ChessboardCoverageHandler {
    private static ChessboardCoverageHandler instance;
    /**
     * n x n棋盘
     */
    private int[][] chessboard;
    /**
     * L形编号
     */
    int number = 1;

    /**
     * 初始化一个棋盘
     *
     * @param n n行 n列
     */
    private ChessboardCoverageHandler(int n) {
        chessboard = new int[n][n];
    }

    /**
     * 静态单实例
     *
     * @param n
     * @return
     */
    public static ChessboardCoverageHandler getInstance(int n) {
        instance = new ChessboardCoverageHandler(n);
        return instance;
    }

    /**
     * 实现棋盘覆盖
     *
     * @param sRowIndex       特殊点的行下标
     * @param sColumnIndex    特殊点的列下标
     * @param leftRowIndex    矩阵的左边起点行下标
     * @param leftColumnIndex 矩阵左边起点的列下标
     * @param size            矩阵的阶数
     */
    public void coverage(int sRowIndex, int sColumnIndex, int leftRowIndex, int leftColumnIndex, int size) {
        if (size == 1) {
            return;
        }

        int subSize = size / 2;
        int n = number++;

        /*
        特殊点在左上角
         */
        if (sRowIndex < leftRowIndex + subSize && sColumnIndex < leftColumnIndex + subSize) {
            coverage(sRowIndex, sColumnIndex, leftRowIndex, leftColumnIndex, subSize);
        } else {
            /*
            不在左上角，假设第二象限矩阵的右下角就是特殊点
             */
            chessboard[leftRowIndex + subSize - 1][leftColumnIndex + subSize - 1] = n;
            coverage(leftRowIndex + subSize - 1, leftColumnIndex + subSize - 1, leftRowIndex, leftColumnIndex, subSize);
        }

        /*
        特殊点在右上角
         */
        if (sRowIndex < leftRowIndex + subSize && sColumnIndex >= leftColumnIndex + subSize) {
            coverage(sRowIndex, sColumnIndex, leftRowIndex, leftColumnIndex + subSize, subSize);
        } else {
            /*
            不在右上角，假设第一象限矩阵的左下角就是特殊点
             */
            chessboard[leftRowIndex + subSize - 1][leftColumnIndex + subSize] = n;
            coverage(leftRowIndex + subSize - 1, leftColumnIndex + subSize, leftRowIndex, leftColumnIndex + subSize, subSize);
        }

        /*
        特殊点在左下角
         */
        if (sRowIndex >= leftRowIndex + subSize && sColumnIndex < leftColumnIndex + subSize) {
            coverage(sRowIndex, sColumnIndex, leftRowIndex + subSize, leftColumnIndex, subSize);
        } else {
            /*
            不在左下角，假设第三象限矩阵的右上角就是特殊点
             */
            chessboard[leftRowIndex + subSize][leftColumnIndex + subSize - 1] = n;
            coverage(leftRowIndex + subSize, leftColumnIndex + subSize - 1, leftRowIndex + subSize, leftColumnIndex, subSize);
        }

        /*
        特殊点在右下角
         */
        if (sRowIndex >= leftRowIndex + subSize && sColumnIndex >= leftColumnIndex + subSize) {
            coverage(sRowIndex, sColumnIndex, leftRowIndex + subSize, leftColumnIndex + subSize, subSize);
        } else {
            /*
            不在右下角，假设第四象限矩阵的左上角就是特殊点
             */
            chessboard[leftRowIndex + subSize][leftColumnIndex + subSize] = n;
            coverage(leftRowIndex + subSize, leftColumnIndex + subSize, leftRowIndex + subSize, leftColumnIndex + subSize, subSize);
        }
    }


    /**
     * 打印覆盖的棋盘
     *
     * @param sRowIndex    特殊点行下标
     * @param sColumnIndex 特殊点列下标
     * @param n            棋盘的阶数
     */
    public void printChessboard(int sRowIndex, int sColumnIndex, int n) {
        coverage(sRowIndex, sColumnIndex, 0, 0, n);
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard.length; j++) {
                System.out.print(chessboard[i][j] + "  ");
            }
            System.out.println();
        }
    }
}