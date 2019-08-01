package com.kata.tennis.game;

import com.kata.tennis.model.Player;

public class TennisGame {
	
	private Player playerOne;
	private Player playerTwo;
	
	public TennisGame(Player playerOne, Player playerTwo) {
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
	}
	
	public void playerOneScoresPoint()
	{
		playerOne.setPoint(playerOne.getPoint()+1);
	}
	
	public void playerTwoScoresPoint()
	{
		playerTwo.setPoint(playerTwo.getPoint()+1);
	}
	
	public String determineScore()
	{
		return "Love-All";
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
