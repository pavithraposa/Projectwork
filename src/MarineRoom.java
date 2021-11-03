public class MarineRoom extends Room {

    public MarineRoom ( String roomname, String dimensions, int roomNumber, boolean isBooked) {
        this.dimensions = dimensions;
        this.roomNumber = roomNumber;
        this.isBooked = isBooked;
        this.roomname=roomname;

    }

    public MarineRoom (String roomname, String dimensions, int roomNumber, boolean isBooked, Animal guests) {
        this.dimensions = dimensions;
        this.roomNumber = roomNumber;
        this.isBooked = isBooked;
        this.roomname=roomname;
        this.guests = guests;

    }
    public String describe(){
        String describe = "The marine room consists of a big pool for animals that prefer the water";
        return describe;
    }
}