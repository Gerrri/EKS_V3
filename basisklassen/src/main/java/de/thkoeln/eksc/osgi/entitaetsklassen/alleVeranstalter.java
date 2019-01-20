package de.thkoeln.eksc.osgi.entitaetsklassen;

import java.util.LinkedList;

public class alleVeranstalter {

    private LinkedList<Veranstalter> veranstalter_Liste;
    private static alleVeranstalter instance;
    private alleVeranstalter(){
        this.veranstalter_Liste = new LinkedList<Veranstalter>();
    }
    public static alleVeranstalter exemplar(){
        if(instance == null){
            instance = new alleVeranstalter();
        }
        return instance;
    }

    public void addVeranstalter(Veranstalter v){
        veranstalter_Liste.add(v);
    }

    public Veranstalter getVeranstalter(String name){
        for(Veranstalter v :veranstalter_Liste ){
            if(v.getName() == name){
                return v;
            }
        }
        return null;
    }

    public int getVeranstalterListSize(){
        return this.veranstalter_Liste.size();
    }

    public Veranstalter getVeranstalterById(int veranstalternr){
        for( Veranstalter v : veranstalter_Liste){
            if(v.getVeranstalternr() == veranstalternr){
                return v;
            }
        }
        return null;
    }

    public boolean containsVeranstalter(Veranstalter v){
        for(int i = 0; i < veranstalter_Liste.size();i++){
            if(veranstalter_Liste.get(i).equals(v)){
                return true;
            }
        }
        return false;
    }


}
