public class ArialRoom extends Room {

    public ArialRoom (String roomname, String dimensions, int roomNumber, boolean isBooked) {

        this.dimensions = dimensions;
        this.roomNumber = roomNumber;
        this.isBooked = isBooked;
        this.roomname = roomname;
    }

    public ArialRoom (String roomname, String dimensions, int roomNumber, boolean isBooked, Animal guests) {

        this.dimensions = dimensions;
        this.roomNumber = roomNumber;
        this.isBooked = isBooked;
        this.roomname=roomname;
        this.guests = guests;
        //this.name1=name1;
    }
    public String describe(){
        String describe = "The arial room got a high ceiling, for the ability to fly and lots of trees.";
        return describe;
    }
}