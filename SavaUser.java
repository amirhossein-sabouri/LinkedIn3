





public void saveUser(String name, String lastName, String userName, String email, String password) throws SQLException {
    PreparedStatement statement = connection.prepareStatement("INSERT INTO Users (userName, first_name, last_name, email, password, skills, posts, currentPosition, education, city , country, additionalName, headLine, phone_info) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
    statement.setString(1, userName);
    statement.setString(2, name);
    statement.setString(3, lastName);
    statement.setString(4, email);
    statement.setString(5, password);
    statement.setString(6, null;
    statement.setString(7, null);
    statement.setString(8, null);
    statement.setString(9, null);
    statement.setString(10, null);
    statement.setString(11, null);
    statement.setString(12, null);
    statement.setString(13, null);
    statement.setString(14, null);

    statement.executeUpdate();
}