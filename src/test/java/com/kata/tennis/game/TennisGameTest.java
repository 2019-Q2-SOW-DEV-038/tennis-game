package com.kata.tennis.game;

import org.junit.Assert;
import org.junit.Test;

public class TennisGameTest {
	
	private static final String PLAYER_ONE_NAME="Federer";
	private static final String PLAYER_TWO_NAME="Nadal";
	
	private static final int POINT_ONE=1;
	
	@Test
	public void shouldCreateNewTennisGameWithTwoPlayers() {
		TennisGame tennisGame = new TennisGame(PLAYER_ONE_NAME, PLAYER_TWO_NAME);
		Assert.assertEquals(PLAYER_ONE_NAME, tennisGame.getPlayerOneName());
		Assert.assertEquals(PLAYER_TWO_NAME, tennisGame.getPlayerTwoName());
	}
	
	@Test
	public void playerOneScoreIncreasesAfterWinningPoint() {
		TennisGame tennisGame = new TennisGame(PLAYER_ONE_NAME, PLAYER_TWO_NAME);
		tennisGame.playerOneScoresPoint();
		Assert.assertEquals(POINT_ONE, tennisGame.getPlayerOnePoint());
	}
	
	@Test
	public void playerTwoScoreIncreasesAfterWinningPoint() {
		TennisGame tennisGame = new TennisGame(PLAYER_ONE_NAME, PLAYER_TWO_NAME);
		tennisGame.playerTwoScoresPoint();
		Assert.assertEquals(POINT_ONE, tennisGame.getPlayerTwoPoint());
	}
	
	@Test
	public void shouldReturnLoveAllWhenScoreIsLoveAll() {
		TennisGame tennisGame = new TennisGame(PLAYER_ONE_NAME, PLAYER_TWO_NAME);
		Assert.assertEquals("Love All", tennisGame.determineScore());
	}

}
