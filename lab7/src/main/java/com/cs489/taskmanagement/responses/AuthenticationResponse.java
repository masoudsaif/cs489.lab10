package com.cs489.taskmanagement.responses;

public class AuthenticationResponse {

    private String jwt;

    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    // Getter for the JWT token
    public String getJwt() {
        return jwt;
    }

    // Setter for the JWT token (optional, depending on your use case)
    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}