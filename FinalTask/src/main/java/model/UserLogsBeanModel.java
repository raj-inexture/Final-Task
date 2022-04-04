package model;

import java.sql.Timestamp;

public class UserLogsBeanModel {

	int id;
	int userid;
	Timestamp startstamp;
	Timestamp endstamp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Timestamp getStartstamp() {
		return startstamp;
	}

	public void setStartstamp(Timestamp startstamp) {
		this.startstamp = startstamp;
	}

	public Timestamp getEndstamp() {
		return endstamp;
	}

	public void setEndstamp(Timestamp endstamp) {
		this.endstamp = endstamp;
	}

}
