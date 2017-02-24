package com.epam.factory_method.business_objects;

public class MailData {

    private String to;
    private String subject;
    private String mailBody;

    public MailData(String to, String subject, String mailBody) {
        this.to = to;
        this.subject = subject;
        this.mailBody = mailBody;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMailBody() {
        return mailBody;
    }

    public void setMailBody(String mailBody) {
        this.mailBody = mailBody;
    }

    @Override
    public String toString() {
        return "MailData{" +
                "to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", mailBody='" + mailBody + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MailData mailData = (MailData) o;

        if (to != null ? !to.equals(mailData.to) : mailData.to != null) return false;
        if (subject != null ? !subject.equals(mailData.subject) : mailData.subject != null) return false;
        return mailBody != null ? mailBody.equals(mailData.mailBody) : mailData.mailBody == null;

    }

    @Override
    public int hashCode() {
        int result = to != null ? to.hashCode() : 0;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (mailBody != null ? mailBody.hashCode() : 0);
        return
                result;
    }
}
