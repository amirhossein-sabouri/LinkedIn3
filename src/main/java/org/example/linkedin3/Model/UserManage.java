package org.example.linkedin3.Model;


import java.util.ArrayList;

public class UserManage extends Model {
    private ArrayList<User> userlist;
    private ArrayList<Follow> follows_list;
    private ArrayList<Connect> connect_list;

    public UserManage(ArrayList<User> userlist, ArrayList<Follow> follows_list, ArrayList<Connect> connect_list) {
        this.userlist = userlist;
        this.follows_list = follows_list;
        this.connect_list = connect_list;
    }

    public ArrayList<User> getUserlist() {
        return userlist;
    }

    public void setUserlist(ArrayList<User> userlist) {
        this.userlist = userlist;
    }

    public ArrayList<Follow> getFollows_list() {
        return follows_list;
    }

    public void setFollows_list(ArrayList<Follow> follows_list) {
        this.follows_list = follows_list;
    }

    public ArrayList<Connect> getConnect_list() {
        return connect_list;
    }

    public void setConnect_list(ArrayList<Connect> connect_list) {
        this.connect_list = connect_list;
    }

    @Override
    public String toString() {
        return "UserManage{" +
                "userlist=" + userlist +
                ", follows_list=" + follows_list +
                ", connect_list=" + connect_list +
                '}';
    }
}
