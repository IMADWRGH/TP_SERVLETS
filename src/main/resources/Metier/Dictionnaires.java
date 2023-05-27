package Metier;
public class Dictionnaires extends Documents{
    private int motsDefinitions;

    public Dictionnaires(int reference, String titre, int motsDefinitions) {
        super(reference, titre);
        this.motsDefinitions = motsDefinitions;
    }

    public Dictionnaires(int reference) {
        super(reference);
    }

    public int getMotsDefinitions() {
        return motsDefinitions;
    }
    String Description() {
        return "le reference de cette Dictionnaire :" + getReference() + " le titre :" + getTitre() + " et le nombre de définitions de mots " + motsDefinitions;
    }
}
