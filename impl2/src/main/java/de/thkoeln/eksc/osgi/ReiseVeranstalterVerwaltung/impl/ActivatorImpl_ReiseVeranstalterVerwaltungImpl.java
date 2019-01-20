package de.thkoeln.eksc.osgi.ReiseVeranstalterVerwaltung.impl;

import de.thkoeln.eksc.osgi.reiseverwaltung.ReiseVeranstalterVerwaltung;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.util.Hashtable;

public class ActivatorImpl_ReiseVeranstalterVerwaltungImpl implements BundleActivator {

    private ServiceRegistration RVV_Service; //ReiseVeranstalterVerwaltung Service

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        Hashtable<String,String> temp = new Hashtable<String,String>();
        temp.put("Service","ReiseVeranstalterVerwaltung");
        RVV_Service = bundleContext.registerService(ReiseVeranstalterVerwaltung.class.getName(),new ReiseVeranstalterVerwaltungImpl(),temp);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        RVV_Service.unregister();
    }
}
