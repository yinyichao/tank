package degisn.command;

public class DeleteCommand extends Command {
    Content c;

    public DeleteCommand(Content c) {
        this.c = c;
    }

    String deleted;

    @Override
    public void exec() {
        deleted = c.msg.substring(0, 5);
        c.msg = c.msg.substring(5, c.msg.length());
    }

    @Override
    public void undo() {
        c.msg = deleted + c.msg;
    }
}
