package com.deepak.classes;

import com.deepak.templates.Hotel;
import com.deepak.templates.HotelClass;

public class Silver extends HotelClass implements Hotel {


    public Silver() {
        this.set_value(200);
        this.set_rent(50);
        this.set_upgrade(100);

    }
    @Override
    public void upgrade() {

    }
}
