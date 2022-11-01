package Package;

import java.util.ArrayList;

public class ListUI {

    //vectorul de obiecte
    public static ArrayList<RegisterUI> UserList = new ArrayList<RegisterUI>();
    //constructor
    public ListUI(){

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