package Instrument;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class InstrumentService {
    static Map<Integer, List<Instrument>> userVsInstrument=new HashMap<Integer,List<Instrument>>();
    public abstract InstrumentDAO addInstrument(InstrumentDAO instrumentDAO);
    public abstract List<InstrumentDAO> getInstrumentByUserId(int userId);
}
