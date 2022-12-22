package com.example.practice3;

public class UserAccount {
    private String IdToken;
    private String emailId;
    private String password;
    private String PhoneNumber;
    private String Name;
    private String CarNumber;


    public UserAccount(){ }

    public String getIdToken() { return IdToken; }
    public void setIdToken(String IdToken) { this.IdToken = IdToken; }

    public String getEmailId() { return emailId; }
    public void setEmailId(String emailId) { this.emailId = emailId; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPhoneNumber() { return PhoneNumber; }
    public void setPhoneNumber(String PhoneNumber) { this.PhoneNumber = PhoneNumber;}

    public String getName() { return Name; }
    public void setName(String Name) { this.Name = Name;}

    public String getCarNumber() { return CarNumber; }
    public void setCarNumber(String CarNumber) { this.CarNumber = CarNumber;}


}
