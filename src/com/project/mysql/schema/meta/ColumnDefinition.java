/**
 * 
 */
package com.project.mysql.schema.meta;

import com.project.mysql.constants.MySQLConstants;

/**
 * @author ravi-1979
 *
 */
public class ColumnDefinition {
	private String tableName;
	private String columnName;
	private Object defaultValue;
	private MySQLConstants.DataTypes dataType;
	private Boolean isNullable = Boolean.TRUE;

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
	 * @return the columnName
	 */
	public String getColumnName() {
		return columnName;
	}

	/**
	 * @param columnName the columnName to set
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	
	public boolean isValidColName(){
		return (this.columnName != null && !(this.columnName.isEmpty()));
	}
	
	public boolean isValidDataType(){
		return (this.dataType != null);
	}
	
	public String getDataTypeStr(){
		return this.dataType.name();
	}
	
	/**
	 * @return the defaultValue
	 */
	public Object getDefaultValue() {
		return defaultValue;
	}

	/**
	 * @param defaultValue the defaultValue to set
	 */
	public void setDefaultValue(Object defaultValue) {
		this.defaultValue = defaultValue;
	}

	/**
	 * @return the dataType
	 */
	public MySQLConstants.DataTypes getDataType() {
		return dataType;
	}

	/**
	 * @param dataType the dataType to set
	 */
	public void setDataType(MySQLConstants.DataTypes dataType) {
		this.dataType = dataType;
	}

	/**
	 * @return the isNullable
	 */
	public Boolean isNullable() {
		return isNullable;
	}

	/**
	 * @param isNullable the isNullable to set
	 */
	public void setNullable(Boolean isNullable) {
		this.isNullable = isNullable;
	}
}
