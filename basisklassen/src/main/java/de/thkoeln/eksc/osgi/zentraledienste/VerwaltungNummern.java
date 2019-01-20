package de.thkoeln.eksc.osgi.zentraledienste;

public interface VerwaltungNummern {

    /** Liefert eine neue, eindeutige Reisenummer
     *  @return neue, eindeutige Reisenummer
     */
    public int getNeueReiseNr();


    /** Liefert eine neue, eindeutige Veranstalternummer
     *  @return neue, eindeutige Veranstalternummer
     */
    public int getNeueVeranstalterNr();


}
