package seis;

public class MapFactory {


    public static IMap getMap(String entry){
        if(entry.equals("1")) { // 1 HashMap
            return new CHashMap();
        }
        else if (entry.equals("2")){ // Elije LinkedHashMap
            return new CLinkedHashMap();

        }else if (entry.equals("3")){ // Elije LinkedHashMap
            return new CTreeMap();
        }
        else {// Sino elije lista
            return null;
        }
    }
}

