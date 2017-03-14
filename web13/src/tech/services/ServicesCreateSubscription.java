package tech.services;
import tech.beans.*;
import tech.dao.CreateSubscriptionDAO;


public class ServicesCreateSubscription implements ServicesCreateSubscriptionInterface{
    public boolean checkSubscription(TechChallenge pojo) throws Exception{
        
    	CreateSubscriptionDAO daoCreateSubscription = new CreateSubscriptionDAO();
        
        if(!daoCreateSubscription.checkExist(pojo)){
            daoCreateSubscription.insert(pojo);
            return true;
        }
        else
            System.out.println("User Already Exists");
            
        return false;
    }
}
