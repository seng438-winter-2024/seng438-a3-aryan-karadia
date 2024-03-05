package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class DataUtilitiesTest extends DataUtilities {

    private DefaultKeyedValues2D values;
    private DefaultKeyedValues2D values2;
    private DefaultKeyedValues2D values3;
    private DefaultKeyedValues2D values4;
    private DefaultKeyedValues2D negativeValues;
    private DefaultKeyedValues2D valuesRow1;
    private DefaultKeyedValues2D valuesRow3;
    private DefaultKeyedValues2D valuesRow2;
    @Before
    public void setUp() {
    	// Creates object of DefaultKeyedValues2D with 2 rows and 1 column
        
        values = new DefaultKeyedValues2D();
        values.addValue(7.5, 0, 0);
        values.addValue(2.5, 1, 0);
        
        
        // Creates object of DefaultKeyedValues2D with 1 row and 2 columns
        
        values2 = new DefaultKeyedValues2D();
        values2.addValue(0, 0, 0);
        values2.addValue(3.5, 0, 1);
        // Creates a object of DefaultKeyedValues2D with 3 columns and 2 rows
        values3 = new DefaultKeyedValues2D();
        values3.addValue(2.5, 0, 1);    
        values3.addValue(2.5, 1, 1);
        values3.addValue(0, 0, 2);        
        values3.addValue(0, 1, 2);
        
        
        // Creates object of DefaultKeyedValues2D with 0 rows and 0 columns
        values4 = new DefaultKeyedValues2D();
       
        // Creates a object of DefaultKeyedValues2D with 2 rows and 1 column
        // with negative values
        negativeValues = new DefaultKeyedValues2D();
        negativeValues.addValue(-2.5, 0, 0);
        negativeValues.addValue(-2.5, 1, 0);
  
        
        //row data
        // Creates an object object with 1 row and 2 columns
        valuesRow1 = new DefaultKeyedValues2D();
        valuesRow1.addValue(7.5, 0, 0);
        valuesRow1.addValue(2.5, 0, 1);


        // Creates an object object with 1 row and 3 columns
        valuesRow2 = new DefaultKeyedValues2D();
        valuesRow2.addValue(3.5, 0, 0);
        valuesRow2.addValue(2.5, 0, 1);
        valuesRow2.addValue(1.5, 0, 2);
        
        
        // Creates  object with 0 rows and 0 columns
        valuesRow3 = new DefaultKeyedValues2D();
       
    }
    
    // This test uses an object object with 1 row and 2 columns and tests the output
    // of calculateColumnTotal given the highest column index for the matrix (column2).
    @Test
    public void calculateColumnTotalWithMaxColumns() {
        double result = DataUtilities.calculateColumnTotal(values2, 1);
        assertEquals(3.5, result, .000000001d);
    }
    
    
    // This test uses an object object with 3 columns and 2 rows and tests the output
    // of calculateColumnTotal given a column index of 1, the middle column of 
    // the matrix (column2).
    @Test
    public void calculateColumnTotalWithThreeColumn() {
        double result = DataUtilities.calculateColumnTotal(values3, 1);
        assertEquals(5.0, result, .000000001d);
    }
    
    // This test uses an object object with 2 rows and 1 column and tests output of
    // calculateColumnTotal given 2 values being added together
    @Test
    public void calculateColumnTotalForTwoValues() {
        // setup  
        double result = DataUtilities.calculateColumnTotal(values, 0);
        // verify
        assertEquals(10.0, result, .000000001d);
        // tear-down: None in this test method
    }
    
    // This test uses an object object with 2 rows and 1 column to test output of
    // calculateColumnTotal method with two negative values
    @Test
    public void calculateColumnTotalForNegativeValues() {
    	double result = DataUtilities.calculateColumnTotal(negativeValues, 0);
    	assertEquals(-5.0, result, .000000001d);
    }
    
    
    // This test uses an object object with 0 rows and 0 columns to test output
    // of calculateColumnTotal which should return 0 with invalid data.
    @Test
    public void calculateColumnTotalWithInvalidData() {
        // Pass null as the data object
        double result = DataUtilities.calculateColumnTotal(values4, 0);
        assertEquals(0.0, result, .000000001d);
    }
    
    //end of testing columns 
    
    //beginning of testing rows
    
	 // This test verifies the calculation of the total for a row with two columns using mock object valuesRow1.
	 // It ensures that the calculateRowTotal method correctly computes the total and matches the expected value (10.0).
	 @Test
	 public void calculateRowTotalWithTwoColumns() {
		 double result = DataUtilities.calculateRowTotal(valuesRow1, 0);
		 assertEquals(10.0, result, .000000001d);
	 }
	
	 // This test examines the calculation of the total for a row with three columns using mock object valuesRow2.
	 // It validates that the calculateRowTotal method accurately computes the total and matches the expected value (7.5).
	 @Test
	 public void calculateRowTotalWithThreeColumns() {
		 double result = DataUtilities.calculateRowTotal(valuesRow2, 0);
		 assertEquals(7.5, result, .000000001d);
	 }
	
	 // This test evaluates the behavior of calculateRowTotal when provided with invalid data using mock object valuesRow3.
	 // It ensures that the calculateRowTotal method correctly handles invalid data and returns 0.0 as the total.
	 @Test
	 public void calculateRowTotalWithInvalidData() {
		 double result = DataUtilities.calculateRowTotal(valuesRow3, 0);
		 assertEquals(0.0, result, .000000001d);
	 }

    //end of calculateRowTotal method
    
    //beginning of createNumberArray method
    
	// This test verifies the creation of a Number array from valid data.
	// It confirms that the createNumberArray method correctly converts the double array into a Number array.
	// However, this test fails due to a known issue where the last value in the array is always null.
	@Test
	public void createNumberArrayWithValidData() {
	    // Given
	    double[] validData = {1.5, 2.5, 3.5};
	    
	    // When
	    Number[] result = DataUtilities.createNumberArray(validData);
	    
	    // Then
	    assertEquals(3, result.length);
	    assertNotNull(result[0]);
	    assertEquals(1.5, result[0].doubleValue(), 0.000000001d);
	    assertNotNull(result[1]);
	    assertEquals(2.5, result[1].doubleValue(), 0.000000001d);
	    assertNotNull(result[2]);
	    assertEquals(3.5, result[2].doubleValue(), 0.000000001d);
	}

    
	// This test verifies the creation of a Number array from empty data.
	// It ensures that the createNumberArray method correctly handles the case of an empty double array.
	@Test
	public void createNumberArrayWithEmptyData() {
	    // Given
	    double[] emptyData = {};
	    
	    // When
	    Number[] result = DataUtilities.createNumberArray(emptyData);
	    
	    // Then
	    assertEquals(0, result.length);
	}

	// This test validates the creation of a 2D Number array from valid data.
	// It confirms that the createNumberArray2D method properly converts the 2D double array into a 2D Number array.
	@Test
	public void createNumberArray2DWithValidData() {
	    // Given
	    double[][] validData = {{1.5, 2.5, 3.5}, {4.5, 5.5, 6.5}};
	    
	    // When
	    Number[][] result = DataUtilities.createNumberArray2D(validData);
	    
	    // Then
	    assertEquals(2, result.length); // Check number of rows
	    assertEquals(3, result[0].length); // Check number of columns in the first row
	    assertEquals(3, result[1].length); // Check number of columns in the second row
	    
	    assertNotNull(result[0][0]);
	    assertEquals(1.5, result[0][0].doubleValue(), 0.000000001d);
	    assertNotNull(result[0][1]);
	    assertEquals(2.5, result[0][1].doubleValue(), 0.000000001d);
	    assertNotNull(result[0][2]);
	    assertEquals(3.5, result[0][2].doubleValue(), 0.000000001d);
	    
	    assertNotNull(result[1][0]);
	    assertEquals(4.5, result[1][0].doubleValue(), 0.000000001d);
	    assertNotNull(result[1][1]);
	    assertEquals(5.5, result[1][1].doubleValue(), 0.000000001d);
	    assertNotNull(result[1][2]);
	    assertEquals(6.5, result[1][2].doubleValue(), 0.000000001d);
	}

	// This test examines the calculation of cumulative percentages from valid data.
	// It ensures that the getCumulativePercentages method correctly computes cumulative percentages.
	@Test
	public void getCumulativePercentagesWithValidData() {
	    // Given
	    DefaultKeyedValues data = new DefaultKeyedValues();
	    
	    data.addValue("0", 5);
	    data.addValue("1", 9);
	    data.addValue("2", 2);
	    
	    // When
	    KeyedValues result = DataUtilities.getCumulativePercentages(data);
	    
	    // Then
	    assertEquals(3, result.getItemCount()); // Check number of items
	    assertEquals(0.3125, result.getValue("0").doubleValue(), 0.000000001d);
	    assertEquals(0.875, result.getValue("1").doubleValue(), 0.000000001d);
	    assertEquals(1.0, result.getValue("2").doubleValue(), 0.000000001d);
	}
	
	@Test
	public void testEqualMethod() {
	    // Test when both arrays are null
	    assertTrue(DataUtilities.equal(null, null));

	    // Test when one array is null and the other is not
	    assertFalse(DataUtilities.equal(new double[][]{{1.0}}, null));
	    assertFalse(DataUtilities.equal(null, new double[][]{{1.0}}));

	    // Test when arrays have different lengths
	    assertFalse(DataUtilities.equal(new double[][]{{1.0}}, new double[][]{{1.0}, {2.0}}));

	    // Test when arrays have the same length but different values
	    assertFalse(DataUtilities.equal(new double[][]{{1.0}}, new double[][]{{2.0}}));
	    assertFalse(DataUtilities.equal(new double[][]{{1.0}, {2.0}}, new double[][]{{1.0}, {3.0}}));

	    // Test when arrays are equal
	    assertTrue(DataUtilities.equal(new double[][]{{1.0}}, new double[][]{{1.0}}));
	    assertTrue(DataUtilities.equal(new double[][]{{1.0}, {2.0}}, new double[][]{{1.0}, {2.0}}));
	}


	@Test
    public void testCloneMethod() {
        // Test case 2: When source is empty
        double[][] source2 = {};
        assertArrayEquals("Cloning empty source should return empty array", source2, DataUtilities.clone(source2));

        // Test case 3: When source contains null rows
        double[][] source3 = {{1.0, 2.0}, null, {3.0, 4.0}};
        double[][] expected3 = {{1.0, 2.0}, null, {3.0, 4.0}};
        assertArrayEquals("Cloning source with null rows should return the same", expected3, DataUtilities.clone(source3));

        // Test case 4: When source contains non-null rows
        double[][] source4 = {{1.0, 2.0}, {3.0, 4.0}};
        double[][] expected4 = {{1.0, 2.0}, {3.0, 4.0}};
        assertArrayEquals("Cloning source with non-null rows should return the same", expected4, DataUtilities.clone(source4));

        // Test case 5: When source contains rows with different lengths
        double[][] source5 = {{1.0, 2.0}, {3.0}};
        double[][] expected5 = {{1.0, 2.0}, {3.0}};
        assertArrayEquals("Cloning source with rows of different lengths should return the same", expected5, DataUtilities.clone(source5));

        // Test case 6: When source contains large array
        double[][] source6 = new double[1000][1000];
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                source6[i][j] = i + j;
            }
        }
        double[][] cloned6 = DataUtilities.clone(source6);
        assertArrayEquals("Cloning large source should return the same array", source6, cloned6);
        assertNotSame("Cloning large source should return a different array instance", source6, cloned6);
    }
	
	@Test
	public void testCalculateColumnTotal_AllValidRows() {
	    int[] validRows = {0, 1, 2, 3};
	    double total = DataUtilities.calculateColumnTotal(values, 0, validRows);
	    assertEquals(10.0, total, 0.000001);
	}

	@Test
	public void testCalculateColumnTotal_SomeValidRows() {
	    int[] validRows = {0, 1};
	    double total = DataUtilities.calculateColumnTotal(values, 0, validRows);
	    assertEquals(3.0, total, 0.000001);
	}

	@Test
	public void testCalculateColumnTotal_NoValidRows() {
	    int[] validRows = {};
	    double total = DataUtilities.calculateColumnTotal(values, 0, validRows);
	    assertEquals(0.0, total, 0.000001);
	}

	@Test
	public void testCalculateRowTotal_AllValidCols() {
	    int[] validCols = {0, 1};
	    double total = DataUtilities.calculateRowTotal(values, 0, validCols);
	    assertEquals(3.0, total, 0.000001);
	}

	@Test
	public void testCalculateRowTotal_SomeValidCols() {
	    int[] validCols = {0};
	    double total = DataUtilities.calculateRowTotal(values, 1, validCols);
	    assertEquals(3.0, total, 0.000001);
	}

	@Test
	public void testCalculateRowTotal_NoValidCols() {
	    int[] validCols = {};
	    double total = DataUtilities.calculateRowTotal(values, 1, validCols);
	    assertEquals(0.0, total, 0.000001);
	}

	@Test
	public void testCalculateRowTotal_WithValidDataAndZeroColumnCount() {
	    int[] validCols = {};
	    double total = DataUtilities.calculateRowTotal(valuesRow3, 0, validCols);
	    assertEquals(0.0, total, 0.000001);
	}
	
    @After
    public void tearDown() {
        values = null;
    }
}
