package com.kata.tennis.game;

import org.junit.Assert;
import org.junit.Test;

import com.kata.tennis.model.Player;

public class TennisGameTest {
	
	private static final String PLAYER_ONE_NAME="Federer";
	private static final String PLAYER_TWO_NAME="Nadal";
	
	private static final int POINT_ONE=1;
	
	@Test
	public void shouldCreateNewTennisGameWithTwoPlayers() {
		TennisGame tennisGame = new TennisGame(new Player(PLAYER_ONE_NAME), new Player(PLAYER_TWO_NAME));
		Assert.assertEquals(PLAYER_ONE_NAME, tennisGame.getPlayerOne().getName());
		Assert.assertEquals(PLAYER_TWO_NAME, tennisGame.getPlayerTwo().getName());
	}
	
	@Test
	public void playerOneScoreIncreasesAfterWinningPoint() {
		TennisGame tennisGame = new TennisGame(new Player(PLAYER_ONE_NAME), new Player(PLAYER_TWO_NAME));
		tennisGame.scorePoint(PLAYER_ONE_NAME);
		Assert.assertEquals(POINT_ONE, tennisGame.getPlayerOne().getPoint());
	}
	
	@Test
	public void playerTwoScoreIncreasesAfterWinningPoint() {
		TennisGame tennisGame = new TennisGame(new Player(PLAYER_ONE_NAME), new Player(PLAYER_TWO_NAME));
		tennisGame.scorePoint(PLAYER_TWO_NAME);
		Assert.assertEquals(POINT_ONE, tennisGame.getPlayerTwo().getPoint());
	}
	
	@Test
	public void shouldReturnLoveAllWhenScoreIsLoveAll() {
		TennisGame tennisGame = new TennisGame(new Player(PLAYER_ONE_NAME), new Player(PLAYER_TWO_NAME));
		Assert.assertEquals("Love-All", tennisGame.determineScore());
	}
	
	@Test
	public void shouldReturnFifteenLoveWhenScoreIsFifteenLove() {
		TennisGame tennisGame = new TennisGame(new Player(PLAYER_ONE_NAME), new Player(PLAYER_TWO_NAME));
		tennisGame.scorePoint(PLAYER_ONE_NAME);
		Assert.assertEquals("Fifteen-Love", tennisGame.determineScore());
	}

}
