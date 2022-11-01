import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Package.*;
public class RegisterInterface extends JDialog {

    private JTextField tfPinCode;
    private JPasswordField pfPassword;
    private JPasswordField pfConfirmPassword;
    private JButton btnRegister;
    private JButton btnBack;

    public  JPanel registerPanel;
    private JTextField tfUsername;


    public static JFrame main = new JFrame("Register");

    public static RegisterInterface UI = new RegisterInterface();
    public ListUI ListUI = new ListUI();

    public RegisterInterface() {
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterUser();
            }
        });
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setVisible(false);
                LoginInterface.main.setVisible(true);
            }
        });


    }
    public boolean PasswordMatch(){

        if(!pfPassword.getText().equals(pfConfirmPassword.getText())){
            JOptionPane.showMessageDialog(this,
                    "Passwords don't match!",
                    "Try Again",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean EmptyFields(){

        if(tfUsername.getText().equals("")||pfPassword.getText().equals("")|| pfConfirmPassword.getText().equals("")||tfPinCode.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "Please enter all fields",
                    "Try Again",
                    JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
    }

    public boolean SuccessfullRegistration(){
        JOptionPane.showMessageDialog(this,
                "User Successfully Registred",
                "REGISTRED!",
                JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    private void RegisterUser(){
        RegisterUI RUI = new RegisterUI();
        RUI.setUserName(UI.tfUsername.getText());
        RUI.setPassword(String.valueOf(pfPassword.getText()));
        RUI.setConfirmPassword(String.valueOf(pfConfirmPassword.getText()));
        RUI.setPinCode(UI.tfPinCode.getText());
        new ListUI().setUserList(RUI);
        ArrayList<RegisterUI> a = ListUI.getUserList();
        //Parcurgerea Listei Returnata in Var a din clasa ListUi
        if(PasswordMatch() && !EmptyFields()) {
            for (RegisterUI i : a) {
                System.out.println(i.getUserName());
                System.out.println(i.getPassword());
                System.out.println(i.getConfirmPassword());
                System.out.println(i.getPinCode());
                SuccessfullRegistration();

            }
        }


    }

}
