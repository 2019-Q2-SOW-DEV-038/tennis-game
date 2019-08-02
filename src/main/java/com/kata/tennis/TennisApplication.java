package com.kata.tennis;

import java.util.Scanner;

import com.kata.tennis.model.Player;
import com.kata.tennis.game.TennisGame;

public class TennisApplication {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		TennisGame tennisGame = initializeTennisGame(scanner);
		playGame(scanner, tennisGame);
		scanner.close();
	}

	private static TennisGame initializeTennisGame(Scanner scanner) {
		String playerOneName;
		String playerTwoName;
		while (true) {
			System.out.print("Enter Player 1 Name:");
			playerOneName = scanner.nextLine();
			System.out.print("Enter Player 2 Name:");
			playerTwoName = scanner.nextLine();

			if (!playerOneName.equalsIgnoreCase(playerTwoName)) {
				break;
			}

			System.out.println("Player names cant be same!");
		}
		return new TennisGame(new Player(playerOneName), new Player(playerTwoName));
	}

	private static void playGame(Scanner scanner, TennisGame tennisGame) {
		boolean isGameFinished = false;
		System.out.println("Game starts!");
		while (!isGameFinished) {
			System.out.print("Next point won by " + tennisGame.getPlayerOne().getName() + " or "
					+ tennisGame.getPlayerTwo().getName() + ":");
			String pointWinningPlayerName = scanner.nextLine();
			if (pointWinningPlayerName != null && tennisGame.containsPlayer(pointWinningPlayerName)) {
				tennisGame.scorePoint(pointWinningPlayerName);
				String score = tennisGame.determineScore();
				printScoreCard(score);
				isGameFinished = score.contains("wins");
			} else {
				System.out.println("Invalid Player Name!");
			}
		}
		System.out.println("Game over!");
	}

	private static void printScoreCard(String score) {
		System.out.println("***************************************************");
		System.out.println("Current Score :"+score);
		System.out.println("***************************************************");
	}
}
