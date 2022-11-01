public class RegisterUI {

    private String UserName;
    private String Password;
    private String ConfirmPassword;
    private String PinCode;

    public String getUserName() {
        return UserName;
    }
    public RegisterUI()
    {

    }
    public RegisterUI(String UserName, String Password, String ConfirmPassword, String PinCode)
    {
        this.UserName = UserName;
        this.Password = Password;
        this.ConfirmPassword = ConfirmPassword;
        this.PinCode = PinCode;
    }

    public void setUserName(String userName) {
        this.UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.ConfirmPassword = confirmPassword;
    }

    public String getPinCode() {
        return PinCode;
    }

    public void setPinCode(String pinCode) {
       this.PinCode = pinCode;
    }
}