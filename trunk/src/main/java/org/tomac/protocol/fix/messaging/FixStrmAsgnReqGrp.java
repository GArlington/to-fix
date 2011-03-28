package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixStrmAsgnReqGrp extends FixGroup {
		FixParties[] parties;
		FixStrmAsgnReqInstrmtGrp[] strmAsgnReqInstrmtGrp;
	
	public FixStrmAsgnReqGrp() {
		super(FixTags.PARTYID_INT);

		
		parties = new FixParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) parties[i] = new FixParties();
		strmAsgnReqInstrmtGrp = new FixStrmAsgnReqInstrmtGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) strmAsgnReqInstrmtGrp[i] = new FixStrmAsgnReqInstrmtGrp();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (parties[0].hasGroup()) return true;
		else return false;
	}


	/**
     * Parse FIX Group. The buffer is positioned at the value of the tag.
     */
    public int setBuffer( int tag, ByteBuffer buf, FixValidationError err)
    {

		super.err = err;
		super.err.clear();
		super.setBuffer(buf, err);


        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	default:
        			if ( tag == FixTags.NOPARTYIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !parties[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = parties[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NORELATEDSYM_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !strmAsgnReqInstrmtGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = strmAsgnReqInstrmtGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else { return tag; }
            }

            tag = FixMessage.getTag(buf, err);
            if (err.hasError()) return tag; // what to do now? 
        }		
        return tag;
    }		
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		for (FixParties fixParties : parties) fixParties.clear();
		for (FixStrmAsgnReqInstrmtGrp fixStrmAsgnReqInstrmtGrp : strmAsgnReqInstrmtGrp) fixStrmAsgnReqInstrmtGrp.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		for (FixParties fixParties : parties) fixParties.encode(out);
		for (FixStrmAsgnReqInstrmtGrp fixStrmAsgnReqInstrmtGrp : strmAsgnReqInstrmtGrp) fixStrmAsgnReqInstrmtGrp.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		for (FixParties fixParties : parties) fixParties.printBuffer(out);
		for (FixStrmAsgnReqInstrmtGrp fixStrmAsgnReqInstrmtGrp : strmAsgnReqInstrmtGrp) fixStrmAsgnReqInstrmtGrp.printBuffer(out);
	}

	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
		
		for (FixParties fixParties : parties) fixParties.toString();
		for (FixStrmAsgnReqInstrmtGrp fixStrmAsgnReqInstrmtGrp : strmAsgnReqInstrmtGrp) fixStrmAsgnReqInstrmtGrp.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixStrmAsgnReqGrp)) return false;

		FixStrmAsgnReqGrp msg = (FixStrmAsgnReqGrp) o;

		for (FixParties fixParties : parties)
			if (!fixParties.equals(msg.parties)) return false;
		for (FixStrmAsgnReqInstrmtGrp fixStrmAsgnReqInstrmtGrp : strmAsgnReqInstrmtGrp)
			if (!fixStrmAsgnReqInstrmtGrp.equals(msg.strmAsgnReqInstrmtGrp)) return false;
		return true;
	}
	public FixStrmAsgnReqGrp clone ( FixStrmAsgnReqGrp out ) {
		int count = 0;
		count = 0;
		for (FixParties fixParties : parties) {
			if (!fixParties.hasGroup()) continue;
			out.parties[count] = fixParties.clone( out.parties[count] );
			count++;
		}
		count = 0;
		for (FixStrmAsgnReqInstrmtGrp fixStrmAsgnReqInstrmtGrp : strmAsgnReqInstrmtGrp) {
			if (!fixStrmAsgnReqInstrmtGrp.hasGroup()) continue;
			out.strmAsgnReqInstrmtGrp[count] = fixStrmAsgnReqInstrmtGrp.clone( out.strmAsgnReqInstrmtGrp[count] );
			count++;
		}
		return out;
	}

}
