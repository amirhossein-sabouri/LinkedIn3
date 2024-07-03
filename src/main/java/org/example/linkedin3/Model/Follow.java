package org.example.linkedin3.Model;

public class Follow extends Model {
    private User follower;
    private User followed;

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }

    public User getFollowed() {
        return followed;
    }

    public void setFollowed(User followed) {
        this.followed = followed;
    }

    public Follow(User follower, User followed) {
        this.follower = follower;
        this.followed = followed;
    }

    public Follow() {

    }

    @Override
    public String toString() {
        return "Follow{" +
                "follower=" + follower +
                ", followed=" + followed +
                '}';
    }
}