package ParkingLot.ParkingObjects.ParkingSpot;

import ParkingLot.Vehicle.Vehicle;
import ParkingLot.Vehicle.VehicleTypeEnum;

public abstract class ParkingSpot {
    private String id;
    private boolean isEmpty;
    private Vehicle vehicle;
    private int price;
    private VehicleTypeEnum allowedVehicleType;

    public ParkingSpot(String id, int price, VehicleTypeEnum allowedVehicleType){
        this.id=id;
        this.price=price;
        this.allowedVehicleType=allowedVehicleType;
        this.isEmpty=true;
    }

    public boolean isCompatible(Vehicle vehicle){
        return vehicle.getVehicleTypeEnum()==this.allowedVehicleType;
    }

    public void parkVehicle(Vehicle vehicle){
        if(!isEmpty){
            System.out.println("Spot "+id+" is already taken");
            return;
        }
        if(!isCompatible(vehicle)){
            System.out.println("Spot "+id+" does not allow "+vehicle.getVehicleTypeEnum());
            return;
        }
        this.vehicle=vehicle;
        this.isEmpty=false;
        System.out.println("Vehicle "+vehicle.getVehicleNumber()+" parked in "+id);
    }

    public void removeVehicle(){
        if(isEmpty){
            System.out.println("Spot "+id+" is already empty");
            return;
        }
        System.out.println("Vehicle "+vehicle.getVehicleNumber()+" removed from spot "+id);
        this.vehicle=null;
        this.isEmpty=true;
    }

    public boolean isEmpty(){
        return isEmpty;
    }

    public int getPrice(){
        return price;
    }

    public String getId(){
        return id;
    }

    public VehicleTypeEnum getAllowedVehicleType(){
        return allowedVehicleType;
    }
}
