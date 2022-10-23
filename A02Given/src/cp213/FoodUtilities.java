package cp213;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Utilities for working with Food objects.
 *
 * @author your name, id, email here
 * @version 2022-10-04
 */
public class FoodUtilities {

    /**
     * Determines the average calories in a list of foods. No rounding necessary.
     * Foods list parameter may be empty.
     *
     * @param foods a list of Food
     * @return average calories in all Food objects
     */
    public static int averageCalories(final ArrayList<Food> foods) {
	int total = 0;

	int x = 0;
	if (!foods.isEmpty()) {
	    for (Food i : foods) {
		total += i.getCalories();
		x++;
	    }
	} else {
	    return total;
	}

	return total / x;
    }

    /**
     * Determines the average calories in a list of foods for a particular origin.
     * No rounding necessary. Foods list parameter may be empty.
     *
     * @param foods  a list of Food
     * @param origin the origin of the Food
     * @return average calories for all Foods of the specified origin
     */
    public static int averageCaloriesByOrigin(final ArrayList<Food> foods, final int origin) {
	ArrayList<Food> foodsList = new ArrayList<Food>();
	foodsList = getByOrigin(foods, origin);

	return averageCalories(foodsList);
    }

    /**
     * Creates a list of foods by origin.
     *
     * @param foods  a list of Food
     * @param origin a food origin
     * @return a list of Food from origin
     */
    public static ArrayList<Food> getByOrigin(final ArrayList<Food> foods, final int origin) {
	ArrayList<Food> foods1 = new ArrayList<Food>();
	if (!foods.isEmpty()) {
	    for (Food i : foods) {
		if (i.getOrigin() == origin) {
		    foods1.add(i);
		}
	    }
	}

	return foods1;
    }

    /**
     * Creates a Food object by requesting data from a user. Uses the format:
     *
     * <pre>
    Name: name
    Origins
     0 Canadian
     1 Chinese
    ...
    11 English
    Origin: origin number
    Vegetarian (Y/N): Y/N
    Calories: calories
     * </pre>
     *
     * @param keyboard a keyboard Scanner
     * @return a Food object
     */
    public static Food getFood(final Scanner keyboard) {
	Scanner myObj = new Scanner(System.in); // Create a Scanner object

	System.out.println("Name: ");
	String name = myObj.nextLine();

	System.out.println(Food.originsMenu());
	System.out.println("Origin: ");
	int origin = myObj.nextInt();

	System.out.println("Vegetarian (Y/N): ");
	Boolean vegetarian = myObj.nextBoolean();

	System.out.println("Calories: ");
	int calories = myObj.nextInt();

	Food food = new Food(name, origin, vegetarian, calories);
	return food;
    }

    /**
     * Creates a list of vegetarian foods.
     *
     * @param foods a list of Food
     * @return a list of vegetarian Food
     */
    public static ArrayList<Food> getVegetarian(final ArrayList<Food> foods) {

	ArrayList<Food> veg = new ArrayList<Food>();

	for (Food i : foods)
	    if (i.isVegetarian() == true)
		veg.add(i);

	return veg;
    }

    /**
     * Creates and returns a Food object from a line of string data.
     *
     * @param line a vertical bar-delimited line of food data in the format
     *             name|origin|isVegetarian|calories
     * @return the data from line as a Food object
     */
    public static Food readFood(final String line) {

	String[] splitArray = line.split("\\|");

	String name = splitArray[0];
	int origin = Integer.valueOf(splitArray[1]);
	boolean isVeg = splitArray[2] == "true";
	int cal = Integer.valueOf(splitArray[3]);

	Food foodObject = new Food(name, origin, isVeg, cal);
	return foodObject;
    }

    /**
     * Reads a file of food strings into a list of Food objects.
     *
     * @param fileIn a Scanner of a Food data file in the format
     *               name|origin|isVegetarian|calories
     * @return a list of Food
     */
    public static ArrayList<Food> readFoods(final Scanner fileIn) {
	ArrayList<Food> foodsList = new ArrayList<Food>();

	while (fileIn.hasNextLine()) {
	    String x = fileIn.nextLine();
	    foodsList.add(FoodUtilities.readFood(x));

	}

	return foodsList;
    }

    /**
     * Searches for foods that fit certain conditions.
     *
     * @param foods        a list of Food
     * @param origin       the origin of the food; if -1, accept any origin
     * @param maxCalories  the maximum calories for the food; if 0, accept any
     * @param isVegetarian whether the food is vegetarian or not; if false accept
     *                     any
     * @return a list of foods that fit the conditions specified
     */
    public static ArrayList<Food> foodSearch(final ArrayList<Food> foods, final int origin, final int maxCalories,
	    final boolean isVegetarian) {

	ArrayList<Food> newFoods = new ArrayList<Food>();
	for (Food i : foods) {
	    if (i.getOrigin() == -1 || i.getOrigin() == origin)
		if (i.getCalories() < maxCalories || i.getCalories() == 0)
		    if (isVegetarian == false)
			newFoods.add(i);

	}

	return newFoods;
    }

    /**
     * Writes the contents of a list of Food to a PrintStream.
     *
     * @param foods a list of Food
     * @param ps    the PrintStream to write to
     */
    public static void writeFoods(final ArrayList<Food> foods, PrintStream ps) {

    }
}
