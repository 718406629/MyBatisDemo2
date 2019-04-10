package org.lanqiao.entity;

public class StudentCard {

	private int cardId;
	private String cardInfo;
	public int getcardId() {
		return cardId;
	}
	public void setcardId(int cardId) {
		this.cardId = cardId;
	}
	public String getcardInfo() {
		return cardInfo;
	}
	public void setcardInfo(String cardInfo) {
		this.cardInfo = cardInfo;
	}
	
	public String toString() {
		return this.cardId+"-"+this.cardInfo;
	}
	
}
