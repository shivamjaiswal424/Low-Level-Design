public abstract class LivingThings {
    protected BreathingProcess breathingProcess;
    public LivingThings(BreathingProcess BreathingProcess) {
        this.breathingProcess = BreathingProcess;
    }
    abstract public void breath();
}
