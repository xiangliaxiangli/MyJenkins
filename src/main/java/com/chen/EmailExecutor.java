package com.chen;

import org.apache.commons.mail.*;

import java.net.MalformedURLException;
import java.net.URL;

public class EmailExecutor {

    //发送简单的邮件
    public String SendSimpleEmail(Sender sender, Receiver receiver, Emails emails) throws EmailException {
        Email email = new SimpleEmail();
        String SendStatus = "SendingError";
        if(sender.IsValidEmail()||receiver.IsValidEmail()){
        try{
            email.setFrom(sender.getEmailAddress(),sender.getName());
            email.setHostName("smtp.qq.com");
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator(sender.getEmailAddress(),sender.getPassWord()));
            email.addTo(receiver.getEmailAddress(),receiver.getName());
            email.setSubject(emails.getTitle());
            email.setMsg(emails.getContent());
            email.send();
            SendStatus = "success";
        }catch (EmailException e) {
            System.out.println("SendingError");
        }
        }else if(sender.IsValidEmail()==false){
            SendStatus = "senderAddressInvalid";
        }else {
            SendStatus = "ReceiverAddressInvalid";
        }
        return SendStatus;
    }


    //发送带有附件的邮件
    public String SendAttachedEmail(Sender sender,Receiver receiver,AttachedEmails attachedEmails){
        MultiPartEmail email = new MultiPartEmail();
        String SendStatus = "SendingError";
        if(sender.IsValidEmail()&&receiver.IsValidEmail()){
            EmailAttachment attachment = new EmailAttachment();
            attachment.setName(attachedEmails.getAttachName());
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            attachment.setDescription(attachedEmails.getAttachDescription());
            if(attachedEmails.getAttachPath()!=null){
                attachment.setPath(attachedEmails.getAttachPath());
            }else if(attachedEmails.getAttachUrl()!=null) {
                try {
                    attachment.setURL(new URL(attachedEmails.getAttachUrl()));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }else {
                throw new NullPointerException();
            }
            try{
                email.setFrom(sender.getEmailAddress(),sender.getName());
                email.setHostName("smtp.qq.com");
                email.setSmtpPort(587);
                email.setAuthenticator(new DefaultAuthenticator(sender.getEmailAddress(),sender.getPassWord()));
                email.addTo(receiver.getEmailAddress(),receiver.getName());
                email.setSubject(attachedEmails.getTitle());
                email.setMsg(attachedEmails.getContent());
                email.attach(attachment);
                email.send();
                SendStatus = "success";
            }catch (EmailException e) {
                System.out.println("SendingError");
            }
        }else if(sender.IsValidEmail()==false){
            SendStatus = "senderAddressInvalid";
        }else {
            SendStatus = "ReceiverAddressInvalid";
        }
        return SendStatus;
    }
}
