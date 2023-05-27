
package Metier;

public class Livres extends Documents{
    private String autheur;
    private int pages;

    public Livres(int reference, String titre, String autheur, int pages) {
        super(reference, titre);
        this.autheur = autheur;
        this.pages = pages;
    }

    public Livres(int reference) {
        super(reference);
    }
    

    public String getAutheur() {
        return autheur;
    }

    public int getPages() {
        return pages;
    }
     String Description(){
       return "le reference de cette Liver: "+getReference()+"- le titre :"+getTitre()+"- et le autheur est : "+autheur+"- et number des pages :"+pages;
    }
}

