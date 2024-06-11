package es.unican.bcc301.empresariales.polaflix.pojos;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

@Embeddable
public class CuentaBancaria {

    @Id
    private String IBAN;

    public CuentaBancaria() { }
    public CuentaBancaria(String IBAN) {
        this.IBAN = IBAN;
    }

    
    // metodos auxiliares

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


    // getters y setters

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String iBAN) {
        IBAN = iBAN;
    }

}
