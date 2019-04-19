package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class ObjectDAO {
    public Connection conn;

    public ResultSet res;
    private PreparedStatement ps;


    public void setRes(String sql) throws SQLException{
        try{
            ps = conn.prepareStatement(sql);
            res =  ps.executeQuery();
        }catch(SQLException e){
            throw  e;
        }
    }

    public void createConnection(String url){
        conn = new DataMapper(url,"","").conn;
    }





}
