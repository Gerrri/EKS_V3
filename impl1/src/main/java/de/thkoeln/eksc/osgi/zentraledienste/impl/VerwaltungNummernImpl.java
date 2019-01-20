package de.thkoeln.eksc.osgi.zentraledienste.impl;


import de.thkoeln.eksc.osgi.entitaetsklassen.alleReisen;
import de.thkoeln.eksc.osgi.entitaetsklassen.alleVeranstalter;
import de.thkoeln.eksc.osgi.zentraledienste.VerwaltungNummern;


public class VerwaltungNummernImpl implements VerwaltungNummern {


    @Override
    public int getNeueReiseNr() {
        alleReisen aR = de.thkoeln.eksc.osgi.entitaetsklassen.alleReisen.exemplar();
        return aR.getReiseListSize()+1;
    }

    @Override
    public int getNeueVeranstalterNr() {
        alleVeranstalter aV = de.thkoeln.eksc.osgi.entitaetsklassen.alleVeranstalter.exemplar();
        return aV.getVeranstalterListSize() +1;
    }
}
