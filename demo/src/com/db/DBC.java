package com.db; /**
 * Created by GenyaHoshino on 2016/9/28.
 */
import java.sql.*;

public class DBC {


    private Connection conn;
    private Statement stmt;
    public DBC() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/danmaku?useUnicode=true&characterEncoding=utf-8", "root", "123456");
            stmt = conn.createStatement();
        }
        catch (Exception e) {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/?useUnicode=true&characterEncoding=utf-8", "root", "123456");
            String sql ="CREATE DATABASE IF NOT EXISTS `danmaku` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;";  //创建数据库如果不存在
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/danmaku?useUnicode=true&characterEncoding=utf-8", "root", "123456");
            stmt = conn.createStatement();
        }
    }
    public int update(String sql) throws Exception{
        int nols = stmt.executeUpdate(sql);
        return nols;
    }
    public ResultSet select(String sql) throws Exception{
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }
    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

}
