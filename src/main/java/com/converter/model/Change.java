package com.converter.model;

import com.converter.utilities.CurrencyOmbd;

public class Change {
    private String base;
    private String target;
    private double amount;
    private double exchangeRate;
    private double result;

    public Change(CurrencyOmbd search , double amount ){
        this.base=search.base_code();
        this.target=search.target_code();
        this.exchangeRate=search.conversion_rate();
        this.result= search.conversion_result();
        this.amount=amount;
    }

    @Override
    public String toString() {
        return
          "-------------------------------------"+'\n'+
          "Moneda de origen =  " + base + '\n' +
          "Moneda de destino = " + target + '\n' +
          "Cantidad = " + amount + '\n' +
          "Tasa de conversion = " + exchangeRate + '\n' +
          "Resultado  = " + result+ '\n';
    }
}
