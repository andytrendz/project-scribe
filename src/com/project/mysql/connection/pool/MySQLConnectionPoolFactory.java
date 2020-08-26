/**
 * 
 */
package com.project.mysql.connection.pool;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import com.project.mysql.connection.MySQLConnection;

/**
 * @author ravi-1979
 *
 */
public class MySQLConnectionPoolFactory extends BasePooledObjectFactory<MySQLConnection> {
	
	private static final Logger LOG = Logger.getLogger(MySQLConnectionPoolFactory.class.getName());

    @Override
    public MySQLConnection create() throws Exception {
    	LOG.log(Level.INFO,"Raviiii ::: MySQLConnectionPoolFactory ::: Create Method Called ");
        return MySQLConnection.getInstance();
    }
    
    @Override
    public PooledObject<MySQLConnection> wrap(MySQLConnection MySQLConnection) {
    	LOG.log(Level.INFO,"Raviiii ::: MySQLConnectionPoolFactory ::: Wrap Method Called ");
        return new DefaultPooledObject<MySQLConnection>(MySQLConnection);
    }
    
    @Override
    public void activateObject(PooledObject<MySQLConnection> pooledObject) throws Exception {
    }
    
    @Override
    public void passivateObject(PooledObject<MySQLConnection> pooledObject) throws Exception {
    	pooledObject.getObject().setResult(null);
    }
    
    @Override
    public boolean validateObject(PooledObject<MySQLConnection> pooledObject) {
    	LOG.log(Level.INFO,"Raviiii ::: MySQLConnectionPoolFactory ::: validateObject Method Called "+pooledObject.getObject());
        return pooledObject.getObject().isValid();
    }
    
    @Override
    public void destroyObject(PooledObject<MySQLConnection> pooledObject) throws Exception  {
    	try {
    		LOG.log(Level.INFO,"Raviiii ::: MySQLConnectionPoolFactory ::: destroyObject Method Called ");
    		pooledObject.getObject().close();
    	} catch(Exception ex) {
    	}
    }
}
