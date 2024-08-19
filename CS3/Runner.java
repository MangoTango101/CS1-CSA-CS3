public class Runner
{
    public static void main(String[] args) {
        Maze m = new Maze();
        m.loadMaze("maze-2");
        System.out.println(m);
        System.out.println(m.getNeighbors(m.getSquare(5, 10)));
    }
}
