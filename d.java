public void updateUser(User user) throws SQLException {
    PreparedStatement statement = connection.prepareStatement("UPDATE users SET user_name = ?, name = ?, last_name = ?, email = ?, password = ?, skills = ?, posts = ?, currentPosition = ?, education = ?, city = ?, country = ?, additionalName = ?, headline = ?  WHERE id = ?");
    String skills = String.join(",", user.getSkills());
    try{
        // Serialize the object
        ByteArrayOutputStream bos1 = new ByteArrayOutputStream();
        ObjectOutputStream oos1 = new ObjectOutputStream(bos1);
        oos1.writeObject(user.getCurrentPosition());
        byte[] objectData1 = bos1.toByteArray();
        ByteArrayOutputStream bos2 = new ByteArrayOutputStream();
        ObjectOutputStream oos2 = new ObjectOutputStream(bos2);
        oos2.writeObject(user.getEducation());
        byte[] objectData2 = bos2.toByteArray();
        ByteArrayOutputStream bos3 = new ByteArrayOutputStream();
        ObjectOutputStream oos3 = new ObjectOutputStream(bos3);
        oos3.writeObject(user.getPosts());
        byte[] objectData3 = bos3.toByteArray();


        statement.setString(1, user.getUserName());
        statement.setString(2, user.getName());
        statement.setString(3, user.getLastName());
        statement.setString(4, user.getEmail());
        statement.setString(5, user.getPassWord());
        statement.setString(6, skills);
        statement.setBytes(7, objectData3);
        statement.setBytes(8, objectData1);
        statement.setBytes(9, objectData2);
        statement.setString(10, user.getCity());
        statement.setString(11, user.getCountry));
        statement.setString(12, user.getAdditionalName());
        statement.setString(13, user.getHeadLine());
    }
    catch(Exception e) {
        e.printStackTrace();
    }
    statement.executeUpdate();
}