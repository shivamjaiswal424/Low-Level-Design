public class Dog extends LivingThings{
    public Dog(BreathingProcess BreathingProcess) {
        super(BreathingProcess);
    }

    @Override
    public void breath() {
        System.out.println("Dog breathing");
        breathingProcess.breath();
    }
}
