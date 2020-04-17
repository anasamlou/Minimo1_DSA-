package edu.upc.dsa;

import edu.upc.dsa.utils.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
    GameManager gm;

    @Before
    public void setUp() {
        gm = GameManagerImp.getInstance();

        this.gm.addUser("Anas","Amlou","anasamlou");
        this.gm.addUser("Carlos", "Mafiozo", "carlosmafiozo");
        this.gm.addUser("juninho", "Pernambucano", "elbicho");
    }

    @Test //Adding users + checking the number of users
    public void testAddUsers() {

        this.gm.addUser("Papi", "Arca", "lamaravilla");

        Assert.assertEquals(4, this.gm.getNumUsers());
    }

    @Test
    public void testAddObjects(){

        this.gm.addArmasUser("anasamlou","Espada", "afilada");
        this.gm.addArmasUser("carlosmafiozo","guitarra", "española");
        this.gm.addArmasUser("elbicho", "maquina", "deltiempo");

        Assert.assertEquals(1, this.gm.getnumArmasbyUser("anasamlou"));
        Assert.assertEquals(1,this.gm.getnumArmasbyUser("carlosmafiozo"));
    }

    @Test
    public void testModifyUser(){

        this.gm.addArmasUser("anasamlou", "Armadura", "metalica");
        this.gm.updateUser("Anass","Amlou", "anasamlou");
        Assert.assertEquals("Anass",this.gm.getUser("anasamlou").getName());
        Assert.assertEquals(1,this.gm.getnumArmasbyUser("anasamlou"));
    }

    @After
    public void tearDown(){
        this.gm.clear();
    }
}
