/**
 * 
 */
package com.project.mysql.schema;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.project.mysql.schema.meta.ColumnDefinition;
import com.project.mysql.schema.meta.PrimaryKeyDefinition;
import com.project.mysql.schema.meta.TableDefinition;

/**
 * @author ravi-1979
 *
 */
public class MySQLSchemaBuilder {
private static final Logger LOG = Logger.getLogger(MySQLSchemaBuilder.class.getName());
	
	public static String getCreateTableQuery(TableDefinition tableDefinition){
		StringBuilder queryBuilder = null;
		List<ColumnDefinition> columns = new ArrayList<ColumnDefinition>();
		PrimaryKeyDefinition primaryKeyDefinition = null;
		
		try {
			if(tableDefinition == null || !(tableDefinition.isValidSchemaName()) || !(tableDefinition.isValidTableName())){
				return null;
			}
			
			queryBuilder = new StringBuilder();
			queryBuilder.append("CREATE TABLE "); 
			queryBuilder.append(tableDefinition.getSchemaName());
			queryBuilder.append(".");
			queryBuilder.append(tableDefinition.getTableName());
			queryBuilder.append("(");
				
			columns = tableDefinition.getColumnDefinitions();
			if(columns != null && !(columns.isEmpty())){
				Iterator<ColumnDefinition> columnsIterator = columns.iterator();
				
				while(columnsIterator.hasNext()){
					ColumnDefinition columnDefinition = columnsIterator.next();
					
					Boolean isNull = columnDefinition.isNullable();
					
					if(columnDefinition.isValidColName() && columnDefinition.isValidDataType()){
						queryBuilder.append(" ");
						queryBuilder.append(columnDefinition.getColumnName());
						queryBuilder.append(" ");
						queryBuilder.append(columnDefinition.getDataTypeStr());
					}
					
					if(!columnDefinition.isNullable()){
						queryBuilder.append(" NOT NULL "); 
					}
					
					if(columnDefinition.getDefaultValue() != null){
						queryBuilder.append(" DEFAULT ");  
						queryBuilder.append(columnDefinition.getDefaultValue().toString());
						queryBuilder.append(" ");
					}
					
					queryBuilder.append(",");
				}
			}
			
			primaryKeyDefinition = tableDefinition.getPrimaryKeyDefinition();
			
			if(primaryKeyDefinition != null && !(primaryKeyDefinition.isEmpty())){
				queryBuilder.append(" ");
				queryBuilder.append(" PRIMARY KEY ("); 
				
				Iterator<String> pkColumnsIter = primaryKeyDefinition.getColumns().iterator();
				while(pkColumnsIter.hasNext()){
					queryBuilder.append(pkColumnsIter.next());
					queryBuilder.append(",");
				}
				queryBuilder.setLength(queryBuilder.length()-1);
				queryBuilder.append(")");
			}
			
			if(queryBuilder.lastIndexOf(",") == queryBuilder.length()-1){
				queryBuilder.setLength(queryBuilder.length()-1);
			}

			queryBuilder.append(")");
			return queryBuilder.toString();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOG.log(Level.SEVERE , "@@Raviiii Exception caught while constructing create table query ::: Exception ::: ",e);
		}
		
		return null;
	}
}
