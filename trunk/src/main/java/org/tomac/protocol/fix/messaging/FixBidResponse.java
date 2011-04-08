package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixBidResponse extends FixInMessage {
	private short hasBidID;
	byte[] bidID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasClientBidID;
	byte[] clientBidID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	public FixBidCompRspGrp[] bidCompRspGrp;
	
	public FixBidResponse() {
		super(FixMessageInfo.MessageTypes.BIDRESPONSE);


		hasBidID = FixUtils.TAG_HAS_NO_VALUE;		
		bidID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasClientBidID = FixUtils.TAG_HAS_NO_VALUE;		
		clientBidID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		bidCompRspGrp = new FixBidCompRspGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) bidCompRspGrp[i] = new FixBidCompRspGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.BIDID_INT:		
            		hasBidID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CLIENTBIDID_INT:		
            		hasClientBidID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	default:
        			if ( standardHeader.isKeyTag(tag)) {
        				tag = standardHeader.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( standardTrailer.isKeyTag(tag)) {
        				tag = standardTrailer.setBuffer( tag, buf, err);
        				FixMessage.unreadLastTag(tag, buf);
        				if (!err.hasError()) hasRequiredTags(err);
            			return; // always last, we are done now
        			} else if ( tag == FixTags.NOBIDCOMPONENTS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !bidCompRspGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = bidCompRspGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else {
 						FixMessage.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else {
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.BIDRESPONSE);
                			break;
                		}
					}

			}

        		if (err.hasError()) return;

            	tag = FixMessage.getTag(buf, err);		
        		if (err.hasError()) break;

		}

	}		

	public boolean hasRequiredTags(FixValidationError err) {
		standardHeader.hasRequiredTags(err); if (err.hasError()) return false; 

		for (int i = 0; i< FixUtils.FIX_MAX_NOINGROUP; i++) { if (bidCompRspGrp[i].hasGroup()) bidCompRspGrp[i].hasRequiredTags(err); if (err.hasError()) return false; }
		standardTrailer.hasRequiredTags(err); if (err.hasError()) return false; 

		return true;
	}
	@Override		
	public void getAll() {		
		getBidID();		
		getClientBidID();		
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
		if (hasBidID()) {		
			out.put(FixTags.BIDID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,bidID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasClientBidID()) {		
			out.put(FixTags.CLIENTBIDID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clientBidID); 		
		
			out.put(FixUtils.SOH);		
		}		
		
		if (FixUtils.getNoInGroup(bidCompRspGrp)>0) {
			out.put(FixTags.NOBIDCOMPONENTS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(bidCompRspGrp));

			out.put(FixUtils.SOH);

		}
		for (FixBidCompRspGrp fixBidCompRspGrp : bidCompRspGrp) if (fixBidCompRspGrp.hasGroup()) fixBidCompRspGrp.encode(out);
		
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
		
		if (hasBidID()) {		
			FixUtils.put(out,bidID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClientBidID()) {		
			FixUtils.put(out,clientBidID); 		
		
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
			
	public void crackBidID() {		
		getBidID();		
	}		
			
	public byte[] getBidID() { 		
		if ( hasBidID()) {		
			if (hasBidID == FixUtils.TAG_HAS_VALUE) {		
				return bidID; 		
			} else {

				buf.position(hasBidID);

			FixMessage.getTagStringValue(buf, bidID, 0, bidID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasBidID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return bidID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasBidID() { return hasBidID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setBidID(byte[] src) {		
		if (src == null ) return;
		if (hasBidID()) FixUtils.fillNul(bidID);		
		FixUtils.copy(bidID, src); 		
		hasBidID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBidID(String str) {		
		if (str == null ) return;
		if (hasBidID()) FixUtils.fillNul(bidID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(bidID, src); 		
		hasBidID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackClientBidID() {		
		getClientBidID();		
	}		
			
	public byte[] getClientBidID() { 		
		if ( hasClientBidID()) {		
			if (hasClientBidID == FixUtils.TAG_HAS_VALUE) {		
				return clientBidID; 		
			} else {

				buf.position(hasClientBidID);

			FixMessage.getTagStringValue(buf, clientBidID, 0, clientBidID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasClientBidID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return clientBidID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasClientBidID() { return hasClientBidID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setClientBidID(byte[] src) {		
		if (src == null ) return;
		if (hasClientBidID()) FixUtils.fillNul(clientBidID);		
		FixUtils.copy(clientBidID, src); 		
		hasClientBidID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setClientBidID(String str) {		
		if (str == null ) return;
		if (hasClientBidID()) FixUtils.fillNul(clientBidID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(clientBidID, src); 		
		hasClientBidID = FixUtils.TAG_HAS_VALUE;		
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

					if (hasBidID()) s += "BidID(390)= " + new String( FixUtils.trim(getBidID()) ) + "\n" ; 
		if (hasClientBidID()) s += "ClientBidID(391)= " + new String( FixUtils.trim(getClientBidID()) ) + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixBidResponse)) return false;

		FixBidResponse msg = (FixBidResponse) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasBidID() && !msg.hasBidID()) || (!hasBidID() && msg.hasBidID())) return false;
		if (!(!hasBidID() && !msg.hasBidID()) && !FixUtils.equals(getBidID(), msg.getBidID())) return false;
		if ((hasClientBidID() && !msg.hasClientBidID()) || (!hasClientBidID() && msg.hasClientBidID())) return false;
		if (!(!hasClientBidID() && !msg.hasClientBidID()) && !FixUtils.equals(getClientBidID(), msg.getClientBidID())) return false;
		return true;
	}
	@Override
	public FixBidResponse clone () {
		FixBidResponse out = new FixBidResponse();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixBidResponse clone ( FixBidResponse out ) {
		if ( hasBidID())
			out.setBidID(getBidID());
		if ( hasClientBidID())
			out.setClientBidID(getClientBidID());
		int count = 0;
		count = 0;
		for (FixBidCompRspGrp fixBidCompRspGrp : bidCompRspGrp) {
			if (!fixBidCompRspGrp.hasGroup()) continue;
			out.bidCompRspGrp[count] = fixBidCompRspGrp.clone( out.bidCompRspGrp[count] );
			count++;
		}
		return out;
	}

}