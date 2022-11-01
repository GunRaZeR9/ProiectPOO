package Package;

import java.util.ArrayList;

public class ListUI extends RegisterUI{

    //vectorul de obiecte
    public static ArrayList<RegisterUI> UserList = new ArrayList<RegisterUI>();
    private String UserName;
    //constructor
    public ListUI(){

    }
    @Override //polimorfism, suprascrierea metodei getUserName
    public String getUserName() {
        return UserName;
    }

    public void setUserList(RegisterUI user){

        UserList.add(user);
    }
    public static  ArrayList<RegisterUI> getUserList(){

        return UserList;
    }
    public String toString(){
        StringBuffer msg = new StringBuffer();
        return msg.toString();
    }




}