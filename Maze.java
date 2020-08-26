/**
 * Maze
 */
public class Maze {
    private int start;
    private int goal;
    private int maze[] = new int[25];

    public void setStart(int start) {
        this.start = start;
        this.maze[this.start] = 1;
    }

    public void setGoal(int goal) {
        this.goal = goal;
        this.maze[this.goal] = 2;
    }

    public int getStart() {
        return start;
    }

    public int getGoal() {
        return goal;
    }

    public void setObstacles(int obstacle) {
        this.maze[obstacle] = -1;
    }

    public void displayMaze() {
        System.out.println("Maze:");
        for (int i = 0; i < maze.length; i++) {
            if ((i + 1) % 5 == 0 && i > 0)
                System.out.println("  " + this.maze[i]);
            else
                System.out.print("  " + this.maze[i]);
        }
    }

    public void findPath() {
        Queue q = new Queue();
        int Q = -1, origin = start;

        try {
            while (origin != goal) {
                if (origin >= 5 && maze[origin - 5] != -1 && !q.contains(origin - 5)) {
                    Q = origin - 5;
                    q.enque(Q, origin);
                }
                if (origin < 20 && maze[origin + 5] != -1 && !q.contains(origin + 5)) {
                    Q = origin + 5;
                    q.enque(Q, origin);
                }
                if (origin % 5 != 0 && maze[origin - 1] != -1 && !q.contains(origin - 1)) {
                    Q = origin - 1;
                    q.enque(Q, origin);
                }
                if ((origin + 1) % 5 != 0 && maze[origin + 1] != -1 && !q.contains(origin + 1)) {
                    Q = origin + 1;
                    q.enque(Q, origin);
                }
                origin = q.next(origin);
            }
            q.displayQueue();
            q.displayPath(start, goal);
        } catch (Exception e) {
            System.out.println("Can't find path, might be trapped");
        }
    }
}