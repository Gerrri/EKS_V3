package de.thkoeln.eksc.osgi.entitaetsklassen;

import java.util.ArrayList;

public class Veranstalter {

    private String name;                // Name des Veranstalters
    private String adresse;             // Adresse des Veranstalters
    private int veranstalternr;         // eindeutige Veranstalternummer
    private ArrayList<Integer> reisen;  // Liste der Nummern der Reisen,
                                        // die dieser Veranstalter  anbietet.

    public Veranstalter(int veranstalternr, String name , String adresse) {
        this.name = name;
        this.veranstalternr = veranstalternr;
        this.adresse = adresse;
        this.reisen = new ArrayList<Integer>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getVeranstalternr() {
        return veranstalternr;
    }

    public void setVeranstalternr(int veranstalternr) {
        this.veranstalternr = veranstalternr;
    }

    public ArrayList<Integer> getReisen() {
        return reisen;
    }

    public void addReise(int reisenr) {
        reisen.add(reisenr);
    }

}
