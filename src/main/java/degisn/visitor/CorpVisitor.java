package degisn.visitor;

public class CorpVisitor implements Visitor{
    double total =0;
    @Override
    public void visitCpu(ComputerPart cpu) {
        total += cpu.getPrice() * 0.6;
    }

    @Override
    public void visitMemory(ComputerPart memory) {
        total += memory.getPrice() * 0.6;
    }

    @Override
    public void visitBoard(ComputerPart board) {
        total += board.getPrice() * 0.6;
    }
    public double totalPrice() {
        return total;
    }
}
