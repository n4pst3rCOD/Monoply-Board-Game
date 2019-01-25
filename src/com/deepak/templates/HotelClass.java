package com.deepak.templates;

public abstract class HotelClass {

    private int _value;
    private int _rent;
    private int _upgrade;

    public int get_upgrade() {
        return _upgrade;
    }

    public void set_upgrade(int _upgrade) {
        this._upgrade = _upgrade;
    }

    public int get_value() {
        return _value;
    }

    public void set_value(int _value) {
        this._value = _value;
    }

    public int get_rent() {
        return _rent;
    }

    public void set_rent(int _rent) {
        this._rent = _rent;
    }
}
