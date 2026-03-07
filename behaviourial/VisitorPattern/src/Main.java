//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        IRoom[] rooms={
                new StandardRoom("101"),
                new StandardRoom("102"),
                new DeluxeRoom("201",true),
                new DeluxeRoom("202",false),
                new SuiteRoom("301", 3)
        };
        System.out.println("-------------HouseKeeping Service----------------");
        IRoomVisitor houseKeeping=new HouseKeepingVisitor();
        for(IRoom room:rooms){
            room.accept(houseKeeping);
        }

        System.out.println("-------------Room Service--------------");
        IRoomVisitor roomService=new RoomServiceVisitor("Breakfast");
        for(IRoom room:rooms){
            room.accept(roomService);
        }
        System.out.println("\n==> Revenue Calculation");
        PricingVisitor pricing = new PricingVisitor();
        for (IRoom room : rooms) {
            room.accept(pricing);
        }
        System.out.println("Total Revenue: Rs." +
                pricing.getTotalRevenue());
    }
}