package com.Kunal.Chauhan.EmployeeApp.Execption;

public class EmployeeExecptionResponse {

    private String message;

    private int status;

    private long timeStamo;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getTimeStamo() {
        return timeStamo;
    }

    public void setTimeStamo(long timeStamo) {
        this.timeStamo = timeStamo;
    }

    public EmployeeExecptionResponse(long timeStamo, int status, String message) {
        this.timeStamo = timeStamo;
        this.status = status;
        this.message = message;
    }

    public EmployeeExecptionResponse() {
    }
}
