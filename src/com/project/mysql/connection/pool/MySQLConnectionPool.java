/**
 * 
 */
package com.project.mysql.connection.pool;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import com.project.mysql.connection.MySQLConnection;

/**
 * @author ravi-1979
 *
 */
public class MySQLConnectionPool extends GenericObjectPool<MySQLConnection>{
	
	private static final Logger LOG = Logger.getLogger(MySQLConnectionPool.class.getName());

	public MySQLConnectionPool(PooledObjectFactory<MySQLConnection> factory) {
		super(factory);
	}
	
	public MySQLConnectionPool(PooledObjectFactory<MySQLConnection> factory,GenericObjectPoolConfig config) {
        super(factory, config);
    }	
	
	@Override
    public MySQLConnection borrowObject() throws Exception {
        LOG.log(Level.INFO," Raviiii ::: GenericObjectPool ::: borrowing object..");
        return super.borrowObject();
    }
    
    @Override
    public void returnObject(MySQLConnection MySQLConnection) {
        LOG.log(Level.INFO," Raviiii ::: GenericObjectPool ::: returning object.." + MySQLConnection);
        super.returnObject(MySQLConnection);
     }
}
