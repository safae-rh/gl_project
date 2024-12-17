package com.gestion.vols.payload.response;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResponse {

    private String message;
    private String details;

    public MessageResponse(String message) {
        this.message = message;
    }

    public MessageResponse(String message, String details) {
        this.message = message;
        this.details = details;
    }
}
