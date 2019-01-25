package com.deepak.classes;

import com.deepak.templates.Hotel;
import com.deepak.templates.HotelClass;

public class Gold extends HotelClass implements Hotel{


        public Gold() {
                this.set_value(300);
                this.set_rent(150);
                this.set_upgrade(200);
        }
        @Override
        public void upgrade() {

        }
}
