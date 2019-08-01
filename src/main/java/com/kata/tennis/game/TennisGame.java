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
		String playerOneScoreAsString = convertPoint(playerOne.getPoint());
		String playerTwoScoreAsString = convertPoint(playerTwo.getPoint());

		if (playerOneScoreAsString != null && playerOneScoreAsString.equalsIgnoreCase(playerTwoScoreAsString)) {
			return playerOneScoreAsString + Constants.HYPHEN + Constants.TEXT_ALL;
		} else {
			return playerOneScoreAsString + Constants.HYPHEN + playerTwoScoreAsString;
		}
	}
	
	private String convertPoint(int point) {
		String pointInTennis = null;
		if (point == Constants.POINT_ZERO) {
			pointInTennis = Constants.TEXT_LOVE;
		} else if (point == Constants.POINT_ONE) {
			pointInTennis = Constants.TEXT_FIFTEEN;
		} 
		return pointInTennis;
	}

	public Player getPlayerOne() {
		return playerOne;
	}

	public void setPlayerOne(Player playerOne) {
		this.playerOne = playerOne;
	}

	public Player getPlayerTwo() {
		return playerTwo;
	}

	public void setPlayerTwo(Player playerTwo) {
		this.playerTwo = playerTwo;
	}

}
