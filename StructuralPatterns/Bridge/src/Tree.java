public class Tree extends LivingThings{
    public Tree(BreathingProcess breathingProcess) {
        super(breathingProcess);
    }
    @Override
    public void breath() {
        System.out.println("Tree breathing");
        breathingProcess.breath();
    }
}
