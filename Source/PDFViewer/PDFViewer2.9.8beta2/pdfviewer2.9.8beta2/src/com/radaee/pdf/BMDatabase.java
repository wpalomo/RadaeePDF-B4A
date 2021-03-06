package com.radaee.pdf;
/**
class for PDF Book-mark database.
@author Radaee
@version 1.1
*/

public class BMDatabase
{
	private static native int openAndCreate( String db_path );
	private static native void close( int db );
	private static native int recOpen( int db, String look_path );
	private static native void recClose( int rec );
	private static native int recGetCount( int rec );
	private static native String recItemGetName( int rec, int index );
	private static native int recItemGetPage( int rec, int index );
	private static native boolean recItemRemove( int rec, int index );
	private static native boolean recItemInsert( int rec, String name, int pageno );
	private int m_hand = 0;
	/**
	 * open exist database file or create it if not exist. (Database for BookMark)
	 * @param db_path
	 * @return
	 */
	public boolean OpenOrCreate( String db_path )
	{
		m_hand = openAndCreate( db_path );
		return (m_hand != 0);
	}
	/**
	 * close database
	 */
	public void Close()
	{
		close( m_hand );
		m_hand = 0;
	}
	/**
	 * Get a RecordSet handle, by input PDF file path
	 * @param look_path PDF path to lookup.
	 * @return handle value of RecordSet.
	 */
	public int RecOpen( String look_path )
	{
		return recOpen( m_hand, look_path );
	}
	/**
	 * Close a RecordSet handle
	 * @param rec handle value of RecordSet. obtained by RecOpen
	 */
	public void RecClose( int rec )
	{
		recClose( rec );
	}
	/**
	 * Get items count of RecordSet.
	 * @param rec RecordSet Handle, obtained by RecOpen
	 * @return records count
	 */
	public int RecGetCount( int rec )
	{
		return recGetCount( rec );
	}
	/**
	 * Get item name by index.
	 * @param rec RecordSet Handle that returned by RecOpen
	 * @param index 0 based index value, range:[0, RecGetCount()-1]
	 * @return name of item.
	 */
	public String RecItemGetName( int rec, int index )
	{
		return recItemGetName( rec, index );
	}
	/**
	 * Get page no by index.
	 * @param rec RecordSet Handle that returned by RecOpen
	 * @param index 0 based index value, range:[0, RecGetCount()-1]
	 * @return 0 based page NO.
	 */
	public int RecItemGetPage( int rec, int index )
	{
		return recItemGetPage( rec, index );
	}
	/**
	 * remove item by index.
	 * @param rec RecordSet Handle that returned by RecOpen
	 * @param index 0 based index value, range:[0, RecGetCount()-1]
	 * @return true or false.
	 */
	public boolean RecItemRemove( int rec, int index )
	{
		return recItemRemove( rec, index );
	}
	/**
	 * insert item.
	 * @param rec RecordSet Handle that returned by RecOpen
	 * @param name label of BookMark.
	 * @param pageno 0 based page no recorded.
	 * @return true or false
	 */
	public boolean RecItemInsert( int rec, String name, int pageno )
	{
		return recItemInsert( rec, name, pageno );
	}
}
