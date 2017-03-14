package tech.dao;
import tech.beans.*;
import java.sql.*;

public class CancelSubscriptionDAO implements CancelSubscriptionDAOInterface{
	public void cancel(TechChallenge tech) throws Exception{        
        Connection connection = DBConnection.getConnection();            
        String uuid = tech.getCreator().getUuid();        
        PreparedStatement prepareStatement = connection.prepareStatement("delete from Subscription where uuid=?");
        prepareStatement.setString(1, uuid);    
        int resultSet = prepareStatement.executeUpdate();
        System.out.println("User removed Successfully");    
    }
    
    public boolean checkExist(TechChallenge tech) throws Exception{

        Connection connection = DBConnection.getConnection();
        String uuid="";    
        uuid = tech.getCreator().getUuid();    
        PreparedStatement prepareStatement = connection.prepareStatement("select * from Subscription where uuid = ?");
        prepareStatement.setString(1,uuid);
        ResultSet resultSet = prepareStatement.executeQuery();
        while(resultSet.next()){
            return true;
        }
        return false;
        
    }
    
    public boolean getAccountIdentifier(TechChallenge pojo) throws Exception {
        Connection connection = DBConnection.getConnection();
        Statement s1 = connection.createStatement();
        ResultSet rst = s1.executeQuery("select * from Subscription WHERE uuid = '"+ pojo.getPayload().getAccount().getAccountIdentifier()+"'");
        if(rst.next())
        {
            connection.close();
            return true;
        }
        connection.close();
        return false;
    }
}