package com.chen;


import static org.junit.Assert.assertEquals;

public class ReceiverTest {

    public void Test() {
        Receiver receiver1 = new Receiver();
        Receiver receiver2 = new Receiver("1739787782@qq.com","cxl2.0");
        Receiver receiver3 = new Receiver("ddd","notUser");
        try{
            receiver1.IsValidEmail();
        }catch (NullPointerException e) {

        }
        assertEquals(true,receiver2.IsValidEmail());
        assertEquals(false,receiver3.IsValidEmail());
    }

}
