public class Carte {
    private String lieu;
    private String nom;
    private int debut;
    private int fin;
    private int etape;

    public Carte(String lieu, String nom, int debut, int fin, int etape) {
        this.lieu = lieu;
        this.nom = nom;
        this.debut = debut;
        this.fin = fin;
        this.etape = etape;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDebut() {
        return debut;
    }

    public void setDebut(int debut) {
        this.debut = debut;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public int getEtape() {
        return etape;
    }

    public void setEtape(int etape) {
        this.etape = etape;
    }
}
