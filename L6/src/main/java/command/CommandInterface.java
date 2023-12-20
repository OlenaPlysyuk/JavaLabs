package command;

public interface CommandInterface {
    public CommandResult<String> execute() throws Exception;
}
