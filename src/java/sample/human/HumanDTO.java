/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.human;

import java.sql.Date;

/**
 *
 * @author 84904
 */
public class HumanDTO {
     private String humanID;
    private String humanName;
    private Date dob;
    private boolean gender;
    private int typeId;
    private String userHuman;
    private String passHuman;
    private String role;

    public HumanDTO() {
    }

    public HumanDTO(String humanID, String humanName, Date dob, boolean gender, int typeId, String userHuman, String passHuman, String role) {
        this.humanID = humanID;
        this.humanName = humanName;
        this.dob = dob;
        this.gender = gender;
        this.typeId = typeId;
        this.userHuman = userHuman;
        this.passHuman = passHuman;
        this.role = role;
    }

    public String getHumanID() {
        return humanID;
    }

    public void setHumanID(String humanID) {
        this.humanID = humanID;
    }

    public String getHumanName() {
        return humanName;
    }

    public void setHumanName(String humanName) {
        this.humanName = humanName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getUserHuman() {
        return userHuman;
    }

    public void setUserHuman(String userHuman) {
        this.userHuman = userHuman;
    }

    public String getPassHuman() {
        return passHuman;
    }

    public void setPassHuman(String passHuman) {
        this.passHuman = passHuman;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
}
