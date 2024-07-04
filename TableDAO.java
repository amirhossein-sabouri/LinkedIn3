public void createUserTable() throws SQLException {
    PreparedStatement statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS users (id VARCHAR(36) PRIMARY KEY, userName VARCHAR(255), first_name VARCHAR(255), last_name VARCHAR(255), email VARCHAR(255), password VARCHAR(255), skills VARCHAR(255), posts BLOB, currentPosition  BLOB, education BLOB, city VARCHAR(50), country VARCHAR(50), additionalName VARCHAR(50), headLine VARCHAR(255), phone_info BLOB");
    statement.executeUpdate();
}