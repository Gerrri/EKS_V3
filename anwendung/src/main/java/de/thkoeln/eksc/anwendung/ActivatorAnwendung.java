package de.thkoeln.eksc.anwendung;

import de.thkoeln.eksc.osgi.entitaetsklassen.Reise;
import de.thkoeln.eksc.osgi.entitaetsklassen.Veranstalter;
import de.thkoeln.eksc.osgi.reiseverwaltung.ReiseVeranstalterVerwaltung;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;


import java.util.ArrayList;

public class ActivatorAnwendung implements BundleActivator {

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        ServiceReference[] s;
        ReiseVeranstalterVerwaltung reiseVerwaltungsService = null;
        try{
            s = bundleContext.getServiceReferences(ReiseVeranstalterVerwaltung.class.getName(),"(ServiceR=ReiseVerantalter)");
            reiseVerwaltungsService = (ReiseVeranstalterVerwaltung) bundleContext.getService(s[0]);
        }catch (Exception e){

        }

        int reise1 = reiseVerwaltungsService.neueReise(123);
        System.out.println("Reisenummer von Reise 123: " + reise1);

        int reise2 = reiseVerwaltungsService.neueReise(456);
        System.out.println("Reisenummer von Reise 456: " + reise2);

        int reise3 = reiseVerwaltungsService.neueReise(789);
        System.out.println("Reisenummer von Reise 789: " + reise3);

        System.out.println();
        int veranstalter1 = reiseVerwaltungsService.neuerVeranstalter("Peter", "Koeln");
        System.out.println("Veranstalternummer von Peter: " + veranstalter1);
        int veranstalter2 =   reiseVerwaltungsService.neuerVeranstalter("Klaus", "Mainz");
        System.out.println("Veranstalternummer von Klaus: " + veranstalter2);

        System.out.println();

        Veranstalter veranstalterObjekt1 = reiseVerwaltungsService.getVeranstalter(veranstalter1);
        System.out.println("Veranstalterobjekt zu Nummer von Peter gefunden.");
        Veranstalter veranstalterObjekt2 = reiseVerwaltungsService.getVeranstalter(veranstalter2);
        System.out.println("Veranstalterobjekt von Nummer von Klaus gefunden.");

        System.out.println();

        reiseVerwaltungsService.veranstaltetReise(veranstalterObjekt1,reise1);
        System.out.println("Peter veranstaltet Reise 123.");

        reiseVerwaltungsService.veranstaltetReise(veranstalterObjekt1,reise2);
        System.out.println("Peter veranstaltet Reise 456.");

        reiseVerwaltungsService.veranstaltetReise(veranstalterObjekt2,reise3);
        System.out.println("Klaus veranstaltet Reise 789.");

        System.out.println();
        ArrayList<Reise> allereisen1 = reiseVerwaltungsService.alleVeranstalteteReisen(veranstalterObjekt1);
        System.out.println("Alle gefundenen Reisen von Peter:");
        for (Reise r : allereisen1) {
            System.out.print(r.getPreis() + ", " + r.getReisenummer());
            System.out.println();
        }

        System.out.println();
        ArrayList<Reise> allereisen2 = reiseVerwaltungsService.alleVeranstalteteReisen(veranstalterObjekt2);
        System.out.println("Alle gefundenen Reisen von Klaus:");
        for (Reise r : allereisen2) {
            System.out.print(r.getPreis() + ", " + r.getReisenummer());
            System.out.println();
        }

        System.out.println();

    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {

    }
}
