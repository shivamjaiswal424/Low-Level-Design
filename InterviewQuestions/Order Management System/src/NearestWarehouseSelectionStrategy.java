import java.util.List;

public class NearestWarehouseSelectionStrategy extends WarehouseSelectionStrategy {

    @Override
    public Warehouse selectWarehouse(List<Warehouse> warehousesList) {
        return warehousesList.get(0);
    }
}
