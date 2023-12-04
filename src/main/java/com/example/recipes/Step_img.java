package com.example.recipes;

public class Step_img {
     int step_id;
     int img_id;

     String img_url;

    public Step_img() {
    }

    @Override
    public String toString() {
        return "Step_img{" +
                "step_id=" + step_id +
                ", img_id=" + img_id +
                ", img_url='" + img_url + '\'' +
                '}';
    }

    public Step_img(int step_id, int img_id, String img_url) {
        this.step_id = step_id;
        this.img_id = img_id;
        this.img_url = img_url;
    }

    public int getStep_id() {
        return step_id;
    }

    public void setStep_id(int step_id) {
        this.step_id = step_id;
    }

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
