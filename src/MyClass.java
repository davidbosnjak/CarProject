import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
public class MyClass {
    public static void main(String[] args) {
        System.out.println("Hello world");
        Car car = new Car();
        WindowFrame windowFrame = new WindowFrame();

    }



}
class Car{
    GasTank tank;
    Position position  = new Position();
    String Make;
    String Model;
    double weight;
    Wheels wheels = new Wheels(2,3);
    Engine engine = new Engine();
    Battery battery = new Battery();
    public boolean StartEngine(){
        if(engine.ValidEngine() && battery.ValidBattery()){
            return true;
        }
        return false;
    }
    public boolean accelerate(){
        System.out.println("test");
        engine.gasPedal(1,position);
        return true;
    }

}
class CarInterface {

}
class Engine{
    double current_rpm;
    public Engine(){

    };
    public boolean ValidEngine(){
        return true;
    }

    public void gasPedal(float pressure, Position pos){
        pos.setX(pos.getX()+pressure);
        System.out.println(pos.getX());

    }




}
class GasTank{
    double gasTankCapacity = 100;
    double currentGas = 50;
    public double getGasTankCapacity() {
        return gasTankCapacity;
    }
    public double getCurrentGas() {
        return currentGas;
    }
    public void setGasTankCapacity(double gasTankCapacity) {
        this.gasTankCapacity = gasTankCapacity;
    }
    public void setCurrentGas(double currentGas) {
        this.currentGas = currentGas;
    }



}
class Battery{
    double voltage;
    public boolean ValidBattery(){
        return true;
    }
}
class DieselEngine extends Engine{

}
class GasEngine extends Engine{

}
class Cylinder{
    int cylinder_width;
    int cylinder_height;
}

class Position{
    double x;
    double y;

    double getX(){return x;}
    double getY(){return y;}
    void setX(double setter){x = setter;}
    void setY(double setter){y = setter;}
    Position(){}
    Position(double x, double y){
        this.x = x;
        this.y = y;
    }


}

class Gear{
    int gear_number;
    float gear_diameter;
    char direction;
    float default_diameter = 5;
    public Gear(int gear_num, float gear_dia, char dir){
        this.gear_number = gear_num;
        this.gear_diameter = gear_dia;
        this.direction = dir;
    }
    public Gear(int gear_num,  char dir){
        this.gear_number = gear_num;
        this.gear_diameter = default_diameter;
        this.direction = dir;
    }


}





class Transmission{
    int num_gears;
    int increment_between_gears;
    ArrayList<Gear> gear_list = new ArrayList<Gear>();
    Clutch clutch = new Clutch();
    Gear current_gear;
    Transmission(){
        this.num_gears = 6;
        increment_between_gears = 2;


    }

    Transmission(int num_gears){
        this.num_gears = num_gears;
    }
    void MakeGearbox(float first_gear){
        Gear reverse = new Gear(-1, 'R');
        Gear neutral = new Gear(0, 'N');
        gear_list.add(reverse);
        gear_list.add(neutral);
        for(int i = 1; i<=num_gears;i++){
            Gear newGear = new Gear(i, first_gear-increment_between_gears, 'F');
            gear_list.add(newGear);
        }
    }
    public boolean shiftGear(char dir){
        if(clutch.isActive()){
            current_gear = gear_list.get(current_gear.gear_number-1);
            return true;
        }
        return false;
    }
    public Gear getCurentGear(){
        return current_gear;
    }




}
class Clutch{
    boolean clutch_active;
    public Clutch(){
        clutch_active = false;
    }
    public boolean activateClutch(){
        if(clutch_active) return false;
        clutch_active = true;
        return true;
    }
    public boolean deactivateClutch(){
        if(!clutch_active) return false;
        clutch_active = false;
        return true;
    }
    public boolean isActive(){return clutch_active;}
}
class ManualTransmission extends Transmission{

}

class AutomaticTransmission extends Transmission{

}
class Wheels{

    float diameter;
    float width;
    public Wheels(float dia, float width){
        this.diameter = dia;
        this.width = width;
    }

}

