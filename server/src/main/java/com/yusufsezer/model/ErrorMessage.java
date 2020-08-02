package com.yusufsezer.model;

import java.util.UUID;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {

    private String type;
    private String title;
    private int status;
    private String traceId;

    public ErrorMessage() {
    }

    public ErrorMessage(String type, String title, int status) {
        this.type = "https://tools.ietf.org/html/rfc7231#section-" + type;
        this.title = title;
        this.status = status;
        this.traceId = UUID.randomUUID().toString();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = "https://tools.ietf.org/html/rfc7231#section-" + type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

}
