package edu.upc.dsa;

import edu.upc.dsa.utils.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class CovidTest {
    Covid19Manager COVID;

    @Before
    public void setUp() {
        COVID = Covid19ManagerImp.getInstance();

        this.COVID.crearBrote("Brote de Madrid");
        this.COVID.crearBrote("Brote de Murcia");
        this.COVID.crearBrote("Brote de Malaga");
    }

    @Test //Adding users + checking the number of users
    public void testCrearBrote() {

        this.COVID.crearBrote("Brote de Barcelona");

        Assert.assertEquals(4, this.COVID.getBrotes());
    }

    @Test
    public void testAddCasos(){
        this.COVID.addCasoToBrote("Brote de Madrid","1","27/01/1932","B",Boolean.TRUE,Boolean.FALSE,Boolean.FALSE);
        this.COVID.addCasoToBrote("Brote de Madrid","2","27/01/1933","B", FALSE,Boolean.FALSE, TRUE);
        this.COVID.addCasoToBrote("Brote de Malaga","1","27/01/1936","B", FALSE, TRUE,Boolean.FALSE);
        this.COVID.addCasoToBrote("Brote de Murcia","1","27/01/1932","B",Boolean.TRUE,Boolean.FALSE,Boolean.FALSE);


    }


    @After
    public void tearDown(){
        this.COVID.clear();
    }
}
