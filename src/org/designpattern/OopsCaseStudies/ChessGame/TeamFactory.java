package org.designpattern.OopsCaseStudies.ChessGame;

import java.io.ObjectStreamException;
import java.io.Serializable;

import org.designpattern.OopsCaseStudies.ChessGame.pieces.Ghode;
import org.designpattern.OopsCaseStudies.ChessGame.pieces.Hathi;
import org.designpattern.OopsCaseStudies.ChessGame.pieces.Pawn;
import org.designpattern.OopsCaseStudies.ChessGame.pieces.Piece;
import org.designpattern.OopsCaseStudies.ChessGame.pieces.Rani;
import org.designpattern.OopsCaseStudies.ChessGame.pieces.Uuth;
import org.designpattern.OopsCaseStudies.ChessGame.pieces.Vazir;

public class TeamFactory implements Serializable , Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private volatile static TeamFactory teamFactoryInstance  = null;
	private Team whiteTeam;
	private Team blackTeam;
	
	private TeamFactory() throws Exception {
		if(teamFactoryInstance == null)
			System.out.println("Team factory is created");
		else 
			throw new Exception("Cant create new instance of this factory");
	}
	
	public static TeamFactory getInstance() throws Exception {
		if(teamFactoryInstance == null)
			return new TeamFactory();
		else
			return teamFactoryInstance;
	}
	
	public Board getInitializedBoardInstance() {
		Board board = new Board();
		blackTeam = createAndInitializeBoardWithTeam(board , TeamType.BLACK );
		whiteTeam = createAndInitializeBoardWithTeam(board , TeamType.WHITE);
		return board;
	}
	
	private Team createAndInitializeBoardWithTeam(Board board , TeamType teamType ) {
		Spot[][] newboard = board.getBoard();
		Team team = new Team(teamType);
		
		populatePawnsOnBoard(team , board);
		// add two Hathi
		populateHathiOnBoard(team, board);
		//add two ghode
		populateGhodeOnBoard(team, board);
		//add two uuth
		populateUuthOnBoard(team, board);
		//add one rani 
		populateRaniOnBoard(team, board);
		//add one vazir
		populateVazirOnBoard(team, board);
		
		board.setBoard(newboard);
		
		return team;
	}
	
	private void populatePawnsOnBoard(Team team, Board board) {
		TeamType teamType = team.getTeamColo();
		// generate 8 pawn class objects
		if (teamType == TeamType.WHITE) {
			for (int i = 0; i < 8; i++) {
				Piece pawn = new Pawn(0, i, teamType);
				team.getTotalAlive().add(pawn);
				board.getBoard()[1][i].setOccupiedBy(pawn);
			}
		} else { // for black team
			for (int i = 0; i < 8; i++) {
				Piece pawn = new Pawn(0, i, teamType);
				team.getTotalAlive().add(pawn);
				board.getBoard()[6][i].setOccupiedBy(pawn);
			}
		}
	
	}
	
	private void populateVazirOnBoard(Team team , Board board) {
		TeamType teamType = team.getTeamColo();
		Piece vazir = new Vazir(0,0,teamType);
		team.getTotalAlive().add(vazir);
		if(teamType == TeamType.WHITE) {
			board.getBoard()[0][3].setOccupiedBy(vazir);
		}else {
			board.getBoard()[7][3].setOccupiedBy(vazir);
		}
		
	}
	
	private void populateHathiOnBoard(Team team , Board board) {
		TeamType teamType = team.getTeamColo();
		Piece hathi1 = new Hathi(0,0,teamType);
		Piece hathi2 = new Hathi(0,0,teamType);
		team.getTotalAlive().add(hathi2);
		team.getTotalAlive().add(hathi1);
		if(teamType == TeamType.WHITE) {
			board.getBoard()[0][0].setOccupiedBy(hathi1);
			board.getBoard()[0][7].setOccupiedBy(hathi2);
		}else {
			board.getBoard()[7][0].setOccupiedBy(hathi1);
			board.getBoard()[7][7].setOccupiedBy(hathi2);
		}
		
	}
	
	private void populateRaniOnBoard(Team team , Board board) {
		TeamType teamType = team.getTeamColo();
		Piece rani = new Rani(0,0,teamType);
		team.getTotalAlive().add(rani);
		if(teamType == TeamType.WHITE) {
			board.getBoard()[0][4].setOccupiedBy(rani);
		}else {
			board.getBoard()[7][4].setOccupiedBy(rani);
		}
	
	}
	
	private void populateGhodeOnBoard(Team team , Board board) {
		TeamType teamType = team.getTeamColo();
		Piece ghode1 = new Ghode(0,0,teamType);
		Piece ghode2 = new Ghode(0,0,teamType);
		team.getTotalAlive().add(ghode1);
		team.getTotalAlive().add(ghode2);
		if(teamType == TeamType.WHITE) {
			board.getBoard()[0][2].setOccupiedBy(ghode1);
			board.getBoard()[0][5].setOccupiedBy(ghode2);
		}else {
			board.getBoard()[7][2].setOccupiedBy(ghode1);
			board.getBoard()[7][5].setOccupiedBy(ghode2);
		}
	}
	
	private void populateUuthOnBoard(Team team , Board board) {
		TeamType teamType = team.getTeamColo();
		Piece uuth1 = new Uuth(0,0,teamType);
		Piece uuth2 = new Uuth(0,0,teamType);
		team.getTotalAlive().add(uuth1);
		team.getTotalAlive().add(uuth2);
		if(teamType == TeamType.WHITE) {
			board.getBoard()[0][1].setOccupiedBy(uuth1);
			board.getBoard()[0][6].setOccupiedBy(uuth2);
		}else {
			board.getBoard()[7][1].setOccupiedBy(uuth1);
			board.getBoard()[7][6].setOccupiedBy(uuth2);
		}
		
	}
	
	public Team getWhiteTeam() {
		return whiteTeam;
	}

	public void setWhiteTeam(Team whiteTeam) {
		this.whiteTeam = whiteTeam;
	}

	public Team getBlackTeam() {
		return blackTeam;
	}

	public void setBlackTeam(Team blackTeam) {
		this.blackTeam = blackTeam;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	public Object readResolve() throws ObjectStreamException {
		return teamFactoryInstance;
	}
}
