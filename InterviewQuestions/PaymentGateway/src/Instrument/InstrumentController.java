package Instrument;

import java.util.ArrayList;
import java.util.List;

public class InstrumentController {
    InstrumentServiceFactory instrumentServiceFactory;
    public InstrumentController() {
        this.instrumentServiceFactory = new InstrumentServiceFactory();
    }
    public InstrumentDAO addInstrument(InstrumentDAO instrumentDAO){
        InstrumentService instrumentController=instrumentServiceFactory.getInstrumentService(instrumentDAO.instrumentType);
        return instrumentController.addInstrument(instrumentDAO);
    }
    public List<InstrumentDAO> getAllInstruments(int userId){
        InstrumentService bankInstrumentController=instrumentServiceFactory.getInstrumentService(InstrumentType.BANK);
        InstrumentService cardInstrumentController=instrumentServiceFactory.getInstrumentService(InstrumentType.CARD);
        List<InstrumentDAO> instrumentDAOList=bankInstrumentController.getInstrumentByUserId(userId);
        instrumentDAOList.addAll(cardInstrumentController.getInstrumentByUserId(userId));
        return instrumentDAOList;
    }
    public InstrumentDAO getInstrumentbyId(int userId,int instrumentId){
        List<InstrumentDAO> instrumentDAOList=getAllInstruments(userId);
        for(InstrumentDAO instrumentDAO:instrumentDAOList){
            if(instrumentDAO.getInstrumentID()==instrumentId){
                return instrumentDAO;
            }
        }
        return null;
    }
}
