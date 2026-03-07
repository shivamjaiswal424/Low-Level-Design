public class RoomServiceVisitor implements IRoomVisitor{
    public final String orderDetails;

    public RoomServiceVisitor(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public void visitStandardRoom(StandardRoom room) {
        System.out.println("Room Service: StandardRoom "+ orderDetails +" to Standard Room "+ room.getRoomNumber() );
    }

    @Override
    public void visitDeluxeRoom(DeluxeRoom room) {
        System.out.println("Room Service: DeluxeRoom "+ orderDetails +" to Deluxe Room " + room.getRoomNumber() );
    }

    @Override
    public void visitSuiteRoom(SuiteRoom room) {
        System.out.println("Room Service: SuiteRoom "+ orderDetails +" to SuiteRoom "+ room.getRoomNumber() );
    }
}
