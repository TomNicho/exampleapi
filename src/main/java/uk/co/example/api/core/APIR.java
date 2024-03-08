package uk.co.example.api.core;

public class APIR {
    public boolean success;
    public Object body;

    public APIR(boolean success, Object body) {
        this.body = body;
        this.success = success;
    }
}