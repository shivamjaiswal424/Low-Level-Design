public class HouseKeepingVisitor implements IRoomVisitor {

    @Override
    public void visitStandardRoom(StandardRoom room) {
        System.out.println("Housekeeping: Cleaning standard room " + room.getRoomNumber() + " (30 minutes)");
    }

    @Override
    public void visitDeluxeRoom(DeluxeRoom room) {
        System.out.println("Housekeeping: Cleaning deluxe room " + room.getRoomNumber() +
                (room.hasJacuzzi() ? " including jacuzzi" : "") +
                " (45 minutes)");
    }

    @Override
    public void visitSuiteRoom(SuiteRoom room) {
        System.out.println("Housekeeping: Cleaning suite " + room.getRoomNumber() + " with " + room.getNumberOfRooms() + " rooms (90 minutes)");
    }
}
