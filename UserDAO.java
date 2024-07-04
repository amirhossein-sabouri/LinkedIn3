public void updateUser(User user) throws SQLException {
    PreparedStatement statement = connection.prepareStatement("UPDATE users SET user_name = ?, name = ?, last_name = ?, email = ?, password = ?, skills = ?, posts = ?, currentPosition = ?, education = ?, city = ?, country = ?, additionalName = ?, headline = ?, phone_info = ?  WHERE id = ?");
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
        byte[] objectData4 = bos4.toByteArray();
        ByteArrayOutputStream bos4 = new ByteArrayOutputStream();
        ObjectOutputStream oos4 = new ObjectOutputStream(bos4);
        oos4.writeObject(user.getPhoneInfo());
        byte[] objectData4 = bos4.toByteArray();


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
        statement.setString(14, objectData4);
    }
    catch(Exception e) {
        e.printStackTrace();
    }
    statement.executeUpdate();
}

public User getUserById(String userId) throws SQLException, IOException, ClassNotFoundException {
    PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
    statement.setString(1, userId);
    ResultSet resultSet = statement.executeQuery();

    if (resultSet.next()) {
        User user = new User();
        user.setId(resultSet.getString("id"));
        user.setUserName(resultSet.getString("userName"));
        user.setName(resultSet.getString("name"));
        user.setLastName(resultSet.getString("last_name"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        //skills
        String skillsDAO = resultSet.getString("skills");
        ArrayList<String> skillsList  = new ArrayList<>();
        String[] skillsArr = skillsDAO.split(",");
        for (String skill : skillsArr) {
            skillsList.add(skill.trim()); // trim() to remove leading/trailing spaces
        }
        user.setSkills(skillsList);
        //posts
        byte[] serializedData1 = resultSet.getBytes("posts");
        ByteArrayInputStream bis1 = new ByteArrayInputStream(serializedData1);
        ObjectInputStream ois1 = new ObjectInputStream(bis1);
        ArrayList<Post> posts = (ArrayList<Post>) ois1.readObject();
        user.setPosts(posts);
        //currentPos
        byte[] serializedData2 = resultSet.getBytes("currentPosition");
        ByteArrayInputStream bis2 = new ByteArrayInputStream(serializedData2);
        ObjectInput in1 = new ObjectInputStream(bis2);
        JobPosition position = (JobPosition) in1.readObject();
        user.setCurrentPosition(position);
        //edu
        byte[] serializedData3 = resultSet.getBytes("education");
        ByteArrayInputStream bis3 = new ByteArrayInputStream(serializedData3);
        ObjectInput in2 = new ObjectInputStream(bis3);
        Education edu = (Education) in2.readObject();
        user.setEducation(edu);
        //phoneInfo
        byte[] serializedData4 = resultSet.getBytes("phone_info");
        ByteArrayInputStream bis4 = new ByteArrayInputStream(serializedData4);
        ObjectInput in3 = new ObjectInputStream(bis4);
        PhoneInfo info = (PhoneInfo) in3.readObject();
        user.setPhoneInfo(info);

        user.setCity(resultSet.getString("city"));
        user.setCountry(resultSet.getString("country"));
        user.setAdditionalName(resultSet.getString("additionalName"));
        user.setHeadLine(resultSet.getString("headline"));

        return user;
    }

    return null; // User not found
}

public User getUserByEmail(String userEmail) throws SQLException, IOException, ClassNotFoundException {
    PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ?");
    statement.setString(1, userEmail);
    ResultSet resultSet = statement.executeQuery();

    if (resultSet.next()) {
        User user = new User();
        user.setId(resultSet.getString("id"));
        user.setUserName(resultSet.getString("userName"));
        user.setName(resultSet.getString("name"));
        user.setLastName(resultSet.getString("last_name"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        //skills
        String skillsDAO = resultSet.getString("skills");
        ArrayList<String> skillsList  = new ArrayList<>();
        String[] skillsArr = skillsDAO.split(",");
        for (String skill : skillsArr) {
            skillsList.add(skill.trim()); // trim() to remove leading/trailing spaces
        }
        user.setSkills(skillsList);
        //posts
        byte[] serializedData1 = resultSet.getBytes("posts");
        ByteArrayInputStream bis1 = new ByteArrayInputStream(serializedData1);
        ObjectInputStream ois1 = new ObjectInputStream(bis1);
        ArrayList<Post> posts = (ArrayList<Post>) ois1.readObject();
        user.setPosts(posts);
        //currentPos
        byte[] serializedData2 = resultSet.getBytes("currentPosition");
        ByteArrayInputStream bis2 = new ByteArrayInputStream(serializedData2);
        ObjectInput in1 = new ObjectInputStream(bis2);
        JobPosition position = (JobPosition) in1.readObject();
        user.setCurrentPosition(position);
        //edu
        byte[] serializedData3 = resultSet.getBytes("education");
        ByteArrayInputStream bis3 = new ByteArrayInputStream(serializedData3);
        ObjectInput in2 = new ObjectInputStream(bis3);
        Education edu = (Education) in2.readObject();
        user.setEducation(edu);
        //phoneInfo
        byte[] serializedData4 = resultSet.getBytes("phone_info");
        ByteArrayInputStream bis4 = new ByteArrayInputStream(serializedData4);
        ObjectInput in3 = new ObjectInputStream(bis4);
        PhoneInfo info = (PhoneInfo) in3.readObject();
        user.setPhoneInfo(info);

        user.setCity(resultSet.getString("city"));
        user.setCountry(resultSet.getString("country"));
        user.setAdditionalName(resultSet.getString("additionalName"));
        user.setHeadLine(resultSet.getString("headline"));
        return user;
    }

    return null; // User not found
}





public ArrayList<User> getUsers() throws SQLException, IOException, ClassNotFoundException {
    ArrayList<User> users = new ArrayList<User>();
    PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");
    ResultSet resultSet = statement.executeQuery();
    while (resultSet.next()) {
        User user = new User();
        user.setId(resultSet.getString("id"));
        user.setUserName(resultSet.getString("userName"));
        user.setName(resultSet.getString("name"));
        user.setLastName(resultSet.getString("last_name"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        //skills
        String skillsDAO = resultSet.getString("skills");
        ArrayList<String> skillsList  = new ArrayList<>();
        String[] skillsArr = skillsDAO.split(",");
        for (String skill : skillsArr) {
            skillsList.add(skill.trim()); // trim() to remove leading/trailing spaces
        }
        user.setSkills(skillsList);
        //posts
        byte[] serializedData1 = resultSet.getBytes("posts");
        ByteArrayInputStream bis1 = new ByteArrayInputStream(serializedData1);
        ObjectInputStream ois1 = new ObjectInputStream(bis1);
        ArrayList<Post> posts = (ArrayList<Post>) ois1.readObject();
        user.setPosts(posts);
        //currentPos
        byte[] serializedData2 = resultSet.getBytes("currentPosition");
        ByteArrayInputStream bis2 = new ByteArrayInputStream(serializedData2);
        ObjectInput in1 = new ObjectInputStream(bis2);
        JobPosition position = (JobPosition) in1.readObject();
        user.setCurrentPosition(position);
        //edu
        byte[] serializedData3 = resultSet.getBytes("education");
        ByteArrayInputStream bis3 = new ByteArrayInputStream(serializedData3);
        ObjectInput in2 = new ObjectInputStream(bis3);
        Education edu = (Education) in2.readObject();
        user.setEducation(edu);
        //phoneInfo
        byte[] serializedData4 = resultSet.getBytes("phone_info");
        ByteArrayInputStream bis4 = new ByteArrayInputStream(serializedData4);
        ObjectInput in3 = new ObjectInputStream(bis4);
        PhoneInfo info = (PhoneInfo) in3.readObject();
        user.setPhoneInfo(info);

        user.setCity(resultSet.getString("city"));
        user.setCountry(resultSet.getString("country"));
        user.setAdditionalName(resultSet.getString("additionalName"));
        user.setHeadLine(resultSet.getString("headline"));
        users.add(user);
    }

    return users;
}
