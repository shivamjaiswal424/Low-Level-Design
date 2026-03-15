package Transaction;

import Instrument.InstrumentController;
import Instrument.InstrumentDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionService {
    public static Map<Integer, List<Transaction>> userVsTransactionsList = new HashMap<>();
    InstrumentController instrumentController;
    Processor processor;

    public TransactionService() {
        instrumentController = new InstrumentController();
        processor = new Processor();
    }

    public List<Transaction> getTransactionHistory(int userID) {
        return userVsTransactionsList.get(userID);
    }

    public TransactionDAO makePayment(TransactionDAO txnDO) {
        // validate details

        // load sender instrument details which need to be passed to processors
        InstrumentDAO senderInstrumentDO = instrumentController.getInstrumentbyId(txnDO.getSenderID(), txnDO.getDebitInstrumentID());

        // load receiver instrument details which need to be passed to processors
        InstrumentDAO receiverInstrumentDO = instrumentController.getInstrumentbyId(txnDO.getReceiverID(), txnDO.getCreditInstrumentID());

        // pass the instrument details to processor
        processor.processPayment(senderInstrumentDO, receiverInstrumentDO);

        //based on processor response, we will set the status. for now har coding it to SUCCESS
        Transaction txn = new Transaction();
        txn.setAmount(txnDO.getAmount());
        txn.setTxnID(txnDO.getTransactionID());
        txn.setSenderId(txnDO.getSenderID());
        txn.setReceiverId(txnDO.getReceiverID());
        txn.setDebitInstrumentId(txnDO.getDebitInstrumentID());
        txn.setCreditInstrumentId(txnDO.getCreditInstrumentID());
        txn.setStatus(TransactionStatus.SUCCESS);

        //history
        List<Transaction> senderTxnsList = userVsTransactionsList.get(txn.getSenderId());
        if (senderTxnsList == null) {
            senderTxnsList = new ArrayList<>();
            userVsTransactionsList.put(txn.getSenderId(), senderTxnsList);
        }
        senderTxnsList.add(txn);
        List<Transaction> receiverTxnLists = userVsTransactionsList.get(txn.getReceiverId());
        if (receiverTxnLists == null) {
            receiverTxnLists = new ArrayList<>();
            userVsTransactionsList.put(txn.getReceiverId(), receiverTxnLists);
        }
        receiverTxnLists.add(txn);
        txnDO.setTransactionID(txn.getTxnID());
        txnDO.setStatus(txn.getStatus());
        return txnDO;
    }

}
