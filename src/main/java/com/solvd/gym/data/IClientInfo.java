package com.solvd.gym.data;

public interface IClientInfo {
	public int getId();
	public String getName();
	public int getFeesPaid();
	public void setFeesPaid(int feesPaid);
	public void payFees(int fees);
}
