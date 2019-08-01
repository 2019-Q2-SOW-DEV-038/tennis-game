package com.kata.tennis.game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.kata.tennis.model.Player;

public class TennisGameTest {
	
	private static final String PLAYER_ONE_NAME="Federer";
	private static final String PLAYER_TWO_NAME="Nadal";
	
	private static final int POINT_ONE=1;
	
	TennisGame tennisGame;
	
	@Before
	public void setup()
	{
		tennisGame = new TennisGame(new Player(PLAYER_ONE_NAME), new Player(PLAYER_TWO_NAME));
	}
	
	@Test
	public void shouldCreateNewTennisGameWithTwoPlayers() {
		Assert.assertEquals(PLAYER_ONE_NAME, tennisGame.getPlayerOne().getName());
		Assert.assertEquals(PLAYER_TWO_NAME, tennisGame.getPlayerTwo().getName());
	}
	
	@Test
	public void playerOneScoreIncreasesAfterWinningPoint() {
		tennisGame.scorePoint(PLAYER_ONE_NAME);
		Assert.assertEquals(POINT_ONE, tennisGame.getPlayerOne().getPoint());
	}
	
	@Test
	public void playerTwoScoreIncreasesAfterWinningPoint() {
		tennisGame.scorePoint(PLAYER_TWO_NAME);
		Assert.assertEquals(POINT_ONE, tennisGame.getPlayerTwo().getPoint());
	}
	
	@Test
	public void shouldReturnLoveAllWhenScoreIsLoveAll() {
		Assert.assertEquals("Love-All", tennisGame.determineScore());
	}
	
	@Test
	public void shouldReturnFifteenLoveWhenScoreIsFifteenLove() {
		tennisGame.scorePoint(PLAYER_ONE_NAME);
		Assert.assertEquals("Fifteen-Love", tennisGame.determineScore());
	}
	
	@Test
	public void shouldReturnLoveFifteenWhenScoreIsLoveFifteen() {
		tennisGame.scorePoint(PLAYER_TWO_NAME);
		Assert.assertEquals("Love-Fifteen", tennisGame.determineScore());
	}
	
	@Test
	public void shouldReturnFifteenAllWhenScoreIsFifteenAll() {
		tennisGame.scorePoint(PLAYER_ONE_NAME);
		tennisGame.scorePoint(PLAYER_TWO_NAME);
		Assert.assertEquals("Fifteen-All", tennisGame.determineScore());
	}

}
