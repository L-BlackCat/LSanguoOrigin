package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Chunlin Li
 * @date 2022/11/10
 * @desc
 */
public class MySqlDB implements AutoCloseable{

    private Connection sqlConn;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;


    public boolean tryConnection(String addr,String name,String user,String pwd) throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://" + addr + "/" + name;
        Class.forName(driver);
        String strUrlBuilder = url +
                "?user=" + user +
                "&password=" + pwd +
                "&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
        this.sqlConn = DriverManager.getConnection(strUrlBuilder);
        return true;
    }


    public Connection getSqlConn() {
        return sqlConn;
    }

    public void setSqlConn(Connection sqlConn) {
        this.sqlConn = sqlConn;
    }

    @Override
    public void close() throws Exception {
        closeDB();
    }

    public void closeStatement(){
        try{
            if(resultSet != null){
                resultSet.close();
                resultSet = null;
            }
            if(preparedStatement != null){
                preparedStatement.close();
                preparedStatement = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resultSet = null;
        preparedStatement = null;
    }

    public void closeDB(){
        closeStatement();
        try {
            if (sqlConn != null) {
                sqlConn.close();
                sqlConn = null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        resultSet = null;
        preparedStatement = null;
        sqlConn = null;
    }

    public void doSomeThing() throws SQLException {
        if(sqlConn != null){
            String sql = "show tables from san_guo_data";
            preparedStatement = sqlConn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String tableName = resultSet.getString(1);
                System.out.println(tableName);
                PreparedStatement temPreStatement = sqlConn.prepareStatement("show columns from " + tableName);
                ResultSet rs = temPreStatement.executeQuery();
                ResultSetMetaData metaData = rs.getMetaData();
                int index = 0;
                while (rs.next()){
                    String fieldName = metaData.getColumnName(++index);
                    System.out.println(fieldName);
                }
                temPreStatement.close();
                rs.close();
            }
        }
    }


//    public <T> List<T> queryAll(String tableName, Class<T> clazz){
//
//        return new ArrayList<>();
//    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        MySqlDB mySqlDB = new MySqlDB();
        mySqlDB.tryConnection("localhost:3306", "san_guo_data", "root", "root");
        mySqlDB.doSomeThing();

    }
}
