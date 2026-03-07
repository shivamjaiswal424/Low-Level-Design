public class SuiteRoom implements IRoom{
    private String RoomNumber;
    private int  numberOfRooms;
    SuiteRoom(String RoomNumber, int numberOfRooms) {
        this.RoomNumber = RoomNumber;
        this.numberOfRooms = numberOfRooms;

    }
    @Override
    public void accept(IRoomVisitor visitor) {
        visitor.visitSuiteRoom(this);
    }
    public String getRoomNumber() {
        return RoomNumber;
    }
    public void setRoomNumber(String RoomNumber) {
        this.RoomNumber = RoomNumber;
    }
    public int getNumberOfRooms() {
        return numberOfRooms;
    }
}
