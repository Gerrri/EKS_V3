package de.thkoeln.eksc.osgi.ReiseVeranstalterVerwaltung.impl;

import de.thkoeln.eksc.osgi.entitaetsklassen.Reise;
import de.thkoeln.eksc.osgi.entitaetsklassen.Veranstalter;
import de.thkoeln.eksc.osgi.entitaetsklassen.alleReisen;
import de.thkoeln.eksc.osgi.reiseverwaltung.ReiseVeranstalterVerwaltung;
import de.thkoeln.eksc.osgi.zentraledienste.VerwaltungNummern;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import java.util.ArrayList;

public class ReiseVeranstalterVerwaltungImpl implements ReiseVeranstalterVerwaltung {

    private VerwaltungNummern vm;
    alleReisen ar;

    public ReiseVeranstalterVerwaltungImpl(){
        //get alleReisen instance
        alleReisen ar = alleReisen.exemplar();

        // initiale Verbindung zum Service VerwaltungNummern
        BundleContext bundleContext = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
        try {
            ServiceReference[] refs = bundleContext.getServiceReferences(
                    VerwaltungNummern.class.getName(), "(Service=VerwaltungNummern)");
            if (refs != null) {
                vm = (VerwaltungNummern) bundleContext.getService(refs[0]);
            }

        }
        catch(Exception e){
            System.out.println(getClass().toString() + ": Fehler beim Laden der Services -> " + VerwaltungNummern.class.getName());
            System.out.println("Exception: "+e.getMessage());
        }
    }


    @Override
    public int neueReise(int preis) {
        int reisenr = vm.getNeueReiseNr();
        ar.addReisen(new Reise(reisenr,preis));
        return reisenr;
    }

    @Override
    public Reise getReise(int reisenr) {

        return null;
    }

    @Override
    public int neuerVeranstalter(String name, String adresse) {
        return 0;
    }

    @Override
    public void veranstaltetReise(Veranstalter v, int reisenr) {

    }

    @Override
    public Veranstalter getVeranstalter(int veranstalternr) {
        return null;
    }

    @Override
    public ArrayList<Reise> alleVeranstalteteReisen(Veranstalter v) {
        return null;
    }
}
