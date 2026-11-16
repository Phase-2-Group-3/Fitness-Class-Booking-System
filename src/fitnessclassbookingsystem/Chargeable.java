

package com.mycompany.chargeable;


public interface Chargeable {
    double VAT = 0.15;
    
    double calcPrice(int sessions);
}