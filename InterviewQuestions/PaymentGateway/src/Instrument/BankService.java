package Instrument;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankService extends InstrumentService {

    @Override
    public InstrumentDAO addInstrument(InstrumentDAO instrumentDAO) {
        BankInstrument bankInstrument=new BankInstrument();
        bankInstrument.instrumentID=new Random().nextInt(100-10)+10;
        bankInstrument.bankAccountNumber=instrumentDAO.getBankAccountNumber();
        bankInstrument.ifscCode=instrumentDAO.ifsc;
        bankInstrument.instrumentType=InstrumentType.BANK;
        bankInstrument.userID=instrumentDAO.userId;
        List<Instrument> userInstrumentList=userVsInstrument.get(bankInstrument.userID);
        if(userInstrumentList==null){
            userInstrumentList=new ArrayList<Instrument>();
            userVsInstrument.put(bankInstrument.userID,userInstrumentList);
        }
        userInstrumentList.add(bankInstrument);
        return mapBanKInstrumentsToInstrumentsDAO(bankInstrument);

    }

    @Override
    public List<InstrumentDAO> getInstrumentByUserId(int userId) {
        List<Instrument> userInstrumentList=userVsInstrument.get(userId);
        List<InstrumentDAO> instrumentDAOList=new ArrayList<InstrumentDAO>();
        for(Instrument instrument:userInstrumentList){
            if (instrument.getInstrumentType()==InstrumentType.BANK){
                instrumentDAOList.add(mapBanKInstrumentsToInstrumentsDAO((BankInstrument) instrument));
            }
        }
        return instrumentDAOList;
    }
    public InstrumentDAO mapBanKInstrumentsToInstrumentsDAO(BankInstrument bankInstrument) {
        InstrumentDAO instrumentDAO=new InstrumentDAO();
        instrumentDAO.instrumentID=bankInstrument.instrumentID;
        instrumentDAO.bankAccountNumber=bankInstrument.bankAccountNumber;
        instrumentDAO.instrumentType=InstrumentType.BANK;
        instrumentDAO.ifsc=bankInstrument.ifscCode;
        instrumentDAO.userId=bankInstrument.userID;
        return instrumentDAO;
    }
}
