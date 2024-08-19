import java.util.*;

/**
 * ArrayPlotter.java  10/18/14
 *
 * @author - Robert Glen Martin
 * @author - School for the Talented and Gifted
 * @author - Dallas ISD
 * <p>
 * The ArrayPlotter class provides methods for drawing in
 * a grid by setting the boolean values of a 2D array.
 * <p>
 * Each drawing method must
 * - take zero arguments,
 * - have a void return type, and
 * - have a name that conforms to the on...ButtonClick format.
 * (This restriction allows the GridPlotterGUI to recognize methods,
 * for which it automatically generates buttons.)
 * <p>
 * License Information:
 * This class is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 * <p>
 * This class is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

public class ArrayPlotter {
    /**
     * The Array Plotter Graphical User Interface.
     */
    private final ArrayPlotterGUI gui;

    /**
     * The Color Array.  The element values indicate how to color a grid cell:
     * - true: Color the cell with the Drawing Color.
     * - false: Color the cell with the Background Color.
     */
    private boolean[][] filledArray;

    /**
     * Constructs an Array Plotter
     */
    public ArrayPlotter() {
        gui = new ArrayPlotterGUI(this);
        filledArray = null;
    }

    /**
     * Initialize this's Color Array to a new 2D array of boolean values
     * with the given dimensions.
     *
     * @param rows the number of rows in the new array.
     * @param cols the number of columns in the new array.
     *             Postcondition: All of the Color Array's elements have the value false.
     */
    public void initializeFilledArray(int rows, int cols)
    {
        filledArray = new boolean[rows][cols];
    }

    // Drawing Methods

    /**
     * Removes all objects from the grid.
     */
    public void clearGrid()
    {
        filledArray = new boolean[filledArray.length][filledArray[0].length];
        gui.update(filledArray);
    }

    /**
     * This button calls the method above, which clears the grid.
     */
    public void onClearGridButtonClick() 
    {
        clearGrid();
    }

    /** NOTE FROM MR. MCCOY ON HOW THIS THING WORKS. -------------------------------------------------------
     *
     * Complete the methods below using for loops to fill the matrix in a specific orders/patterns.
     *
     * Your instance variable is a 2-dimensional boolean array called filledArray.
     * To make a cell appear as filled, you have to set it as true and then tell the gui to update.
     *
     * Example:         filledArray[3][7] = true;
     *                  gui.update(filledArray);
     *
     * To ensure that you are coding wisely, this should be done efficiently using for loops.
     * Therefore, I am limiting the number of times you are allowed to inclde the gui.update()
     * command in each method.  See the method description for limit.
     *
     * You can add your own methods also!  Buttons will be created automatically, as long as you follow
     * the correct naming convention.  The authors of this lab built that feature into the GUI!
     *
     *-----------------------------------------------------------------------------------------------------*/

    /** Fills in all the cells of the grid using a row-major traversal. */
    /******** MAXIMUM NUMBER OF gui.update(filledArray) STATEMENTS: 1  ******/
    public void onRowMajorFillButtonClick()
    {
        try 
        {
            clearGrid();
            for(int column = 0; column < filledArray.length; column ++)
            {
                for(int row = 0; row < filledArray[column].length; row ++)
                {
                    filledArray[column][row] = true;
                    gui.update(filledArray);
                }
            }
        } catch (Exception e)
        {
            System.out.println("Error! " + e + "\n");
            clearGrid();
        }
    }

    /** Fills in all the cells of the grid using a column-major traversal. */
    /******** MAXIMUM NUMBER OF gui.update(filledArray) STATEMENTS: 1  ******/
    public void onColMajorFillButtonClick() 
    {
        try {
            clearGrid();
            for(int row = 0; row < filledArray.length; row ++)
            {
                for(int column = 0; column < filledArray[row].length; column ++)
                {
                    filledArray[column][row] = true;
                    gui.update(filledArray);
                }
            }
        } catch (Exception e)
        {
            System.out.println("Error! " + e + "\n");
            clearGrid();
        }
    }

    /** Fills in all the cells of the grid bottom-up, going left-to-right across each row.  */
    /******** MAXIMUM NUMBER OF gui.update(filledArray) STATEMENTS: 1  ******/
    public void onReverseRowMajorFillButtonClick() {
        try {
            clearGrid();
            for (int r = filledArray.length - 1; r >= 0; r--) 
            {
                for (int c = filledArray.length - 1; c >= 0; c--) 
                {
                    filledArray[r][c] = true;
                    gui.update(filledArray);
                }
            }
        } catch (Exception e) 
        {
            System.out.println("Error! " + e + "\n");
            clearGrid();
        }
    }

    /** Fills in all the cells of the grid right-to-left, going up each column from the bottom. */
    /******** MAXIMUM NUMBER OF gui.update(filledArray) STATEMENTS: 1  ******/
    public void onReverseColMajorFillButtonClick() 
    {
        try 
        {
            clearGrid();
            for (int c = filledArray.length - 1; c >= 0; c--) 
            {
                for (int r = filledArray.length - 1; r >= 0; r--) 
                {
                    filledArray[r][c] = true;
                    gui.update(filledArray);
                }
            }
        } catch (Exception e) 
        {
            System.out.println("Error! " + e + "\n");
            clearGrid();
        }
    }

    /** Fills in the cells creating a diagonal from the upper-left corner down and to the right. */
    /******** MAXIMUM NUMBER OF gui.update(filledArray) STATEMENTS: 1  ******/
    public void onMainDiagonalLineButtonClick() 
    {
        try 
        {
            clearGrid();
            for (int r = 0; r < filledArray.length; r++)
            {
                for (int c = r; c <= r; c++) 
                {
                    filledArray[r][c] = true;
                    gui.update(filledArray);
                }
            }
        } catch (Exception e) 
        {
            System.out.println("Something went wrong! " + e + "\n");
            clearGrid();
        }
    }

    /** Fills in the cells of the grid on and below the main diagonal. */
    /******** MAXIMUM NUMBER OF gui.update(filledArray) STATEMENTS: 1  ******/
    public void onMainTriangleFillButtonClick() {
        try {
            clearGrid();
            for (int r = 0; r < filledArray.length; r++) {
                for (int c = 0; c <= r; c++) {


                    filledArray[r][c] = true;
                    gui.update(filledArray);
                }
            }
        } catch (Exception e) 
        {
            System.out.println("Something went wrong! " + e + "\n");
            clearGrid();
        }
    }

    /** Fills in the cells creating a diagonal from the upper-right corner down and to the left. */
    /******** MAXIMUM NUMBER OF gui.update(filledArray) STATEMENTS: 1  ******/
    public void onOtherDiagonalLineButtonClick() 
    {
        try
        {
            clearGrid();
            for (int r = 0; r < filledArray.length; r++) 
            {
                filledArray[r][filledArray.length - 1 - r] = true;
                gui.update(filledArray);
            }
        } catch (Exception e) 
        {
            System.out.println("Error! " + e + "\n");
            clearGrid();
        }
    }

    /** Fills in the cells of the grid on and below the other diagonal. */
    /******** MAXIMUM NUMBER OF gui.update(filledArray) STATEMENTS: 1  ******/
    public void onOtherTriangleFillButtonClick() 
    {
        try 
        {
            clearGrid();
            for (int r = 0; r < filledArray.length; r++) 
            {
                for (int c = 0; c <= r; c++)
                {
                    filledArray[r][filledArray.length - 1 - c] = true;
                    gui.update(filledArray);
                }
            }
        } catch (Exception e)
        {
            System.out.println("Error! " + e + "\n");
            clearGrid();
        }
    }

    /** Fills in the cells of the grid on the two diagonals */
    /******** MAXIMUM NUMBER OF gui.update(filledArray) STATEMENTS: 2  ******/
    public void onBothDiagonalsButtonClick() {
        try 
        {
            clearGrid();
            for (int r = 0; r < filledArray.length; r++) 
            {
                for (int c = r; c <= r; c++)
                {
                    filledArray[r][c] = true;
                    gui.update(filledArray);
                }
            }
            for (int r = 0; r < filledArray.length; r++) 
            {
                filledArray[r][filledArray.length - 1 - r] = true;
                gui.update(filledArray);
            }
        } catch (Exception e) 
        {
            System.out.println("Something went wrong! " + e + "\n");
            clearGrid();
        }
    }

    /** Fills in the cells of the grid in a serpentine fashion from the top left corner*/
    /******** MAXIMUM NUMBER OF gui.update(filledArray) STATEMENTS: 2  ******/
    public void onSerpentineFillButtonClick() {
        try {
            clearGrid();
            for (int r = 0; r < filledArray.length; r++) {
                if (r % 2 == 0) {
                    for (int c = 0; c < filledArray[r].length; c++) {
                        filledArray[r][c] = true;
                        gui.update(filledArray);
                    }
                } else {
                    for (int c = filledArray[r].length - 1; c > -1; c--) {
                        filledArray[r][c] = true;
                        gui.update(filledArray);
                    }
                }
            }


        } catch (Exception e) {
            System.out.println("Something went wrong! " + e + "\n");
            clearGrid();
        }
    }
    /** Fills in the cells of the grid along the outside border starting in the upper left corner and going clockwise. */
    /******** MAXIMUM NUMBER OF gui.update(filledArray) STATEMENTS: 4  ******/
    public void onBorderLinesButtonClick() {
        try {
            clearGrid();
            for (int c = 0; c < filledArray.length; c++)
            {
                filledArray[0][c] = true;
                gui.update(filledArray);
            }
            for (int r = 0; r < filledArray.length;r++)
            {
                filledArray[r][filledArray.length-1] = true;
                gui.update(filledArray);
            }
            for (int c = filledArray.length-1; c >= 0; c--)
            {
                filledArray[filledArray.length-1][c] = true;
                gui.update(filledArray);
            }
            for (int r = filledArray.length-1; r >= 0;r--)
            {
                filledArray[r][0] = true;
                gui.update(filledArray);
            }

        } catch (Exception e) 
        {
            System.out.println("Something went wrong! " + e + "\n");
            clearGrid();
        }
    }

    /** Fills in the cells of the grid in a spiral toward center, starting in the upper left corner and going clockwise. */
    /******** MAXIMUM NUMBER OF gui.update(filledArray) STATEMENTS: 4  ******/
    public void onSpiralFillButtonClick() {
        try {
            clearGrid();
            int counter = filledArray.length;
            int counter2 = 0;
            for(int i = 0; i < filledArray.length; i++){
                for(int c = counter2; c < counter; c ++){
                    filledArray[counter2][c] = true;
                    gui.update(filledArray);
                }
                for(int r = counter2; r < counter; r ++){
                    filledArray[r][counter - 1] = true;
                    gui.update(filledArray);
                }
                for(int c = counter - 1; c >= counter2; c --){
                    filledArray[counter - 1][c] = true;
                    gui.update(filledArray);
                }
                for(int r = counter - 1; r >= 0; r --){
                    filledArray[r][counter2] = true;
                    gui.update(filledArray);
                }
                counter --;
                counter2++;
            }

        } catch (Exception e) {
            System.out.println("Something went wrong! " + e + "\n");
            clearGrid();
        }
    }

    /** Fills from top left to bottom right using upward diagonal lines */
    /******** MAXIMUM NUMBER OF gui.update(filledArray) STATEMENTS: 2  ******/
    public void onDiagonalFillButtonClick() {
        try {
            clearGrid();  //We should always start with a clean grid.
            //Your solution should be here in the try block.
            for(int i = 0; i < filledArray.length; i++) {
                int r = i, c = 0;
                while(c <= i) {
                    filledArray[r][c] = true;
                    gui.update(filledArray);
                    r--;
                    c++;
                }
            }
            int counter = 1;
            int counter2 = 0;
            for(int x = 1; x < filledArray.length; x++) {
                int r = filledArray.length-1, c = counter;
                while(c < filledArray.length && r > counter2) {
                    //System.out.println("A: " + a + " || I: " + i + " || X: " + x);
                    filledArray[r][c] = true;
                    gui.update(filledArray);
                    r--;
                    c++;
                }
                counter++;
            }

        } catch (Exception e) {
            System.out.println("Something went wrong! " + e + "\n");
            clearGrid();  //
        }
    }

    /** Fills in the cells of the grid in a spiral toward center, starting in the upper left corner and going clockwise. */
    /******** MAXIMUM NUMBER OF gui.update(filledArray) STATEMENTS: 1  ******/
    public void onRandomFillButtonClick() {
        try {
            clearGrid();  //We should always start with a clean grid.
            //Your solution should be here in the try block.
            for(int x = 0; x < filledArray.length; x++) {
                for (int i = 0; i < filledArray.length; i++) {
                    int c = (int) (Math.random() * filledArray.length);
                    int r = (int) (Math.random() * filledArray.length);
                    while(filledArray[r][c]){
                        c = (int) (Math.random() * filledArray.length);
                        r = (int) (Math.random() * filledArray.length);
                    }
                    filledArray[r][c] = true;
                    gui.update(filledArray);
                }
            }

        } catch (Exception e) {
            System.out.println("Something went wrong! " + e + "\n");
            clearGrid();  //
        }
    }

    /**
     * main method that creates the grid plotter application.
     */
    public static void main(String[] args) {
        new ArrayPlotter();
    }
}
