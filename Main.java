public class Main {
    public static  RegisterInterface UI = new RegisterInterface();
    public static void main(String[] args){
        LoginInterface LUI = new LoginInterface();
        RegisterInterface.main.setContentPane(UI.registerPanel);
        LoginInterface.main.setContentPane(LUI.getSecPanel());

        LoginInterface.main.pack();
        RegisterInterface.main.pack();

        LoginInterface.main.setVisible(true);
    }
}
