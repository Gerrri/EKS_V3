package de.thkoeln.eksc.osgi.entitaetsklassen;

import java.util.LinkedList;

public class alleReisen {
    private LinkedList<Reise> reiseList;
    private static alleReisen instance;
    private alleReisen(){
        this.reiseList = new LinkedList<Reise>();
    }

    public static alleReisen exemplar(){
        if (instance == null){
            instance = new alleReisen();
        }
        return instance;
    }

    public void addReisen(Reise r){
        reiseList.add(r);
    }

    public int getReiseListSize(){
        return this.reiseList.size();
    }

    public Reise getReiseById(int reisenummer){
        for(Reise r: reiseList){
            if(r.getReisenummer() ==reisenummer){
                return r;
            }
        }
        return null;
    }
}
