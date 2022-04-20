package com.example.hexad.controller;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.test.context.ActiveProfiles;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.*;

/*
https://conwaylife.com/wiki/Conway%27s_Game_of_Life

At each step in time, the following transitions occur:
1. Any live cell with fewer than two live neighbours dies, as if by underpopulation.
2. Any live cell with more than three live neighbours dies, as if by overpopulation.
3. Any live cell with two or three live neighbours lives, unchanged, to the next generation.
4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

Let use Game Field: 80 x 24
 */

@TestInstance(PER_CLASS)
@ActiveProfiles("test")

class LifeTest {
    public static final int ROW = 80;
    public static final int COL = 24;
    private int[][] lifeArray = new int[ROW][COL];

    private Life life;
    @BeforeEach
    public void init() {
        life = new Life();

        for(int i=0; i<ROW;i++){
            for(int j=0; j<COL;j++){
                lifeArray[i][j] =0;
            }
        }
    }

    @Test
    void addNumTest() {

     int result=   life.addNum(4,5);
     Assertions.assertNotNull(result);
        Assertions.assertEquals(9,result);
    }

/*
00000
01000
0000
*/
    @Test
    void caseOne() {
        lifeArray[1][1] = 1;
        life.step(lifeArray);
        Assertions.assertEquals(0, lifeArray[1][1]);
    }

/*
01100
01100
01000
00000
 */
    @Test
    void caseTwo(){
        lifeArray[1][1] = 1;
        lifeArray[0][1] =1;
        lifeArray[0][2] =1;
        lifeArray[1][2] =1;
        lifeArray[2][1] =1;
        life.step(lifeArray);
        Assertions.assertEquals(0,lifeArray[1][1]);
    }

/*
01100
0X100
00000
*/
    @Test
    void caseFour(){
        lifeArray[1][1] = 0;
        lifeArray[0][1] =1;
        lifeArray[0][2] =1;
        lifeArray[1][2] =1;
        life.step(lifeArray);
        Assertions.assertEquals(1,lifeArray[1][1]);
    }

    @Test
    void printResults() {
        life.print(lifeArray);
    }
}