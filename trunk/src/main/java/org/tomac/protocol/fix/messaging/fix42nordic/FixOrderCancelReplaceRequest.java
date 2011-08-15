package org.tomac.protocol.fix.messaging.fix42nordic;

// DO NOT EDIT!!!
// This file is generated by FixMessageGenerator.
// If you need additional functionality, put it in a helper class
// that does not live in this folder!!!  Any java file in this folder 
// will be deleted upon the next run of the FixMessageGenerator!

import java.nio.ByteBuffer;

import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.FixSessionException;
import org.tomac.utils.Utils;
import org.tomac.protocol.fix.FixConstants;



public class FixOrderCancelReplaceRequest extends FixMessage
{

	public byte[] clOrdID;
	public byte[] currency;
	public byte handlInst = (byte)' ';
	public byte[] orderID;
	public long orderQty = 0;
	public byte ordType = (byte)' ';
	public byte[] origClOrdID;
	public long price = 0;
	public byte[] securityID;
	public byte side = (byte)' ';
	public byte[] symbol;
	public byte timeInForce = (byte)' ';
	public byte[] transactTime;
	public long maxFloor = 0;
	public byte[] expireTime;
	public byte[] clearingFirm;
	public byte[] clearingAccount;
	public byte[] subMktID;
	public byte[] brSeqNbr;
	public byte[] clRefID;

	public FixOrderCancelReplaceRequest() {
		super();

		clOrdID = new byte[20];
		currency = new byte[FixUtils.CURRENCY_LENGTH];
		orderID = new byte[32];
		origClOrdID = new byte[20];
		securityID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		symbol = new byte[8];
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		expireTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		clearingFirm = new byte[4];
		clearingAccount = new byte[12];
		subMktID = new byte[3];
		brSeqNbr = new byte[10];
		clRefID = new byte[15];
		this.clear();

		msgType = MsgTypes.ORDERCANCELREPLACEREQUEST_INT;

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( clOrdID, (byte)0 );
		Utils.fill( currency, (byte)0 );
		handlInst = Byte.MAX_VALUE;		
		Utils.fill( orderID, (byte)0 );
		orderQty = Long.MAX_VALUE;		
		ordType = Byte.MAX_VALUE;		
		Utils.fill( origClOrdID, (byte)0 );
		price = Long.MAX_VALUE;		
		Utils.fill( securityID, (byte)0 );
		side = Byte.MAX_VALUE;		
		Utils.fill( symbol, (byte)0 );
		timeInForce = Byte.MAX_VALUE;		
		Utils.fill( transactTime, (byte)0 );
		maxFloor = Long.MAX_VALUE;		
		Utils.fill( expireTime, (byte)0 );
		Utils.fill( clearingFirm, (byte)0 );
		Utils.fill( clearingAccount, (byte)0 );
		Utils.fill( subMktID, (byte)0 );
		Utils.fill( brSeqNbr, (byte)0 );
		Utils.fill( clRefID, (byte)0 );
	}

	@Override
	public void getAll() throws FixSessionException, IllegalStateException
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

			case FixTags.CLORDID_INT:
				clOrdID = FixUtils.getTagStringValue(value, clOrdID);
				break;

			case FixTags.CURRENCY_INT:
				currency = FixUtils.getTagStringValue(value, currency);
				break;

			case FixTags.HANDLINST_INT:
				handlInst = FixUtils.getTagCharValue( value );
				if (!HandlInst.isValid(handlInst) ) throw new FixSessionException(buf, "Invalid enumerated value(" + handlInst + ") for tag: " + id );
				break;

			case FixTags.ORDERID_INT:
				orderID = FixUtils.getTagStringValue(value, orderID);
				break;

			case FixTags.ORDERQTY_INT:
				orderQty = FixUtils.getTagFloatValue(value);
				break;

			case FixTags.ORDTYPE_INT:
				ordType = FixUtils.getTagCharValue( value );
				if (!OrdType.isValid(ordType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + ordType + ") for tag: " + id );
				break;

			case FixTags.ORIGCLORDID_INT:
				origClOrdID = FixUtils.getTagStringValue(value, origClOrdID);
				break;

			case FixTags.PRICE_INT:
				price = FixUtils.getTagFloatValue(value);
				break;

			case FixTags.SECURITYID_INT:
				securityID = FixUtils.getTagStringValue(value, securityID);
				break;

			case FixTags.SIDE_INT:
				side = FixUtils.getTagCharValue( value );
				if (!Side.isValid(side) ) throw new FixSessionException(buf, "Invalid enumerated value(" + side + ") for tag: " + id );
				break;

			case FixTags.SYMBOL_INT:
				symbol = FixUtils.getTagStringValue(value, symbol);
				break;

			case FixTags.TIMEINFORCE_INT:
				timeInForce = FixUtils.getTagCharValue( value );
				if (!TimeInForce.isValid(timeInForce) ) throw new FixSessionException(buf, "Invalid enumerated value(" + timeInForce + ") for tag: " + id );
				break;

			case FixTags.TRANSACTTIME_INT:
				transactTime = FixUtils.getTagStringValue(value, transactTime);
				break;

			case FixTags.MAXFLOOR_INT:
				maxFloor = FixUtils.getTagFloatValue(value);
				break;

			case FixTags.EXPIRETIME_INT:
				expireTime = FixUtils.getTagStringValue(value, expireTime);
				break;

			case FixTags.CLEARINGFIRM_INT:
				clearingFirm = FixUtils.getTagStringValue(value, clearingFirm);
				break;

			case FixTags.CLEARINGACCOUNT_INT:
				clearingAccount = FixUtils.getTagStringValue(value, clearingAccount);
				break;

			case FixTags.SUBMKTID_INT:
				subMktID = FixUtils.getTagStringValue(value, subMktID);
				break;

			case FixTags.BRSEQNBR_INT:
				brSeqNbr = FixUtils.getTagStringValue(value, brSeqNbr);
				break;

			case FixTags.CLREFID_INT:
				clRefID = FixUtils.getTagStringValue(value, clRefID);
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

		if (! FixUtils.isSet(clOrdID) ) return FixTags.CLORDID_INT;
		if (! FixUtils.isSet(handlInst) ) return FixTags.HANDLINST_INT;
		if (! FixUtils.isSet(orderQty) ) return FixTags.ORDERQTY_INT;
		if (! FixUtils.isSet(ordType) ) return FixTags.ORDTYPE_INT;
		if (! FixUtils.isSet(origClOrdID) ) return FixTags.ORIGCLORDID_INT;
		if (! FixUtils.isSet(price) ) return FixTags.PRICE_INT;
		if (! FixUtils.isSet(side) ) return FixTags.SIDE_INT;
		if (! FixUtils.isSet(symbol) ) return FixTags.SYMBOL_INT;
		if (! FixUtils.isSet(transactTime) ) return FixTags.TRANSACTTIME_INT;
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

		FixUtils.putFixTag( out, FixTags.MSGTYPE_INT, MsgTypes.ORDERCANCELREPLACEREQUEST);

		// encode all fields including the header

		FixUtils.putFixTag( out, FixTags.MSGSEQNUM_INT, msgSeqNum);
		if (FixUtils.isSet(possDupFlag)) FixUtils.putFixTag( out, FixTags.POSSDUPFLAG_INT, possDupFlag?(byte)'Y':(byte)'N' );
		FixUtils.putFixTag( out, FixTags.SENDERCOMPID_INT, senderCompID, 0, Utils.lastIndexTrim(senderCompID, (byte)0) );
		if (FixUtils.isSet(senderSubID)) FixUtils.putFixTag( out, FixTags.SENDERSUBID_INT, senderSubID, 0, Utils.lastIndexTrim(senderSubID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.SENDINGTIME_INT, sendingTime);
		FixUtils.putFixTag( out, FixTags.TARGETCOMPID_INT, targetCompID, 0, Utils.lastIndexTrim(targetCompID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.TARGETSUBID_INT, targetSubID, 0, Utils.lastIndexTrim(targetSubID, (byte)0) );
		if (FixUtils.isSet(possResend)) FixUtils.putFixTag( out, FixTags.POSSRESEND_INT, possResend?(byte)'Y':(byte)'N' );
		if (FixUtils.isSet(onBehalfOfCompID)) FixUtils.putFixTag( out, FixTags.ONBEHALFOFCOMPID_INT, onBehalfOfCompID, 0, Utils.lastIndexTrim(onBehalfOfCompID, (byte)0) );
		if (FixUtils.isSet(onBehalfOfSubID)) FixUtils.putFixTag( out, FixTags.ONBEHALFOFSUBID_INT, onBehalfOfSubID, 0, Utils.lastIndexTrim(onBehalfOfSubID, (byte)0) );
		if (FixUtils.isSet(origSendingTime)) FixUtils.putFixTag( out, FixTags.ORIGSENDINGTIME_INT, origSendingTime);
		if (FixUtils.isSet(deliverToCompID)) FixUtils.putFixTag( out, FixTags.DELIVERTOCOMPID_INT, deliverToCompID, 0, Utils.lastIndexTrim(deliverToCompID, (byte)0) );
		if (FixUtils.isSet(deliverToSubID)) FixUtils.putFixTag( out, FixTags.DELIVERTOSUBID_INT, deliverToSubID, 0, Utils.lastIndexTrim(deliverToSubID, (byte)0) );

		FixUtils.putFixTag( out, FixTags.CLORDID_INT, clOrdID, 0, Utils.lastIndexTrim(clOrdID, (byte)0) );
		if (FixUtils.isSet(currency)) FixUtils.putFixTag( out, FixTags.CURRENCY_INT, currency, 0, Utils.lastIndexTrim(currency, (byte)0) );
		FixUtils.putFixTag( out, FixTags.HANDLINST_INT, handlInst );
		if (FixUtils.isSet(orderID)) FixUtils.putFixTag( out, FixTags.ORDERID_INT, orderID, 0, Utils.lastIndexTrim(orderID, (byte)0) );
		FixUtils.putFixFloatTag( out, FixTags.ORDERQTY_INT, orderQty);
		FixUtils.putFixTag( out, FixTags.ORDTYPE_INT, ordType );
		FixUtils.putFixTag( out, FixTags.ORIGCLORDID_INT, origClOrdID, 0, Utils.lastIndexTrim(origClOrdID, (byte)0) );
		FixUtils.putFixFloatTag( out, FixTags.PRICE_INT, price);
		if (FixUtils.isSet(securityID)) FixUtils.putFixTag( out, FixTags.SECURITYID_INT, securityID, 0, Utils.lastIndexTrim(securityID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.SIDE_INT, side );
		FixUtils.putFixTag( out, FixTags.SYMBOL_INT, symbol, 0, Utils.lastIndexTrim(symbol, (byte)0) );
		if (FixUtils.isSet(timeInForce)) FixUtils.putFixTag( out, FixTags.TIMEINFORCE_INT, timeInForce );
		FixUtils.putFixTag( out, FixTags.TRANSACTTIME_INT, transactTime);
		if (FixUtils.isSet(maxFloor)) FixUtils.putFixFloatTag( out, FixTags.MAXFLOOR_INT, maxFloor);
		if (FixUtils.isSet(expireTime)) FixUtils.putFixTag( out, FixTags.EXPIRETIME_INT, expireTime);
		if (FixUtils.isSet(clearingFirm)) FixUtils.putFixTag( out, FixTags.CLEARINGFIRM_INT, clearingFirm, 0, Utils.lastIndexTrim(clearingFirm, (byte)0) );
		if (FixUtils.isSet(clearingAccount)) FixUtils.putFixTag( out, FixTags.CLEARINGACCOUNT_INT, clearingAccount, 0, Utils.lastIndexTrim(clearingAccount, (byte)0) );
		if (FixUtils.isSet(subMktID)) FixUtils.putFixTag( out, FixTags.SUBMKTID_INT, subMktID, 0, Utils.lastIndexTrim(subMktID, (byte)0) );
		if (FixUtils.isSet(brSeqNbr)) FixUtils.putFixTag( out, FixTags.BRSEQNBR_INT, brSeqNbr, 0, Utils.lastIndexTrim(brSeqNbr, (byte)0) );
		if (FixUtils.isSet(clRefID)) FixUtils.putFixTag( out, FixTags.CLREFID_INT, clRefID, 0, Utils.lastIndexTrim(clRefID, (byte)0) );
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
		s += "MsgType(35)=" + new String(MsgTypes.ORDERCANCELREPLACEREQUEST) + sep;

		try {
			// print all fields including the header

			 s += "MsgSeqNum(34)=" + String.valueOf(msgSeqNum) + sep;
			if (FixUtils.isSet(possDupFlag)) s += "PossDupFlag(43)=" + String.valueOf(possDupFlag) + sep;
			 s += "SenderCompID(49)=" + new String(senderCompID) + sep;
			if (FixUtils.isSet(senderSubID)) s += "SenderSubID(50)=" + new String(senderSubID) + sep;
			 s += "SendingTime(52)=" + new String(sendingTime) + sep;
			 s += "TargetCompID(56)=" + new String(targetCompID) + sep;
			 s += "TargetSubID(57)=" + new String(targetSubID) + sep;
			if (FixUtils.isSet(possResend)) s += "PossResend(97)=" + String.valueOf(possResend) + sep;
			if (FixUtils.isSet(onBehalfOfCompID)) s += "OnBehalfOfCompID(115)=" + new String(onBehalfOfCompID) + sep;
			if (FixUtils.isSet(onBehalfOfSubID)) s += "OnBehalfOfSubID(116)=" + new String(onBehalfOfSubID) + sep;
			if (FixUtils.isSet(origSendingTime)) s += "OrigSendingTime(122)=" + new String(origSendingTime) + sep;
			if (FixUtils.isSet(deliverToCompID)) s += "DeliverToCompID(128)=" + new String(deliverToCompID) + sep;
			if (FixUtils.isSet(deliverToSubID)) s += "DeliverToSubID(129)=" + new String(deliverToSubID) + sep;

			 s += "ClOrdID(11)=" + new String(clOrdID) + sep;
			if (FixUtils.isSet(currency)) s += "Currency(15)=" + new String(currency) + sep;
			 s += "HandlInst(21)=" + String.valueOf(handlInst) + sep;
			if (FixUtils.isSet(orderID)) s += "OrderID(37)=" + new String(orderID) + sep;
			 s += "OrderQty(38)=" + String.valueOf(orderQty) + sep;
			 s += "OrdType(40)=" + String.valueOf(ordType) + sep;
			 s += "OrigClOrdID(41)=" + new String(origClOrdID) + sep;
			 s += "Price(44)=" + String.valueOf(price) + sep;
			if (FixUtils.isSet(securityID)) s += "SecurityID(48)=" + new String(securityID) + sep;
			 s += "Side(54)=" + String.valueOf(side) + sep;
			 s += "Symbol(55)=" + new String(symbol) + sep;
			if (FixUtils.isSet(timeInForce)) s += "TimeInForce(59)=" + String.valueOf(timeInForce) + sep;
			 s += "TransactTime(60)=" + new String(transactTime) + sep;
			if (FixUtils.isSet(maxFloor)) s += "MaxFloor(111)=" + String.valueOf(maxFloor) + sep;
			if (FixUtils.isSet(expireTime)) s += "ExpireTime(126)=" + new String(expireTime) + sep;
			if (FixUtils.isSet(clearingFirm)) s += "ClearingFirm(439)=" + new String(clearingFirm) + sep;
			if (FixUtils.isSet(clearingAccount)) s += "ClearingAccount(440)=" + new String(clearingAccount) + sep;
			if (FixUtils.isSet(subMktID)) s += "SubMktID(5815)=" + new String(subMktID) + sep;
			if (FixUtils.isSet(brSeqNbr)) s += "BrSeqNbr(9861)=" + new String(brSeqNbr) + sep;
			if (FixUtils.isSet(clRefID)) s += "ClRefID(6209)=" + new String(clRefID) + sep;

			s += "checkSum(10)=" + String.valueOf(checkSum) + sep;

		} catch(Exception e) {  };

		return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixOrderCancelReplaceRequest)) return false;

			FixOrderCancelReplaceRequest msg = (FixOrderCancelReplaceRequest) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( clOrdID, msg.clOrdID)) return false;

		if (!Utils.equals( currency, msg.currency)) return false;

		if (!( handlInst==msg.handlInst)) return false;

		if (!Utils.equals( orderID, msg.orderID)) return false;

		if (!( orderQty==msg.orderQty)) return false;

		if (!( ordType==msg.ordType)) return false;

		if (!Utils.equals( origClOrdID, msg.origClOrdID)) return false;

		if (!( price==msg.price)) return false;

		if (!Utils.equals( securityID, msg.securityID)) return false;

		if (!( side==msg.side)) return false;

		if (!Utils.equals( symbol, msg.symbol)) return false;

		if (!( timeInForce==msg.timeInForce)) return false;

		if (!( maxFloor==msg.maxFloor)) return false;

		if (!Utils.equals( clearingFirm, msg.clearingFirm)) return false;

		if (!Utils.equals( clearingAccount, msg.clearingAccount)) return false;

		if (!Utils.equals( subMktID, msg.subMktID)) return false;

		if (!Utils.equals( brSeqNbr, msg.brSeqNbr)) return false;

		if (!Utils.equals( clRefID, msg.clRefID)) return false;

		return true;
	}
}