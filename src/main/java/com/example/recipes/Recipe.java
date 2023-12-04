package com.example.recipes;


public class Recipe {
    Integer id;
    String name;
    String category;
    String main_img;
    String time;
    String difficulty_level;
    Integer favorite;

    @Override
    public String toString() {;
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", main_img='" + main_img + '\'' +
                ", time='" + time + '\'' +
                ", difficulty_level='" + difficulty_level + '\'' +
                ", favorite=" + favorite +
                '}';
    }

    public Recipe(int rec_id, int step_id, String text) {
    }

    public Recipe(Integer id, String name, String category, String main_img, String time, String difficulty_level,
                  Integer favorite) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.main_img = main_img;
        this.time = time;
        this.difficulty_level = difficulty_level;
        this.favorite = favorite;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMain_img() {
        return main_img;
    }

    public void setMain_img(String main_img) {
        this.main_img = main_img;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDifficulty_level() {
        return difficulty_level;
    }

    public void setDifficulty_level(String difficulty_level) {
        this.difficulty_level = difficulty_level;
    }

    public Integer getFavorite() {
        return favorite;
    }

    public void setFavorite(Integer favorite) {
        this.favorite = favorite;
    }
}
