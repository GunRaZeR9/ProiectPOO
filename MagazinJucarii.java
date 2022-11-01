public class MagazinJucarii
{
    //campuri ce se stocheaza in heap
    private String nume;
    private int pret=0;
    private int NrPerJucarie=0;
    private final int MAXIM_NrPerJucarie= 5;

    //constructor ce initializeaza campurile clasei
    public MagazinJucarii(String nume, int pret, int IDprodus, int NrPerJucarie)
    {
        this.nume = nume; //referinta catre obiectul curent
        this.pret = pret;
        this.NrPerJucarie = NrPerJucarie;
    }

    public MagazinJucarii(){

    }

    // in metoda vanzare, returneaza adevarat daca sunt pe stoc mai mult de 5 produse(in acest magazin este obligatoriu sa ramana 5 produse pentru reclama!)
    //altfel, returneaza false daca sunt mai putin de 5 produse. aceasta functie ajuta la metoda toString()
    public boolean vanzare(int NrPerJucarie)
    {
        if(MAXIM_NrPerJucarie > NrPerJucarie)
            return false;
        else
        {
            return true;
        }
    }
    //verificarea pretului daca este mai mic decat 0 sau mai mare
    public boolean verificare(int pret)
    {
        if(pret < 0 )
            return false;
        else
        {
            return true;
        }
    }
    // scade pretul curent cu o anumita valoare "sold" data la tastatura
    public void ieftinire(int sold)
    {
        pret -= sold;
    }

    // aduna pretul curent cu o anumita valoare "sold" data la tastatura
    public void scumpire(int sold)
    {
        pret +=sold;

    }
    //afisarea mesajului pentru a determina daca o anumita jucarie este sau nu pe stoc.
    public String toString()
    {
        String msg = "Jucaria ";
        msg += nume;
        if(vanzare(NrPerJucarie))
        {
            msg += " mai este in stoc cu ";
            msg += NrPerJucarie;
            msg += " produse";
        }
        else
        {
            msg += " nu mai este in stoc deoarece";
            msg += NrPerJucarie;
            msg += "<" + MAXIM_NrPerJucarie + ", ceea ce nu pot sa fie vandute!";
        }
        return msg;
    }
    public String toString1()
    {
        StringBuffer msg = new StringBuffer();
        msg.append("Jucaria ");
        msg.append(nume);
        msg.append(" cu ID-ul ");
        msg.append(NrPerJucarie);
        msg.append(" are pretul de ");
        msg.append(pret);
        return msg.toString();
    }

    //incapsularea presupune ascunderea datelor ale unui obiect, de aceea se folosesc metodele publice GET(returnarea unei valori al unei date private) si SET(atribuirea unei date private o anumita valoare)

    public String getNume()
    {
        return this.nume;
    }
    public int getPret()
    {
        return this.pret;
    }
    public int getNrPerJucarie()
    {
        return this.NrPerJucarie;
    }
    public void setNume(String nume)
    {
        this.nume = nume;
    }
    public void setPret(int pret)
    {
        this.pret = pret;
    }

    public void setNrPerJucarie(int NrPerJucarie)
    {
        this.NrPerJucarie = NrPerJucarie;
    }


}