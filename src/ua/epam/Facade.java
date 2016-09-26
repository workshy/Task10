package ua.epam;

/**
 * Created by Viktoriia_Marynchak on 9/26/2016.
 */
public class Facade {
    public static void main(String[] args) {
        // write your code here
//        Power power = new Power();
//        power.on();
//        DVDrom dvd = new DVDrom();
//        dvd.load();
//        HDD hdd = new HDD();
//        hdd.copyFromDVD(dvd);

        ComputerFacadeClass comp = new ComputerFacadeClass();
        comp.copy();

    }
}

class ComputerFacadeClass {
    Power power = new Power();
    DVDrom dvd = new DVDrom();
    HDD hdd = new HDD();

    void copy(){
        power.on();
        dvd.load();
        hdd.copyFromDVD(dvd);
    }
}

class Power {
    void on(){
        System.out.println("Включение питания");
    }
    void off(){
        System.out.println("Выключение питания");
    }
}

class DVDrom {
    private boolean data = false;

    public boolean hasData() {
        return data;
    }

    void load(){
        data = true;
    }

    void unLoad(){
        data = false;
    }

}

class HDD {
    void copyFromDVD(DVDrom dvd){
        if (dvd.hasData()){
            System.out.println("Происходит копирование данных с диска");
        }
        else {
            System.out.println("Вставтье диск с данными");
        }
    }
}
