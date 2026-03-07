public class DeluxeRoom implements IRoom{
    private String RoomNumber;
    private Boolean hasJacuzzi;
    DeluxeRoom(String RoomNumber,Boolean hasJacuzzi){
        this.RoomNumber = RoomNumber;
        this.hasJacuzzi = hasJacuzzi;
    }
    @Override
    public void accept(IRoomVisitor visitor) {
        visitor.visitDeluxeRoom(this);
    }
    public String getRoomNumber() {
        return RoomNumber;
    }
    public boolean hasJacuzzi() {
        return hasJacuzzi;
    }
}
