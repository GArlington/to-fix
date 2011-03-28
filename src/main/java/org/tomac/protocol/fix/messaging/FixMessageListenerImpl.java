package org.tomac.protocol.fix.messaging;

// DO NOT EDIT!!!
// This file is generated by FixMessageGenerator.
// If you need additional functionality, put it in a helper class
// that does not live in this folder!!!  Any java file in this folder 
// will be deleted upon the next run of the FixMessageGenerator!

import java.nio.ByteBuffer;

import org.tomac.protocol.fix.FixInMessage;

public class FixMessageListenerImpl implements FixMessageListener 
{

    @Override
    public void onUnknownMessageType( ByteBuffer msg, int msgType ) {}

    @Override
    public void onFixHeartbeat( FixHeartbeat msg ) {}

    @Override
    public void onFixTestRequest( FixTestRequest msg ) {}

    @Override
    public void onFixResendRequest( FixResendRequest msg ) {}

    @Override
    public void onFixReject( FixReject msg ) {}

    @Override
    public void onFixSequenceReset( FixSequenceReset msg ) {}

    @Override
    public void onFixLogout( FixLogout msg ) {}

    @Override
    public void onFixIOI( FixIOI msg ) {}

    @Override
    public void onFixAdvertisement( FixAdvertisement msg ) {}

    @Override
    public void onFixExecutionReport( FixExecutionReport msg ) {}

    @Override
    public void onFixOrderCancelReject( FixOrderCancelReject msg ) {}

    @Override
    public void onFixLogon( FixLogon msg ) {}

    @Override
    public void onFixNews( FixNews msg ) {}

    @Override
    public void onFixEmail( FixEmail msg ) {}

    @Override
    public void onFixNewOrderSingle( FixNewOrderSingle msg ) {}

    @Override
    public void onFixNewOrderList( FixNewOrderList msg ) {}

    @Override
    public void onFixOrderCancelRequest( FixOrderCancelRequest msg ) {}

    @Override
    public void onFixOrderCancelReplaceRequest( FixOrderCancelReplaceRequest msg ) {}

    @Override
    public void onFixOrderStatusRequest( FixOrderStatusRequest msg ) {}

    @Override
    public void onFixAllocationInstruction( FixAllocationInstruction msg ) {}

    @Override
    public void onFixListCancelRequest( FixListCancelRequest msg ) {}

    @Override
    public void onFixListExecute( FixListExecute msg ) {}

    @Override
    public void onFixListStatusRequest( FixListStatusRequest msg ) {}

    @Override
    public void onFixListStatus( FixListStatus msg ) {}

    @Override
    public void onFixAllocationInstructionAck( FixAllocationInstructionAck msg ) {}

    @Override
    public void onFixDontKnowTradeDK( FixDontKnowTradeDK msg ) {}

    @Override
    public void onFixQuoteRequest( FixQuoteRequest msg ) {}

    @Override
    public void onFixQuote( FixQuote msg ) {}

    @Override
    public void onFixSettlementInstructions( FixSettlementInstructions msg ) {}

    @Override
    public void onFixMarketDataRequest( FixMarketDataRequest msg ) {}

    @Override
    public void onFixMarketDataSnapshotFullRefresh( FixMarketDataSnapshotFullRefresh msg ) {}

    @Override
    public void onFixMarketDataIncrementalRefresh( FixMarketDataIncrementalRefresh msg ) {}

    @Override
    public void onFixMarketDataRequestReject( FixMarketDataRequestReject msg ) {}

    @Override
    public void onFixQuoteCancel( FixQuoteCancel msg ) {}

    @Override
    public void onFixQuoteStatusRequest( FixQuoteStatusRequest msg ) {}

    @Override
    public void onFixMassQuoteAcknowledgement( FixMassQuoteAcknowledgement msg ) {}

    @Override
    public void onFixSecurityDefinitionRequest( FixSecurityDefinitionRequest msg ) {}

    @Override
    public void onFixSecurityDefinition( FixSecurityDefinition msg ) {}

    @Override
    public void onFixSecurityStatusRequest( FixSecurityStatusRequest msg ) {}

    @Override
    public void onFixSecurityStatus( FixSecurityStatus msg ) {}

    @Override
    public void onFixTradingSessionStatusRequest( FixTradingSessionStatusRequest msg ) {}

    @Override
    public void onFixTradingSessionStatus( FixTradingSessionStatus msg ) {}

    @Override
    public void onFixMassQuote( FixMassQuote msg ) {}

    @Override
    public void onFixBusinessMessageReject( FixBusinessMessageReject msg ) {}

    @Override
    public void onFixBidRequest( FixBidRequest msg ) {}

    @Override
    public void onFixBidResponse( FixBidResponse msg ) {}

    @Override
    public void onFixListStrikePrice( FixListStrikePrice msg ) {}

    @Override
    public void onFixRegistrationInstructions( FixRegistrationInstructions msg ) {}

    @Override
    public void onFixRegistrationInstructionsResponse( FixRegistrationInstructionsResponse msg ) {}

    @Override
    public void onFixOrderMassCancelRequest( FixOrderMassCancelRequest msg ) {}

    @Override
    public void onFixOrderMassCancelReport( FixOrderMassCancelReport msg ) {}

    @Override
    public void onFixNewOrderCross( FixNewOrderCross msg ) {}

    @Override
    public void onFixCrossOrderCancelReplaceRequest( FixCrossOrderCancelReplaceRequest msg ) {}

    @Override
    public void onFixCrossOrderCancelRequest( FixCrossOrderCancelRequest msg ) {}

    @Override
    public void onFixSecurityTypeRequest( FixSecurityTypeRequest msg ) {}

    @Override
    public void onFixSecurityTypes( FixSecurityTypes msg ) {}

    @Override
    public void onFixSecurityListRequest( FixSecurityListRequest msg ) {}

    @Override
    public void onFixSecurityList( FixSecurityList msg ) {}

    @Override
    public void onFixDerivativeSecurityListRequest( FixDerivativeSecurityListRequest msg ) {}

    @Override
    public void onFixDerivativeSecurityList( FixDerivativeSecurityList msg ) {}

    @Override
    public void onFixNewOrderMultileg( FixNewOrderMultileg msg ) {}

    @Override
    public void onFixMultilegOrderCancelReplace( FixMultilegOrderCancelReplace msg ) {}

    @Override
    public void onFixTradeCaptureReportRequest( FixTradeCaptureReportRequest msg ) {}

    @Override
    public void onFixTradeCaptureReport( FixTradeCaptureReport msg ) {}

    @Override
    public void onFixOrderMassStatusRequest( FixOrderMassStatusRequest msg ) {}

    @Override
    public void onFixQuoteRequestReject( FixQuoteRequestReject msg ) {}

    @Override
    public void onFixRFQRequest( FixRFQRequest msg ) {}

    @Override
    public void onFixQuoteStatusReport( FixQuoteStatusReport msg ) {}

    @Override
    public void onFixQuoteResponse( FixQuoteResponse msg ) {}

    @Override
    public void onFixConfirmation( FixConfirmation msg ) {}

    @Override
    public void onFixPositionMaintenanceRequest( FixPositionMaintenanceRequest msg ) {}

    @Override
    public void onFixPositionMaintenanceReport( FixPositionMaintenanceReport msg ) {}

    @Override
    public void onFixRequestForPositions( FixRequestForPositions msg ) {}

    @Override
    public void onFixRequestForPositionsAck( FixRequestForPositionsAck msg ) {}

    @Override
    public void onFixPositionReport( FixPositionReport msg ) {}

    @Override
    public void onFixTradeCaptureReportRequestAck( FixTradeCaptureReportRequestAck msg ) {}

    @Override
    public void onFixTradeCaptureReportAck( FixTradeCaptureReportAck msg ) {}

    @Override
    public void onFixAllocationReport( FixAllocationReport msg ) {}

    @Override
    public void onFixAllocationReportAck( FixAllocationReportAck msg ) {}

    @Override
    public void onFixConfirmation_Ack( FixConfirmation_Ack msg ) {}

    @Override
    public void onFixSettlementInstructionRequest( FixSettlementInstructionRequest msg ) {}

    @Override
    public void onFixAssignmentReport( FixAssignmentReport msg ) {}

    @Override
    public void onFixCollateralRequest( FixCollateralRequest msg ) {}

    @Override
    public void onFixCollateralAssignment( FixCollateralAssignment msg ) {}

    @Override
    public void onFixCollateralResponse( FixCollateralResponse msg ) {}

    @Override
    public void onFixCollateralReport( FixCollateralReport msg ) {}

    @Override
    public void onFixCollateralInquiry( FixCollateralInquiry msg ) {}

    @Override
    public void onFixNetworkCounterpartySystemStatusRequest( FixNetworkCounterpartySystemStatusRequest msg ) {}

    @Override
    public void onFixNetworkCounterpartySystemStatusResponse( FixNetworkCounterpartySystemStatusResponse msg ) {}

    @Override
    public void onFixUserRequest( FixUserRequest msg ) {}

    @Override
    public void onFixUserResponse( FixUserResponse msg ) {}

    @Override
    public void onFixCollateralInquiryAck( FixCollateralInquiryAck msg ) {}

    @Override
    public void onFixConfirmationRequest( FixConfirmationRequest msg ) {}

    @Override
    public void onFixContraryIntentionReport( FixContraryIntentionReport msg ) {}

    @Override
    public void onFixSecurityDefinitionUpdateReport( FixSecurityDefinitionUpdateReport msg ) {}

    @Override
    public void onFixSecurityListUpdateReport( FixSecurityListUpdateReport msg ) {}

    @Override
    public void onFixAdjustedPositionReport( FixAdjustedPositionReport msg ) {}

    @Override
    public void onFixAllocationInstructionAlert( FixAllocationInstructionAlert msg ) {}

    @Override
    public void onFixExecutionAcknowledgement( FixExecutionAcknowledgement msg ) {}

    @Override
    public void onFixTradingSessionList( FixTradingSessionList msg ) {}

    @Override
    public void onFixTradingSessionListRequest( FixTradingSessionListRequest msg ) {}

    @Override
    public void onFixSettlementObligationReport( FixSettlementObligationReport msg ) {}

    @Override
    public void onFixDerivativeSecurityListUpdateReport( FixDerivativeSecurityListUpdateReport msg ) {}

    @Override
    public void onFixTradingSessionListUpdateReport( FixTradingSessionListUpdateReport msg ) {}

    @Override
    public void onFixMarketDefinitionRequest( FixMarketDefinitionRequest msg ) {}

    @Override
    public void onFixMarketDefinition( FixMarketDefinition msg ) {}

    @Override
    public void onFixMarketDefinitionUpdateReport( FixMarketDefinitionUpdateReport msg ) {}

    @Override
    public void onFixUserNotification( FixUserNotification msg ) {}

    @Override
    public void onFixOrderMassActionReport( FixOrderMassActionReport msg ) {}

    @Override
    public void onFixOrderMassActionRequest( FixOrderMassActionRequest msg ) {}

    @Override
    public void onFixApplicationMessageRequest( FixApplicationMessageRequest msg ) {}

    @Override
    public void onFixApplicationMessageRequestAck( FixApplicationMessageRequestAck msg ) {}

    @Override
    public void onFixApplicationMessageReport( FixApplicationMessageReport msg ) {}

    @Override
    public void onFixStreamAssignmentRequest( FixStreamAssignmentRequest msg ) {}

    @Override
    public void onFixStreamAssignmentReport( FixStreamAssignmentReport msg ) {}

    @Override
    public void onFixStreamAssignmentReportACK( FixStreamAssignmentReportACK msg ) {}

    @Override
    public void onFixPartyDetailsListRequest( FixPartyDetailsListRequest msg ) {}

    @Override
    public void onFixPartyDetailsListReport( FixPartyDetailsListReport msg ) {}

}
