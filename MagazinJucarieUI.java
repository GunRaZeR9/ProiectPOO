import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Package.*;
public class MagazinJucarieUI {
    private static ArrayList<MagazinJucarii> ListaJucarii = new ArrayList<MagazinJucarii>();
    public JPanel panel1;
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
    private JButton button1;
    private JLabel Message1;

    public static JFrame main = new JFrame();
    public static MagazinJucarieUI MUI = new MagazinJucarieUI();

    public MagazinJucarieUI(){
        Introduceti.addActionListener(new ActionListener() {
            // in acest buton, dupa scrierea in textfieldurile Name,Pret si NrJucarie, dupa apasarea acestuia,
            // se va introduce in Labelul " Screen", unde se va seta textul cu proprietatile obiectului curent.
            // Tot in momentul apasarii, se vor goli textfiedurile.
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
            //in acest buton, se scumpeste pretul obiectului
            @Override
            public void actionPerformed(ActionEvent e) {
                Scumpire(Parsare(Valoare), Parsare(SITexField));


                Screen.setText(getList());
                Message.setVisible(false);
            }
        });
        button2.addActionListener(new ActionListener() {
            //in acest buton, se ieftineste pretul obiectului
            @Override
            public void actionPerformed(ActionEvent e) {
                Ieftinire(Parsare(Valoare), Parsare(SITexField));


                Screen.setText(getList());
                Message.setVisible(false);
            }
        });

        MAIESTEPESTOCButton.addActionListener(new ActionListener() {
            //in acest buton, se afiseaza mesajul daca mai este pe stoc sau nu, respectiv datele obiectului
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

    //verificare daca ID-ul jucariei respective pe care vrem sa o cautam este egala cu ID-UL unei jucarii
    //care face parte deja din vectorul de obiecte ArrayList "listaJucarii"
    private boolean Check(ArrayList<MagazinJucarii> listaJucarii, int nrJucarie) {
        for(MagazinJucarii jucarie : MagazinJucarieUI.ListaJucarii){
            if(jucarie.getNrPerJucarie() == nrJucarie){
                return true;
            }
        }
        return false;
    }

    //transformare in Integer, daca nu se poate face in try, se va afisa mesajul " NU ESTE UN INTREG"
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

    // metoda de get, panel1 este private
    public JPanel getPanel(){
        return panel1;
    }

    //pentru Label "Screen" care afiseaza elementele vectorului de obiecte
    private String getList(){
        String msg= "";
        int i = 0;
        for(MagazinJucarii jucarie : MagazinJucarieUI.ListaJucarii){
            i++;
            msg = msg  +" " + i + ") " + jucarie.getNrPerJucarie() + " " + jucarie.getNume() + " " + jucarie.getPret() + "\n";
        }
        return msg;
    }

    //metoda de scumpire ce se foloseste pentru butonul SCUMPIRE.

    //verifica mai intai daca ID-ul jucariei pe care vrei sa o cauti daca este egal cu ID-ul unei jucarii
    //existente .In caz afirmativ, se va seta pretul jucariei obiectului curent adunand cu valoarea respective.
    private void Scumpire(int valoare, int nrJucarie)
    {
        for(MagazinJucarii jucarie : MagazinJucarieUI.ListaJucarii){
            if(jucarie.getNrPerJucarie() == nrJucarie){
                jucarie.setPret(jucarie.getPret()+valoare);
                break;
            }
        }
    }

    //metoda de ieftinire ce se foloseste pentru butonul IEFTINIRE.

    //verifica mai intai daca ID-ul jucariei pe care vrei sa o cauti daca este egal cu ID-ul unei jucarii
    //existente .In caz afirmativ, se va seta pretul jucariei obiectului curent scazand cu valoarea respectiva.

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

    //metode de get pentru a returna valorile campurilor private.
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
