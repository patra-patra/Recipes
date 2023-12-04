package com.example.recipes;

import java.util.ArrayList;

public class Step {

    int rec_id;
    int step_id;
    String text;
    public ArrayList<String> img;

    @Override
    public String toString() {
        return "Step{" +
                "rec_id=" + rec_id +
                ", step_id=" + step_id +
                ", text='" + text + '\'' +
                '}';
    }

    public Step() {
    }

    public Step(int rec_id, int step_id, String text) {
        this.rec_id = rec_id;
        this.step_id = step_id;
        this.text = text;
    }

    public int getRec_id() {
        return rec_id;
    }

    public void setRec_id(int rec_id) {
        this.rec_id = rec_id;
    }

    public int getStep_id() {
        return step_id;
    }

    public void setStep_id(int ste_id) {
        this.step_id = ste_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
