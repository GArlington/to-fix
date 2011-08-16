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



public class FixBreakNotification extends FixMessage
{

	public long avgPx = 0;
	public byte[] clOrdID;
	public long cumQty = 0;
	public byte[] currency;
	public byte[] execID;
	public byte execTransType = (byte)' ';
	public byte[] orderID;
	public byte ordStatus = (byte)' ';
	public byte[] securityID;
	public byte side = (byte)' ';
	public byte[] symbol;
	public byte[] text;
	public byte[] transactTime;
	public byte[] futSettDate;
	public byte[] securityDesc;
	public byte[] clientID;
	public byte execType = (byte)' ';
	public long leavesQty = 0;
	public long noContraBrokers = 0;
	public byte[] contraBroker;
	public long priceType = 0;
	public byte[] transBkdTime;
	public byte[] clearingFirm;
	public byte[] clearingAccount;
	public byte[] orderCapacity;
	public byte[] orderRestrictions;
	public byte[] tradeReportID;
	public byte[] tradeReportRefID;
	public byte[] clearingInstruction;
	public byte[] tradeType;
	public byte[] publishTrdIndicator;
	public byte[] tradeReportType;
	public byte[] trdMatchID;
	public byte[] secondaryTradeReportRefID;
	public byte[] tradeID;
	public byte[] subMktID;
	public byte[] disseminationTime;
	public byte[] timestampown;
	public byte[] timestampcounterpart;
	public byte[] clRefID;
	public byte lockedInStatus = (byte)' ';
	public byte delayedDisseminationInst = (byte)' ';
	public byte breakIndicator = (byte)' ';
	public byte[] brSeqNbr;

	public FixBreakNotification() {
		super();

		clOrdID = new byte[20];
		currency = new byte[FixUtils.CURRENCY_LENGTH];
		execID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		orderID = new byte[32];
		securityID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		symbol = new byte[8];
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		futSettDate = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		securityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		clientID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		contraBroker = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		transBkdTime = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		clearingFirm = new byte[4];
		clearingAccount = new byte[12];
		orderCapacity = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		orderRestrictions = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		tradeReportID = new byte[20];
		tradeReportRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		clearingInstruction = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		tradeType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		publishTrdIndicator = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		tradeReportType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		trdMatchID = new byte[10];
		secondaryTradeReportRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		tradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		subMktID = new byte[3];
		disseminationTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		timestampown = new byte[20];
		timestampcounterpart = new byte[20];
		clRefID = new byte[15];
		brSeqNbr = new byte[10];
		this.clear();

		msgType = MsgTypes.BREAKNOTIFICATION_INT;

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		avgPx = Long.MAX_VALUE;		
		Utils.fill( clOrdID, (byte)0 );
		cumQty = Long.MAX_VALUE;		
		Utils.fill( currency, (byte)0 );
		Utils.fill( execID, (byte)0 );
		execTransType = Byte.MAX_VALUE;		
		Utils.fill( orderID, (byte)0 );
		ordStatus = Byte.MAX_VALUE;		
		Utils.fill( securityID, (byte)0 );
		side = Byte.MAX_VALUE;		
		Utils.fill( symbol, (byte)0 );
		Utils.fill( text, (byte)0 );
		Utils.fill( transactTime, (byte)0 );
		Utils.fill( futSettDate, (byte)0 );
		Utils.fill( securityDesc, (byte)0 );
		Utils.fill( clientID, (byte)0 );
		execType = Byte.MAX_VALUE;		
		leavesQty = Long.MAX_VALUE;		
		noContraBrokers = Long.MAX_VALUE;		
		Utils.fill( contraBroker, (byte)0 );
		priceType = Long.MAX_VALUE;		
		Utils.fill( transBkdTime, (byte)0 );
		Utils.fill( clearingFirm, (byte)0 );
		Utils.fill( clearingAccount, (byte)0 );
		Utils.fill( orderCapacity, (byte)0 );
		Utils.fill( orderRestrictions, (byte)0 );
		Utils.fill( tradeReportID, (byte)0 );
		Utils.fill( tradeReportRefID, (byte)0 );
		Utils.fill( clearingInstruction, (byte)0 );
		Utils.fill( tradeType, (byte)0 );
		Utils.fill( publishTrdIndicator, (byte)0 );
		Utils.fill( tradeReportType, (byte)0 );
		Utils.fill( trdMatchID, (byte)0 );
		Utils.fill( secondaryTradeReportRefID, (byte)0 );
		Utils.fill( tradeID, (byte)0 );
		Utils.fill( subMktID, (byte)0 );
		Utils.fill( disseminationTime, (byte)0 );
		Utils.fill( timestampown, (byte)0 );
		Utils.fill( timestampcounterpart, (byte)0 );
		Utils.fill( clRefID, (byte)0 );
		lockedInStatus = Byte.MAX_VALUE;		
		delayedDisseminationInst = Byte.MAX_VALUE;		
		breakIndicator = Byte.MAX_VALUE;		
		Utils.fill( brSeqNbr, (byte)0 );
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

			case FixTags.CURRENCY_INT:
				currency = FixUtils.getTagStringValue(value, currency);
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

			case FixTags.TEXT_INT:
				text = FixUtils.getTagStringValue(value, text);
				break;

			case FixTags.TRANSACTTIME_INT:
				transactTime = FixUtils.getTagStringValue(value, transactTime);
				break;

			case FixTags.FUTSETTDATE_INT:
				futSettDate = FixUtils.getTagStringValue(value, futSettDate);
				break;

			case FixTags.SECURITYDESC_INT:
				securityDesc = FixUtils.getTagStringValue(value, securityDesc);
				if (!SecurityDesc.isValid(securityDesc) ) throw new FixSessionException(buf, "Invalid enumerated value(" + securityDesc + ") for tag: " + id );
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

			case FixTags.NOCONTRABROKERS_INT:
				noContraBrokers = FixUtils.getTagIntValue( value );
				break;

			case FixTags.CONTRABROKER_INT:
				contraBroker = FixUtils.getTagStringValue(value, contraBroker);
				break;

			case FixTags.PRICETYPE_INT:
				priceType = FixUtils.getTagIntValue( value );
				if (!PriceType.isValid(priceType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + priceType + ") for tag: " + id );
				break;

			case FixTags.TRANSBKDTIME_INT:
				transBkdTime = FixUtils.getTagStringValue(value, transBkdTime);
				break;

			case FixTags.CLEARINGFIRM_INT:
				clearingFirm = FixUtils.getTagStringValue(value, clearingFirm);
				break;

			case FixTags.CLEARINGACCOUNT_INT:
				clearingAccount = FixUtils.getTagStringValue(value, clearingAccount);
				break;

			case FixTags.ORDERCAPACITY_INT:
				orderCapacity = FixUtils.getTagStringValue(value, orderCapacity);
				if (!OrderCapacity.isValid(orderCapacity) ) throw new FixSessionException(buf, "Invalid enumerated value(" + orderCapacity + ") for tag: " + id );
				break;

			case FixTags.ORDERRESTRICTIONS_INT:
				orderRestrictions = FixUtils.getTagStringValue(value, orderRestrictions);
				if (!OrderRestrictions.isValid(orderRestrictions) ) throw new FixSessionException(buf, "Invalid enumerated value(" + orderRestrictions + ") for tag: " + id );
				break;

			case FixTags.TRADEREPORTID_INT:
				tradeReportID = FixUtils.getTagStringValue(value, tradeReportID);
				break;

			case FixTags.TRADEREPORTREFID_INT:
				tradeReportRefID = FixUtils.getTagStringValue(value, tradeReportRefID);
				break;

			case FixTags.CLEARINGINSTRUCTION_INT:
				clearingInstruction = FixUtils.getTagStringValue(value, clearingInstruction);
				if (!ClearingInstruction.isValid(clearingInstruction) ) throw new FixSessionException(buf, "Invalid enumerated value(" + clearingInstruction + ") for tag: " + id );
				break;

			case FixTags.TRADETYPE_INT:
				tradeType = FixUtils.getTagStringValue(value, tradeType);
				if (!TradeType.isValid(tradeType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + tradeType + ") for tag: " + id );
				break;

			case FixTags.PUBLISHTRDINDICATOR_INT:
				publishTrdIndicator = FixUtils.getTagStringValue(value, publishTrdIndicator);
				if (!PublishTrdIndicator.isValid(publishTrdIndicator) ) throw new FixSessionException(buf, "Invalid enumerated value(" + publishTrdIndicator + ") for tag: " + id );
				break;

			case FixTags.TRADEREPORTTYPE_INT:
				tradeReportType = FixUtils.getTagStringValue(value, tradeReportType);
				if (!TradeReportType.isValid(tradeReportType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + tradeReportType + ") for tag: " + id );
				break;

			case FixTags.TRDMATCHID_INT:
				trdMatchID = FixUtils.getTagStringValue(value, trdMatchID);
				break;

			case FixTags.SECONDARYTRADEREPORTREFID_INT:
				secondaryTradeReportRefID = FixUtils.getTagStringValue(value, secondaryTradeReportRefID);
				break;

			case FixTags.TRADEID_INT:
				tradeID = FixUtils.getTagStringValue(value, tradeID);
				break;

			case FixTags.SUBMKTID_INT:
				subMktID = FixUtils.getTagStringValue(value, subMktID);
				break;

			case FixTags.DISSEMINATIONTIME_INT:
				disseminationTime = FixUtils.getTagStringValue(value, disseminationTime);
				break;

			case FixTags.TIMESTAMPOWN_INT:
				timestampown = FixUtils.getTagStringValue(value, timestampown);
				break;

			case FixTags.TIMESTAMPCOUNTERPART_INT:
				timestampcounterpart = FixUtils.getTagStringValue(value, timestampcounterpart);
				break;

			case FixTags.CLREFID_INT:
				clRefID = FixUtils.getTagStringValue(value, clRefID);
				break;

			case FixTags.LOCKEDINSTATUS_INT:
				lockedInStatus = FixUtils.getTagCharValue( value );
				if (!LockedInStatus.isValid(lockedInStatus) ) throw new FixSessionException(buf, "Invalid enumerated value(" + lockedInStatus + ") for tag: " + id );
				break;

			case FixTags.DELAYEDDISSEMINATIONINST_INT:
				delayedDisseminationInst = FixUtils.getTagCharValue( value );
				if (!DelayedDisseminationInst.isValid(delayedDisseminationInst) ) throw new FixSessionException(buf, "Invalid enumerated value(" + delayedDisseminationInst + ") for tag: " + id );
				break;

			case FixTags.BREAKINDICATOR_INT:
				breakIndicator = FixUtils.getTagCharValue( value );
				if (!BreakIndicator.isValid(breakIndicator) ) throw new FixSessionException(buf, "Invalid enumerated value(" + breakIndicator + ") for tag: " + id );
				break;

			case FixTags.BRSEQNBR_INT:
				brSeqNbr = FixUtils.getTagStringValue(value, brSeqNbr);
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
		if (! FixUtils.isSet(cumQty) ) return FixTags.CUMQTY_INT;
		if (! FixUtils.isSet(currency) ) return FixTags.CURRENCY_INT;
		if (! FixUtils.isSet(execID) ) return FixTags.EXECID_INT;
		if (! FixUtils.isSet(execTransType) ) return FixTags.EXECTRANSTYPE_INT;
		if (! FixUtils.isSet(orderID) ) return FixTags.ORDERID_INT;
		if (! FixUtils.isSet(ordStatus) ) return FixTags.ORDSTATUS_INT;
		if (! FixUtils.isSet(securityID) ) return FixTags.SECURITYID_INT;
		if (! FixUtils.isSet(side) ) return FixTags.SIDE_INT;
		if (! FixUtils.isSet(symbol) ) return FixTags.SYMBOL_INT;
		if (! FixUtils.isSet(text) ) return FixTags.TEXT_INT;
		if (! FixUtils.isSet(transactTime) ) return FixTags.TRANSACTTIME_INT;
		if (! FixUtils.isSet(securityDesc) ) return FixTags.SECURITYDESC_INT;
		if (! FixUtils.isSet(clientID) ) return FixTags.CLIENTID_INT;
		if (! FixUtils.isSet(execType) ) return FixTags.EXECTYPE_INT;
		if (! FixUtils.isSet(leavesQty) ) return FixTags.LEAVESQTY_INT;
		if (! FixUtils.isSet(priceType) ) return FixTags.PRICETYPE_INT;
		if (! FixUtils.isSet(transBkdTime) ) return FixTags.TRANSBKDTIME_INT;
		if (! FixUtils.isSet(orderRestrictions) ) return FixTags.ORDERRESTRICTIONS_INT;
		if (! FixUtils.isSet(tradeReportID) ) return FixTags.TRADEREPORTID_INT;
		if (! FixUtils.isSet(clearingInstruction) ) return FixTags.CLEARINGINSTRUCTION_INT;
		if (! FixUtils.isSet(tradeType) ) return FixTags.TRADETYPE_INT;
		if (! FixUtils.isSet(publishTrdIndicator) ) return FixTags.PUBLISHTRDINDICATOR_INT;
		if (! FixUtils.isSet(tradeReportType) ) return FixTags.TRADEREPORTTYPE_INT;
		if (! FixUtils.isSet(trdMatchID) ) return FixTags.TRDMATCHID_INT;
		if (! FixUtils.isSet(secondaryTradeReportRefID) ) return FixTags.SECONDARYTRADEREPORTREFID_INT;
		if (! FixUtils.isSet(tradeID) ) return FixTags.TRADEID_INT;
		if (! FixUtils.isSet(subMktID) ) return FixTags.SUBMKTID_INT;
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

		FixUtils.putFixTag( out, FixTags.MSGTYPE_INT, MsgTypes.BREAKNOTIFICATION);

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
		if (FixUtils.isSet(clOrdID)) FixUtils.putFixTag( out, FixTags.CLORDID_INT, clOrdID, 0, Utils.lastIndexTrim(clOrdID, (byte)0) );
		FixUtils.putFixFloatTag( out, FixTags.CUMQTY_INT, cumQty);
		FixUtils.putFixTag( out, FixTags.CURRENCY_INT, currency, 0, Utils.lastIndexTrim(currency, (byte)0) );
		FixUtils.putFixTag( out, FixTags.EXECID_INT, execID, 0, Utils.lastIndexTrim(execID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.EXECTRANSTYPE_INT, execTransType );
		FixUtils.putFixTag( out, FixTags.ORDERID_INT, orderID, 0, Utils.lastIndexTrim(orderID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.ORDSTATUS_INT, ordStatus );
		FixUtils.putFixTag( out, FixTags.SECURITYID_INT, securityID, 0, Utils.lastIndexTrim(securityID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.SIDE_INT, side );
		FixUtils.putFixTag( out, FixTags.SYMBOL_INT, symbol, 0, Utils.lastIndexTrim(symbol, (byte)0) );
		FixUtils.putFixTag( out, FixTags.TEXT_INT, text, 0, Utils.lastIndexTrim(text, (byte)0) );
		FixUtils.putFixTag( out, FixTags.TRANSACTTIME_INT, transactTime);
		if (FixUtils.isSet(futSettDate)) FixUtils.putFixTag( out, FixTags.FUTSETTDATE_INT, futSettDate);
		FixUtils.putFixTag( out, FixTags.SECURITYDESC_INT, securityDesc, 0, Utils.lastIndexTrim(securityDesc, (byte)0) );
		FixUtils.putFixTag( out, FixTags.CLIENTID_INT, clientID, 0, Utils.lastIndexTrim(clientID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.EXECTYPE_INT, execType );
		FixUtils.putFixFloatTag( out, FixTags.LEAVESQTY_INT, leavesQty);
		if (FixUtils.isSet(noContraBrokers)) FixUtils.putFixTag( out, FixTags.NOCONTRABROKERS_INT, noContraBrokers);
		if (FixUtils.isSet(contraBroker)) FixUtils.putFixTag( out, FixTags.CONTRABROKER_INT, contraBroker, 0, Utils.lastIndexTrim(contraBroker, (byte)0) );
		FixUtils.putFixTag( out, FixTags.PRICETYPE_INT, priceType);
		FixUtils.putFixTag( out, FixTags.TRANSBKDTIME_INT, transBkdTime, 0, Utils.lastIndexTrim(transBkdTime, (byte)0) );
		if (FixUtils.isSet(clearingFirm)) FixUtils.putFixTag( out, FixTags.CLEARINGFIRM_INT, clearingFirm, 0, Utils.lastIndexTrim(clearingFirm, (byte)0) );
		if (FixUtils.isSet(clearingAccount)) FixUtils.putFixTag( out, FixTags.CLEARINGACCOUNT_INT, clearingAccount, 0, Utils.lastIndexTrim(clearingAccount, (byte)0) );
		if (FixUtils.isSet(orderCapacity)) FixUtils.putFixTag( out, FixTags.ORDERCAPACITY_INT, orderCapacity, 0, Utils.lastIndexTrim(orderCapacity, (byte)0) );
		FixUtils.putFixTag( out, FixTags.ORDERRESTRICTIONS_INT, orderRestrictions, 0, Utils.lastIndexTrim(orderRestrictions, (byte)0) );
		FixUtils.putFixTag( out, FixTags.TRADEREPORTID_INT, tradeReportID, 0, Utils.lastIndexTrim(tradeReportID, (byte)0) );
		if (FixUtils.isSet(tradeReportRefID)) FixUtils.putFixTag( out, FixTags.TRADEREPORTREFID_INT, tradeReportRefID, 0, Utils.lastIndexTrim(tradeReportRefID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.CLEARINGINSTRUCTION_INT, clearingInstruction, 0, Utils.lastIndexTrim(clearingInstruction, (byte)0) );
		FixUtils.putFixTag( out, FixTags.TRADETYPE_INT, tradeType, 0, Utils.lastIndexTrim(tradeType, (byte)0) );
		FixUtils.putFixTag( out, FixTags.PUBLISHTRDINDICATOR_INT, publishTrdIndicator, 0, Utils.lastIndexTrim(publishTrdIndicator, (byte)0) );
		FixUtils.putFixTag( out, FixTags.TRADEREPORTTYPE_INT, tradeReportType, 0, Utils.lastIndexTrim(tradeReportType, (byte)0) );
		FixUtils.putFixTag( out, FixTags.TRDMATCHID_INT, trdMatchID, 0, Utils.lastIndexTrim(trdMatchID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.SECONDARYTRADEREPORTREFID_INT, secondaryTradeReportRefID, 0, Utils.lastIndexTrim(secondaryTradeReportRefID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.TRADEID_INT, tradeID, 0, Utils.lastIndexTrim(tradeID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.SUBMKTID_INT, subMktID, 0, Utils.lastIndexTrim(subMktID, (byte)0) );
		if (FixUtils.isSet(disseminationTime)) FixUtils.putFixTag( out, FixTags.DISSEMINATIONTIME_INT, disseminationTime);
		if (FixUtils.isSet(timestampown)) FixUtils.putFixTag( out, FixTags.TIMESTAMPOWN_INT, timestampown, 0, Utils.lastIndexTrim(timestampown, (byte)0) );
		if (FixUtils.isSet(timestampcounterpart)) FixUtils.putFixTag( out, FixTags.TIMESTAMPCOUNTERPART_INT, timestampcounterpart, 0, Utils.lastIndexTrim(timestampcounterpart, (byte)0) );
		if (FixUtils.isSet(clRefID)) FixUtils.putFixTag( out, FixTags.CLREFID_INT, clRefID, 0, Utils.lastIndexTrim(clRefID, (byte)0) );
		if (FixUtils.isSet(lockedInStatus)) FixUtils.putFixTag( out, FixTags.LOCKEDINSTATUS_INT, lockedInStatus );
		if (FixUtils.isSet(delayedDisseminationInst)) FixUtils.putFixTag( out, FixTags.DELAYEDDISSEMINATIONINST_INT, delayedDisseminationInst );
		if (FixUtils.isSet(breakIndicator)) FixUtils.putFixTag( out, FixTags.BREAKINDICATOR_INT, breakIndicator );
		if (FixUtils.isSet(brSeqNbr)) FixUtils.putFixTag( out, FixTags.BRSEQNBR_INT, brSeqNbr, 0, Utils.lastIndexTrim(brSeqNbr, (byte)0) );
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
		s += "MsgType(35)=" + new String(MsgTypes.BREAKNOTIFICATION) + sep;

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
			if (FixUtils.isSet(clOrdID)) s += "ClOrdID(11)=" + new String(clOrdID) + sep;
			 s += "CumQty(14)=" + String.valueOf(cumQty) + sep;
			 s += "Currency(15)=" + new String(currency) + sep;
			 s += "ExecID(17)=" + new String(execID) + sep;
			 s += "ExecTransType(20)=" + String.valueOf(execTransType) + sep;
			 s += "OrderID(37)=" + new String(orderID) + sep;
			 s += "OrdStatus(39)=" + String.valueOf(ordStatus) + sep;
			 s += "SecurityID(48)=" + new String(securityID) + sep;
			 s += "Side(54)=" + String.valueOf(side) + sep;
			 s += "Symbol(55)=" + new String(symbol) + sep;
			 s += "Text(58)=" + new String(text) + sep;
			 s += "TransactTime(60)=" + new String(transactTime) + sep;
			if (FixUtils.isSet(futSettDate)) s += "FutSettDate(64)=" + new String(futSettDate) + sep;
			 s += "SecurityDesc(107)=" + new String(securityDesc) + sep;
			 s += "ClientID(109)=" + new String(clientID) + sep;
			 s += "ExecType(150)=" + String.valueOf(execType) + sep;
			 s += "LeavesQty(151)=" + String.valueOf(leavesQty) + sep;
			if (FixUtils.isSet(noContraBrokers)) s += "NoContraBrokers(382)=" + String.valueOf(noContraBrokers) + sep;
			if (FixUtils.isSet(contraBroker)) s += "ContraBroker(375)=" + new String(contraBroker) + sep;
			 s += "PriceType(423)=" + String.valueOf(priceType) + sep;
			 s += "TransBkdTime(483)=" + new String(transBkdTime) + sep;
			if (FixUtils.isSet(clearingFirm)) s += "ClearingFirm(439)=" + new String(clearingFirm) + sep;
			if (FixUtils.isSet(clearingAccount)) s += "ClearingAccount(440)=" + new String(clearingAccount) + sep;
			if (FixUtils.isSet(orderCapacity)) s += "OrderCapacity(528)=" + new String(orderCapacity) + sep;
			 s += "OrderRestrictions(529)=" + new String(orderRestrictions) + sep;
			 s += "TradeReportID(571)=" + new String(tradeReportID) + sep;
			if (FixUtils.isSet(tradeReportRefID)) s += "TradeReportRefID(572)=" + new String(tradeReportRefID) + sep;
			 s += "ClearingInstruction(577)=" + new String(clearingInstruction) + sep;
			 s += "TradeType(828)=" + new String(tradeType) + sep;
			 s += "PublishTrdIndicator(852)=" + new String(publishTrdIndicator) + sep;
			 s += "TradeReportType(856)=" + new String(tradeReportType) + sep;
			 s += "TrdMatchID(880)=" + new String(trdMatchID) + sep;
			 s += "SecondaryTradeReportRefID(881)=" + new String(secondaryTradeReportRefID) + sep;
			 s += "TradeID(1003)=" + new String(tradeID) + sep;
			 s += "SubMktID(5815)=" + new String(subMktID) + sep;
			if (FixUtils.isSet(disseminationTime)) s += "DisseminationTime(6169)=" + new String(disseminationTime) + sep;
			if (FixUtils.isSet(timestampown)) s += "Timestampown(6204)=" + new String(timestampown) + sep;
			if (FixUtils.isSet(timestampcounterpart)) s += "Timestampcounterpart(6205)=" + new String(timestampcounterpart) + sep;
			if (FixUtils.isSet(clRefID)) s += "ClRefID(6209)=" + new String(clRefID) + sep;
			if (FixUtils.isSet(lockedInStatus)) s += "LockedInStatus(9847)=" + String.valueOf(lockedInStatus) + sep;
			if (FixUtils.isSet(delayedDisseminationInst)) s += "DelayedDisseminationInst(9855)=" + String.valueOf(delayedDisseminationInst) + sep;
			if (FixUtils.isSet(breakIndicator)) s += "BreakIndicator(9856)=" + String.valueOf(breakIndicator) + sep;
			if (FixUtils.isSet(brSeqNbr)) s += "BrSeqNbr(9861)=" + new String(brSeqNbr) + sep;

			s += "checkSum(10)=" + String.valueOf(checkSum) + sep;

		} catch(Exception e) {  };

		return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixBreakNotification)) return false;

			FixBreakNotification msg = (FixBreakNotification) o;

		if ( ! super.equals(msg) ) return false;

		if (!( avgPx==msg.avgPx)) return false;

		if (!Utils.equals( clOrdID, msg.clOrdID)) return false;

		if (!( cumQty==msg.cumQty)) return false;

		if (!Utils.equals( currency, msg.currency)) return false;

		if (!Utils.equals( execID, msg.execID)) return false;

		if (!( execTransType==msg.execTransType)) return false;

		if (!Utils.equals( orderID, msg.orderID)) return false;

		if (!( ordStatus==msg.ordStatus)) return false;

		if (!Utils.equals( securityID, msg.securityID)) return false;

		if (!( side==msg.side)) return false;

		if (!Utils.equals( symbol, msg.symbol)) return false;

		if (!Utils.equals( text, msg.text)) return false;

		if (!Utils.equals( securityDesc, msg.securityDesc)) return false;

		if (!Utils.equals( clientID, msg.clientID)) return false;

		if (!( execType==msg.execType)) return false;

		if (!( leavesQty==msg.leavesQty)) return false;

		if (!( noContraBrokers==msg.noContraBrokers)) return false;

		if (!Utils.equals( contraBroker, msg.contraBroker)) return false;

		if (!( priceType==msg.priceType)) return false;

		if (!Utils.equals( transBkdTime, msg.transBkdTime)) return false;

		if (!Utils.equals( clearingFirm, msg.clearingFirm)) return false;

		if (!Utils.equals( clearingAccount, msg.clearingAccount)) return false;

		if (!Utils.equals( orderCapacity, msg.orderCapacity)) return false;

		if (!Utils.equals( orderRestrictions, msg.orderRestrictions)) return false;

		if (!Utils.equals( tradeReportID, msg.tradeReportID)) return false;

		if (!Utils.equals( tradeReportRefID, msg.tradeReportRefID)) return false;

		if (!Utils.equals( clearingInstruction, msg.clearingInstruction)) return false;

		if (!Utils.equals( tradeType, msg.tradeType)) return false;

		if (!Utils.equals( publishTrdIndicator, msg.publishTrdIndicator)) return false;

		if (!Utils.equals( tradeReportType, msg.tradeReportType)) return false;

		if (!Utils.equals( trdMatchID, msg.trdMatchID)) return false;

		if (!Utils.equals( secondaryTradeReportRefID, msg.secondaryTradeReportRefID)) return false;

		if (!Utils.equals( tradeID, msg.tradeID)) return false;

		if (!Utils.equals( subMktID, msg.subMktID)) return false;

		if (!Utils.equals( timestampown, msg.timestampown)) return false;

		if (!Utils.equals( timestampcounterpart, msg.timestampcounterpart)) return false;

		if (!Utils.equals( clRefID, msg.clRefID)) return false;

		if (!( lockedInStatus==msg.lockedInStatus)) return false;

		if (!( delayedDisseminationInst==msg.delayedDisseminationInst)) return false;

		if (!( breakIndicator==msg.breakIndicator)) return false;

		if (!Utils.equals( brSeqNbr, msg.brSeqNbr)) return false;

		return true;
	}
}
