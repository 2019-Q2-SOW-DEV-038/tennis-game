package com.kata.tennis.game;

public class TennisGame {
	
	public String playerOneName;
	public String playerTwoName;
	public int playerOnePoint;
	public int playerTwoPoint;
	
	public TennisGame(String playerOneName, String playerTwoName) {
		this.playerOneName = playerOneName;
		this.playerTwoName = playerTwoName;
	}
	
	public void playerOneScoresPoint()
	{
		playerOnePoint++;
	}
}
