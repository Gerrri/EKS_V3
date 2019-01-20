package de.thkoeln.eksc.osgi.reiseverwaltung.impl;

import de.thkoeln.eksc.osgi.reiseverwaltung.ReiseVeranstalterVerwaltung;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.util.Hashtable;

public class ActivatorImplReiseVeranstalterVerwaltung implements BundleActivator {
    private ServiceRegistration ReiseVeranstalterService;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        Hashtable<String,String> temp = new Hashtable<String,String>();
        temp.put("ServiceR","ReiseVerantalter");

        ReiseVeranstalterService = bundleContext.registerService(ReiseVeranstalterVerwaltung.class.getName(),new ReiseVeranstalterVerwaltungImpl(),temp);

    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        ReiseVeranstalterService.unregister();
    }
}

