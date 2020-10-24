package com.chen;

import java.util.regex.Pattern;

public class Receiver {
    private String emailAddress;
    private String name;

    public Receiver() {
    }

    public Receiver(String emailAddress, String name) {
        this.emailAddress = emailAddress;
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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
        if(emailAddress==null){
            throw new NullPointerException();
        }else {
            matches = Pattern.matches(Isemail, getEmailAddress());
        }
        return matches;
    }
}
