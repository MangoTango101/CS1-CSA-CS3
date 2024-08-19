import java.util.Collections;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;

/**
 * A simple predator-prey simulator, based on a field containing rabbits and foxes.
 */
public class Simulator
{
	/* Constants representing configuration information for the simulation. */

	private static final int    DEFAULT_HEIGHT = 200; //size of field by default
	private static final int    DEFAULT_WIDTH  = 200;
	private static final double FOX_CREATION_PROBABILITY = 0.02;
	private static final double RABBIT_CREATION_PROBABILITY = 0.08;    

	/* Instance variables */

	private Field field;
	private int   step;
	
	private SimulatorView view; //graphical view of the Simulator, don't mess with this

	/**
	 * Construct a simulation field with default size.
	 */

	public Simulator()
	{
		this(DEFAULT_HEIGHT, DEFAULT_WIDTH);
	}

	/**
	 * Create a simulation field with the given size.
	 * @param height Depth of the field. Must be greater than zero.
	 * @param width Width of the field. Must be greater than zero.
	 */
	public Simulator(int height, int width)
	{
		field = new Field(height, width);
		
		// Create a view of the state of each location in the field, don't mess with this
		view = new SimulatorView(height, width);
		view.setColor(Rabbit.class, Color.orange);
		view.setColor(Fox.class, Color.blue);
		view.setColor(ZombieRabbit.class, Color.green);

		// Set up a valid starting point, don't mess with this
		reset();
	}

	/**
	 * Run the simulation from its current state for a reasonably long period,
	 * e.g. 500 steps.
	 */
	public void runLongSimulation()
	{
		simulate(500);
	}

	/**
	 * Run the simulation from its current state for the given number of steps.
	 * Stop before the given number of steps if it ceases to be viable.
	 * @param numSteps The number of steps to run for.
	 */
	public void simulate(int numSteps)
	{
		for (int step = 1; step <= numSteps && view.isViable(field); step++) {
			simulateOneStep();
		}
	}
	
	/**
	 * Run the simulation from its current state for a single step.
	 * Iterate over the whole field updating the state of each
	 * fox and rabbit.
	 */
	public void simulateOneStep()
	{
		try { Thread.sleep(100); } catch (Exception e) {} // Slow it down a bit, don't remove

		step ++;

		List<List<Object>> map = new ArrayList<>();
		List<Object> a;

		for(int i = 0; i < field.getHeight(); i++)
		{
			a = new ArrayList<>();
			for(int j = 0; j < field.getWidth(); j++)
			{
				a.add(field.getObjectAt(i, j));
			}
			map.add(a);
		}

		Collections.shuffle(map);

		for(List<Object> l : map)
		{
			for(Object o : l)
			{
				Object animal = o;
				if(animal instanceof Rabbit)
				{
					((Rabbit)animal).act();
				}
				if(animal instanceof Fox)
				{
					((Fox)animal).act();
				}
				if(animal instanceof ZombieRabbit)
				{
					((ZombieRabbit)animal).act();
				}
			}
		}

		/*
		for(int r = 0; r < field.getHeight(); r++)
		{
			for(int c = 0; c < field.getWidth(); c++)
			{
				Object animal = field.getObjectAt(r, c);
				if(animal instanceof Rabbit)
				{
					((Rabbit)animal).act();
				}
				if(animal instanceof Fox)
				{
					((Fox)animal).act();
				}
				if(animal instanceof ZombieRabbit)
				{
					((ZombieRabbit)animal).act();
				}
			}
		}
		*/
		view.showStatus(step, field); // Display the new field on screen, don't remove
	}

	/**
	 * Reset the simulation to a starting position.
	 */
	public void reset()
	{
		step = 0;
		
		field.clear();
		
		this.populate();

		// Show the starting state in the view
		view.showStatus(step, field);
	}

	/**
	 * Populate a field with foxes and rabbits.
	 */
	private void populate()
	{
		Random rand = new Random();
		field.clear();


		for(int r = 0; r < field.getHeight(); r++)
		{
			for(int c = 0; c < field.getWidth(); c++)
			{
				if(rand.nextDouble() <= FOX_CREATION_PROBABILITY)
				{
					Fox f = new Fox(field, new Location(r, c));
					field.place(f, r, c);
				}

				if(rand.nextDouble() <= RABBIT_CREATION_PROBABILITY)
				{
					Rabbit rab = new Rabbit(field, new Location(r, c));
					field.place(rab, r, c);
				}
			}
		}

	}
}
