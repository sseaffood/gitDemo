/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.human;

/**
 *
 * @author 84904
 */
public class ERROR {
    private String humanIDError;
    private String humanNameError;
    private String roleIDError;
    private String uHumanError;
    private String passwordError;
    private String genderError;
    private String confirmError;
    private String error;
    private String typeIdError;

    public ERROR() {
    }

    public ERROR(String humanIDError, String humanNameError, String roleIDError, String uHumanError, String passwordError, String genderError, String confirmError, String error) {
        this.humanIDError = humanIDError;
        this.humanNameError = humanNameError;
        this.roleIDError = roleIDError;
        this.uHumanError = uHumanError;
        this.passwordError = passwordError;
        this.genderError = genderError;
        this.confirmError = confirmError;
        this.error = error;
    }

    public String getHumanIDError() {
        return humanIDError;
    }

    public void setHumanIDError(String humanIDError) {
        this.humanIDError = humanIDError;
    }

    public String getHumanNameError() {
        return humanNameError;
    }

    public void setHumanNameError(String humanNameError) {
        this.humanNameError = humanNameError;
    }

    public String getRoleIDError() {
        return roleIDError;
    }

    public void setRoleIDError(String roleIDError) {
        this.roleIDError = roleIDError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getConfirmError() {
        return confirmError;
    }

    public void setConfirmError(String confirmError) {
        this.confirmError = confirmError;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getGenderError() {
        return genderError;
    }

    public void setGenderError(String genderError) {
        this.genderError = genderError;
    }

    public String getuHumanError() {
        return uHumanError;
    }

    public void setuHumanError(String uHumanError) {
        this.uHumanError = uHumanError;
    }

    public String getTypeIdError() {
        return typeIdError;
    }

    public void setTypeIdError(String typeIdError) {
        this.typeIdError = typeIdError;
    }

}