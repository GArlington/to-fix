package org.tomac.protocol.fix.messaging.fix42nordic;

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



public class FixExecutionRestatement extends FixMessage
{

	public long avgPx = 0;
	public byte[] clOrdID;
	public long cumQty = 0;
	public byte[] execID;
	public byte execTransType = (byte)' ';
	public byte[] orderID;
	public byte ordStatus = (byte)' ';
	public byte side = (byte)' ';
	public byte[] symbol;
	public byte[] clientID;
	public byte execType = (byte)' ';
	public long leavesQty = 0;
	public byte[] secondaryOrderID;
	public long execRestatementReason = 0;

	public FixExecutionRestatement() {
		super();

		clOrdID = new byte[20];
		execID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		orderID = new byte[32];
		symbol = new byte[8];
		clientID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		secondaryOrderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

		msgType = MsgTypes.EXECUTIONRESTATEMENT_INT;

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		avgPx = Long.MAX_VALUE;		
		Utils.fill( clOrdID, (byte)0 );
		cumQty = Long.MAX_VALUE;		
		Utils.fill( execID, (byte)0 );
		execTransType = Byte.MAX_VALUE;		
		Utils.fill( orderID, (byte)0 );
		ordStatus = Byte.MAX_VALUE;		
		side = Byte.MAX_VALUE;		
		Utils.fill( symbol, (byte)0 );
		Utils.fill( clientID, (byte)0 );
		execType = Byte.MAX_VALUE;		
		leavesQty = Long.MAX_VALUE;		
		Utils.fill( secondaryOrderID, (byte)0 );
		execRestatementReason = Long.MAX_VALUE;		
	}

	@Override
	public void getAll() throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		super.getAll();

		// assumption message is full otherwise decode would return null
		// so negative id means that we are at the end of the message
		int id;
		int lastTagPosition = buf.position();
		while ( ( id = FixUtils.getTagId( buf ) ) > 0 )
		{
			ByteBuffer value;

			value = buf;

			switch( id ) {

			case FixTags.AVGPX_INT:
				avgPx = FixUtils.getTagFloatValue(value);
				break;

			case FixTags.CLORDID_INT:
				clOrdID = FixUtils.getTagStringValue(value, clOrdID);
				break;

			case FixTags.CUMQTY_INT:
				cumQty = FixUtils.getTagFloatValue(value);
				break;

			case FixTags.EXECID_INT:
				execID = FixUtils.getTagStringValue(value, execID);
				break;

			case FixTags.EXECTRANSTYPE_INT:
				execTransType = FixUtils.getTagCharValue( value );
				if (!ExecTransType.isValid(execTransType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + execTransType + ") for tag: " + id );
				break;

			case FixTags.ORDERID_INT:
				orderID = FixUtils.getTagStringValue(value, orderID);
				break;

			case FixTags.ORDSTATUS_INT:
				ordStatus = FixUtils.getTagCharValue( value );
				if (!OrdStatus.isValid(ordStatus) ) throw new FixSessionException(buf, "Invalid enumerated value(" + ordStatus + ") for tag: " + id );
				break;

			case FixTags.SIDE_INT:
				side = FixUtils.getTagCharValue( value );
				if (!Side.isValid(side) ) throw new FixSessionException(buf, "Invalid enumerated value(" + side + ") for tag: " + id );
				break;

			case FixTags.SYMBOL_INT:
				symbol = FixUtils.getTagStringValue(value, symbol);
				break;

			case FixTags.CLIENTID_INT:
				clientID = FixUtils.getTagStringValue(value, clientID);
				break;

			case FixTags.EXECTYPE_INT:
				execType = FixUtils.getTagCharValue( value );
				if (!ExecType.isValid(execType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + execType + ") for tag: " + id );
				break;

			case FixTags.LEAVESQTY_INT:
				leavesQty = FixUtils.getTagFloatValue(value);
				break;

			case FixTags.SECONDARYORDERID_INT:
				secondaryOrderID = FixUtils.getTagStringValue(value, secondaryOrderID);
				break;

			case FixTags.EXECRESTATEMENTREASON_INT:
				execRestatementReason = FixUtils.getTagIntValue( value );
				if (!ExecRestatementReason.isValid(execRestatementReason) ) throw new FixSessionException(buf, "Invalid enumerated value(" + execRestatementReason + ") for tag: " + id );
				break;

			// for a message always get the checksum
			case FixTags.CHECKSUM_INT:
				checkSum = FixUtils.getTagIntValue( value );

				id = checkRequiredTags();
				if (id > 0) throw new FixSessionException(buf, "Required tag missing: " + id );

				return;

			default:
				throw new FixSessionException(buf, "Unknown tag: " + id );

			}

			lastTagPosition = buf.position();

		}

		buf.position(startTagPosition);

	}

	private int checkRequiredTags() {
		int tag = -1;

		if (! FixUtils.isSet(msgSeqNum) ) return FixTags.MSGSEQNUM_INT;
		if (! FixUtils.isSet(senderCompID) ) return FixTags.SENDERCOMPID_INT;
		if (! FixUtils.isSet(sendingTime) ) return FixTags.SENDINGTIME_INT;
		if (! FixUtils.isSet(targetCompID) ) return FixTags.TARGETCOMPID_INT;
		if (! FixUtils.isSet(avgPx) ) return FixTags.AVGPX_INT;
		if (! FixUtils.isSet(clOrdID) ) return FixTags.CLORDID_INT;
		if (! FixUtils.isSet(cumQty) ) return FixTags.CUMQTY_INT;
		if (! FixUtils.isSet(execID) ) return FixTags.EXECID_INT;
		if (! FixUtils.isSet(execTransType) ) return FixTags.EXECTRANSTYPE_INT;
		if (! FixUtils.isSet(orderID) ) return FixTags.ORDERID_INT;
		if (! FixUtils.isSet(ordStatus) ) return FixTags.ORDSTATUS_INT;
		if (! FixUtils.isSet(side) ) return FixTags.SIDE_INT;
		if (! FixUtils.isSet(symbol) ) return FixTags.SYMBOL_INT;
		if (! FixUtils.isSet(clientID) ) return FixTags.CLIENTID_INT;
		if (! FixUtils.isSet(execType) ) return FixTags.EXECTYPE_INT;
		if (! FixUtils.isSet(leavesQty) ) return FixTags.LEAVESQTY_INT;
		if (! FixUtils.isSet(secondaryOrderID) ) return FixTags.SECONDARYORDERID_INT;
		if (! FixUtils.isSet(execRestatementReason) ) return FixTags.EXECRESTATEMENTREASON_INT;
		if (! FixUtils.isSet(checkSum) ) return FixTags.CHECKSUM_INT;
		return tag;

	}
	@Override
	public void encode( ByteBuffer out )
	{
		// Encode message. Set msgSeqNum and sendingTime and optional resend flags, before encoding. 

		int msgStart = out.position();

		out.put( BEGINSTRING_VALUE_WITH_TAG );

		int msgLengthValueStart = out.position() + 2 /* 9= */;

		// placeholder
		FixUtils.putFixTag(out, FixTags.BODYLENGTH_INT, FixConstants.MAX_MESSAGE_SIZE );

		int msgTypeStart = out.position();

		FixUtils.putFixTag( out, FixTags.MSGTYPE_INT, MsgTypes.EXECUTIONRESTATEMENT);

		// encode all fields including the header

		FixUtils.putFixTag( out, FixTags.MSGSEQNUM_INT, msgSeqNum);
		if (FixUtils.isSet(possDupFlag)) FixUtils.putFixTag( out, FixTags.POSSDUPFLAG_INT, possDupFlag?(byte)'Y':(byte)'N' );
		FixUtils.putFixTag( out, FixTags.SENDERCOMPID_INT, senderCompID, 0, Utils.lastIndexTrim(senderCompID, (byte)0) );
		if (FixUtils.isSet(senderSubID)) FixUtils.putFixTag( out, FixTags.SENDERSUBID_INT, senderSubID, 0, Utils.lastIndexTrim(senderSubID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.SENDINGTIME_INT, sendingTime);
		FixUtils.putFixTag( out, FixTags.TARGETCOMPID_INT, targetCompID, 0, Utils.lastIndexTrim(targetCompID, (byte)0) );
		if (FixUtils.isSet(targetSubID)) FixUtils.putFixTag( out, FixTags.TARGETSUBID_INT, targetSubID, 0, Utils.lastIndexTrim(targetSubID, (byte)0) );
		if (FixUtils.isSet(possResend)) FixUtils.putFixTag( out, FixTags.POSSRESEND_INT, possResend?(byte)'Y':(byte)'N' );
		if (FixUtils.isSet(onBehalfOfCompID)) FixUtils.putFixTag( out, FixTags.ONBEHALFOFCOMPID_INT, onBehalfOfCompID, 0, Utils.lastIndexTrim(onBehalfOfCompID, (byte)0) );
		if (FixUtils.isSet(onBehalfOfSubID)) FixUtils.putFixTag( out, FixTags.ONBEHALFOFSUBID_INT, onBehalfOfSubID, 0, Utils.lastIndexTrim(onBehalfOfSubID, (byte)0) );
		if (FixUtils.isSet(origSendingTime)) FixUtils.putFixTag( out, FixTags.ORIGSENDINGTIME_INT, origSendingTime);
		if (FixUtils.isSet(deliverToCompID)) FixUtils.putFixTag( out, FixTags.DELIVERTOCOMPID_INT, deliverToCompID, 0, Utils.lastIndexTrim(deliverToCompID, (byte)0) );
		if (FixUtils.isSet(deliverToSubID)) FixUtils.putFixTag( out, FixTags.DELIVERTOSUBID_INT, deliverToSubID, 0, Utils.lastIndexTrim(deliverToSubID, (byte)0) );

		FixUtils.putFixFloatTag( out, FixTags.AVGPX_INT, avgPx);
		FixUtils.putFixTag( out, FixTags.CLORDID_INT, clOrdID, 0, Utils.lastIndexTrim(clOrdID, (byte)0) );
		FixUtils.putFixFloatTag( out, FixTags.CUMQTY_INT, cumQty);
		FixUtils.putFixTag( out, FixTags.EXECID_INT, execID, 0, Utils.lastIndexTrim(execID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.EXECTRANSTYPE_INT, execTransType );
		FixUtils.putFixTag( out, FixTags.ORDERID_INT, orderID, 0, Utils.lastIndexTrim(orderID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.ORDSTATUS_INT, ordStatus );
		FixUtils.putFixTag( out, FixTags.SIDE_INT, side );
		FixUtils.putFixTag( out, FixTags.SYMBOL_INT, symbol, 0, Utils.lastIndexTrim(symbol, (byte)0) );
		FixUtils.putFixTag( out, FixTags.CLIENTID_INT, clientID, 0, Utils.lastIndexTrim(clientID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.EXECTYPE_INT, execType );
		FixUtils.putFixFloatTag( out, FixTags.LEAVESQTY_INT, leavesQty);
		FixUtils.putFixTag( out, FixTags.SECONDARYORDERID_INT, secondaryOrderID, 0, Utils.lastIndexTrim(secondaryOrderID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.EXECRESTATEMENTREASON_INT, execRestatementReason);
		// the checksum at the end

		int checkSumStart = out.position();
		out.position( msgLengthValueStart );
		bodyLength = checkSumStart - msgTypeStart;
		Utils.longToNumeric( out, bodyLength, Utils.digits(FixConstants.MAX_MESSAGE_SIZE) );

		checkSum = FixUtils.computeChecksum( out, msgStart, checkSumStart );
		out.position( checkSumStart );
		FixUtils.putFixTag( out, FixTags.CHECKSUM_INT, checkSum );

		out.flip();

	}
	@Override		
	public void printBuffer(ByteBuffer out) {

		out.put(buf);

		out.flip();

	}

	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will end up in nifelheim!
	**/
	@Override
	public String toString() {
		char sep = '\n';
		if (Boolean.getBoolean("fix.useOneLiner")) sep = SOH;

		String s = "BeginString(8)=" + new String(BEGINSTRING_VALUE) + sep;
		s += "BodyLength(9)=" + bodyLength + sep;
		s += "MsgType(35)=" + new String(MsgTypes.EXECUTIONRESTATEMENT) + sep;

		try {
			// print all fields including the header

			 s += "MsgSeqNum(34)=" + String.valueOf(msgSeqNum) + sep;
			if (FixUtils.isSet(possDupFlag)) s += "PossDupFlag(43)=" + String.valueOf(possDupFlag) + sep;
			 s += "SenderCompID(49)=" + new String(senderCompID) + sep;
			if (FixUtils.isSet(senderSubID)) s += "SenderSubID(50)=" + new String(senderSubID) + sep;
			 s += "SendingTime(52)=" + new String(sendingTime) + sep;
			 s += "TargetCompID(56)=" + new String(targetCompID) + sep;
			if (FixUtils.isSet(targetSubID)) s += "TargetSubID(57)=" + new String(targetSubID) + sep;
			if (FixUtils.isSet(possResend)) s += "PossResend(97)=" + String.valueOf(possResend) + sep;
			if (FixUtils.isSet(onBehalfOfCompID)) s += "OnBehalfOfCompID(115)=" + new String(onBehalfOfCompID) + sep;
			if (FixUtils.isSet(onBehalfOfSubID)) s += "OnBehalfOfSubID(116)=" + new String(onBehalfOfSubID) + sep;
			if (FixUtils.isSet(origSendingTime)) s += "OrigSendingTime(122)=" + new String(origSendingTime) + sep;
			if (FixUtils.isSet(deliverToCompID)) s += "DeliverToCompID(128)=" + new String(deliverToCompID) + sep;
			if (FixUtils.isSet(deliverToSubID)) s += "DeliverToSubID(129)=" + new String(deliverToSubID) + sep;

			 s += "AvgPx(6)=" + String.valueOf(avgPx) + sep;
			 s += "ClOrdID(11)=" + new String(clOrdID) + sep;
			 s += "CumQty(14)=" + String.valueOf(cumQty) + sep;
			 s += "ExecID(17)=" + new String(execID) + sep;
			 s += "ExecTransType(20)=" + String.valueOf(execTransType) + sep;
			 s += "OrderID(37)=" + new String(orderID) + sep;
			 s += "OrdStatus(39)=" + String.valueOf(ordStatus) + sep;
			 s += "Side(54)=" + String.valueOf(side) + sep;
			 s += "Symbol(55)=" + new String(symbol) + sep;
			 s += "ClientID(109)=" + new String(clientID) + sep;
			 s += "ExecType(150)=" + String.valueOf(execType) + sep;
			 s += "LeavesQty(151)=" + String.valueOf(leavesQty) + sep;
			 s += "SecondaryOrderID(198)=" + new String(secondaryOrderID) + sep;
			 s += "ExecRestatementReason(378)=" + String.valueOf(execRestatementReason) + sep;

			s += "checkSum(10)=" + String.valueOf(checkSum) + sep;

		} catch(Exception e) {  };

		return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixExecutionRestatement)) return false;

			FixExecutionRestatement msg = (FixExecutionRestatement) o;

		if ( ! super.equals(msg) ) return false;

		if (!( avgPx==msg.avgPx)) return false;

		if (!Utils.equals( clOrdID, msg.clOrdID)) return false;

		if (!( cumQty==msg.cumQty)) return false;

		if (!Utils.equals( execID, msg.execID)) return false;

		if (!( execTransType==msg.execTransType)) return false;

		if (!Utils.equals( orderID, msg.orderID)) return false;

		if (!( ordStatus==msg.ordStatus)) return false;

		if (!( side==msg.side)) return false;

		if (!Utils.equals( symbol, msg.symbol)) return false;

		if (!Utils.equals( clientID, msg.clientID)) return false;

		if (!( execType==msg.execType)) return false;

		if (!( leavesQty==msg.leavesQty)) return false;

		if (!Utils.equals( secondaryOrderID, msg.secondaryOrderID)) return false;

		if (!( execRestatementReason==msg.execRestatementReason)) return false;

		return true;
	}
}
