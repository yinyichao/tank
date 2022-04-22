package degisn.visitor;

public interface Visitor {
    void visitCpu(ComputerPart cpu);
    void visitMemory(ComputerPart memory);
    void visitBoard(ComputerPart board);
}
