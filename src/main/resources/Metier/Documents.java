package Metier;
public class Documents {
    private int reference ;
     private String titre;
     
    public Documents(int reference, String titre) {
        this.reference = reference;
        this.titre = titre;
    }
    public Documents(int reference) {
        this.reference = reference;
        
    }
    
    public int getReference() {
        return reference;
    }

    public String getTitre() {
        return titre;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}

