import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Field
{    
	private int height, width;
	private Object[][] field;

	/**
	 * Represent a field of the given dimensions.
	 * @param height The height of the field.
	 * @param width The width of the field.
	 */
	public Field(int height, int width)
	{
		this.width = width;
		this.height = height;

		field = new Object[height][width];
	}

	/** Empty the field */
	public void clear()
	{
		for(int i = 0; i < field.length; i++)
		{
			for(int j = 0; j < field[i].length; j++)
			{
				field[i][j] = null;
			}
		}
	}

	/**
	 * Place an animal at the given location.
	 * If there is already an animal at the location it will
	 * be lost.
	 * @param animal The animal to be placed.
	 * @param row Row coordinate of the location.
	 * @param col Column coordinate of the location.
	 */
	public void place(Object animal, int row, int col)
	{
		field[row][col] = animal;
	}

	/**
	 * Place an animal at the given location.
	 * If there is already an animal at the location it will
	 * be lost.
	 * @param animal The animal to be placed.
	 * @param location Where to place the animal.
	 */
	public void place(Object animal, Location location)
	{
		place(animal, location.getRow(), location.getCol());
	}
	
	/**
	 * Move an Object from one location in the field to another
	 * @param oldLocation Object's old location
	 * @param newLocation Object's new location
	 */
	public void move(Location oldLocation, Location newLocation)
	{
		field[newLocation.getRow()][newLocation.getCol()] = field[oldLocation.getRow()][oldLocation.getCol()];
		remove(oldLocation);
	}
	
	/**
	 * Remove an Object from a particular location
	 * @param location
	 */
	public void remove(Location location)
	{
		field[location.getRow()][location.getCol()] = null;
	}
	
	/**
	 * Return the animal at the given location, if any.
	 * @param location Where in the field.
	 * @return The animal at the given location, or null if there is none.
	 */
	public Object getObjectAt(Location location)
	{
		return getObjectAt(location.getRow(), location.getCol());
	}

	/**
	 * Return the animal at the given location, if any.
	 * @param row The desired row.
	 * @param col The desired column.
	 * @return The animal at the given location, or null if there is none.
	 */
	public Object getObjectAt(int row, int col)
	{
		return field[row][col];
	}

	/**
	 * Generate a shuffled List of locations adjacent to the given one - will 
	 * not include the location itself. All locations will lie within the grid.
	 * @param location The location from which to generate adjacencies.
	 * @return A randomized list of locations adjacent to that given.
	 */
	public List<Location> adjacentLocations(Location location)
	{
		List<Location> locations = new ArrayList<>();

		int row = location.getRow();
		int col = location.getCol();

		int width = field[0].length;
		int height = field.length;

		for(int i = row - 1; i <= row + 1; i++)
		{
			for(int j = col - 1; j <= col + 1; j++)
			{
				if(i < 0 || i >= height || j < 0 || j >= width || (i == row && j == col))
				{
					continue;
				}

				locations.add(new Location(i, j));
			}
		}

		Collections.shuffle(locations);

		return locations;
	}

	/**
	 * Try to find a free location that is adjacent to the given location. 
	 * If there is none, return null. The returned location will be within 
	 * the valid bounds of the field.
	 * @param location The location from which to generate an adjacency.
	 * @return A valid free location within the grid area, or null if all
	 *         locations around are full.
	 */
	public Location freeAdjacentLocation(Location location)
	{
		List<Location> l = adjacentLocations(location);
		List<Location> ret = new ArrayList<>();

		for(int i = 0; i < l.size(); i++)
		{
			int row = l.get(i).getRow();
			int col = l.get(i).getCol();

			if(field[row][col] == null)
			{
				ret.add(new Location(row, col));
			}
		}

		Collections.shuffle(ret);
		if(ret.size() >= 1)
		{
			return ret.get(0);
		}

		return null;
	}

	@Override
	public String toString() //quick picture of the state of the field, for debugging
	{
		String result = "";
		
		for (int r = 0; r < this.height; r++)
		{
			for (int c = 0; c < this.width; c++)
			{
				Object obj = this.field[r][c];
				
				if (obj instanceof Rabbit)
					result += "R\t";
				else if (obj instanceof Fox)
					result += "F\t";
				else
					result += "x\t";
			}
			result += "\n";
		}
		
		return result;
	}
	
	public int getHeight() { return this.height; }
	
	public int getWidth() { return this.width; }
}
