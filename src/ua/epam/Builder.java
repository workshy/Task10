package ua.epam;

/**
 * Created by Viktoriia_Marynchak on 9/26/2016.
 */
public class Builder {
    public static void main (String[] args) {
       /* Car car = new CarBuilder()
                .buildMake("Audi")
                .buildTransmission(Transmission.AUTO)
                .buildMaxSpeed(400)
                .build();
        System.out.println(car);*/

        Director director = new Director();
        director.setBuilder(new SubaruBuilder());
        Car car = director.BuildCar();
        System.out.println(car);


    }
}

enum Transmission{
    MANUAL, AUTO
}

class Car{
    String make;
    Transmission transmission;
    int maxSpeed;

    public void setMake(String make) {
        this.make = make;
    }
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", transmission=" + transmission +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
abstract class CarBuilder{
    Car car;
    void createCar(){car = new Car();}

    abstract void buildMake();
    abstract void buildTransmission ();
    abstract void buildMaxSpeed ();

    Car getCar(){return car;}
}

class FordBuilder extends CarBuilder{
    @Override
    void buildMake() {
        car.setMake("Ford");
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.AUTO);
    }

    @Override
    void buildMaxSpeed() {
        car.setMaxSpeed(260);
    }
}


class SubaruBuilder extends CarBuilder{
    @Override
    void buildMake() {
        car.setMake("Subaru");
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.MANUAL);
    }

    @Override
    void buildMaxSpeed() {
        car.setMaxSpeed(220);
    }
}

class Director{
    CarBuilder builder;
    void setBuilder(CarBuilder b){builder = b;}

    Car BuildCar (){
        builder.createCar();
        builder.buildMake();
        builder.buildMaxSpeed();
        builder.buildTransmission();
        Car car = builder.getCar();
        return car;
    }
}

/*
class CarBuilder{
    String m;
    Transmission t;
    int s;

    CarBuilder buildMake(String m){
        this.m = m;
        return this;
    }

    CarBuilder buildTransmission(Transmission t){
        this.t = t;
        return this;
    }

    CarBuilder buildMaxSpeed(int s){
        this.s = s;
        return this;
    }

    Car build(){
        Car car = new Car();
        car.setMake(m);
        car.setTransmission(t);
        car.setMaxSpeed(s);
        return car;
    }
}*/

