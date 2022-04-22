package degisn.visitor;

public class Cpu extends ComputerPart {
    @Override
    void accept(Visitor v) {
        v.visitCpu(this);
    }

    @Override
    double getPrice() {
        return 500;
    }
}
