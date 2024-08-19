import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Path
{
    private Point[] points;
    private double  minX, minY; //min X and Y values, for setting canvas scale
    private double  maxX, maxY; //maxes
    private int numPoints;

    /** construct a path from a given file */
    public Path(String fileName) throws IOException
    {
        //TODO
        Scanner in = new Scanner(new File(fileName));
        numPoints = in.nextInt();
        Point[] pointsDup = new Point[numPoints];
        for (int i = 0; i < pointsDup.length; i++)
        {
            Point p = new Point(in.nextDouble(), in.nextDouble());
            pointsDup[i] = p;
        }
        points = pointsDup;

        double x = pointsDup[0].getX();
        double y = pointsDup[0].getY();
        for (int i = 1; i < pointsDup.length; i++)
        {
            if (x > pointsDup[i].getX())
            {
                x = pointsDup[i].getX();
            }
            if (y > pointsDup[i].getY())
            {
                y = pointsDup[i].getY();
            }
        }
        minX = x;
        minY = y;
        x = pointsDup[0].getX();
        y = pointsDup[0].getY();
        for (int i = 1; i < pointsDup.length; i++)
        {
            if (x < pointsDup[i].getX())
            {
                x = pointsDup[i].getX();
            }
            if (y < pointsDup[i].getY())
            {
                y = pointsDup[i].getY();
            }
        }
        maxX = x;
        maxY = y;
    }

    public double getMinX() {return minX;}

    public double getMinY() {return minY;}

    public double getMaxX() {return maxX;}

    public double getMaxY() {return maxY;}

    public int getNumPoints()
    {
        return numPoints;
    }

    public Point getPoint(int x)
    {
        return points[x];
    }

    /** returns the distance traveled going point to point, in order given in file */
    public double getDistance()
    {
        //TODO
        double distance = 0;
        for (int i = 0; i < points.length-1; i++)
        {
            distance += points[i].getDistance(points[i+1]);
        }
        return distance; //replace
    }

    @Override
    public String toString()
    {
        //TODO
        String x = super.toString() + "\nCanvas Scale: " + minX + ", " + minY + " --> " + maxX + ", " + maxY + "\n";
        String y = "There are " + numPoints + " points.";
        String z = "\nThe total distance is: " + this.getDistance();
        return x+y+z;
    }
}