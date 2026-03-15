import Instrument.InstrumentController;
import Instrument.InstrumentDAO;
import Instrument.InstrumentType;
import Transaction.Transaction;
import Transaction.TransactionController;
import Transaction.TransactionDAO;
import User.User;
import User.UserController;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("\nLLD Code - Payment Gateway\n");

        InstrumentController instrumentController = new InstrumentController();
        UserController userController = new UserController();
        TransactionController transactionController = new TransactionController();

        // Add USER1
        User user1 = new User();
        user1.setUserName("Alice");
        user1.setMail("alice@conceptandcoding.com");
        User user1Details = userController.addUser(user1);

        // Add USER2
        User user2 = new User();
        user2.setUserName("Bob");
        user2.setMail("bob@conceptandcoding.com");
        User user2Details = userController.addUser(user2);

        // Add Bank to User1
        InstrumentDAO bankInstrumentDO = new InstrumentDAO();
        bankInstrumentDO.setBankAccountNumber("234324234324324");
        bankInstrumentDO.setInstrumentType(InstrumentType.BANK);
        bankInstrumentDO.setUserId(user1Details.getUserID());
        bankInstrumentDO.setIfsc("ER3223E");
        InstrumentDAO user1BankInstrument = instrumentController.addInstrument(bankInstrumentDO);
        System.out.println("Bank Instrument created for User1: " + user1BankInstrument.getInstrumentID());

        // Add Card to User2
        InstrumentDAO cardInstrumentDO = new InstrumentDAO();
        cardInstrumentDO.setCardNumber("1230099");
        cardInstrumentDO.setInstrumentType(InstrumentType.CARD);
        cardInstrumentDO.setCvv("0000");
        cardInstrumentDO.setUserId(user2Details.getUserID());
        InstrumentDAO user2CardInstrument = instrumentController.addInstrument(cardInstrumentDO);
        System.out.println("Card Instrument created for User2: " + user2CardInstrument.getInstrumentID());

        // Make Payment
        TransactionDAO transactionDO = new TransactionDAO();
        transactionDO.setTransactionID(101);
        transactionDO.setAmount(500);
        transactionDO.setSenderID(user1Details.getUserID());
        transactionDO.setReceiverID(user2Details.getUserID());
        transactionDO.setDebitInstrumentID(user1BankInstrument.getInstrumentID());
        transactionDO.setCreditInstrumentID(user2CardInstrument.getInstrumentID());
        transactionController.makePayment(transactionDO);

        // Get all instruments of USER1
        List<InstrumentDAO> user1Instruments = instrumentController.getAllInstruments(user1Details.getUserID());
        for (InstrumentDAO instrumentDO : user1Instruments) {
            System.out.println("\nUser1 Name: " + user1Details.getUserName() +
                    "; UserID: " + instrumentDO.getUserId() +
                    "; InstrumentID: " + instrumentDO.getInstrumentID() +
                    "; InstrumentType: " + instrumentDO.getInstrumentType().name());
        }

        // Get all instruments of USER2
        List<InstrumentDAO> user2Instruments = instrumentController.getAllInstruments(user2Details.getUserID());
        for (InstrumentDAO instrumentDO : user2Instruments) {
            System.out.println("User2 Name: " + user2Details.getUserName() +
                    "; UserID: " + instrumentDO.getUserId() +
                    "; InstrumentID: " + instrumentDO.getInstrumentID() +
                    "; InstrumentType: " + instrumentDO.getInstrumentType().name());
        }

        // Get transaction history of USER1
        List<Transaction> user1TransactionList = transactionController.getTransactionHistory(user1Details.getUserID());
        for (Transaction txn : user1TransactionList) {
            System.out.println("\nUser1 txnID: " + txn.getTxnID() +
                    "; Amount: " + txn.getAmount() +
                    "; Sender: " + txn.getSenderId() +
                    "; Receiver: " + txn.getReceiverId());
        }

        // Get transaction history of USER2
        List<Transaction> user2TransactionList = transactionController.getTransactionHistory(user2Details.getUserID());
        for (Transaction txn : user2TransactionList) {
            System.out.println("User2 txnID: " + txn.getTxnID() +
                    "; Amount: " + txn.getAmount() +
                    "; Sender: " + txn.getSenderId() +
                    "; Receiver: " + txn.getReceiverId());
        }

    }
}