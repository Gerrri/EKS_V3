import org.apache.felix.framework.*;
import org.osgi.framework.*;

import java.util.HashMap;
import java.util.Map;

public class Test_Main {

    private static Felix felix_framework;

    public static void main(String [] args){

        final Map<String, String> configMap = new HashMap<>();
        configMap.put(Constants.FRAMEWORK_STORAGE_CLEAN, "onFirstInit");

        try
        {
            String path_basisklasse = "file:./basisklassen/target/basisklassen-1.0.jar";
            String path_impl1 = "file:./impl1/target/impl1-1.0.jar";
            String path_impl2 = "file:./impl2/target/impl2-1.0.jar";
            String path_anwendung = "file:./anwendung/target/anwendung-1.0.jar";

            felix_framework = new Felix(configMap);
            felix_framework.init();

            final BundleContext context = felix_framework.getBundleContext();


            System.out.println("#################  INSTALL  #################");
            System.out.println("Installiere:  Basisklassen");
            Bundle basisklassen = context.installBundle(path_basisklasse);

            System.out.println("Installiere:  Impl1");
            Bundle impl1 = context.installBundle(path_impl1);

            System.out.println("Installiere:  Impl2");
            Bundle impl2 = context.installBundle(path_impl2);

            System.out.println("Installiere:  anwendung");
            Bundle anwendung = context.installBundle(path_anwendung);



            System.out.println("\n#################  START  #################");
            System.out.println("start:  OSGI");
            felix_framework.start();

            System.out.println("start:  Basisklassen" );
            basisklassen.start();

            System.out.println("start:  Impl1 ");
            impl1.start();

            System.out.println("start:  Impl2 ");
            impl2.start();

            System.out.println("start:  anwendung ");
            anwendung.start();


            System.out.println("\n#################  STOP  #################");
            System.out.println("stop:  Basisklassen");
            basisklassen.stop();

            System.out.println("stop:  Impl1");
            impl1.stop();

            System.out.println("stop:  Impl2");
            impl2.stop();

            System.out.println("stop:  anwendung");
            anwendung.stop();


            System.out.println("\n#################  UNINSTALL  #################");
            System.out.println("Deinstalliere:  Basisklassen");
            basisklassen.uninstall();

            System.out.println("Deinstalliere:  Impl1");
            impl1.uninstall();

            System.out.println("Deinstalliere:  Impl2");
            impl2.uninstall();

            System.out.println("Deinstalliere:  anwendung");
            anwendung.uninstall();


            System.out.println("\nstop:  OSGI");
            felix_framework.stop();
            felix_framework.waitForStop(1000);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("\n#################  ENDE  #################");
    }

    }

