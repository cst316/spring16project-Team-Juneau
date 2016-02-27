package net.sf.memoranda.ui;

import java.util.Random;

public class Die
{   
	public static final int DEFAULT_SIDES = 6;
    private static Random rand = new Random();
    private final int numOfSides;
    private int dieResult;

    /**
     * Default constructor, sets the number of sides to 6.
     */
    public Die()
    {   
    	this(DEFAULT_SIDES);
    }

    /**
     * Constructor that also sets the number of sides on the die.
     * @param sides the desired number of sides for this die
     */
    public Die(int sides)
    {   
    	assert sides > 1 : "Violation of precondition: numSides = " + sides + "numSides must be greater than 1";
        numOfSides = sides;
        dieResult = 1;
        assert getResult() == 1 && getNumSides() == sides;
    }

    /**
     * Constructor that sets the number of sides on the die and an initial value.
     * @param numSides is the number of desired die sides
     * @param result initializes a value for the die before the first roll
     */
    public Die(int numSides, int result)
    {   
    	assert numSides > 1 && 1 <= result && result <= numSides : "Illegal construction!";
        numOfSides = numSides;
        dieResult = result;
    }

    /**
     * "Rolls" the die and provides a random value >=1 && <= numOfSides.
     * @return the value of the die roll
     */
    public int roll()
    {   dieResult = rand.nextInt(numOfSides) + 1;

        assert ( 1 <= getResult() ) && ( getResult() <= getNumSides() );

        return dieResult;
    }

    /**
     * Returns the highest possible value for the die
     * @return the number of sides this die has
     */
    public int getNumSides()
    {   
    	return numOfSides; 
    }

    /**
     * Returns the current value of the die
     * @return the value of this die
     */
    public int getResult()
    {   
    	return dieResult;   
    }

    /**
     * Shows if two die are equal
     * @param otherObj the die to compare to this one
     * @return whether or not the two die objects are equal
     */
    public boolean equals(Object otherObj)
    {   
    	boolean result = true;
        if(otherObj == null)
            result = false;
        else if(this == otherObj)
            result = true;
        else if(this.getClass() != otherObj.getClass())
            result = false;
        else
        {   
        	Die otherDie = (Die)otherObj;
            result = this.dieResult == otherDie.dieResult
                && this.numOfSides == otherDie.numOfSides;
        }
        return result;
    }
    
    public int hashCode() {
    	  assert false : "hashCode not designed";
    	  return 42;
      }

    /**
     * Returns a string with the number of sides and the value of the die.
     * @return: The number of sides and the value of this die
     */
    public String toString()
    {   
    	return "Num sides " + getNumSides() + " result " + getResult();
    }
}

