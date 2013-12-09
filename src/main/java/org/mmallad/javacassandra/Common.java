package org.mmallad.javacassandra;

/**
 * Created with IntelliJ IDEA.
 * User: Dipak Malla mmallad
 * Date: 12/9/13
 * Time: 3:10 PM
 * Initilize the cassandra cluster
 */
public class Common {
    public static String Ip = "localhost";
    public static CassandraCluster cassandraCluster = null;
    public static void Connect()
    {
        //Make it singleton pattern
        if(cassandraCluster == null)
        {
            cassandraCluster = new CassandraCluster();
            //Connecting to localhost
            cassandraCluster.connectCluster(Ip);
            cassandraCluster.makeSession();
            cassandraCluster.createDatabase();
            cassandraCluster.createTable();
        }
    }
    public static void Close()
    {
        if(cassandraCluster != null)
        {
            cassandraCluster.closeCluster();
            cassandraCluster = null;
        }
    }
}
