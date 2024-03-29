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
        List<Product> products = new ArrayList<>();
        String query = "SELECT prod_id FROM prod_in_rec  WHERE rec_id = ?";
        String query1 = "SELECT * FROM products WHERE prod_id = ?";
        try (Connection connection = DBconn.GetConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1,rec_id);
            ResultSet rs = preparedStatement.executeQuery();

            PreparedStatement showProducts = connection.prepareStatement(query1);

            while (rs.next()){
                int prod_id = rs.getInt("prod_id");
                showProducts.setInt(1,prod_id);
                ResultSet res = showProducts.executeQuery();

                while (res.next()){
                    String prod_name = res.getString("prod_name");
                    double protein = res.getDouble("protein");
                    double carbohydrates = res.getDouble("protein");
                    double fats = res.getDouble("fats");
                    double calories = res.getDouble("calories");
                    double temp_weight = res.getDouble("temp_weight");

                    products.add(new Product(prod_id,prod_name,protein,carbohydrates,fats,calories,temp_weight));
                }
            }

        } catch(SQLException throwables){
            throwables.printStackTrace();
        }

        return products;
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

    public static void deleteSteps(int id){
        String query = "DELETE FROM steps WHERE rec_id = ?";

        try (Connection connection = DBconn.GetConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public static void deleteImgs(int step_id){
        String query = "DELETE FROM step_img WHERE step_id = ?";

        try (Connection connection = DBconn.GetConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, step_id);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public static void deleteProductsFromRec(int id){
        String query = "DELETE FROM prod_in_rec WHERE rec_id = ?";
        Recipe recipe = null;
        try (Connection connection = DBconn.GetConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    //показать картинку шага

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


    //добавить рецепт Recipe recipe
    public static void addRecipe(Recipe recipe){
        String query = "INSERT INTO recipes(rec_name,category,main_img,cooking_time,difficulty_level,favorite) VALUES(?,?,?,?,?,?)";
        try (Connection connection = DBconn.GetConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1,recipe.name);
            preparedStatement.setString(2, recipe.category);
            preparedStatement.setString(3,recipe.main_img);
            preparedStatement.setString(4,recipe.time);
            preparedStatement.setString(5,recipe.difficulty_level);
            preparedStatement.setInt(6,recipe.favorite);

            preparedStatement.executeUpdate();


        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }

    //добавить шаги рецепта

    public static void addStep(int rec_id, String step_text){
        String query = "INSERT INTO steps(rec_id,step_text) VALUES(?,?)";
        try (Connection connection = DBconn.GetConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {


            preparedStatement.setInt(1,rec_id);
            preparedStatement.setString(2, step_text);

            preparedStatement.executeUpdate();


        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }

    //добавить картинку рецепта

    public static void addStepImg(int step_id, String img_url){
        String query = "INSERT INTO step_img(step_id,img_url) VALUES(?,?)";
        try (Connection connection = DBconn.GetConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {


            preparedStatement.setInt(1,step_id);
            preparedStatement.setString(2, img_url);

            preparedStatement.executeUpdate();


        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }


    //добавить продукты в рецепт(создание связи в таблице)

    public static void addProductToRecipe(int prod_id, int rec_id, double weight){
        String query = "INSERT INTO prod_in_rec(prod_id,rec_id,weight) VALUES(?,?,?)";
        try (Connection connection = DBconn.GetConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {


            preparedStatement.setInt(1,prod_id);
            preparedStatement.setInt(2, rec_id);
            preparedStatement.setDouble(3, weight);

            preparedStatement.executeUpdate();


        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }



    //добавить продукт в базу  Product product

    public static void addProduct(Product product){
        String query = "INSERT INTO products(prod_name,protein,carbohydrates,fats,calories,temp_weight) " +
                "VALUES(?,?,?,?,?,?)";
        try (Connection connection = DBconn.GetConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {


            preparedStatement.setString(1, product.name);
            preparedStatement.setDouble(2, product.protein);
            preparedStatement.setDouble(3, product.carbohydrates);
            preparedStatement.setDouble(4, product.fats);
            preparedStatement.setDouble(5, product.calories);
            preparedStatement.setDouble(6, product.temp_weight);

            preparedStatement.executeUpdate();


        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }




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
        String query = "SELECT prod_id FROM prod_in_rec WHERE rec_id = ?";
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

    //поиск ингридиента по названию

    public static Product searchProduct(String prod_name) {
        String query = "SELECT * FROM products WHERE prod_name = ?";
        Product product = null;
        try (Connection connection = DBconn.GetConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, prod_name);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                int prod_id = rs.getInt("prod_id");
                double protein = rs.getDouble("protein");
                double carbohydrates = rs.getDouble("protein");
                double fats = rs.getDouble("fats");
                double calories = rs.getDouble("calories");
                double temp_weight = rs.getDouble("temp_weight");

                product = new Product(prod_id, prod_name, protein, carbohydrates, fats, calories, temp_weight);
            }





        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    //поиск рецепта по названию
    public static Recipe searchRecipe(String rec_name) {
        String query = "SELECT * FROM recipes WHERE rec_name = ?";
        Recipe recipe = null;
        try (Connection connection = DBconn.GetConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, rec_name);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String category = rs.getString("category");
                String main_img = rs.getString("main_img");
                String cooking_time = rs.getString("cooking_time");
                String difficulty_level = rs.getString("difficulty_level");
                int favorite = rs.getInt("favorite");

                recipe = new Recipe(id, rec_name, category, main_img, cooking_time, difficulty_level, favorite);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return recipe;
    }

    //удалить рецепт
    public static void deleteRecipe(int id) {
        String query = "DELETE FROM recipes WHERE id = ?";
        Recipe recipe = null;
        try (Connection connection = DBconn.GetConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        deleteSteps(id);
        deleteProductsFromRec(id);

    }

    public static void deleteFromCart(int id) {
        String query = "DELETE FROM cart WHERE prod_id = ?";
        Recipe product = null;
        try (Connection connection = DBconn.GetConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //обновить рецепт
    public static void updateRecipe(Recipe recipe) {
        String query =  "UPDATE recipes SET rec_name = ?,category = ?,main_img = ?,cooking_time = ?," +
                "difficulty_level = ?,favorite = ? WHERE id = ?";
        try (Connection connection = DBconn.GetConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, recipe.name);
            preparedStatement.setString(2, recipe.category);
            preparedStatement.setString(3, recipe.main_img);
            preparedStatement.setString(4, recipe.time);
            preparedStatement.setString(5, recipe.difficulty_level);
            preparedStatement.setInt(6, recipe.favorite);
            preparedStatement.setInt(7, recipe.id);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    //получение веса продукта
    public static Double showWeight(int rec_id, int prod_id) {
        String query =  "SELECT weight FROM prod_in_rec WHERE rec_id = ? AND prod_id = ?";
        Double weight = null;
        try (Connection connection = DBconn.GetConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, rec_id);
            preparedStatement.setInt(2, prod_id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                weight = rs.getDouble("weight");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return weight;

    }

    //показать корзину
    public static List<Product> showCart(){
        List<Product> products = new ArrayList<>();
        String query = "SELECT prod_id  FROM cart";
        String query1 = "SELECT * FROM products WHERE prod_id = ?";
        try (Connection connection = DBconn.GetConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();

            PreparedStatement showProducts = connection.prepareStatement(query1);

            while (rs.next()){
                int prod_id = rs.getInt("prod_id");
                showProducts.setInt(1,prod_id);
                ResultSet res = showProducts.executeQuery();

                while (res.next()){
                    String prod_name = res.getString("prod_name");
                    double protein = res.getDouble("protein");
                    double carbohydrates = res.getDouble("carbohydrates");
                    double fats = res.getDouble("fats");
                    double calories = res.getDouble("calories");
                    double temp_weight = res.getDouble("temp_weight");

                    products.add(new Product(prod_id,prod_name,protein,carbohydrates,fats,calories,temp_weight));
                }
            }

        } catch(SQLException throwables){
            throwables.printStackTrace();
        }

        return products;
    }

    //просмотр всех продуктов
    public static List<Product> showAllProducts(){
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products";
        try (Connection connection = DBconn.GetConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int id = rs.getInt("prod_id");
                String prod_name = rs.getString("prod_name");
                double protein = rs.getDouble("protein");
                double carbohydrates = rs.getDouble("carbohydrates");
                double fats = rs.getDouble("fats");
                double calories = rs.getDouble("calories");
                double temp_weight = rs.getDouble("temp_weight");


                products.add(new Product(id,prod_name,protein,carbohydrates, fats,calories,temp_weight));
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }

        return products;
    }
}
