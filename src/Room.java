public class Room {

    String roomname;
    String dimensions;
    int roomNumber;
    boolean isBooked;
    Animal guests;
    String method;



    public Room(){

    }
    public Room(String roomName,String dimensions,int roomNumber, boolean isBooked){
        this.dimensions = dimensions;
        this.roomNumber = roomNumber;
        this.roomname= roomName;
        this.isBooked = isBooked;

    }
    public Room(String roomName,String dimensions, String description, int roomNumber, boolean isBooked, Animal guests){
        this.dimensions = dimensions;
        this.roomNumber = roomNumber;
        this.roomname= roomName;
        this.isBooked = isBooked;
        this.guests = guests;
    }

    public void setDimensions(String newDimensions){
        dimensions = newDimensions;
    }
    public String getDimensions(){
        return dimensions;
    }
    public void setRoomNumber(int newRoomNumber){
        roomNumber = newRoomNumber;
    }
    public int getRoomNumber(){
        return roomNumber;
    }
    public void setIsBooked(boolean newIsBooked){
        isBooked = newIsBooked;
    }
    public boolean getIsBooked(){
        return isBooked;
    }
    public void setRoomName(String newRoomName){
        roomname = newRoomName;
    }
    public String getRoomName(){
        return roomname;
    }
    public void setGuests(Animal newGuests){
        guests = newGuests;
    }
    public Animal getGuests(){
        return guests;
    }
    public String describe(){
        String describe = "A room that an animal can hire";
        return describe;
    }
}