package com.deepak.classes;

import com.deepak.templates.HotelClass;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Turn {

    public static int issueTurn(int min, int max) {

        return ThreadLocalRandom.current().nextInt(min, max + 1);

    }

    public static int cellValue(int value) {

        if (value >= 10)
            return value % 10;

        return value;
    }

    public static int cellType(String type, Player player, CentralBank bank, int currCellValue, String[] hotels, int[] ownedBy) {

        switch (type) {

            case "J":
                player.setPlayerBalance(player.getPlayerBalance() - 150);
                bank.set_currentBankBalance(bank.get_currentBankBalance() + 150);
                return 0;
            case "H":
                String hotelType = hotels[currCellValue];
                return hotelExecution(hotelType, currCellValue, ownedBy, player, bank);
            case "L":
                player.setPlayerBalance(player.getPlayerBalance() + 200);
                bank.set_currentBankBalance(bank.get_currentBankBalance() - 200);
                return 0;
            case "E":
                return 0;

        }

        return 0;
    }

    public static int hotelExecution(String hotelType, int currCellValue, int[] ownedBy, Player player, CentralBank bank) {

        switch (hotelType) {
            case "P":
                return transferOwnershipAndCalcualteRent(new Platinum(), currCellValue, ownedBy, player, bank);
            case "G":
                return transferOwnershipAndCalcualteRent(new Gold(), currCellValue, ownedBy, player, bank);
            case "S":
                return transferOwnershipAndCalcualteRent(new Silver(), currCellValue, ownedBy, player, bank);
        }
        return 0;
    }

    private static Integer transferOwnershipAndCalcualteRent(HotelClass hotel, int currCellValue, int[] ownedBy, Player player, CentralBank bank) {
        if (ownedBy[currCellValue] == 0 && player.get_id() == 1) {
            updateBankAndPlayerBalance(currCellValue, ownedBy, player, bank, 1, hotel.get_value());

        } else if (ownedBy[currCellValue] == 0 && player.get_id() == 2) {
            updateBankAndPlayerBalance(currCellValue, ownedBy, player, bank, 2, hotel.get_value());
        } else if (ownedBy[currCellValue] == 1 && player.get_id() == 2) {
            player.setPlayerBalance(player.getPlayerBalance() - hotel.get_rent());
        } else if(ownedBy[currCellValue] == 2 && player.get_id() == 1) {
            player.setPlayerBalance(player.getPlayerBalance() - hotel.get_rent());
        }

        if (ownedBy[currCellValue] == player.get_id()) {
                player.setPlayerBalance(player.getPlayerBalance() - hotel.get_upgrade());
            bank.set_currentBankBalance(bank.get_currentBankBalance() + hotel.get_upgrade());
                return 0;
            }


        return hotel.get_rent();
    }

    private static void updateBankAndPlayerBalance(int currCellValue, int[] ownedBy, Player player, CentralBank bank, int playerId, int value) {
        ownedBy[currCellValue] = playerId;
        player.setPlayerBalance(player.getPlayerBalance() - value);
        bank.set_currentBankBalance(bank.get_currentBankBalance() + value);
    }
    private static void ownershipList(Player pla)


}
