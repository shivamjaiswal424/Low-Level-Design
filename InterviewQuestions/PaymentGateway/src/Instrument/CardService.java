package Instrument;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardService extends InstrumentService{
    @Override
    public InstrumentDAO addInstrument(InstrumentDAO instrumentDAO) {
        CardInstrument cardInstrument = new CardInstrument();
        cardInstrument.cardNumber = instrumentDAO.getCardNumber();
        cardInstrument.instrumentID=new Random().nextInt(100-10)+10;
        cardInstrument.cvvNumber=instrumentDAO.cvv;
        cardInstrument.instrumentType=instrumentDAO.getInstrumentType();
        cardInstrument.userID=instrumentDAO.userId;
        List<Instrument> userInstrumentList=userVsInstrument.get(cardInstrument.userID);
        if(userInstrumentList==null){
            userInstrumentList=new ArrayList<Instrument>();
            userVsInstrument.put(cardInstrument.userID,userInstrumentList);

        }
        userInstrumentList.add(cardInstrument);

        return mapBanKInstrumentsToInstrumentsDAO((CardInstrument) cardInstrument);
    }

    @Override
    public List<InstrumentDAO> getInstrumentByUserId(int userId) {
        List<Instrument> userInstrumentList=userVsInstrument.get(userId);
        List<InstrumentDAO> instrumentDAOList=new ArrayList<InstrumentDAO>();
        for(Instrument instrument:userInstrumentList){
            if(instrument.getInstrumentType()==InstrumentType.CARD){
                instrumentDAOList.add(mapBanKInstrumentsToInstrumentsDAO((CardInstrument) instrument));
            }
        }
        return instrumentDAOList;
    }
    public InstrumentDAO mapBanKInstrumentsToInstrumentsDAO(CardInstrument cardInstrument) {
        InstrumentDAO instrumentDAO=new InstrumentDAO();
        instrumentDAO.instrumentID=cardInstrument.instrumentID;

        instrumentDAO.instrumentType=InstrumentType.BANK;

        instrumentDAO.userId=cardInstrument.userID;
        instrumentDAO.cardNumber=cardInstrument.cardNumber;
        instrumentDAO.cvv=cardInstrument.cvvNumber;
        return instrumentDAO;
    }
}
