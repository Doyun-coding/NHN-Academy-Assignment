import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 김도윤_Maze {
    static BufferedWriter bw;
    static Queue<Node> queue;
    static boolean[][] visited;
    static int cnt = 0;
    static boolean check = false;
    static int[][] maze = {
        {0,0,1,0,0,1,1,0,1,0},
        {1,0,0,0,1,1,1,1,0,1},
        {0,1,1,0,0,0,1,0,0,0},
        {1,0,0,0,0,0,1,0,0,1},
        {0,0,1,0,1,0,1,1,0,0},
        {0,0,1,0,0,0,0,0,1,0},
        {1,0,0,0,1,1,0,1,0,1},
        {1,1,1,0,0,0,0,0,0,0},
        {1,0,0,0,0,0,1,0,0,1},
        {0,0,1,0,0,0,1,1,0,0}
    };

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static void BFS(int a, int b) {
        queue.add(new Node(a, b));
        while(!queue.isEmpty()) {
            Node curNode = queue.remove();
            int x = curNode.getX();
            int y = curNode.getY();

            if(!visited[x][y] && maze[x][y] == 0) {
                visited[x][y] = true;
                cnt++;

                if(x == 9 && y == 9) {
                    check = true;
                    return;
                }
                
                for(int i = 0; i < 4; i++) {
                    if(x+dx[i] >= 0 && x+dx[i] < 10 && y+dy[i] >= 0 && y+dy[i] < 10) {
                        if(!visited[x+dx[i]][y+dy[i]] && maze[x+dx[i]][y+dy[i]] == 0) {
                            queue.add(new Node(x+dx[i], y+dy[i]));
                        }
                    }
                }
            }
        }
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() {
            return this.x;
        }
        int getY() {
            return this.y;
        }
    }

    public static void main(String[] args) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        queue = new LinkedList<>();
        visited = new boolean[10][10];

        BFS(0, 0);

        if(check) {
            bw.write("Pass, " + cnt + "\n");
        }
        else {
            bw.write("Fail, " + cnt + "\n");
        }

        bw.flush();
        bw.close();
    }
}