public class FireModel {
    public static final int SIZE = 47;
    private final FireCell[][] grid;
    private final FireView view;
    public FireModel(FireView view) {
        grid = new FireCell[SIZE][SIZE];
        this.view = view;
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                grid[row][col] = new FireCell();
            }
        }
    }
    private void spread(int row, int col) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE || !grid[row][col].canBurn()) {
            return;
        }
        grid[row][col].setStatus(FireCell.BURNING);
        spread(row - 1, col);
        spread(row + 1, col);
        spread(row, col - 1);
        spread(row, col + 1);
    }
    public void solve() {
        for (int col = 0; col < SIZE; col++) {
            if (grid[SIZE - 1][col].getStatus() == FireCell.GREEN) {
                spread(SIZE - 1, col);
            }
        }
        boolean danger = false;
        for (int col = 0; col < SIZE; col++) {
            if (grid[0][col].getStatus() == FireCell.BURNING) {
                danger = true;
                break;
            }
        }
        if (danger) {
            System.out.println("Onett is in trouble!");
        }
        else {
            System.out.println("Onett is safe.");
        }
        view.updateView(grid);
    }
}
