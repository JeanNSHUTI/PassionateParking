package test;

import company.Size;
import org.junit.Assert;
import org.junit.Test;

public class SizeTest {

    @Test
    public void SizeTest(){
        //test to see if we can access size parameters
        Size size = new Size(1,2);
        Assert.assertEquals("should be 0",2, size.getLength());
        Assert.assertEquals("should be 0",1, size.getWidth());
    }
}
