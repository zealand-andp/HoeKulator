package beregnafskrivning;

import entities.exceptions.*;

import java.lang.reflect.Array;
import java.util.LinkedHashMap;

public class SaldoAfskrivningBeregnerImpl implements SaldoAfskrivningsRequest, AfskrivningsBeregner{

   private double resultat;
   AfskrivningsBeregner afskrivningsBeregner;
   @Override
   public void beregnAfskrivning(AfskrivningsRequest request) throws NegativBeloebException, NegativEllerNulVaerdiException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException, OverMaksbeloebException, NegativVaerdiException, NegativAfskrivningsprocentException {
      if (request.hentAfskrivningsmetode() != Afskrivningsmetoder.SALDO){
         afskrivningsBeregner.beregnAfskrivning(request);
      }
      if (request.hentAfskrivningsProcent() <0){
         throw new NegativAfskrivningsprocentException();
      }
      if (request.hentAnskaffelsesvaedi()<0){
         throw new NegativBeloebException("beløb må ikke være negativt");
      }

   }
}
