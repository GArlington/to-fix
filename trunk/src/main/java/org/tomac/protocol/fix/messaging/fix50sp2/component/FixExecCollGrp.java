package org.tomac.protocol.fix.messaging.fix50sp2.component;

// DO NOT EDIT!!!
// This file is generated by FixMessageGenerator.
// If you need additional functionality, put it in a helper class
// that does not live in this folder!!!  Any java file in this folder 
// will be deleted upon the next run of the FixMessageGenerator!

import java.nio.ByteBuffer;

import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.FixSessionException;
import org.tomac.protocol.fix.FixGarbledException;
import org.tomac.utils.Utils;
import org.tomac.protocol.fix.FixConstants;


import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo;
import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;

public class FixExecCollGrp
{

	public int noExecs;
	public ExecCollGrp[] group;

	public void getAll(int noExecs, ByteBuffer buf) throws FixSessionException {
		this.noExecs = noExecs;

		if (noExecs < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group == null || group.length < noExecs) {
			group = new ExecCollGrp[noExecs];

			for ( int i = 0; i < noExecs; i++ ) group[i] = new ExecCollGrp();
	}

		for ( int i = 0; i < noExecs; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noExecs; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noExecs; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noExecs; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noExecs; i++)
			s += group[i].toString();
		return s;
	}

public class ExecCollGrp implements FixComponent
{

	public byte[] execID;

	public ExecCollGrp() {
		super();

		execID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( execID, (byte)0 );
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.EXECID_INT) {
				execID = FixUtils.getTagStringValue(value, execID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			id = checkRequiredTags();
			if (id > 0) throw new FixSessionException(buf, "Required tag missing: " + id );

			buf.position( lastTagPosition );
			return;

	}

	private int checkRequiredTags() {
		int tag = -1;

		return tag;

	}
	@Override
	public boolean isSet()
	{
		if (FixUtils.isSet(execID)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(execID)) FixUtils.putFixTag( out, FixTags.EXECID_INT, execID, 0, Utils.lastIndexTrim(execID, (byte)0) );
	}
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will end up in nifelheim!
	**/
	@Override
	public String toString() {
		char sep = '\n';
		if (Boolean.getBoolean("fix.useOneLiner")) sep = ( byte )0x01;

		String s = "";

			if (FixUtils.isSet(execID)) s += "ExecID(17)=" + new String(execID) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof ExecCollGrp)) return false;

			ExecCollGrp msg = (ExecCollGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( execID, msg.execID)) return false;

		return true;
	}
}
}
