package org.example.linkedin3.DataBase;
import org.example.linkedin3.Model.Education;
import org.example.linkedin3.Model.JobPosition;
import org.example.linkedin3.Model.Post;
import org.example.linkedin3.Model.User;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.example.linkedin3.DataBase.DataBase.closeConnection;


public class UserDAO {
    private final Connection connection;
    public UserDAO() throws SQLException {
        connection = DatabaseConnectionManager.getConnection();
        createUserTable();
    }
    public void createUserTable() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("CREATE TABLE users (\n" +
                "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    username VARCHAR(255) NOT NULL,\n" +
                "    name VARCHAR(255) NOT NULL,\n" +
                "    lastname VARCHAR(255) NOT NULL,\n" +
                "    email VARCHAR(255) NOT NULL,\n" +
                "    password VARCHAR(255) NOT NULL,\n" +
                "    skills VARCHAR(255),\n" +
                "    posts JSON,\n" +
                "    currentPosition JSON,\n" +
                "    education JSON,\n" +
                "    city VARCHAR(255),\n" +
                "    country VARCHAR(255),\n" +
                "    additionalName VARCHAR(255),\n" +
                "    headline VARCHAR(255)\n" +
                ");\n");
        statement.executeUpdate();
    }
    public ArrayList<User> getUsers() throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("first_name"));
            user.setLastname(resultSet.getString("last_name"));
            user.setEmail(resultSet.getString("email"));
            user.setCity(resultSet.getString("city"));
            user.setPassword(resultSet.getString("password"));
            user.setCountry(resultSet.getString("country"));
            user.setAdditionalName(resultSet.getString("additionalName"));
            user.setHeadline(resultSet.getString("headline"));

            // Handle the posts column
            String postsJson = resultSet.getString("posts");
            Gson gson = new Gson();
            Post[] posts = gson.fromJson(postsJson, Post[].class);
            user.setPosts(new ArrayList<>(Arrays.asList(posts)));

            // Handle the skills column
            String skillsString = resultSet.getString("skills");
            String[] skillsArray = skillsString.split(",");
            user.setSkills(new ArrayList<>(Arrays.asList(skillsArray)));

            // Handle the education column
            String educationJson = resultSet.getString("education");
            Education education = gson.fromJson(educationJson, Education.class);
            user.setEducation(education);

            // Handle the currentPosition column
            String currentPositionJson = resultSet.getString("currentPosition");
            JobPosition currentPosition = gson.fromJson(currentPositionJson, JobPosition.class);
            user.setCurrentPosition(currentPosition);

            users.add(user);
        }

        return users;
    }
    public void updateUser(User user) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("UPDATE users SET username = ?, name = ?,lastname " +
                "= ?, email = ?,password = ?,skills = ?,posts = ?,currentPosition = ?,education = ?,city = ?,country = ?," +
                " additionalName = ?,headline = ?");
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getName());
        statement.setString(3, user.getLastname());
        statement.setString(4, user.getEmail());
        statement.setString(5, user.getPassword());
        statement.setString(6, String.join(",", user.getSkills()));
        Gson gson = new Gson();
        String postsJson = gson.toJson(user.getPosts());
        statement.setString(7, postsJson);
        String currentPositionJson = gson.toJson(user.getCurrentPosition());
        statement.setString(8, currentPositionJson);
        String educationJson = gson.toJson(user.getEducation());
        statement.setString(9, educationJson);
        statement.setString(10, user.getCity());
        statement.setString(11, user.getCountry());
        statement.setString(12, user.getAdditionalName());
        statement.setString(13, user.getHeadline());
        statement.executeUpdate();
        ResultSet resultSet = statement.getGeneratedKeys();
        resultSet.next();
        int id = resultSet.getInt(1);
        statement.executeUpdate();
        connection.close();

    }
    public void deleteUser(User user) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE id = ?");
        statement.setInt(1, user.getId());
        statement.executeUpdate();
    }
    public void deleteUsers() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM users");
        statement.executeUpdate();
    }


//    public class UserDAO {
//        private final Connection connection;
//
//        public UserDAO(Connection connection) {
//            this.connection = connection;
//        }

//        public ArrayList<User> getUsers() throws SQLException {
//            ArrayList<User> users = new ArrayList<>();
//            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                User user = new User();
//                user.setId(resultSet.getInt("id"));
//                user.setName(resultSet.getString("first_name"));
//                user.setLastname(resultSet.getString("last_name"));
//                user.setEmail(resultSet.getString("email"));
//                user.setCity(resultSet.getString("city"));
//                user.setPassword(resultSet.getString("password"));
//                user.setCountry(resultSet.getString("country"));
//                user.setAdditionalName(resultSet.getString("additionalName"));
//                user.setHeadline(resultSet.getString("headline"));
//
//                // Handle the posts column
//                String postsJson = resultSet.getString("posts");
//                Gson gson = new Gson();
//                Post[] posts = gson.fromJson(postsJson, Post[].class);
//                user.setPosts(new ArrayList<>(Arrays.asList(posts)));
//
//                // Handle the skills column
//                String skillsString = resultSet.getString("skills");
//                String[] skillsArray = skillsString.split(",");
//                user.setSkills(new ArrayList<>(Arrays.asList(skillsArray)));
//
//                // Handle the education column
//                String educationJson = resultSet.getString("education");
//                Education education = gson.fromJson(educationJson, Education.class);
//                user.setEducation(education);
//
//                // Handle the currentPosition column
//                String currentPositionJson = resultSet.getString("currentPosition");
//                JobPosition currentPosition = gson.fromJson(currentPositionJson, JobPosition.class);
//                user.setCurrentPosition(currentPosition);
//
//                users.add(user);
//            }
//
//            return users;
//        }
//    }

//    public ArrayList<User> getUsers() throws SQLException {
//        ArrayList<User> users = new ArrayList<User>();
//        PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");
//        ResultSet resultSet = statement.executeQuery();
//        while (resultSet.next()) {
//            User user = new User();
//            user.setId(resultSet.getInt("id"));
//            user.setName(resultSet.getString("first_name"));
//            user.setLastname(resultSet.getString("last_name"));
//            user.setEmail(resultSet.getString("email"));
//            user.setCity(resultSet.getString("city"));
//            user.setPassword(resultSet.getString("password"));
//            user.setCountry(resultSet.getString("country"));
//            user.setAdditionalName(resultSet.getString("additionalName"));
//            user.setHeadline(resultSet.getString("headline"));
//
//
//            users.add(user);
//        }
//
//        return users;
//    }
}
