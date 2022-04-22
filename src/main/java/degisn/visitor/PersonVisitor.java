package degisn.visitor;

public class PersonVisitor implements Visitor{
    double total =0;
    @Override
    public void visitCpu(ComputerPart cpu) {
        total += cpu.getPrice() * 0.8;
    }

    @Override
    public void visitMemory(ComputerPart memory) {
        total += memory.getPrice() * 0.8;
    }

    @Override
    public void visitBoard(ComputerPart board) {
        total += board.getPrice() * 0.8;
    }
    public double totalPrice() {
        return total;
    }
}
