package de.thkoeln.eksc.osgi.entitaetsklassen;

public class Reise{
    private int preis; // Preis der Reise
    private int reisenummer;    // eindeutige Reisenummer
    public Reise(int reisenummer, int preis) {
        this.reisenummer = reisenummer;
        this.preis = preis;
    }

    // Getter und Setter

    public int getPreis() {
        return preis;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

    public int getReisenummer() {
        return reisenummer;
    }

    public void setReisenummer(int reisenummer) {
        this.reisenummer = reisenummer;
    }
}