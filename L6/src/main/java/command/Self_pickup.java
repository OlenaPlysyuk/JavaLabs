package command;

public class Self_pickup implements CommandInterface{
    @Override
    public CommandResult<String> execute() throws Exception {
        CommandResult<String> result = new CommandResult<String>("Choosing self pick up was successful","Without errors",true);
        return result;
    }
}
