package com.aurionpro.model;

import java.util.Scanner;

public class TicTacToeGame {

    public static void main(String[] args) {
        Board board = new Board();
        ResultAnalyzer analyzer = new ResultAnalyzer(board);
        Scanner scanner = new Scanner(System.in);
        MarkType currentPlayer = MarkType.X;
        ResultType gameStatus = ResultType.INPROGRESS;

        System.out.println("Tic Tac Toe Game Started!");

        while (gameStatus == ResultType.INPROGRESS) {
            printBoard(board);
            System.out.println("Player " + currentPlayer + ", enter your move (1-9):");
            
            int move = -1;
            boolean validInput = false;
            
            while(!validInput) {
                try {
                    move = Integer.parseInt(scanner.nextLine());
                    if (move < 1 || move > 9) {
                        System.out.println("Invalid input. Please enter a number between 1 and 9.");
                        continue;
                    }
                    int row = (move - 1) / 3;
                    int col = (move - 1) % 3;
                    
                    if (board.setCellMark(row, col, currentPlayer)) {
                        validInput = true;
                    } else {
                        System.out.println("This cell is already marked or it's not your turn. Try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("That's not a number. Please enter a number between 1 and 9.");
                }
            }

            gameStatus = analyzer.analyzeResult();

            if (gameStatus == ResultType.WIN) {
                printBoard(board);
                System.out.println("Player " + currentPlayer + " wins!");
            } else if (gameStatus == ResultType.DRAW) {
                printBoard(board);
                System.out.println("The game is a draw!");
            } else {
                currentPlayer = (currentPlayer == MarkType.X) ? MarkType.O : MarkType.X;
            }
        }
        scanner.close();
    }

    public static void printBoard(Board board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                MarkType mark = board.getCell(i, j).getMark();
                char symbol = mark == MarkType.EMPTY ? (char)('1' + i * 3 + j) : mark.name().charAt(0);
                System.out.print(symbol + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
}