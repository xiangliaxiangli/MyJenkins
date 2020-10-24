package com.chen;

public class AttachedEmails extends Emails {
    private String attachName;
    private String attachPath;
    private String attachDescription;
    private String attachUrl;

    public AttachedEmails(){
        super();
        attachName = null;
        attachPath = null;
        attachDescription = null;
        attachUrl = null;
    }

    public AttachedEmails(String title, String content, String attachName, String attachPath, String attachDescription, String attachUrl) {
        super(title, content);
        this.attachName = attachName;
        this.attachPath = attachPath;
        this.attachDescription = attachDescription;
        this.attachUrl = attachUrl;
    }

    public String getAttachName() {
        return attachName;
    }

    public void setAttachName(String attachName) {
        this.attachName = attachName;
    }

    public String getAttachPath() {
        return attachPath;
    }

    public void setAttachPath(String attachPath) {
        this.attachPath = attachPath;
    }

    public String getAttachDescription() {
        return attachDescription;
    }

    public void setAttachDescription(String attachDescription) {
        this.attachDescription = attachDescription;
    }

    public String getAttachUrl() {
        return attachUrl;
    }

    public void setAttachUrl(String attachUrl) {
        this.attachUrl = attachUrl;
    }
}
