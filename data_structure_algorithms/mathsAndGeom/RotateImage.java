package com.vikas.core.leetcode.mathsAndGeom;

public class RotateImage {
    public static void main(String[] args){
        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }

    public void rotate(int[][] matrix) {
        //Take transpose
        for(int i =0;i<matrix.length;i++){
            for(int j=i+1;j<matrix[0].length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //Swap first column with last column
        for(int i =0;i<matrix.length;i++){
            for(int j=0;j<matrix.length/2;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j];
                matrix[i][matrix.length - j] = temp;
            }
        }
    }
}
