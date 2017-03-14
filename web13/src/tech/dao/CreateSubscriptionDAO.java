package tech.dao;
import tech.beans.*;
import tech.utils.*;
import tech.beans.*;
import java.sql.*;

public class CreateSubscriptionDAO implements CreateSubscriptionDAOInterface{
public void insert(TechChallenge techObj) throws Exception{
        
        Connection connection = DBConnection.getConnection();
        String firstName, lastName, email, uuid;
        firstName = techObj.getCreator().getFirstName();
        lastName = techObj.getCreator().getLastName();
        email = techObj.getCreator().getEmail();
        uuid = techObj.getCreator().getUuid();
        PreparedStatement pst = connection.prepareStatement("insert into Subscription values(?,?,?,?)");
        pst.setString(1, firstName);
        pst.setString(2, lastName);
        pst.setString(3, email);
        pst.setString(4, uuid);
        
        int resultSet = pst.executeUpdate();
        
    }
    
    public boolean checkExist(TechChallenge techObj) throws Exception{
        Connection connection = DBConnection.getConnection();
        String uuid;    
        uuid = techObj.getCreator().getUuid();        
        PreparedStatement prepareStatement = connection.prepareStatement("select * from Subscription where uuid = ?");
        prepareStatement.setString(1, uuid);
        ResultSet resultSet = prepareStatement.executeQuery();
        while(resultSet.next()){
            return true;
        }
        return false;        
    }
}
