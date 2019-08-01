package com.kata.tennis.game;

import org.junit.Assert;
import org.junit.Test;

public class TennisGameTest {

	@Test
	public void shouldCreateNewTennisGameWithTwoPlayers() {
		TennisGame tennisGame = new TennisGame("Federer", "Nadal");
		Assert.assertEquals("Federer", tennisGame.playerOneName);
		Assert.assertEquals("Nadal", tennisGame.playerTwoName);
	}
	
	@Test
	public void playerOneScoreIncreasesAfterWinningPoint() {
		TennisGame tennisGame = new TennisGame("Federer", "Nadal");
		tennisGame.playerOneScoresPoint();
		Assert.assertEquals(1, tennisGame.playerOnePoint);
	}

}
