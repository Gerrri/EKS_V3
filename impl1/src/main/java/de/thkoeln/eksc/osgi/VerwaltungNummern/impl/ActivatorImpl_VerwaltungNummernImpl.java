package de.thkoeln.eksc.osgi.VerwaltungNummern.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import de.thkoeln.eksc.osgi.zentraledienste.VerwaltungNummern;

import java.util.Hashtable;

public class ActivatorImpl_VerwaltungNummernImpl implements BundleActivator {

    private ServiceRegistration VN_Service; //VerwaltungsNummern Service

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        Hashtable<String,String> temp = new Hashtable<String,String>();
        temp.put("Service","VerwaltungNummern");
        VN_Service = bundleContext.registerService(VerwaltungNummern.class.getName(),new VerwaltungsNummernImpl(),temp);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        VN_Service.unregister();
    }
}
