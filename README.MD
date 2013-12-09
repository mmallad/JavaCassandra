##About JavaCassandra

1. This is sample web application shwoing how to use cassandra with java.
2. CQL has been used as a drver. (Version: 2.0.0-beta2)
3. Cassandra Version 2.0.3

##Install JDK 7 (need 7 for latest Cassandra)
On the unix based machine, run  sudo apt-get install default-jdk

On Mac OS X will need to download the jdk.dmg from Oracle and install.  However, they've broken where they keep the tools.jar  - https://issues.apache.org/jira/browse/HADOOP-9350

Java 7 on Mac does not have a classes.jar in ../Classes/classes.jar per CompilationMojoSupport.groovy:findToolsJar. So I had to create the directory and create a symlink:

% sudo mkdir /Library/Java/JavaVirtualMachines/1.7.0u-dev.jdk/Contents/Home/Classes 
% cd !$
% sudo ln -s ../lib/tools.jar classes.jar


##Install Cassandra 2.0.3
1. Download Cassandra Binary From Apache Site
[http://www.apache.org/dyn/closer.cgi?path=/cassandra/2.0.3/apache-cassandra-2.0.3-bin.tar.gz] (Download Cassandra)

2. Unzip the tar with tar -xzf

3. Set environment varibales like:
	 export CASSANDRA_HOME = /path/to/cassandra
	 export PATH = $PATH:$CASSANDRA_HOME/bin

4. Configure cassandra 
	Open cassandra configuration file i.e cassandra.yml
	vi $CASSANDRA_HOME/conf/cassandra.yml
        set line to 
	start_native_transport : true
5. Start cassandra
	$CASSANDRA_HOME/bin/cassandra -f 

##Install Tomcat
Download Tomcat 7 from link: http://tomcat.apache.org/http://tomcat.apache.org/download-70.cgi (pick the tar.gz from “core” distributions)

FTP the download to the machine you installed Cassandra on

Untar the file with “tar -xzvf <filename>

Run these following commands to set the path to java and tomcat

sudo nano ~/.bashrc

In the file that opens, at the bottom put the following lines:

export JAVA_HOME=/usr/lib/jvm/default-java

export CATALINA_HOME=~/path/to/tomcat (where path to tomcat is the path to the root directory of the tomcat installation that you extracted

Exit out of that file
.~/.bashrc (to run the settings you just saved)

Now to got CATALINA_HOME/bin and run the startup.sh script to start tomcat

Verify tomcat is running by going to the browser and hitting that machine on part 8080.  You should see a tomcat page



##Java Cassandra
1. Download Java Cassandra zip
2. Unzip and got to the directory
3. No need to compile there is already war file inside the target directory.
5. Drop that war file i.e JavaCassandra.war to tomcat webapps directory
6. Vist [http://localhost:8080/JavaCassandra](http://localhost:8080/JavaCassandra)
  
