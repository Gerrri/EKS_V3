package de.thkoeln.eksc.osgi.ReiseVeranstalterVerwaltung.impl;

import de.thkoeln.eksc.osgi.entitaetsklassen.Reise;
import de.thkoeln.eksc.osgi.entitaetsklassen.Veranstalter;
import de.thkoeln.eksc.osgi.entitaetsklassen.alleReisen;
import de.thkoeln.eksc.osgi.entitaetsklassen.alleVeranstalter;
import de.thkoeln.eksc.osgi.reiseverwaltung.ReiseVeranstalterVerwaltung;
import de.thkoeln.eksc.osgi.zentraledienste.VerwaltungNummern;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ReiseVeranstalterVerwaltungImpl implements ReiseVeranstalterVerwaltung {

    private VerwaltungNummern vN;
    alleReisen ar;
    alleVeranstalter av;

    public ReiseVeranstalterVerwaltungImpl(){
        //get alleReisen instance
        ar = alleReisen.exemplar();
        av = alleVeranstalter.exemplar();

        // initiale Verbindung zum Service VerwaltungNummern
        BundleContext bundleContext = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
        try {
            ServiceReference[] refs = bundleContext.getServiceReferences(
                    VerwaltungNummern.class.getName(), "(Service=VerwaltungNummern)");
            if (refs != null) {
                vN = (VerwaltungNummern) bundleContext.getService(refs[0]);
            }

        }
        catch(Exception e){
            System.out.println(getClass().toString() + ": Fehler beim Laden der Services -> " + VerwaltungNummern.class.getName());
            System.out.println("Exception: "+e.getMessage());
        }
    }


    @Override
    public int neueReise(int preis) {
        int reisenr = vN.getNeueReiseNr();
        ar.addReisen(new Reise(reisenr,preis));
        return reisenr;
    }

    @Override
    public Reise getReise(int reisenr) {
        return ar.getReiseById(reisenr);
    }

    @Override
    public int neuerVeranstalter(String name, String adresse) {
        int neueNummer = vN.getNeueVeranstalterNr();

        av.addVeranstalter(new Veranstalter(neueNummer, name,adresse));
        return neueNummer;
    }

    @Override
    public void veranstaltetReise(Veranstalter v, int reisenr) {
        av.getVeranstalterById(v.getVeranstalternr())
                .addReise(reisenr);
    }

    @Override
    public Veranstalter getVeranstalter(int veranstalternr) {
       return av.getVeranstalterById(veranstalternr);
    }

    @Override
    public ArrayList<Reise> alleVeranstalteteReisen(Veranstalter v) {
        ArrayList<Reise> ret_reisen_List = new ArrayList<Reise>();

        for(int reisenr : av.getVeranstalterById(v.getVeranstalternr()).getReisen()){
            ret_reisen_List.add(ar.getReiseById(reisenr));
        }

        return  ret_reisen_List;
    }
}
