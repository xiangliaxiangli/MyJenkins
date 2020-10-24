package com.chen;


import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.junit.Test;

//对Apache的Email类进行单元测试
public class ApacheEmailTest {

    @Test
    public void SuccessTest() {
        Email email = new SimpleEmail();
        try {
            email.setFrom("1174996959@qq.com","cxl");
        } catch (EmailException e) {
            e.printStackTrace();
        }
        email.setHostName("smtp.qq.com");
        email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator("1174996959@qq.com","kkvtbcsspbpuiiaf"));
        try {
            email.addTo("1739787782@qq.com","cxl2.0");
        } catch (EmailException e) {
            e.printStackTrace();
        }
        email.setSubject("title");
        try {
            email.setMsg("content");
        } catch (EmailException e) {
            e.printStackTrace();
        }
        try {
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ErrorTest() {
        Email email = new SimpleEmail();
        try {
            email.setFrom("xxx","cxl");
        } catch (EmailException e) {
            System.out.println(e.getMessage());
        }
        email.setHostName("smtp.qq.com");
        email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator("1174996959@qq.com","kkvtbcsspbpuiiaf"));
        try {
            email.addTo("xxx","cxl2.0");
        } catch (EmailException e) {
            System.out.println(e.getMessage());
        }
        email.setSubject("title");
        try {
            email.setMsg(null);
        } catch (EmailException e) {
            System.out.println(e.getMessage());
        }
        try {
            email.send();
        } catch (EmailException e) {
            System.out.println(e.getMessage());
        }
    }


}
