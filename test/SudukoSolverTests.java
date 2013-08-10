import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.BitSet;

public class SudukoSolverTests {

    @Test
    public void testGetPeers() {
        int[][] grid = new int[][]{
                {4,0,0,0,0,0,8,0,5},
                {0,3,0,0,0,0,0,0,0},
                {0,0,0,7,0,0,0,0,0},
                {0,2,0,0,0,0,0,6,0},
                {0,0,0,0,8,0,4,0,0},
                {0,0,0,0,1,0,0,0,0},
                {0,0,0,6,0,3,0,7,0},
                {5,0,0,2,0,0,0,0,0},
                {1,0,4,0,0,0,0,0,0},

        } ;
        SudukoPuzzle sudukoPuzzle = new SudukoPuzzle(grid);
        BitSet peers = sudukoPuzzle.getRestrictedEntries(0, 1);
        System.out.print(peers);

    }



    @Test
    public void testSolver() {
        int[][] grid = new int[][]{
                {4,0,0,0,0,0,8,0,5},
                {0,3,0,0,0,0,0,0,0},
                {0,0,0,7,0,0,0,0,0},
                {0,2,0,0,0,0,0,6,0},
                {0,0,0,0,8,0,4,0,0},
                {0,0,0,0,1,0,0,0,0},
                {0,0,0,6,0,3,0,7,0},
                {5,0,0,2,0,0,0,0,0},
                {1,0,4,0,0,0,0,0,0},

        } ;

        SudukoPuzzle sudukoPuzzle = new SudukoPuzzle(grid);
        sudukoPuzzle.solve();
        try {
            sudukoPuzzle.displayOn(System.out);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Test
    public void testHardPuzzle1() throws IOException {

        int[][] grid = new int[][]{
                {8,5,0,0,0,2,4,0,0},
                {7,2,0,0,0,0,0,0,9},
                {0,0,4,0,0,0,0,0,0},
                {0,0,0,1,0,7,0,0,2},
                {3,0,5,0,0,0,9,0,0},
                {0,4,0,0,0,0,0,0,0},
                {0,0,0,0,8,0,0,7,0},
                {0,1,7,0,0,0,0,0,0},
                {0,0,0,0,3,6,0,4,0},

        } ;


        SudukoPuzzle sudukoPuzzle = new SudukoPuzzle(grid);
        Assert.assertTrue(sudukoPuzzle.solve());
        sudukoPuzzle.displayOn(System.out);

    }

    @Test
    public void testHardPuzzle2() throws IOException {

        int[][] grid = new int[][]{
                {0,0,5,3,0,0,0,0,0},
                {8,0,0,0,0,0,0,2,0},
                {0,7,0,0,1,0,5,0,0},
                {4,0,0,0,0,5,3,0,0},
                {0,1,0,0,7,0,0,0,6},
                {0,0,3,2,0,0,0,8,0},
                {0,6,0,5,0,0,0,0,9},
                {0,0,4,0,0,0,0,3,0},
                {0,0,0,0,0,9,7,0,0},

        } ;


        SudukoPuzzle sudukoPuzzle = new SudukoPuzzle(grid);
        Assert.assertTrue(sudukoPuzzle.solve());
        sudukoPuzzle.displayOn(System.out);

    }
}