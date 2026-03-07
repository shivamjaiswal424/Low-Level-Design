public interface IRoomVisitor {
    void visitStandardRoom(StandardRoom room);
    void visitDeluxeRoom(DeluxeRoom room);
    void visitSuiteRoom(SuiteRoom room);
}
