package de.thkoeln.eksc.osgi.entitaetsklassen;

import java.util.LinkedList;

public class alleVeranstalter {

    private LinkedList<Veranstalter> veranstalterList;
    private static alleVeranstalter instance;
    private alleVeranstalter(){
        this.veranstalterList = new LinkedList<Veranstalter>();
    }
    public static alleVeranstalter exemplar(){
        if(instance == null){
            instance = new alleVeranstalter();
        }
        return instance;
    }

    public void addVeranstalter(Veranstalter v){
        veranstalterList.add(v);
    }

    public Veranstalter getVeranstalter(String name ){
        for(Veranstalter v :veranstalterList ){
            if(v.getName().equals(name)){
                return v;
            }
        }
        return null;
    }

    public int getVeranstalterListSize(){
        return this.veranstalterList.size();
    }

    public Veranstalter getVeranstalterById(int veranstalternr){
        for( Veranstalter v : veranstalterList){
            if(v.getVeranstalternr() == veranstalternr){
                return v;
            }
        }
        return null;
    }

    public boolean containsVeranstalter(Veranstalter v){
        for(int i = 0; i < veranstalterList.size();i++){
            if(veranstalterList.get(i).equals(v)){
                return true;
            }
        }
        return false;
    }


}
