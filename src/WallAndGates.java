public class Solution {
    public static class Pair {
        public int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void wallsAndGates(int[][] rooms) {
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0) {
                    Queue<Pair> q = new LinkedList<>();
                    q.add(new Pair(i, j));
                    bfs(q, rooms);
                }
            }
        }
    }
    
    private void bfs(Queue<Pair> q, int[][] rooms) {
        int[][] dir = {{-1,0}, {1,0}, {0, 1}, {0,-1}};
        while(!q.isEmpty()) {
            Pair tmp = q.poll();
            for(int[] d : dir) {
                int nx = tmp.x + d[0], ny = tmp.y + d[1];
                if(nx >= 0 && nx < rooms.length && ny >= 0 && ny < rooms[0].length) {
                    if(rooms[tmp.x][tmp.y] + 1 < rooms[nx][ny]) {
                        rooms[nx][ny] = rooms[tmp.x][tmp.y] + 1;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }
    }
}
