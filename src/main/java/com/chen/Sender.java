package com.chen;

import java.util.regex.Pattern;

public class Sender {
    private String EmailAddress;
    private String PassWord;
    private String name;

    public Sender() {
    }

    public Sender(String emailAddress, String passWord, String name) {
        EmailAddress = emailAddress;
        PassWord = passWord;
        this.name = name;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //判断邮箱是否合法
    public boolean IsValidEmail() {
        String Isemail = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
        boolean matches;
        if(EmailAddress==null){
            throw new NullPointerException();
        }else {
            matches = Pattern.matches(Isemail, getEmailAddress());
        }
        return matches;
    }
}
