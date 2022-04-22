package degisn.command;

public class InsertCommand extends Command {
    Content c;

    public InsertCommand(Content c) {
        this.c = c;
    }

    String strToInsert = "http://www.yyc.com";
    @Override
    public void exec() {
        c.msg = c.msg + strToInsert;
    }

    @Override
    public void undo() {
        c.msg = c.msg.substring(0,c.msg.length()-strToInsert.length());
    }
}
