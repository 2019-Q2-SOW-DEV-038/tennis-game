package com.kata.tennis.game;

import com.kata.tennis.constant.Constants;
import com.kata.tennis.model.Player;

public class TennisGame {
	
	private Player playerOne;
	private Player playerTwo;
	
	public TennisGame(Player playerOne, Player playerTwo) {
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
	}
	
	public void scorePoint(String pointWinningPlayerName) {
		if (pointWinningPlayerName.equalsIgnoreCase(playerOne.getName())) {
			playerOne.setPoint(playerOne.getPoint() + 1);
		} else if (pointWinningPlayerName.equalsIgnoreCase(playerTwo.getName())) {
			playerTwo.setPoint(playerTwo.getPoint() + 1);
		}
	}
	
	public String determineScore()
	{	
		if (isGameOver()) {
			return fetchLeadingPlayer().getName() + Constants.HYPHEN + Constants.TEXT_WINS;
		}
		
		if (isDeuce()) {
			return Constants.TEXT_DEUCE;
		}
		
		if (isAdvantage()) {
			return Constants.TEXT_ADVANTAGE + Constants.HYPHEN + fetchLeadingPlayer().getName();
		}

		return formatGameScore(playerOne.getPoint(), playerTwo.getPoint());
	}
	
	private static String convertPoint(int point) {
		String pointInTennis = null;
		switch (point) {
		case Constants.POINT_ZERO:
			pointInTennis = Constants.TEXT_LOVE;
			break;
		case Constants.POINT_ONE:
			pointInTennis = Constants.TEXT_FIFTEEN;
			break;
		case Constants.POINT_TWO:
			pointInTennis = Constants.TEXT_THIRTY;
			break;
		case Constants.POINT_THREE:
			pointInTennis = Constants.TEXT_FORTY;
			break;
		default:
		}
		return pointInTennis;
	}

	public Player getPlayerOne() {
		return playerOne;
	}
	
	public Player getPlayerTwo() {
		return playerTwo;
	}
	
	private boolean isScoresLevel() {
		return playerOne.getPoint() == playerTwo.getPoint();
	}
	
	private boolean isBothPlayersReachedForty() {
		return (playerOne.getPoint() + playerTwo.getPoint() > Constants.MINIMUM_POINTS_FOR_DEUCE);
	}
	
	private boolean isDeuce() {
		return (isScoresLevel() && isBothPlayersReachedForty());
	}
	
	private boolean isAdvantage() {
		return (!isScoresLevel() && isBothPlayersReachedForty());
	}
	
	private Player fetchLeadingPlayer() {
		return (playerOne.getPoint() > playerTwo.getPoint()) ? playerOne : playerTwo;
	}
	
	private boolean isGameOver() {
		return (fetchLeadingPlayer().getPoint() > Constants.POINT_THREE
				&& pointDifferenceBetweenPlayers() > Constants.POINT_ONE);
	}
	
	private int pointDifferenceBetweenPlayers() {
		return Math.abs(playerOne.getPoint() - playerTwo.getPoint());
	}
	
	private static String formatGameScore(int playerOnePoint,int playerTwoPoint)
	{	
		String gameScore=null;
		String convertedPlayerOneScore = convertPoint(playerOnePoint);
		String convertedPlayerTwoScore = convertPoint(playerTwoPoint);
		
		if (convertedPlayerOneScore != null && convertedPlayerOneScore.equalsIgnoreCase(convertedPlayerTwoScore)) {
			gameScore = convertedPlayerOneScore + Constants.HYPHEN + Constants.TEXT_ALL;
		} else {
			gameScore = convertedPlayerOneScore + Constants.HYPHEN + convertedPlayerTwoScore;
		}
		return gameScore;
	}
}
