/**
 * 
 */
package com.project.mysql.util;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ravi-1979
 *
 */
public class MySQLUtil {
	
	public static final Logger LOG = Logger.getLogger(MySQLUtil.class.getName());
	public static Properties loadProperties(String path){
    	LOG.log(Level.INFO," @@Raviiii MySQLUtil ::: loadProperties ::: path ::: ", path);
    	FileInputStream fip = null ;
        try
        {
                Properties prop = new Properties();
                fip = new FileInputStream(path);
                prop.load(fip);
                return prop;
        }
        catch(Exception e)
        {
                LOG.log(Level.SEVERE, " @@Raviiii error in loading properties using path "+path, e);
        }
        finally
        {
                if(fip != null)
                {
                        try
                        {
                                fip.close();
                                fip = null;
                        }
                        catch(Exception ex)
                        {
                        }
                }
        }

        return new Properties();

    }
}
