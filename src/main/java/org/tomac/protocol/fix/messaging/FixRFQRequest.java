package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixRFQRequest extends FixInMessage {
	private short hasRFQReqID;
	byte[] rFQReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSubscriptionRequestType;
	byte subscriptionRequestType = (byte)' ';		
	private short hasPrivateQuote;
		boolean privateQuote = false;		
	public FixParties[] parties;
	public FixRFQReqGrp[] rFQReqGrp;
	
	public FixRFQRequest() {
		super(FixMessageInfo.MessageTypes.RFQREQUEST);


		hasRFQReqID = FixUtils.TAG_HAS_NO_VALUE;		
		rFQReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSubscriptionRequestType = FixUtils.TAG_HAS_NO_VALUE;		
		hasPrivateQuote = FixUtils.TAG_HAS_NO_VALUE;		
		parties = new FixParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) parties[i] = new FixParties();
		rFQReqGrp = new FixRFQReqGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) rFQReqGrp[i] = new FixRFQReqGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixUtils.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.RFQREQID_INT:		
            		hasRFQReqID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SUBSCRIPTIONREQUESTTYPE_INT:		
            		hasSubscriptionRequestType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.PRIVATEQUOTE_INT:		
            		hasPrivateQuote = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	default:
        			if ( standardHeader.isKeyTag(tag)) {
        				tag = standardHeader.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( standardTrailer.isKeyTag(tag)) {
        				tag = standardTrailer.setBuffer( tag, buf, err);
        				FixUtils.unreadLastTag(tag, buf);
        				if (!err.hasError()) hasRequiredTags(err);
            			return; // always last, we are done now
        			} else if ( tag == FixTags.NOPARTYIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !parties[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOPARTYIDS_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = parties[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NORELATEDSYM_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !rFQReqGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NORELATEDSYM_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = rFQReqGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else {
 						FixUtils.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else if (FixUtils.validateOnlyDefinedTagsAllowed) {
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.RFQREQUEST_INT);
                			break;
                		}
					}

			}

        		if (err.hasError()) return;

            	tag = FixUtils.getTag(buf, err);		
        		if (err.hasError()) break;

		}

	}		

	public boolean hasRequiredTags(FixValidationError err) {
		if (!hasRFQReqID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.RFQREQID_INT, FixMessageInfo.MessageTypes.RFQREQUEST_INT);
			return false;
		}
		for (int i = 0; i< FixUtils.FIX_MAX_NOINGROUP; i++) { if (rFQReqGrp[i].hasGroup()) rFQReqGrp[i].hasRequiredTags(err); if (err.hasError()) return false; }
		return true;
	}
	@Override		
	public void getAll() {		
		getRFQReqID();		
		getSubscriptionRequestType();		
		getPrivateQuote();		
	}		
		
	@Override		
	public int encode(ByteBuffer out) {

		int startPos = out.position();
		super.standardHeader.setBodyLength(1000);

		// if this is the standardHeader for an out-bound message wee need to set default tags
		if (buf == null) {
			super.standardHeader.setBeginString(FixMessageInfo.BEGINSTRING_VALUE);
		}

		super.standardHeader.encode(out);
		if (hasRFQReqID()) {		
			out.put(FixTags.RFQREQID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,rFQReqID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSubscriptionRequestType()) {		
			out.put(FixTags.SUBSCRIPTIONREQUESTTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,subscriptionRequestType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPrivateQuote()) {		
			out.put(FixTags.PRIVATEQUOTE);		
		
			out.put((byte) '=');		
		
			out.put(privateQuote?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		
		if (FixUtils.getNoInGroup(parties)>0) {
			out.put(FixTags.NOPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(parties));

			out.put(FixUtils.SOH);

		}
		for (FixParties fixParties : parties) if (fixParties.hasGroup()) fixParties.encode(out);
		if (FixUtils.getNoInGroup(rFQReqGrp)>0) {
			out.put(FixTags.NORELATEDSYM);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(rFQReqGrp));

			out.put(FixUtils.SOH);

		}
		for (FixRFQReqGrp fixRFQReqGrp : rFQReqGrp) if (fixRFQReqGrp.hasGroup()) fixRFQReqGrp.encode(out);
		
		// set body length

		int endPos = out.position();

		super.standardHeader.setBodyLength(endPos - FixUtils.FIX_MESSAGE_START);

		out.position(startPos + FixUtils.FIX_HEADER);

		if (super.standardHeader.getBodyLength()>999) {
			FixUtils.put(out, super.standardHeader.getBodyLength());
		} else if (super.standardHeader.getBodyLength()>99) {
			FixUtils.put(out, 0);
			FixUtils.put(out, super.standardHeader.getBodyLength());
		} else {
			FixUtils.put(out, 0);
			FixUtils.put(out, 0);
			FixUtils.put(out, super.standardHeader.getBodyLength());
		}
		final byte[] tmpCheckSum = new byte[FixTags.CHECKSUM_LENGTH];
		FixUtils.generateCheckSum(tmpCheckSum, out, startPos, endPos);
		super.standardTrailer.setCheckSum(tmpCheckSum);

		out.position(endPos);

		super.standardTrailer.encode(out);
		out.limit(out.position());
		out.flip();

		return (int) super.standardHeader.getBodyLength();

	}			
			
			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		int startPos = out.position();		
					
		super.standardHeader.encode(out);		
		
		if (hasRFQReqID()) {		
			FixUtils.put(out,rFQReqID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSubscriptionRequestType()) {		
			FixUtils.put(out,subscriptionRequestType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPrivateQuote()) {		
			out.put(privateQuote?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		super.standardTrailer.encode(out);		
		
		int endPos = out.position();		
		
		// set body length		
				
		super.standardHeader.setBodyLength( out.position() - startPos );		
				
		out.position(startPos + FixUtils.FIX_HEADER); 		
		
		FixUtils.put( out, super.standardHeader.getBodyLength() );		
		
		out.position(endPos);		
		
	}			
			
	public void crackRFQReqID() {		
		getRFQReqID();		
	}		
			
	public byte[] getRFQReqID() { 		
		if ( hasRFQReqID()) {		
			if (hasRFQReqID == FixUtils.TAG_HAS_VALUE) {		
				return rFQReqID; 		
			} else {

				buf.position(hasRFQReqID);

			FixUtils.getTagStringValue(buf, rFQReqID, 0, rFQReqID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasRFQReqID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return rFQReqID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRFQReqID() { return hasRFQReqID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRFQReqID(byte[] src) {		
		if (src == null ) return;
		if (hasRFQReqID()) FixUtils.fillNul(rFQReqID);		
		FixUtils.copy(rFQReqID, src); 		
		hasRFQReqID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRFQReqID(String str) {		
		if (str == null ) return;
		if (hasRFQReqID()) FixUtils.fillNul(rFQReqID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(rFQReqID, src); 		
		hasRFQReqID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSubscriptionRequestType() {		
		getSubscriptionRequestType();		
	}		
			
	public byte getSubscriptionRequestType() { 		
		if ( hasSubscriptionRequestType()) {		
			if (hasSubscriptionRequestType == FixUtils.TAG_HAS_VALUE) {		
				return subscriptionRequestType; 		
			} else {

				buf.position(hasSubscriptionRequestType);

			subscriptionRequestType = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (subscriptionRequestType != (byte)'2') && (subscriptionRequestType != (byte)'1') && (subscriptionRequestType != (byte)'0') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 263);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasSubscriptionRequestType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return subscriptionRequestType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasSubscriptionRequestType() { return hasSubscriptionRequestType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSubscriptionRequestType(byte[] src) {		
		if (src == null ) return;
		if (hasSubscriptionRequestType()) subscriptionRequestType = (byte)' ';		
		subscriptionRequestType = src[0];		
		hasSubscriptionRequestType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSubscriptionRequestType(byte src) {		
		subscriptionRequestType = src;
		hasSubscriptionRequestType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSubscriptionRequestType(String str) {		
		if (str == null ) return;
		if (hasSubscriptionRequestType()) subscriptionRequestType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		subscriptionRequestType = src[0];		
		hasSubscriptionRequestType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPrivateQuote() {		
		getPrivateQuote();		
	}		
			
	public boolean getPrivateQuote() { 		
		if ( hasPrivateQuote()) {		
			if (hasPrivateQuote == FixUtils.TAG_HAS_VALUE) {		
				return privateQuote; 		
			} else {

				buf.position(hasPrivateQuote);

			privateQuote = FixUtils.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasPrivateQuote = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return privateQuote;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasPrivateQuote() { return hasPrivateQuote != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPrivateQuote(byte[] src) {		
		if (src == null ) return;
		if (hasPrivateQuote()) privateQuote = false;		
		privateQuote = src[0]==(byte)'Y'?true:false;		
		hasPrivateQuote = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPrivateQuote(boolean src) {		
		privateQuote = src;
		hasPrivateQuote = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPrivateQuote(String str) {		
		if (str == null ) return;
		if (hasPrivateQuote()) privateQuote = false;		
		byte[] src = str.getBytes(); 		
		privateQuote = src[0]==(byte)'Y'?true:false;		
		hasPrivateQuote = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
		try {
					if (standardHeader.hasBeginString()) s += "BeginString(8)= " + new String( FixUtils.trim(standardHeader.getBeginString()) ) + "\n" ; 
		if (standardHeader.hasBodyLength()) s += "BodyLength(9)= " + standardHeader.getBodyLength() + "\n" ; 
		if (standardHeader.hasMsgType()) s += "MsgType(35)= " + new String( FixUtils.trim(standardHeader.getMsgType()) ) + "\n" ; 
		if (standardHeader.hasApplVerID()) s += "ApplVerID(1128)= " + new String( FixUtils.trim(standardHeader.getApplVerID()) ) + "\n" ; 
		if (standardHeader.hasCstmApplVerID()) s += "CstmApplVerID(1129)= " + new String( FixUtils.trim(standardHeader.getCstmApplVerID()) ) + "\n" ; 
		if (standardHeader.hasApplExtID()) s += "ApplExtID(1156)= " + standardHeader.getApplExtID() + "\n" ; 
		if (standardHeader.hasSenderCompID()) s += "SenderCompID(49)= " + new String( FixUtils.trim(standardHeader.getSenderCompID()) ) + "\n" ; 
		if (standardHeader.hasTargetCompID()) s += "TargetCompID(56)= " + new String( FixUtils.trim(standardHeader.getTargetCompID()) ) + "\n" ; 
		if (standardHeader.hasOnBehalfOfCompID()) s += "OnBehalfOfCompID(115)= " + new String( FixUtils.trim(standardHeader.getOnBehalfOfCompID()) ) + "\n" ; 
		if (standardHeader.hasDeliverToCompID()) s += "DeliverToCompID(128)= " + new String( FixUtils.trim(standardHeader.getDeliverToCompID()) ) + "\n" ; 
		if (standardHeader.hasSecureDataLen()) s += "SecureDataLen(90)= " + standardHeader.getSecureDataLen() + "\n" ; 
		if (standardHeader.hasSecureData()) s += "SecureData(91)= " + new String( FixUtils.trim(standardHeader.getSecureData()) ) + "\n" ; 
		if (standardHeader.hasMsgSeqNum()) s += "MsgSeqNum(34)= " + standardHeader.getMsgSeqNum() + "\n" ; 
		if (standardHeader.hasSenderSubID()) s += "SenderSubID(50)= " + new String( FixUtils.trim(standardHeader.getSenderSubID()) ) + "\n" ; 
		if (standardHeader.hasSenderLocationID()) s += "SenderLocationID(142)= " + new String( FixUtils.trim(standardHeader.getSenderLocationID()) ) + "\n" ; 
		if (standardHeader.hasTargetSubID()) s += "TargetSubID(57)= " + new String( FixUtils.trim(standardHeader.getTargetSubID()) ) + "\n" ; 
		if (standardHeader.hasTargetLocationID()) s += "TargetLocationID(143)= " + new String( FixUtils.trim(standardHeader.getTargetLocationID()) ) + "\n" ; 
		if (standardHeader.hasOnBehalfOfSubID()) s += "OnBehalfOfSubID(116)= " + new String( FixUtils.trim(standardHeader.getOnBehalfOfSubID()) ) + "\n" ; 
		if (standardHeader.hasOnBehalfOfLocationID()) s += "OnBehalfOfLocationID(144)= " + new String( FixUtils.trim(standardHeader.getOnBehalfOfLocationID()) ) + "\n" ; 
		if (standardHeader.hasDeliverToSubID()) s += "DeliverToSubID(129)= " + new String( FixUtils.trim(standardHeader.getDeliverToSubID()) ) + "\n" ; 
		if (standardHeader.hasDeliverToLocationID()) s += "DeliverToLocationID(145)= " + new String( FixUtils.trim(standardHeader.getDeliverToLocationID()) ) + "\n" ; 
		if (standardHeader.hasPossDupFlag()) s += "PossDupFlag(43)= " + standardHeader.getPossDupFlag() + "\n" ; 
		if (standardHeader.hasPossResend()) s += "PossResend(97)= " + standardHeader.getPossResend() + "\n" ; 
		if (standardHeader.hasSendingTime()) s += "SendingTime(52)= " + new String( FixUtils.trim(standardHeader.getSendingTime()) ) + "\n" ; 
		if (standardHeader.hasOrigSendingTime()) s += "OrigSendingTime(122)= " + new String( FixUtils.trim(standardHeader.getOrigSendingTime()) ) + "\n" ; 
		if (standardHeader.hasXmlDataLen()) s += "XmlDataLen(212)= " + standardHeader.getXmlDataLen() + "\n" ; 
		if (standardHeader.hasXmlData()) s += "XmlData(213)= " + new String( FixUtils.trim(standardHeader.getXmlData()) ) + "\n" ; 
		if (standardHeader.hasMessageEncoding()) s += "MessageEncoding(347)= " + new String( FixUtils.trim(standardHeader.getMessageEncoding()) ) + "\n" ; 
		if (standardHeader.hasLastMsgSeqNumProcessed()) s += "LastMsgSeqNumProcessed(369)= " + standardHeader.getLastMsgSeqNumProcessed() + "\n" ; 

					if (hasRFQReqID()) s += "RFQReqID(644)= " + new String( FixUtils.trim(getRFQReqID()) ) + "\n" ; 
		if (hasSubscriptionRequestType()) s += "SubscriptionRequestType(263)= " + getSubscriptionRequestType() + "\n" ; 
		if (hasPrivateQuote()) s += "PrivateQuote(1171)= " + getPrivateQuote() + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixRFQRequest)) return false;

		FixRFQRequest msg = (FixRFQRequest) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasRFQReqID() && !msg.hasRFQReqID()) || (!hasRFQReqID() && msg.hasRFQReqID())) return false;
		if (!(!hasRFQReqID() && !msg.hasRFQReqID()) && !FixUtils.equals(getRFQReqID(), msg.getRFQReqID())) return false;
		if ((hasSubscriptionRequestType() && !msg.hasSubscriptionRequestType()) || (!hasSubscriptionRequestType() && msg.hasSubscriptionRequestType())) return false;
		if (!(!hasSubscriptionRequestType() && !msg.hasSubscriptionRequestType()) && !(getSubscriptionRequestType()==msg.getSubscriptionRequestType())) return false;
		if ((hasPrivateQuote() && !msg.hasPrivateQuote()) || (!hasPrivateQuote() && msg.hasPrivateQuote())) return false;
		if (!(!hasPrivateQuote() && !msg.hasPrivateQuote()) && !(getPrivateQuote()==msg.getPrivateQuote())) return false;
		return true;
	}
	@Override
	public FixRFQRequest clone () {
		FixRFQRequest out = new FixRFQRequest();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixRFQRequest clone ( FixRFQRequest out ) {
		if ( hasRFQReqID())
			out.setRFQReqID(getRFQReqID());
		if ( hasSubscriptionRequestType())
			out.setSubscriptionRequestType(getSubscriptionRequestType());
		if ( hasPrivateQuote())
			out.setPrivateQuote(getPrivateQuote());
		int count = 0;
		count = 0;
		for (FixParties fixParties : parties) {
			if (!fixParties.hasGroup()) continue;
			out.parties[count] = fixParties.clone( out.parties[count] );
			count++;
		}
		count = 0;
		for (FixRFQReqGrp fixRFQReqGrp : rFQReqGrp) {
			if (!fixRFQReqGrp.hasGroup()) continue;
			out.rFQReqGrp[count] = fixRFQReqGrp.clone( out.rFQReqGrp[count] );
			count++;
		}
		return out;
	}

}