import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MagazinJucarieUI {
    private static ArrayList<MagazinJucarii> ListaJucarii = new ArrayList<MagazinJucarii>();
    private JPanel panel1;
    private JLabel Nume;
    private JLabel pret;
    private JLabel NrPerJucarie;
    private JTextField Name;
    private JTextField Pret;
    private JTextField NrJucarie;
    private JButton button2;
    private JButton MAIESTEPESTOCButton;
    private JButton SCUMPESTEButton;
    private JButton Introduceti;
    private JLabel Screen;
    private JTextField Valoare;
    private JLabel PretScumpire;
    private JTextField SITexField;
    private JLabel SINrJucarie;
    private JLabel Message;
    private JLabel Message1;

    public MagazinJucarieUI(){
        Introduceti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MagazinJucarii MJ = new MagazinJucarii();
                MJ.setNume(Name.getText());
                MJ.setPret(Parsare(Pret));
                MJ.setNrPerJucarie(Parsare(NrJucarie));
                MagazinJucarieUI.ListaJucarii.add(MJ);

                Name.setText("");
                Pret.setText("");
                NrJucarie.setText("");


                Screen.setText(getList());
                Message.setVisible(false);
            }
        });

        SCUMPESTEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scumpire(Parsare(Valoare), Parsare(SITexField));


                Screen.setText(getList());
                Message.setVisible(false);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ieftinire(Parsare(Valoare), Parsare(SITexField));


                Screen.setText(getList());
                Message.setVisible(false);
            }
        });

        MAIESTEPESTOCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Check(MagazinJucarieUI.ListaJucarii, Parsare(SITexField))){
                    Message.setText(getJucarie(Parsare(SITexField)).toString());
                    Message.setVisible(true);
                    Message1.setText(getJucarie(Parsare(SITexField)).toString1());
                    Message1.setVisible(true);
                }
                else{
                    Message.setText("Nu exista deloc!!");
                    Message.setVisible(true);
                    Message1.setText("Nu exista deloc!!");
                    Message1.setVisible(true);
                }
                NrJucarie.setText("");
            }
        });
    }

    private boolean Check(ArrayList<MagazinJucarii> listaJucarii, int nrJucarie) {
        for(MagazinJucarii jucarie : MagazinJucarieUI.ListaJucarii){
            if(jucarie.getNrPerJucarie() == nrJucarie){
                return true;
            }
        }
        return false;
    }

    private int Parsare(JTextField textField){
        try
        {
            return Integer.parseInt(textField.getText());
        }
        catch(Exception ex)
        {
            System.out.println("NU ESTE UN INTREG!");
            return 0;
        }
    }

    public JPanel getPanel(){
        return panel1;
    }

    private String getList(){
        String msg= "";
        int i = 0;
        for(MagazinJucarii jucarie : MagazinJucarieUI.ListaJucarii){
            i++;
            msg = msg  +" " + i + ") " + jucarie.getNrPerJucarie() + " " + jucarie.getNume() + " " + jucarie.getPret() + "\n";
        }
        return msg;
    }

    private void Scumpire(int valoare, int nrJucarie)
    {
        for(MagazinJucarii jucarie : MagazinJucarieUI.ListaJucarii){
            if(jucarie.getNrPerJucarie() == nrJucarie){
                jucarie.setPret(jucarie.getPret()+valoare);
                break;
            }
        }
    }

    private void Ieftinire(int valoare, int nrJucarie){
        for(MagazinJucarii jucarie : MagazinJucarieUI.ListaJucarii)
        {
            if(jucarie.getNrPerJucarie() == nrJucarie)
            {
                jucarie.setPret(jucarie.getPret()-valoare);
                break;
            }
        }
    }

    private MagazinJucarii getJucarie(int nrJucarie){
        for(MagazinJucarii jucarie : MagazinJucarieUI.ListaJucarii)
        {
            if(jucarie.getNrPerJucarie() == nrJucarie)
            {
                return jucarie;
            }
        }
        return null;
    }

    public JTextField getPret(){
        return Pret;
    }
    public JTextField getNume(){
        return Name;
    }
    public JTextField getNrJucarii(){
        return NrJucarie;
    }
}
