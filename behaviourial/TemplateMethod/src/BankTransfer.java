public class BankTransfer extends PaymentFlow{
    @Override
    public void validatePayment() {
        System.out.println("Enter Amount to Transfer for Bank transfer");
    }

    @Override
    public void debitAmount() {
        System.out.println("Enter Amount to Debit for Bank transfer");
    }

    @Override
    public void calculateFees() {
        System.out.println("Enter Amount to calculate fees for Bank transfer");
    }

    @Override
    public void creditAmount() {
        System.out.println("Enter Amount to credit for Bank transfer");
    }
}
