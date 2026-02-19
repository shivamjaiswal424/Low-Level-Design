public class Fish extends LivingThings{
    public Fish(BreathingProcess BreathingProcess) {
        super(BreathingProcess);
    }

    @Override
    public void breath() {
        System.out.println("Fish breathing");
        breathingProcess.breath();
    }
}
