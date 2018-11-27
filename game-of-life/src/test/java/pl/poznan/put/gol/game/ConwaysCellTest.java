package pl.poznan.put.gol.game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Paweł Korczak
 */
public class ConwaysCellTest {
    
    public ConwaysCellTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    private ConwaysCell testCell;

    /**
     * Test of neighbors method, of class ConwaysCell.
     */
    @org.junit.Test
    public void testNeighbors() {
        Cells cell = new Cells();
        cell.getNeighbors();
        
        assertEquals(cell, testCell.neighbors());
        
    }

    /**
     * Test of toString method, of class ConwaysCell.
     */
    @org.junit.Test
    public void testToString() {
        
    }
    
}
