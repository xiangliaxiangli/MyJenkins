package com.chen;
import org.apache.commons.mail.EmailException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class test {

    @Test
    public void test() {
        //假设Sender类还没有被编写好 这时候我们需要进行集成测试
        Sender sender = mock(Sender.class);
        when(sender.getEmailAddress()).thenReturn("1174996959@qq.com");
        when(sender.IsValidEmail()).thenReturn(true);
        when(sender.getPassWord()).thenReturn("kkvtbcsspbpuiiaf");
        when(sender.getName()).thenReturn("cxl");
        
        Receiver receiver = new Receiver("1739787782@qq.com","cxl2.0");
        SimpleEmails simpleEmails = new SimpleEmails("pig","your are a pig");
        EmailExecutor emailExecutor = new EmailExecutor();
        try {
            assertEquals("success",emailExecutor.SendSimpleEmail(sender, receiver, simpleEmails));
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

}
