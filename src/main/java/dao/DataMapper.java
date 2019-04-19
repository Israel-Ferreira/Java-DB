package dao;


import java.sql.Connection;
import java.sql.DriverManager;




public class DataMapper {
    public Connection conn;
    private String url;
    private final String driver = "org.postgresql.Driver";

    public DataMapper(String url,String user, String password){
        String userDb = user.equals("") ? "postgres" : user;
        this.url = "jdbc:postgresql://localhost:5432/" + url;
        prepareConnection(userDb,password);
    }


    private void prepareConnection(String user, String psw){
        try{
            createConnection(user,psw);
        }catch (Exception e){
            System.err.println(e);
        }
    }



    private void createConnection(String user, String psw) throws Exception {
        Class.forName(this.driver);

        if(this.url == null){
            throw new RuntimeException("The variable url is not initialized");
        }

        this.conn = DriverManager.getConnection(url,user,psw);
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
