/**
 * 
 */
package com.project.mysql.schema.meta;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ravi-1979
 *
 */
public class TableDefinition {
	private List<ColumnDefinition> columns = new ArrayList<ColumnDefinition>();
	private List<String> columnNamesList = new ArrayList<String>();
	private PrimaryKeyDefinition primaryKeyDefinition = null;
	private String tableName = null;
	private String schemaName = null;
	
	

	/**
	 * @return the columns
	 */
	public List<ColumnDefinition> getColumnDefinitions() {
		return columns;
	}

	/**
	 * @return the primaryKeyDefinition
	 */
	public PrimaryKeyDefinition getPrimaryKeyDefinition() {
		return primaryKeyDefinition;
	}

	/**
	 * @param primaryKeyDefinition the primaryKeyDefinition to set
	 */
	public void setPrimaryKeyDefinition(PrimaryKeyDefinition primaryKeyDefinition) {
		this.primaryKeyDefinition = primaryKeyDefinition;
	}

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * @return the schemaName
	 */
	public String getSchemaName() {
		return schemaName;
	}

	/**
	 * @param schemaName the schemaName to set
	 */
	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}
	
	
	public boolean isValidSchemaName(){
		return (this.schemaName != null && !(this.schemaName.isEmpty()));
	}
	
	public boolean isValidTableName(){
		return (this.tableName != null && !(this.tableName.isEmpty()));
	}
	
	public boolean isValidColName(String colName){
		return (this.columnNamesList.contains(colName));
	}
}
