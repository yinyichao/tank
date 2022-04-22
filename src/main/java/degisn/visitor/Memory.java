package degisn.visitor;

public class Memory extends ComputerPart {
    @Override
    void accept(Visitor v) {
        v.visitMemory(this);
    }

    @Override
    double getPrice() {
        return 30;
    }
}
