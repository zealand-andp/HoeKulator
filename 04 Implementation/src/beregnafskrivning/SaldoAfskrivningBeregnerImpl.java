package beregnafskrivning;

import entities.exceptions.*;

public class SaldoAfskrivningBeregnerImpl implements SaldoAfskrivningsRequest, AfskrivningsBeregner{

   private double resultat;
   AfskrivningsBeregner afskrivningsBeregner;
   SaldoAfskrivningsRequest saldoAfskrivningsRequest;
   SaldoAfskrivningBeregnerImpl saldoAfskrivningBeregnerImpl;

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
      if (request.hentAfskrivningsProcent()>3.5){

      }

      saldoAfskrivningsRequest=(SaldoAfskrivningBeregnerImpl) request;
      double anskaffelsesvardi = saldoAfskrivningsRequest.hentAnskaffelsesvaedi();
      double saldoAfksrivningsProcent = saldoAfskrivningsRequest.hentAfskrivningsProcent()


   }
}
