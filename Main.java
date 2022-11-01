public class Main {
    public static  RegisterInterface UI = new RegisterInterface();
    public static  MagazinJucarieUI MUI = new MagazinJucarieUI();
    public static void main(String[] args){
        LoginInterface LUI = new LoginInterface();
        RegisterInterface.main.setContentPane(UI.registerPanel);
        LoginInterface.main.setContentPane(LUI.getSecPanel());
        MagazinJucarieUI.main.setContentPane(MUI.panel1);

        LoginInterface.main.pack();
        RegisterInterface.main.pack();
        MagazinJucarieUI.main.pack();

        LoginInterface.main.setVisible(true);
    }
}
