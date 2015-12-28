package view;

public class Pumpa {
    private String naziv;
    private int pumpaId;
    private int velicinaReda;


    public Pumpa(String naziv, int pumpaId) {
        super();
        this.naziv = naziv;
        this.pumpaId = pumpaId;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setPumpaId(int pumpaId) {
        this.pumpaId = pumpaId;
    }

    public int getPumpaId() {
        return pumpaId;
    }


    public void setVelicinaReda(int velicinaReda) {
        this.velicinaReda = velicinaReda;
    }

    public int getVelicinaReda() {
        return velicinaReda;
    }
}
