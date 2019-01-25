package com.deepak.classes;

import com.deepak.templates.Hotel;
import com.deepak.templates.HotelClass;

public class Platinum extends HotelClass implements Hotel {


    public Platinum() {
        this.set_value(500);
        this.set_rent(200);
        this.set_upgrade(0);
  }


    @Override
    public void upgrade() {


    }


}
