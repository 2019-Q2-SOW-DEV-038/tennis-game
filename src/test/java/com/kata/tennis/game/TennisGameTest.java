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
		createScore(1,0);
		Assert.assertEquals("Fifteen-Love", tennisGame.determineScore());
	}
	
	@Test
	public void shouldReturnLoveFifteenWhenScoreIsLoveFifteen() {
		createScore(0,1);
		Assert.assertEquals("Love-Fifteen", tennisGame.determineScore());
	}
	
	@Test
	public void shouldReturnFifteenAllWhenScoreIsFifteenAll() {
		createScore(1,1);
		Assert.assertEquals("Fifteen-All", tennisGame.determineScore());
	}
	
	private void createScore(int playerOnePoint,int playerTwoPoint)
	{
		for(int pointCounter=0;pointCounter<playerOnePoint;pointCounter++)
		{
			tennisGame.scorePoint(PLAYER_ONE_NAME);
		}
		for(int pointCounter=0;pointCounter<playerTwoPoint;pointCounter++)
		{
			tennisGame.scorePoint(PLAYER_TWO_NAME);
		}
	}
}
