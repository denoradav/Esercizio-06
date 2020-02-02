package beans;

public class User implements java.io.Serializable{
    private String usr;
    private String pwd;

    public User(){}
    public User(String usr, String pwd){
        this.usr=usr;
        this.pwd=pwd;
    }

    public String getUsr(){
        return usr;
    }

    public String getPwd(){
        return pwd;
    }

    public boolean canLog(String usr,String pwd){
        return getUsr().equals(usr) && getPwd().equals(pwd);
    }
}