package de.thkoeln.eksc.osgi.reiseverwaltung;

import de.thkoeln.eksc.osgi.entitaetsklassen.Reise;
import de.thkoeln.eksc.osgi.entitaetsklassen.Veranstalter;

import java.util.ArrayList;

public interface ReiseVeranstalterVerwaltung {
/**
 * Erzeugt ein neues Objekt der Klasse Reise.
 * Hierbei muss auf das Interface VerwaltungNummern.
 * zugegriffen werden, um eine neue Reisenummer zu erhalten.
 * @param preis
 * @return
 */
public int neueReise(int preis);

    /**
     *  Liefert das Reise-Objekt zur gegebenen
     *  Reisenummer
     *  @param reisenr Reisenummer der gesuchten Reise
     *  @return Reise-Objekt mit der Nummer reisenr
     */
    public Reise getReise(int reisenr);

    /** Erzeugt ein neues Objekt der Klasse Veranstalter.
     *  Hierzu muss auf das Interface Verwaltung Nummern
     *  zugegriffen werden.
     *  @param name Name der neuen Veranstalters
     *  @param adresse Adresse des neuen Veranstalters
     *  @return Nummer des neuen Veranstalters
     *  */
    public int neuerVeranstalter(String name, String adresse);


    /**  Durch Aufruf der Methode wird angezeigt, dass ein Veranstalter
     *  eine bestimmte Reise anbietet.
     *  @param v Veranstalter, der die Reise mit der Nummer reisenr
     *  anbietet
     *  @param reisenr Nummer der Reise, die der Veranstalter v anbietet.
     */
    public void veranstaltetReise(Veranstalter v, int reisenr);


    /** Liefert das Veranstalter-Objekt zu einer gegebenen
     *  Veranstalternummer
     *  @param veranstalternr Nummer des gesuchten Veranstalters
     *  @return Veranstalter-Objekt mit der Nummer veranstalternr
     */
    public Veranstalter getVeranstalter(int veranstalternr);


    /** Liefert die Liste aller Reisen, die der übergebene Veranstalter
     * anbietet.
     * Hierzu muss auf das Interface ReiseVerwaltung zugegriffen werden.
     * @param v Veranstalter, dessen Reisen gesucht werden
     * @return Liste der Reisen des Veranstalters v      */
    public ArrayList<Reise> alleVeranstalteteReisen(Veranstalter v);

}
