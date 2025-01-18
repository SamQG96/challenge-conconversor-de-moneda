import java.util.Map;

public class FiltroMoneda {
    private Moneda moneda;

    public FiltroMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

  public double convertirMoneda(String baseCode, double valor) {

      Map<String, Double> conversionRates = moneda.conversion_rates();
      if (conversionRates.containsKey(baseCode)) {
          double tasa = conversionRates.get(baseCode);
          return valor * tasa;
      }else {
          throw new IllegalArgumentException("La Moneda de a convertir no valida");
      }

  }

    public double monedaAnterior (String Code, double valor){
        Map<String, Double> conversionRates = moneda.conversion_rates();
        if (conversionRates.containsKey(Code)) {
            double tasa = conversionRates.get(Code);
            return valor / tasa;
        }else {
            throw new IllegalArgumentException("La Moneda de origen no valida");
        }

    }
}
