package org.mmallad.javacassandra;

/**
 * Created with IntelliJ IDEA.
 * User: Dipka Malla mmallad
 * Date: 12/9/13
 * Time: 1:58 PM
 * Class For Creating Cassandra Cluster and Executing CQL Statements
 */

import com.datastax.driver.core.*;

import java.util.HashMap;
import java.util.Map;

public class CassandraCluster {
    private Cluster cluster = null;
    private Session session = null;
    public Cluster connectCluster(String nodeIP)
    {
        //Build cluster
        cluster = Cluster.builder().addContactPoint(nodeIP).build();
        return cluster;
    }
    public void closeCluster()
    {
        if(cluster == null)
            return;
        cluster.shutdown();
    }
    public Session makeSession()
    {
        if(cluster == null)
            connectCluster(Common.Ip);
        session = cluster.connect();
        return  session;
    }

    public Session getSession()
    {
        return this.session;
    }
    //Create Keyspace which like database name in relation model.
    public void createDatabase()
    {
        if(session == null)
            return;
        session.execute("CREATE KEYSPACE JavaCassandra WITH replication " +
                "= {'class':'SimpleStrategy', 'replication_factor':3};");
        //It will create JavaCassandra Keyspace.
    }
    //Create Table that is column family
    public void createTable()
    {
        if(session == null)
            return;
        session.execute("CREATE TABLE JavaCassandra.users ("+
                    " name text," +
                    " email text PRIMARY KEY," +
                    " phone text"
                    +")");
    }
    public Map<Integer, Map> selectRecords()
    {
        if(session == null)
            makeSession();
        ResultSet resultSet = session.execute("SELECT * FROM JavaCassandra.users");
        Map<Integer, Map> sendData = new HashMap<Integer, Map>();
        int c = 0;
        for(Row row : resultSet)
        {
            Map<String, String> d = new HashMap<String, String>();
            d.put("name", row.getString("name"));
            d.put("email", row.getString("email"));
            d.put("phone", row.getString("phone"));
            sendData.put(c, d);
            c++;
        }
        return sendData;
    }
    public void deleteRecord(String email)
    {
        if(session == null)
            return;
        session.execute("DELETE FROM JavaCassandra.users  WHERE " +
                " email = '"+email+"' ");
    }
    public void updateRecord(String[] data)
    {
        if(session == null)
            return;
        session.execute("UPDATE JavaCassandra.users SET name = '"+data[0]+"', phone = '"+data[2]+"' WHERE " +
                " email = '"+data[1]+"' ");
    }
    public void insertRecords(String[] data)
    {
        if(session == null)
            return;
        session.execute("INSERT INTO JavaCassandra.users (name, email, phone) VALUES" +
                "('"+data[0]+"', " +
                "'"+data[1]+"', '"+data[2]+"'"+
                ")");
    }
    public Map[] getMetaData()
    {
        if(cluster == null)
            return null;
        Metadata metadata = cluster.getMetadata();
        Map<String, String> data = new HashMap<String, String>();
        Map[] sendData = new Map[metadata.getAllHosts().size()];
        int c = 0;
        for(Host host : metadata.getAllHosts())
        {
            data.put("datacentar",host.getDatacenter());
            data.put("host",host.getAddress().toString());
            data.put("rack",host.getRack());
            sendData[c] = data;
            c++;
        }
        return sendData;

    }
    public Cluster getCluster()
    {
        return cluster;
    }
}
