package beregnafskrivning;

import entities.exceptions.*;

public class SaldoAfskrivningBeregnerImpl implements SaldoAfskrivningBeregner{

   private double resultat;
   AfskrivningsBeregner afskrivningsBeregner;
   SaldoAfskrivningRequest saldoAfskrivningsRequest;


   @Override
   public void beregnAfskrivning(AfskrivningRequest request) throws NegativBeloebException, NegativEllerNulVaerdiException, ScrapvaerdiStoerreEndAnskaffelsesvaerdiException, OverMaksbeloebException, NegativVaerdiException, NegativAfskrivningsprocentException {
      if (request.hentAfskrivningsmetode() != Afskrivningsmetoder.SALDO){
         //Sender programmet videre til næste del af systemet
         afskrivningsBeregner = new StraksAfskrivningBeregnerImpl();
         afskrivningsBeregner.beregnAfskrivning(request);
      }

      if (((SaldoAfskrivningRequest) request).hentAfskrivningsProcent() < 0){
         //thrower en Exception hvis Afksrivningsprocenten er under 0
         throw new NegativAfskrivningsprocentException();
      }

      if (request.hentAnskaffelsesvaerdi() < 0) {
         //thrower en Exception hvis Anskaffelsesværdien er negativ
         throw new NegativBeloebException("beløb må ikke være negativt");
      }

      if (((SaldoAfskrivningRequest) request).hentAfskrivningsProcent() > 100){
         try {
            throw new UrealistiskProcentException();
         } catch (UrealistiskProcentException urealistiskProcentException) {
            urealistiskProcentException.printStackTrace();
         }
      }

      saldoAfskrivningsRequest= (SaldoAfskrivningRequest) request;
      double anskaffelsesvardi = saldoAfskrivningsRequest.hentAnskaffelsesvaerdi();
      double saldoAfksrivningsProcent = saldoAfskrivningsRequest.hentAfskrivningsProcent();
      this.resultat = (anskaffelsesvardi / 100) * saldoAfksrivningsProcent;

   }
}
