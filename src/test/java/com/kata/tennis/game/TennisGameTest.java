package com.kata.tennis.game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.kata.tennis.model.Player;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class TennisGameTest {

	private static final String PLAYER_ONE_NAME = "Federer";
	private static final String PLAYER_TWO_NAME = "Nadal";

	private static final int POINT_ONE = 1;

	TennisGame tennisGame;

	@Before
	public void setup() {
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
    @Parameters({
    	"0, 0, Love-All",
        "1, 0, Fifteen-Love", 
        "0, 1, Love-Fifteen", 
        "1, 1, Fifteen-All",
        "2, 0, Thirty-Love",
        "2, 1, Thirty-Fifteen",
        "2, 2, Thirty-All",
        "0, 2, Love-Thirty",
        "1, 2, Fifteen-Thirty",
        "3, 0, Forty-Love",
        "3, 1, Forty-Fifteen",
        "3, 2, Forty-Thirty",
        "0, 3, Love-Forty",
        "1, 3, Fifteen-Forty",
        "2, 3, Thirty-Forty"})
	public void shouldReturnScoreInTennisFormatBasedOnThePointsScoredByPlayers(int playerOnePoint, int playerTwoPoint,
			String gameScore) {
		createScore(playerOnePoint, playerTwoPoint);
		Assert.assertEquals(gameScore, tennisGame.determineScore());
	}
	
	@Test
	@Parameters({
    	"3, 3",
        "4, 4", 
        "5, 5", 
        "6, 6",
        "9, 9"})
	public void shouldReturnDeuceWhenScoresAreLevelAndBothPlayersReachedForty(int playerOnePoint, int playerTwoPoint)
	{
		createScore(playerOnePoint, playerTwoPoint);
		Assert.assertEquals("Deuce", tennisGame.determineScore());
	}
	
	@Test
	@Parameters({
    	"4, 3",
        "5, 4", 
        "6, 5", 
        "7, 6",
        "8, 7",
        "9, 8" })
	public void playerOneIsInAdvantage(int playerOnePoint, int playerTwoPoint)
	{
		createScore(playerOnePoint, playerTwoPoint);
		Assert.assertEquals("Advantage-"+PLAYER_ONE_NAME, tennisGame.determineScore());
	}
	
	@Test
	@Parameters({
    	"3, 4",
        "4, 5", 
        "5, 6", 
        "6, 7",
        "7, 8",
        "8, 9" })
	public void playerTwoIsInAdvantage(int playerOnePoint, int playerTwoPoint)
	{
		createScore(playerOnePoint, playerTwoPoint);
		Assert.assertEquals("Advantage-"+PLAYER_TWO_NAME, tennisGame.determineScore());
	}

	private void createScore(int playerOnePoint, int playerTwoPoint) {
		for (int pointCounter = 0; pointCounter < playerOnePoint; pointCounter++) {
			tennisGame.scorePoint(PLAYER_ONE_NAME);
		}
		for (int pointCounter = 0; pointCounter < playerTwoPoint; pointCounter++) {
			tennisGame.scorePoint(PLAYER_TWO_NAME);
		}
	}
}
