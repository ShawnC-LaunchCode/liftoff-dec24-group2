package com.waxofalltrades.liftoff_capstone_vinyl_destination.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class StripeResponse {
    private String status;
    private String message;
    private String sessionId;
    private String sessionUrl;



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionUrl() {
        return sessionUrl;
    }

    public void setSessionUrl(String sessionUrl) {
        this.sessionUrl = sessionUrl;
    }
}
