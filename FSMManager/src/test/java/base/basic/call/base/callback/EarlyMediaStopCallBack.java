package base.basic.call.base.callback;

import base.basic.call.base.CallInfo;
import base.basic.media.base.MediaEvent;
import base.basic.media.base.MediaState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import state.StateManager;
import state.basic.state.CallBack;
import state.basic.state.StateHandler;

/**
 * @class public class EarlyMediaStopCallBack extends CallBack
 * @brief EarlyMediaStopCallBack class
 */
public class EarlyMediaStopCallBack extends CallBack {

    private static final Logger logger = LoggerFactory.getLogger(EarlyMediaStopCallBack.class);

    public EarlyMediaStopCallBack(String name) {
        super(name);
    }

    @Override
    public Object callBackFunc(Object... object) {
        if (object.length == 0) {
            return null;
        }

        CallInfo callInfo = (CallInfo) object[0];
        if (callInfo == null) { return null; }

        StateManager stateManager = StateManager.getInstance();
        StateHandler mediaStateHandler = stateManager.getStateHandler(MediaState.MEDIA_STATE_NAME);
        if (mediaStateHandler == null) { return null; }

        logger.debug("EarlyMediaStopCallBack: callId={}, fromNo={}, toNo={}, mediaStateUnitName={}", callInfo.getCallId(), callInfo.getFromNo(), callInfo.getToNo(), callInfo.getMediaStateUnitName());

        return mediaStateHandler.fire(
                MediaEvent.MEDIA_STOP_EVENT,
                StateManager.getInstance().getStateUnit(callInfo.getMediaStateUnitName()),
                MediaState.ACTIVE_STATE,
                MediaState.IDLE_REQUEST
        );
    }

}