public abstract class PaymentFlow {
    public abstract void validatePayment();
    public abstract void debitAmount();
    public abstract void calculateFees();
    public abstract void creditAmount();

    public final void sendMoney(){
        validatePayment();
        debitAmount();
        calculateFees();
        calculateFees();
    }
    public boolean requiresOTP(){
        return false;
    }
    public void logTransaction(){
        System.out.println("Log Transaction");
    }
}
