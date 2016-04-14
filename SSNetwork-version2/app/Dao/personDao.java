package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by caoyi on 16/4/11.
 * This class is used to include db functions
 */
public class personDao {

    Connection connection= play.db.DB.getConnection();
    Statement statement=null;
    String query=null;
    ResultSet resultSet=null;
    public void getNames(){
        try {
            statement =connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultSet=statement.executeQuery(query);
            while (resultSet.next()) {
                resultSet.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
