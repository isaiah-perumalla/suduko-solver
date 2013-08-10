import java.io.IOException;
import java.io.PrintStream;
import java.util.BitSet;

public class SudukoPuzzle {

    private int[][] grid;

    public SudukoPuzzle(int[][] grid) {
        if(grid.length != 9 || grid[0].length != 9)
            throw new IllegalArgumentException("not a valid suduko grid");
        this.grid = grid;
    }

    public  boolean solve() {

        return solvePuzzle(0,0);
    }

    private  boolean solvePuzzle( int x,int y){
        if(x == 9) {
            x=0;
            y+= 1;
        }
        if( y ==9) return true;
        if(grid[x][y] != 0)
            return solvePuzzle( x+1, y) ;
        else
        {
            BitSet restrictedEntries = getRestrictedEntries(x, y);
            boolean solved = false;
            for(int entry=1; entry<10; entry++) {
                if(restrictedEntries.get(entry)) continue;
                grid[x][y] = entry;
                solved = solvePuzzle( x+1,y);
                if(!solved) {
                    grid[x][y] = 0;
                }
                else { break;}
            }
            return solved;
        }
    }


    public  BitSet getRestrictedEntries(int x, int y) {
        BitSet peers = new BitSet(10);
        for(int i=0; i<9; i++) {
            if(i != y && grid[x][i] != 0)
                peers.set(grid[x][i]);
        }

        for(int i=0; i<9; i++) {
            if(i !=x && grid[i][y] != 0)
                peers.set( grid[i][y]);
        }

        int xStart = getStartofSqr(x);
        int yStart = getStartofSqr(y);
        for(int i=xStart ; i<3+xStart; i++) {
            for(int j=yStart; j<3+yStart; j++) {
                if(i != x && j != y)
                    peers.set( grid[i][j]);
            }
        }
        return peers;
    }

    private static int getStartofSqr(int x) {
        if(x<3) return 0;
        if(x<6) return 3;
        return 6;
    }

    public  String asString() {

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<grid.length; i++)   {
            for(int j=0; j<grid[0].length; j++) {
                if(j==3 || j==6) sb.append("|");
                sb.append(grid[i][j]).append(" ");
            }
            sb.append(System.lineSeparator());
            if(i==2 || i==5) {
                for(int j=0; j<10; j++){
                    sb.append("- ");
                }
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public void displayOn(Appendable appendable) throws IOException {

        for(int i=0; i<grid.length; i++)   {
            for(int j=0; j<grid[0].length; j++) {
                if(j==3 || j==6) appendable.append("|");
                appendable.append(Integer.toString(grid[i][j])).append(" ");
            }
            appendable.append(System.lineSeparator());
            if(i==2 || i==5) {
                for(int j=0; j<10; j++){
                    appendable.append("- ");
                }
                appendable.append(System.lineSeparator());
            }
        }

    }

    }
