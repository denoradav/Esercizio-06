package beans;



public class Utente implements java.io.Serializable{
    private String nome;
    private String cognome;
    private int annoDiNascita;

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCognome(String cognome){
        this.cognome = cognome;
    }

    public void setAnnoDiNascita(int anno){
        annoDiNascita=anno;
    }

    public Utente(){}

    public Utente(String nome,String cognome, int anno){
        this.cognome=cognome;
        this.nome=nome;
        annoDiNascita = anno;
    }

    public String getNome(){
        return nome;
    }

    public String getCognome(){
        return cognome;
    }

    public int getAnnoDiNascita(){
        return annoDiNascita;
    }
}