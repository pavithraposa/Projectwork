public class GroundRoom extends Room {

    public GroundRoom(String roomname,String dimensions,int roomNumber,boolean isBooked){
        this.dimensions = dimensions;
        this.roomNumber = roomNumber;
        this.isBooked = isBooked;
        this.roomname = roomname;
    }

    public GroundRoom(String roomname, String dimensions, int roomNumber, boolean isBooked, Animal guests){
        this.dimensions = dimensions;
        this.roomNumber = roomNumber;
        this.isBooked = isBooked;
        this.roomname = roomname;
        this.guests = guests;
    }
    public String describe(){
        String describe = "The ground room is shaped like a long rectangle, for an easier experience if you like running.";
        return describe;
    }
}
