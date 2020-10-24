package com.chen;

import org.apache.commons.mail.EmailException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SimpleEmailTest {

    @Test
    //一切正常 送达成功
    public void SucessTest() {
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
            System.out.println(e.getMessage());
        }
    }

    @Test
    //发邮件的不是邮箱
    public void SenderErrorTest() {
        //发送者的地址不是邮箱
        Sender sender = mock(Sender.class);
        when(sender.getEmailAddress()).thenReturn("xxx");
        when(sender.IsValidEmail()).thenReturn(false);
        when(sender.getPassWord()).thenReturn("kkvtbcsspbpuiiaf");
        when(sender.getName()).thenReturn("cxl");
        Receiver receiver = new Receiver("1739787782@qq.com","cxl2.0");
        SimpleEmails simpleEmails = new SimpleEmails("pig","your are a pig");
        EmailExecutor emailExecutor = new EmailExecutor();
        try {
            assertEquals("senderAddressInvalid",emailExecutor.SendSimpleEmail(sender, receiver, simpleEmails));
        } catch (EmailException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    //收邮件的地址不是邮箱地址
    public void ReceiverErrorTest() {
        Sender sender = mock(Sender.class);
        when(sender.getEmailAddress()).thenReturn("1174996959@qq.com");
        when(sender.IsValidEmail()).thenReturn(true);
        when(sender.getPassWord()).thenReturn("kkvtbcsspbpuiiaf");
        when(sender.getName()).thenReturn("cxl");
        //接受者的邮箱地址错误
//        Receiver receiver = new Receiver("xxx","cxl2.0");
        Receiver receiver = mock(Receiver.class);
        when(receiver.getEmailAddress()).thenReturn("xxx");
        when(receiver.IsValidEmail()).thenReturn(false);
        when(receiver.getName()).thenReturn("cxl2.0");
        SimpleEmails simpleEmails = new SimpleEmails("pig","your are a pig");
        EmailExecutor emailExecutor = new EmailExecutor();
        try {
            assertEquals("ReceiverAddressInvalid",emailExecutor.SendSimpleEmail(sender, receiver, simpleEmails));
        } catch (EmailException e) {
            System.out.println(e.getMessage());
        }
    }

}
