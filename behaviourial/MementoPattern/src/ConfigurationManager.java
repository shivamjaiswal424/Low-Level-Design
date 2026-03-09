import java.util.Stack;

public class ConfigurationManager {
    private static final Stack<ConfigurationMemento> history = new Stack<>();

    public static void saveState(ApplicationConfiguration appConfig) {
        ConfigurationMemento configurationMemento=appConfig.save();
        history.push(configurationMemento);
        System.out.println("Configuration saved");
        System.out.println(history.size()==1 ? "Default state" + configurationMemento : "Default state" + configurationMemento);

    }

    public void undo(ApplicationConfiguration appConfig) {
        if (history.size()>1) {
            history.pop();
            ConfigurationMemento mementoToBeRestored=history.peek();
            appConfig.restore(mementoToBeRestored);
            System.out.println("Configuration restored");
            System.out.println("[+] Undo performed. History size: " + history.size());
            System.out.println(history.size() == 1 ? "[+] Default State: " + mementoToBeRestored : "[+] Current State: " + mementoToBeRestored);
        } else {
            System.out.println("[+] No more states to undo!");
            System.out.println("[+] Default State: " + history.peek());
        }
    }
}
