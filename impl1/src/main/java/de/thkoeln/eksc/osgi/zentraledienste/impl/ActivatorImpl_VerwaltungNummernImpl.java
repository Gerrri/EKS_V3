package de.thkoeln.eksc.osgi.zentraledienste.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import de.thkoeln.eksc.osgi.zentraledienste.VerwaltungNummern;

import java.util.Hashtable;

public class ActivatorImpl_VerwaltungNummernImpl implements BundleActivator {

    private ServiceRegistration verwaltungNummernService;
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        Hashtable<String,String> temp = new Hashtable<String,String>();
        temp.put("Service","VerwaltungNummern");


        verwaltungNummernService = bundleContext.registerService(VerwaltungNummern.class.getName(),new VerwaltungNummernImpl(),temp);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        verwaltungNummernService.unregister();
    }
}
