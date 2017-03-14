package tech.services;
import tech.beans.TechChallenge;
import tech.dao.*;
import tech.models.ResponseSuccess;

public class ServicesCancelSubscription implements ServicesCancelSubscriptionInterface{
	public ResponseSuccess cancelSubscription(TechChallenge pojo) throws Exception{
		ResponseSuccess responseObject;    
		CancelSubscriptionDAO obj = new CancelSubscriptionDAO();   
        	if(obj.checkExist(pojo)){
        		if(obj.getAccountIdentifier(pojo))
        		{
	                obj.cancel(pojo);
	                responseObject = new ResponseSuccess(true,pojo.getCreator().getFirstName()+":"+pojo.getCreator().getUuid());
	                return responseObject;
        		}
	            responseObject = new ResponseSuccess(false,"");   
	            return responseObject;
        	}
        	else{
        		System.out.println("User already unsubscribed the product");
        		responseObject = new ResponseSuccess(false,"");
        		return responseObject;
        	}          
    }
}
