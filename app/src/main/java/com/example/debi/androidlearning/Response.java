package com.example.debi.androidlearning;

/**
 * Created by debi on 19/12/17.
 */

public class Response {
    private String status, fullname, message;

    public Response(String status, String fullname, String message) {
        this.status = status;
        this.fullname = fullname;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
