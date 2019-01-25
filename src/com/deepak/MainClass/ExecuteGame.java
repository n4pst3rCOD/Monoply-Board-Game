package com.deepak.MainClass;

import com.deepak.classes.CentralBank;
import com.deepak.classes.Player;
import com.deepak.classes.Turn;

import java.util.Scanner;

public class ExecuteGame {
    private static int minValue = 1;
    private static int maxValue = 10;
    private static int lastRolledValueForPlayer1 = 0;
    private static int lastRolledValueForPlayer2 = 0;

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        int numberOfTurns = 20;
        String turn = "playerone";
        System.out.print("Enter first player name: ");
        Player playerone = new Player(0, userInput.next(), 1000, null, 1000);
        System.out.println();
        System.out.println("Enter second player name: ");
        Player playertwo = new Player(1, userInput.next(), 1000, null, 1000);
        CentralBank bank = new CentralBank(5000, 5000);

        System.out.println("Enter cells:");

        String[] cell = {"J", "H", "L", "H", "E", "L", "H", "L", "H", "J"};

        System.out.println();
        String[] hotels = {"J", "P", "L", "G", "E", "L", "S", "L", "P", "J"};
        int[] ownedBy = new int[cell.length];

        for (int i = 0; i < ownedBy.length; i++) {
            ownedBy[i] = 0;
        }

        for (int i = 0; i < numberOfTurns; i++) {
            if (turn == "playerone") {
                lastRolledValueForPlayer1 = playerMovement(playerone, playertwo, lastRolledValueForPlayer1, bank, cell, hotels, ownedBy);
                turn = "playertwo";
                continue;
            }
            if (turn == "playertwo") {
                lastRolledValueForPlayer2 = playerMovement(playertwo, playerone, lastRolledValueForPlayer2, bank, cell, hotels, ownedBy);
                turn = "playerone";
                continue;
            }
        }

        System.out.println("Player one balance: " + playerone.getPlayerBalance());
        System.out.println("Player two balance: " + playertwo.getPlayerBalance());
        System.out.println("Central Bank balance: " + bank.get_currentBankBalance());

    }

    private static int playerMovement(Player currentPlayer, Player nextPlayer, int lastRolledValueForPlayer, CentralBank bank, String[] cell, String[] hotels, int[] ownedBy){
        int rolledValue;
        int currCellValue;
        String cellValue;
        rolledValue = Turn.issueTurn(minValue, maxValue);
        System.out.print(currentPlayer.get_playerName() + " rolled: " + rolledValue);
        currCellValue = Turn.cellValue(lastRolledValueForPlayer + rolledValue - 1);
        cellValue = cell[currCellValue];
        lastRolledValueForPlayer = rolledValue;
        System.out.println(" and jumped onto " + cellValue);

        int rent = Turn.cellType(cellValue, nextPlayer, bank, currCellValue, hotels, ownedBy);
        nextPlayer.setPlayerBalance(nextPlayer.getPlayerBalance() + rent);
        return lastRolledValueForPlayer;
    }

    public static void calculateAssetsForPlayer(Player player){




    }
}
