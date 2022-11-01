import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Package.*;

public class LoginInterface extends Component {

    private JTextField tfUserName;
    private JPasswordField pfPassWord;

    private JButton bntLogIn;
    private JButton btnReg;
    private JPanel secPanel;

    private static LoginInterface LUI ;

    public static JFrame main = new JFrame();


    public boolean isEmpty(){
        //verificare daca textfieldurile pentru username sau parola sunt goale
        //daca da, se va afisa panelul cu eroarea "please enter all fields"
        if(tfUserName.getText().equals("")||pfPassWord.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "Please enter all fields",
                    "Try Again",
                    JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
    }

    public boolean isUsername(String username){
        //metoda ce verificare egalitatea intre username-ul ce l-ai introdus in registerInterface
        // si username-ul ce il introduci in login Interface

        if(!tfUserName.getText().equals(username)){
            JOptionPane.showMessageDialog(this,
                    "Username is Incorect",
                    "Try Again",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;

    }

    public boolean isPassword(String password){
        //metoda ce verificare egalitatea intre parola ce ai introdus-o in registerInterface
        // si parola ce o introduci in login Interface
        if(!pfPassWord.getText().equals(password)){
            JOptionPane.showMessageDialog(this,
                    "Password is Incorect",
                    "Try Again",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public void isSuccesFull(){
        //metoda afisarii mesajului de logare cu succes
        JOptionPane.showMessageDialog(this,
                "Welcome \n Login Succesfull!",
                "Succes",
                JOptionPane.INFORMATION_MESSAGE);
    }
    public void isNotSuccesFull(){
        //metoda afisarii mesajului de logare fara succes
        JOptionPane.showMessageDialog(this,
                "User Does Not Exist!",
                "Try Again",
                JOptionPane.ERROR_MESSAGE);
    }

    public JPanel getSecPanel(){

        return secPanel;
    }

    public LoginInterface() {
        bntLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isEmpty()){
                    for(RegisterUI i : ListUI.getUserList()){

                        if(isPassword(i.getPassword())) {
                            isSuccesFull();
                            MagazinJucarieUI.main.setVisible(true);
                            main.setVisible(false);

                            return;
                        }

                    }
                    isNotSuccesFull();

                }

            }
        });
        btnReg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setVisible(false);
                RegisterInterface.main.setVisible(true);

            }
        });
    }
}
