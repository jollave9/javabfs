
/**
 * TestMaze
 */
import java.util.*;

public class TestMaze {

    public static void main(String[] args) {
        Maze maze1 = new Maze();
        int start, goal, obstacle;
        Scanner input = new Scanner(System.in);

        System.out.println("Assign Start:");
        start = input.nextInt();
        System.out.println("Assign Goal:");
        goal = input.nextInt();

        maze1.setStart(start);
        maze1.setGoal(goal);

        System.out.println("Assign Obstacles:");
        char yesOrNo;
        do {
            obstacle = input.nextInt();
            maze1.setObstacles(obstacle);
            System.out.println("Continue?Y/N");
            yesOrNo = input.next().charAt(0);

        } while (yesOrNo == 'y' || yesOrNo == 'Y');

        try {
            maze1.displayMaze();

        } catch (Exception e) {
            System.out.println("Can't find path, might be trapped");
        }
        maze1.findPath();
    }
}