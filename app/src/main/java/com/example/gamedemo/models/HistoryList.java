package com.example.gamedemo.models;


public class HistoryList {
    private String B1;
    private int WF1;
    private String B2;
    private int WF2;
    private String B3;
    private int WF3;

    public HistoryList(String B1, int WF1,String B2, int WF2,String B3, int WF3) {
        this.B1 = B1;
        this.WF1 = WF1;
        this.B2 = B2;
        this.WF2 = WF2;
        this.B3 = B3;
        this.WF3 = WF3;

    }
    public String getB1() {
        return B1;
    }
    public void setB1(String b1) {
        this.B1 = b1;
    }
    public int getWF1() {
        return WF1;
    }
    public void setWF1(int WF1) {
        this.WF1 = WF1;
    }

    public String getB2() {
        return B2;
    }
    public void setB2(String b2) {
        this.B2 = b2;
    }
    public int getWF2() {
        return WF2;
    }
    public void setWF2(int WF2) {
        this.WF2 = WF2;
    }

    public String getB3() {
        return B3;
    }
    public void setB3(String b3) {
        this.B3 = b3;
    }
    public int getWF3() {
        return WF3;
    }
    public void setWF3(int WF3) {
        this.WF3 = WF3;
    }

}

