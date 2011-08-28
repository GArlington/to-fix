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



public class FixOrderCancelReject extends FixMessage
{

	public byte[] clOrdID;
	public byte[] orderID;
	public byte ordStatus = (byte)' ';
	public byte[] origClOrdID;
	public byte[] text;
	public long cxlRejReason = 0;
	public byte[] clientID;
	public byte cxlRejResponseTo = (byte)' ';

	public FixOrderCancelReject() {
		super();

		clOrdID = new byte[20];
		orderID = new byte[32];
		origClOrdID = new byte[20];
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		clientID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

		msgType = MsgTypes.ORDERCANCELREJECT_INT;

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( clOrdID, (byte)0 );
		Utils.fill( orderID, (byte)0 );
		ordStatus = Byte.MAX_VALUE;		
		Utils.fill( origClOrdID, (byte)0 );
		Utils.fill( text, (byte)0 );
		cxlRejReason = Long.MAX_VALUE;		
		Utils.fill( clientID, (byte)0 );
		cxlRejResponseTo = Byte.MAX_VALUE;		
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
		while ( ( id = FixUtils.getTagId( buf ) ) >= 0 )
		{
			ByteBuffer value;

			value = buf;

			switch( id ) {

			case FixTags.CLORDID_INT:
				clOrdID = FixUtils.getTagStringValue(MsgTypes.ORDERCANCELREJECT ,id ,value, clOrdID);
				break;

			case FixTags.ORDERID_INT:
				orderID = FixUtils.getTagStringValue(MsgTypes.ORDERCANCELREJECT ,id ,value, orderID);
				break;

			case FixTags.ORDSTATUS_INT:
				ordStatus = FixUtils.getTagCharValue(MsgTypes.ORDERCANCELREJECT ,id ,value );
				if (!OrdStatus.isValid(ordStatus) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + ordStatus + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.ORIGCLORDID_INT:
				origClOrdID = FixUtils.getTagStringValue(MsgTypes.ORDERCANCELREJECT ,id ,value, origClOrdID);
				break;

			case FixTags.TEXT_INT:
				text = FixUtils.getTagStringValue(MsgTypes.ORDERCANCELREJECT ,id ,value, text);
				break;

			case FixTags.CXLREJREASON_INT:
				cxlRejReason = FixUtils.getTagIntValue(MsgTypes.ORDERCANCELREJECT ,id ,value );
				if (!CxlRejReason.isValid(cxlRejReason) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + cxlRejReason + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.CLIENTID_INT:
				clientID = FixUtils.getTagStringValue(MsgTypes.ORDERCANCELREJECT ,id ,value, clientID);
				break;

			case FixTags.CXLREJRESPONSETO_INT:
				cxlRejResponseTo = FixUtils.getTagCharValue(MsgTypes.ORDERCANCELREJECT ,id ,value );
				if (!CxlRejResponseTo.isValid(cxlRejResponseTo) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + cxlRejResponseTo + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			// for a message always get the checksum
			case FixTags.CHECKSUM_INT:
				checkSum = FixUtils.getTagIntValue( MsgTypes.ORDERCANCELREJECT ,FixTags.CHECKSUM_INT, value );

				id = checkRequiredTags();
				if (id > 0) throw new FixSessionException(SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing".getBytes(), id, FixUtils.getMsgType(msgType) );

				return;

			default:
				throw new FixSessionException(SessionRejectReason.UNDEFINED_TAG, "Unknown tag".getBytes(), id, FixUtils.getMsgType(msgType) );

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
		if (! FixUtils.isSet(clOrdID) ) return FixTags.CLORDID_INT;
		if (! FixUtils.isSet(orderID) ) return FixTags.ORDERID_INT;
		if (! FixUtils.isSet(ordStatus) ) return FixTags.ORDSTATUS_INT;
		if (! FixUtils.isSet(origClOrdID) ) return FixTags.ORIGCLORDID_INT;
		if (! FixUtils.isSet(clientID) ) return FixTags.CLIENTID_INT;
		if (! FixUtils.isSet(cxlRejResponseTo) ) return FixTags.CXLREJRESPONSETO_INT;
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

		FixUtils.putFixTag( out, FixTags.MSGTYPE_INT, MsgTypes.ORDERCANCELREJECT);

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

		FixUtils.putFixTag( out, FixTags.CLORDID_INT, clOrdID, 0, Utils.lastIndexTrim(clOrdID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.ORDERID_INT, orderID, 0, Utils.lastIndexTrim(orderID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.ORDSTATUS_INT, ordStatus );
		FixUtils.putFixTag( out, FixTags.ORIGCLORDID_INT, origClOrdID, 0, Utils.lastIndexTrim(origClOrdID, (byte)0) );
		if (FixUtils.isSet(text)) FixUtils.putFixTag( out, FixTags.TEXT_INT, text, 0, Utils.lastIndexTrim(text, (byte)0) );
		if (FixUtils.isSet(cxlRejReason)) FixUtils.putFixTag( out, FixTags.CXLREJREASON_INT, cxlRejReason);
		FixUtils.putFixTag( out, FixTags.CLIENTID_INT, clientID, 0, Utils.lastIndexTrim(clientID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.CXLREJRESPONSETO_INT, cxlRejResponseTo );
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
		s += "MsgType(35)=" + new String(MsgTypes.ORDERCANCELREJECT) + sep;

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

			 s += "ClOrdID(11)=" + new String(clOrdID) + sep;
			 s += "OrderID(37)=" + new String(orderID) + sep;
			 s += "OrdStatus(39)=" + String.valueOf(ordStatus) + sep;
			 s += "OrigClOrdID(41)=" + new String(origClOrdID) + sep;
			if (FixUtils.isSet(text)) s += "Text(58)=" + new String(text) + sep;
			if (FixUtils.isSet(cxlRejReason)) s += "CxlRejReason(102)=" + String.valueOf(cxlRejReason) + sep;
			 s += "ClientID(109)=" + new String(clientID) + sep;
			 s += "CxlRejResponseTo(434)=" + String.valueOf(cxlRejResponseTo) + sep;

			s += "checkSum(10)=" + String.valueOf(checkSum) + sep;

		} catch(Exception e) {  };

		return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixOrderCancelReject)) return false;

			FixOrderCancelReject msg = (FixOrderCancelReject) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( clOrdID, msg.clOrdID)) return false;

		if (!Utils.equals( orderID, msg.orderID)) return false;

		if (!( ordStatus==msg.ordStatus)) return false;

		if (!Utils.equals( origClOrdID, msg.origClOrdID)) return false;

		if (!Utils.equals( text, msg.text)) return false;

		if (!( cxlRejReason==msg.cxlRejReason)) return false;

		if (!Utils.equals( clientID, msg.clientID)) return false;

		if (!( cxlRejResponseTo==msg.cxlRejResponseTo)) return false;

		return true;
	}
}
