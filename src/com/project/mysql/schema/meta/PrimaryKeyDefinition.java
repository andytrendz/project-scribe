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
public class PrimaryKeyDefinition {
	private List<String> columns = new ArrayList<String>();
	private String constraintName = null;
	private String tableName = null;

	/**
	 * @return the columns
	 */
	public List<String> getColumns() {
		return columns;
	}

	/**
	 * @param columns the columns to set
	 */
	public void setColumns(List<String> columns) {
		this.columns = columns;
	}


	/**
	 * @return the constraintName
	 */
	public String getConstraintName() {
		return constraintName;
	}

	/**
	 * @param constraintName the constraintName to set
	 */
	public void setConstraintName(String constraintName) {
		this.constraintName = constraintName;
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

	public boolean isEmpty(){
		return this.columns.isEmpty();
	}

}
