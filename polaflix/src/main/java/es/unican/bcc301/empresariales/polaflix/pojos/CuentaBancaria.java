package es.unican.bcc301.empresariales.polaflix.pojos;

public class CuentaBancaria {

    private String IBAN;

    public CuentaBancaria(String iBAN) {
        IBAN = iBAN;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String iBAN) {
        IBAN = iBAN;
    }

    @Override
    public boolean equals(Object o) {

        CuentaBancaria cuenta;

        if (!(o instanceof CuentaBancaria)) {
            return false;
        } else {
            cuenta = (CuentaBancaria) o;
        }

        return this.IBAN.equals(cuenta.getIBAN());
    }
}
