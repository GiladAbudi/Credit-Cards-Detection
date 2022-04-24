package com.creditcard.cards.detection.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document
public class Message {
    @Id
    String id;
    String sender;
    List<String> recipients;
    String subject;
    String body;
    double sentTime;

    public Message() {
    }

    public Message(String id, String sender, List<String> recipients, String subject, String body, double sentTime) {
        this.id = id;
        this.sender = sender;
        this.recipients = recipients;
        this.subject = subject;
        this.body = body;
        this.sentTime = sentTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public double getSentTime() {
        return sentTime;
    }

    public void setSentTime(double sentTime) {
        this.sentTime = sentTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Double.compare(message.sentTime, sentTime) == 0 &&
                Objects.equals(id, message.id) &&
                Objects.equals(sender, message.sender) &&
                Objects.equals(recipients, message.recipients) &&
                Objects.equals(subject, message.subject) &&
                Objects.equals(body, message.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sender, recipients, subject, body, sentTime);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", sender='" + sender + '\'' +
                ", recipients=" + recipients +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", sentTime=" + sentTime +
                '}';
    }
}
