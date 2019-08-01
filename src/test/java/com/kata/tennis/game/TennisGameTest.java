package com.kata.tennis.game;

import org.junit.Assert;
import org.junit.Test;

public class TennisGameTest {

	@Test
	public void shouldCreateNewTennisGameWithTwoPlayers() {
		TennisGame tennisGame = new TennisGame("Federer", "Nadal");
		Assert.assertEquals("Federer", tennisGame.getPlayerOneName());
		Assert.assertEquals("Nadal", tennisGame.getPlayerTwoName());
	}
	
	@Test
	public void playerOneScoreIncreasesAfterWinningPoint() {
		TennisGame tennisGame = new TennisGame("Federer", "Nadal");
		tennisGame.playerOneScoresPoint();
		Assert.assertEquals(1, tennisGame.getPlayerOnePoint());
	}
	
	@Test
	public void playerTwoScoreIncreasesAfterWinningPoint() {
		TennisGame tennisGame = new TennisGame("Federer", "Nadal");
		tennisGame.playerTwoScoresPoint();
		Assert.assertEquals(1, tennisGame.getPlayerTwoPoint());
	}

}
