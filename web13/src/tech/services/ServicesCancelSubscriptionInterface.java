package tech.services;

import tech.beans.TechChallenge;
import tech.models.*;

public interface ServicesCancelSubscriptionInterface {
	public ResponseSuccess cancelSubscription(TechChallenge pojo) throws Exception;
}
