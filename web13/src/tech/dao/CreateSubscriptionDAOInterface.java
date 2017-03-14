package tech.dao;

import tech.beans.TechChallenge;

public interface CreateSubscriptionDAOInterface {
	public void insert(TechChallenge techObj) throws Exception;
	public boolean checkExist(TechChallenge techObj) throws Exception;
}
