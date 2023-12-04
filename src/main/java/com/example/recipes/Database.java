package com.example.recipes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    //просмотр списка рецептов
    public static List<Recipe> showAllRecipe(){
        List<Recipe> recipes = new ArrayList<>();
        String query = "SELECT * FROM recipes";
        try (Connection connection = DBconn.GetConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("rec_name");
                String category = rs.getString("category");
                String main_img = rs.getString("main_img");
                String time = rs.getString("cooking_time");
                String difficulty_level = rs.getString("difficulty_level");
                int favorite = rs.getInt("favorite");


                recipes.add(new Recipe(id,name,category,main_img, time,difficulty_level,favorite));
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }

        return recipes;
    }

    //показать избранные рецепты
    public static List<Recipe> showRecipeFavorite(){
        List<Recipe> recipes = new ArrayList<>();
        String query = "SELECT * FROM recipes  WHERE favorite = 1";
        try (Connection connection = DBconn.GetConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("rec_name");
                String category = rs.getString("category");
                String main_img = rs.getString("main_img");
                String time = rs.getString("cooking_time");
                String difficulty_level = rs.getString("difficulty_level");
                int favorite = rs.getInt("favorite");

                recipes.add(new Recipe(id,name,category,main_img, time,difficulty_level,favorite));
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }

        return recipes;
    }

    //показать рецепт
    public static List<Recipe> showRecipe(int id){
        List<Recipe> recipes = new ArrayList<>();
        String query = "SELECT * FROM recipes  WHERE id = ?";
        try (Connection connection = DBconn.GetConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){

                String name = rs.getString("rec_name");
                String category = rs.getString("category");
                String main_img = rs.getString("main_img");
                String time = rs.getString("cooking_time");
                String difficulty_level = rs.getString("difficulty_level");
                int favorite = rs.getInt("favorite");

                recipes.add(new Recipe(id,name,category,main_img, time,difficulty_level,favorite));
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }

        return recipes;
    }




    //показать продукты рецепта
    public static List<Product> showProducts(int rec_id){
        List<Product> prosucts = new ArrayList<>();
        String query = "SELECT prod_id FROM prod_rec  WHERE rec_id = ?";
        String query1 = "SELECT * FROM products WHERE prod_id = ?";
        try (Connection connection = DBconn.GetConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(2,rec_id);
            ResultSet rs = preparedStatement.executeQuery();

            PreparedStatement addToCart = connection.prepareStatement(query1);

            while (rs.next()){
                int prod_id = rs.getInt("prod_id");
                addToCart.setInt(1,prod_id);
                addToCart.executeUpdate();
            }

        } catch(SQLException throwables){
            throwables.printStackTrace();
        }

        return prosucts;
    }


    //показать шаги рецепта
    public static List<Step> showSteps(int rec_id){
        List<Step> steps = new ArrayList<>();
        String query = "SELECT * FROM steps  WHERE rec_id = ?";
        try (Connection connection = DBconn.GetConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1,rec_id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int step_id = rs.getInt("step_id");
                String text = rs.getString("step_text");

                steps.add(new Step(rec_id,step_id,text));
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }

        return steps;
    }

    //показать картинку рецепта

    public static List<Step_img> showStepImg(int step_id){
        List<Step_img> img = new ArrayList<>();
        String query = "SELECT * FROM step_img  WHERE step_id = ?";
        try (Connection connection = DBconn.GetConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1,step_id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int img_id = rs.getInt("img_id");
                String img_url = rs.getString("img_url");

                img.add(new Step_img(step_id,img_id,img_url));
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }

        return img;
    }


    //добавить рецепт
    public static void addRecipe(String rec_name, String category, String main_img, String time,
                                 String difficulty_level,int favorite){
        String query = "INSERT INTO recipes(rec_name,category,main_img,cooking_time,difficulty_level,favorite) VALUES(?,?,?,?,?,?)";
        try (Connection connection = DBconn.GetConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {


            preparedStatement.setString(1,rec_name);
            preparedStatement.setString(2, category);
            preparedStatement.setString(3,main_img);
            preparedStatement.setString(4,time);
            preparedStatement.setString(5,difficulty_level);
            preparedStatement.setInt(6,favorite);

            preparedStatement.executeUpdate();


        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }

    //добавить шаги рецепта

    public static void addStep(String rec_name, String category, String main_img, String time,
                                 String difficulty_level,int favorite){
        String query = "INSERT INTO recipes(rec_name,category,main_img,cooking_time,difficulty_level,favorite) VALUES(?,?,?,?,?,?)";
        try (Connection connection = DBconn.GetConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {


            preparedStatement.setString(1,rec_name);
            preparedStatement.setString(2, category);
            preparedStatement.setString(3,main_img);
            preparedStatement.setString(4,time);
            preparedStatement.setString(5,difficulty_level);
            preparedStatement.setInt(6,favorite);

            preparedStatement.executeUpdate();


        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }

    //добавить картинку рецепта

    //добавить продукты в рецепт


    //добавить в избранное
    public static void addRecipeToFavorite(int id){
        String query = "UPDATE recipes SET favorite = 1 WHERE id = ?";

        try (Connection connection = DBconn.GetConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();

        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }



    //добавить в корзину
    public static void addRecipeToCart(int rec_id){
        String query = "SELECT prod_id FROM prod_rec WHERE rec_id = ?";
        String query1 = "INSERT INTO cart VALUES(?)";
        try (Connection connection = DBconn.GetConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1,rec_id);
            ResultSet rs = preparedStatement.executeQuery();

            PreparedStatement addToCart = connection.prepareStatement(query1);

            while (rs.next()){
                int prod_id = rs.getInt("prod_id");
                addToCart.setInt(1,prod_id);
                addToCart.executeUpdate();
            }


        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }
    
}
