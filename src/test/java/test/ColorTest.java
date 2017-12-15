package test;

import company.Color;
import org.junit.Assert;
import org.junit.Test;

public class ColorTest {

    @Test
    public void ColorTest(){
        //test if the color parameter is correctely stored
        Color color = new Color("green");
        Assert.assertEquals("Should be green", "green",color.getColor());
    }
}
