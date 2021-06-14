package com.ibm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cibil {
	
	@Id
	private String panCard;
	
	private int cibilscore;

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public int getCibilscore() {
		return cibilscore;
	}

	public void setCibilscore(int cibilscore) {
		this.cibilscore = cibilscore;
	}
	
	

}
