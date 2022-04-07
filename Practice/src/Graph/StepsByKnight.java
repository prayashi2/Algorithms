package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class StepsByKnight {

    class Cell {
        int x;
        int y;
        int dis;

        Cell(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    public boolean isInside(int x, int y, int N) {
        if(x>=1 && x<=N && y>=1 && y<=N) {
            return true;
        }
        return false;
    }

    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        int dirX[] = {-2,-2,-1,-1,1,1,2,2};
        int dirY[] = {-1,1,-2,2,-2,2,-1,1};
        int x, y;
        Queue<Cell> q = new LinkedList<>();
        int vis[][] = new int[N+1][N+1];
        q.add(new Cell(KnightPos[0], KnightPos[1], 0));
        vis[KnightPos[0]][KnightPos[1]] = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                Cell pop = q.remove();
                if(pop.x == TargetPos[0] && pop.y == TargetPos[1]) {
                    return pop.dis;
                }
                for(int j=0; j<8; j++) {
                    x = pop.x + dirX[j];
                    y = pop.y + dirY[j];
                    if(isInside(x, y, N) && vis[x][y]==0) {
                        q.add(new Cell(x, y, pop.dis+1));
                        vis[x][y] = 1;
                    }
                }

            }
        }
        return -1;
    }
}
