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
        JOptionPane.showMessageDialog(this,
                "Welcome \n Login Succesfull!",
                "Succes",
                JOptionPane.INFORMATION_MESSAGE);
    }
    public void isNotSuccesFull(){
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
