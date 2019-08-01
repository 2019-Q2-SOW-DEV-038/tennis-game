package com.kata.tennis.game;

public class TennisGame {
	
	private String playerOneName;
	private String playerTwoName;
	private int playerOnePoint;
	private int playerTwoPoint;
	
	public TennisGame(String playerOneName, String playerTwoName) {
		this.playerOneName = playerOneName;
		this.playerTwoName = playerTwoName;
	}
	
	public void playerOneScoresPoint()
	{
		playerOnePoint++;
	}
	
	public void playerTwoScoresPoint()
	{
		playerTwoPoint++;
	}

	public String getPlayerOneName() {
		return playerOneName;
	}

	public void setPlayerOneName(String playerOneName) {
		this.playerOneName = playerOneName;
	}

	public String getPlayerTwoName() {
		return playerTwoName;
	}

	public void setPlayerTwoName(String playerTwoName) {
		this.playerTwoName = playerTwoName;
	}

	public int getPlayerOnePoint() {
		return playerOnePoint;
	}

	public void setPlayerOnePoint(int playerOnePoint) {
		this.playerOnePoint = playerOnePoint;
	}

	public int getPlayerTwoPoint() {
		return playerTwoPoint;
	}

	public void setPlayerTwoPoint(int playerTwoPoint) {
		this.playerTwoPoint = playerTwoPoint;
	}
}
