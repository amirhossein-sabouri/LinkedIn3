package org.example.linkedin3.Model;

public class PhoneInfo extends Model {
    private String link;
    private String phonenumber;
    private String email;
    private String phonetype;

    public PhoneInfo(String link, String phonenumber, String email, String phonetype) {
        this.link = link;
        this.phonenumber = phonenumber;
        this.email = email;
        this.phonetype = phonetype;
    }

    public PhoneInfo() {

    }


    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonetype() {
        return phonetype;
    }

    public void setPhonetype(String phonetype) {
        this.phonetype = phonetype;
    }
    //birth_display_policy
    //instant communication

    @Override
    public String toString() {
        return "PhoneInfo{" +
                "link='" + link + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", email='" + email + '\'' +
                ", phonetype='" + phonetype + '\'' +
                '}';
    }
}

