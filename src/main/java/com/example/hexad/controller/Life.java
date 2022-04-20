package com.example.hexad.controller;

import java.util.Arrays;

public class Life {
    public static final int ROW = 80;
    public static final int COL = 24;
    public static void main(String[] args) {
        System.out.println("Hello World");
        addNum(4,5);
    }
    public static int addNum(int a,int b){
        return a+b;
    }
/*
0000
01000 =
0000
 */
    public void step(int[][] lifeArray) {

for(int i=1; i<ROW-1;i++){
    for(int j=1;j<COL-1;j++){
        int liveNeighborCount = 0;
            if(lifeArray[i][j-1] == 1){
                liveNeighborCount++;
            }
            if(lifeArray[i][j+1] == 1){
                liveNeighborCount++;
            }
            if(lifeArray[i-1][j]==1){
                liveNeighborCount++;
            }
            if(lifeArray[i+1][j]==1){
                liveNeighborCount++;
            }
            if(lifeArray[i-1][j-1]==1){
                liveNeighborCount++;
            }
            if(lifeArray[i+1][j+1]==1){
                liveNeighborCount++;
            }
            if(lifeArray[i-1][j+1]==1){
                liveNeighborCount++;
            }
            if(lifeArray[i+1][j-1]==1){
                liveNeighborCount++;
            }

        if(lifeArray[i][j]==1){
            if(liveNeighborCount < 2){
                lifeArray[i][j]=0;
            }
            if(liveNeighborCount > 3){
                lifeArray[i][j]=0;
            }
        }
        if(lifeArray[i][j] == 0){
            if(liveNeighborCount == 3){
                lifeArray[i][j] =1;
            }
        }

    }
}
    }

    public void print(int[][] lifeArray) {
        for(int i=1; i<ROW-1;i++){
            for(int j=1;j<COL-1;j++){
                System.out.print(lifeArray[i][j]);
            }
            System.out.println();
    }
//        System.out.println(Arrays.deepToString(lifeArray));
    }
}
