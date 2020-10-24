package com.chen;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SenderTest {

    @Test
    public void Test() {
        Sender sender1 = new Sender();
        Sender sender2 = new Sender("1174996959@qq.com","123","cxl");
        Sender sender3 = new Sender("5555","123","xys");
        try{
            sender1.IsValidEmail();
        }catch (NullPointerException e) {

        }
        assertEquals(true,sender2.IsValidEmail());
        assertEquals(false,sender3.IsValidEmail());
    }

}
