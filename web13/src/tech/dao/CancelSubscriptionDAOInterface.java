package tech.dao;

import tech.beans.TechChallenge;

public interface CancelSubscriptionDAOInterface {
	public void cancel(TechChallenge tech) throws Exception;
	public boolean checkExist(TechChallenge tech) throws Exception;
	public boolean getAccountIdentifier(TechChallenge pojo) throws Exception;  
}
