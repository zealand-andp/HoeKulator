package beregnindtjeningsbidrag;

import entities.Indtjeningsbidrag;
import entities.KKO;
import entities.Markedsfoeringsbidrag;

public class BeregnIndtjeningsbidragImpl implements BeregnIndtjeningsbidrag {
    KKO kko;
    Markedsfoeringsbidrag markedsfoeringsbidrag;
    Indtjeningsbidrag indtjeningsbidrag;

    @Override
    public void beregnIndtjeningsbidrag(){
       if (markedsfoeringsbidrag == null || kko == null) {
       }
    }

}
