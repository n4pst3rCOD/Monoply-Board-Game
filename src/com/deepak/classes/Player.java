package com.deepak.classes;


import java.util.ArrayList;

public class Player {

    private  int _id;
    private String _playerName;
    private int _initialBalance;
    private ArrayList<String> _hotelsOwned;
    private int _playerBalance;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public Player(int id, String _playerName, int _initialBalance, ArrayList<String> _hotelsOwned, int _playerBalance) {
        this._id = _id;
        this._playerName = _playerName;
        this._initialBalance = _initialBalance;
        this._hotelsOwned = _hotelsOwned;
        this._playerBalance = _playerBalance;

    }

    public String get_playerName() {
        return _playerName;
    }

    public void set_playerName(String _playerName) {
        this._playerName = _playerName;
    }

    public int get_initialBalance() {
        return _initialBalance;
    }

    public void set_initialBalance(int _initialBalance) {
        this._initialBalance = _initialBalance;
    }

    public ArrayList<String> get_hotelsOwned() {
        return _hotelsOwned;
    }

    public void set_hotelsOwned(ArrayList<String> _hotelsOwned) {
        this._hotelsOwned = _hotelsOwned;
    }

    public int getPlayerBalance() {
        return _playerBalance;
    }

    public void setPlayerBalance(int playerBalance) {
        this._playerBalance = playerBalance;
    }
}
