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
			playerOne.setPoint(playerOne.getPoint() + Constants.POINT_ONE);
		} else if (pointWinningPlayerName.equalsIgnoreCase(playerTwo.getName())) {
			playerTwo.setPoint(playerTwo.getPoint() + Constants.POINT_ONE);
		}
	}
	
	public String determineScore()
	{	
		String gameScore = null;
		if (isGameOver()) {
			gameScore = fetchLeadingPlayer().getName() + Constants.HYPHEN + Constants.TEXT_WINS;
		} else if (isDeuce()) {
			gameScore = Constants.TEXT_DEUCE;
		} else if (isAdvantage()) {
			gameScore = Constants.TEXT_ADVANTAGE + Constants.HYPHEN + fetchLeadingPlayer().getName();
		} else {
			gameScore = formatGameScore(playerOne.getPoint(), playerTwo.getPoint());
		}
		return gameScore;
	}
	
	private static String convertPoint(int point) {
		return Constants.SCORES[point];
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
	
	public boolean containsPlayer(String name)
	{
		return name.equalsIgnoreCase(playerOne.getName())||name.equalsIgnoreCase(playerTwo.getName());
	}
}
