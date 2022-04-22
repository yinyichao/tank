package degisn.visitor;

public class Computer {
    ComputerPart cpu = new Cpu();
    ComputerPart memory = new Memory();
    ComputerPart board = new Board();
    public void accept(Visitor v) {
        this.cpu.accept(v);
        this.memory.accept(v);
        this.board.accept(v);
    }

    public static void main(String[] args) {
        PersonVisitor p1 = new PersonVisitor();
        CorpVisitor p = new CorpVisitor();
        new Computer().accept(p);
        System.out.println(p.totalPrice());
    }
}
