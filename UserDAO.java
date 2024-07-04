


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

        user.setCity(resultSet.getString("city"));
        user.setCountry(resultSet.getString("country"));
        user.setAdditionalName(resultSet.getString("additionalName"));
        user.setHeadLine(resultSet.getString("headline"));
        return user;
    }

    return null; // User not found
}
