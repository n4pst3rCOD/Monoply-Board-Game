package com.deepak.classes;

public class CentralBank {

    public int get_startignBankBalance() {
        return _startignBankBalance;
    }

    public CentralBank(int _startignBankBalance, int _currentBankBalance) {
        this._startignBankBalance = _startignBankBalance;
        this._currentBankBalance = _currentBankBalance;
    }

    public void set_startignBankBalance(int _startignBankBalance) {
        this._startignBankBalance = _startignBankBalance;
    }

    public int get_currentBankBalance() {
        return _currentBankBalance;
    }

    public void set_currentBankBalance(int _currentBankBalance) {
        this._currentBankBalance = _currentBankBalance;
    }

    private int _startignBankBalance;
    private int _currentBankBalance;


}
