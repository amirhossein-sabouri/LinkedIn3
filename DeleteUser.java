public void deleteUser(User user) throws SQLException {
    PreparedStatement statement = connection.prepareStatement("DELETE FROM Users WHERE id = ?");
    statement.setString(1, user.getId());
    statement.executeUpdate();