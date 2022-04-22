package degisn.command;

public class Main {
    public static void main(String[] args) {
        Content content = new Content();
        Command insertCommand = new InsertCommand(content);
        insertCommand.exec();
        System.out.println(content.msg);
        insertCommand.undo();
        System.out.println(content.msg);
        Command deleteCommand = new DeleteCommand(content);
        deleteCommand.exec();
        System.out.println(content.msg);
        deleteCommand.undo();
        System.out.println(content.msg);
    }
}
