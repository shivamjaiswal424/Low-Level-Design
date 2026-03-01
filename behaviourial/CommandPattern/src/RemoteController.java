import java.util.Stack;

public class RemoteController {
    ICommand command;
    Stack<ICommand> commandStack=new Stack<>();

    RemoteController(){

    }
    public void setCommand(ICommand command){
        this.command=command;
    }
    public void pressButton(){
        command.execute();
        commandStack.push(command);
    }
    public void undo(){
        if(!commandStack.isEmpty()){
            ICommand lastCommand=commandStack.pop();
            lastCommand.undo();
        }
    }

}
