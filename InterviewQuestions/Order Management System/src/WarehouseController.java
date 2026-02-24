import java.util.List;

public class WarehouseController {
    List<Warehouse> warehouseList;
    WarehouseSelectionStrategy warehouseSelectionStrategy=null;
    public WarehouseController(List<Warehouse> warehouseList,WarehouseSelectionStrategy warehouseSelectionStrategy){
        this.warehouseList = warehouseList;
        this.warehouseSelectionStrategy=warehouseSelectionStrategy;

    }
    public void addWarehouse(Warehouse warehouse){
        warehouseList.add(warehouse);
    }
    public void removeWarehouse(Warehouse warehouse){
        warehouseList.remove(warehouse);
    }
    public Warehouse selectWarehouse(WarehouseSelectionStrategy warehouseSelectionStrategy){
        this.warehouseSelectionStrategy=warehouseSelectionStrategy;
        return warehouseSelectionStrategy.selectWarehouse(warehouseList);
    }
}
