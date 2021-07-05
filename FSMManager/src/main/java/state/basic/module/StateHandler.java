package state.basic.module;

import state.basic.event.StateEventManager;
import state.basic.event.base.CallBack;
import state.basic.event.base.StateEvent;
import state.basic.unit.StateUnit;

import java.util.List;

/**
 * @class public class StateHandler
 * @brief StateHandler class
 */
public class StateHandler {


    // StateEventManager
    private final StateEventManager stateEventManager;

    // StateHandler 이름
    private final String name;

    /**
     * @fn public StateHandler(String name)
     * @brief StateHandler 생성자 함수
     * @param name StateHandler 이름
     */
    public StateHandler(String name) {
        this.name = name;

        stateEventManager = new StateEventManager();
    }

    /**
     * @fn public boolean addState (String event, String fromState, String toState, String failState, CallBack callBack)
     * @brief 새로운 State 를 추가하는 함수
     * fromState 가 toState 로 천이되기 위한 trigger 이벤트와 천이 후에 실행될 CallBack 을 정의한다.
     *
     * 1) 천이 성공 시 CallBack 실행 (CallBack)
     * 2) 천이 실패 시 timeout 후 event 실행 (TaskUnit 필요)
     *
     * @param event Trigger 될 이벤트 이름
     * @param fromState 천이 전 State 이름
     * @param toState 천이 후 State 이름
     * @param callBack 천이 성공 후 실행될 CallBack
     * @param failEvent 천이 실패 후 실행될 이벤트 이름
     * @param delay 천이 실패 후 실행될 이벤트가 실행되기 위한 Timeout 시간
     * @param params 실패 후 실행될 이벤트의 CallBack 의 매개변수
     * @return 성공 시 true, 실패 시 false 반환
     */
    public boolean addState (String event, String fromState, String toState, CallBack callBack, String failEvent, int delay, Object... params) {
        return stateEventManager.addEvent(event, fromState, toState, callBack, failEvent, delay, params);
    }

    public void clearStateEventManager() {
        stateEventManager.removeAllEvents();
    }

    /**
     * @fn public String getName()
     * @brief StateHandler 이름을 반환하는 함수
     * @return StateHandler 이름
     */
    public String getName() {
        return name;
    }

    /**
     * @fn public boolean removeEvent(String fromState)
     * @brief Event 를 삭제하는 함수
     * @param event 이벤트 이름
     * @return 성공 시 true, 실패 시 false 반환
     */
    public boolean removeEvent (String event) {
        return stateEventManager.removeEvent(event);
    }

    /**
     * @fn public List<String> getEventList ()
     * @brief StateEventManager 에 정의된 모든 이벤트들을 새로운 리스트에 저장하여 반환하는 함수
     * @return 성공 시 정의된 이벤트 리스트, 실패 시 null 반환
     */
    public List<String> getEventList () {
        return stateEventManager.getAllEvents();
    }

    public int getTotalEventSize () {
        return stateEventManager.getAllEvents().size();
    }

    /**
     * @fn public String fire (String event, StateUnit stateUnit)
     * @brief 정의된 State 천이를 위해 지정한 이벤트를 발생시키는 함수
     * @param event 발생할 이벤트 이름
     * @param stateUnit State unit
     * @return 성공 시 지정한 결과값 반환, 실패 시 failState 반환
     */
    public String fire (String event, StateUnit stateUnit) {
        return stateEventManager.nextState(this, event, stateUnit, (Object) null);
    }

    /**
     * @fn public String fire (String event, StateUnit stateUnit, Object... params)
     * @brief 정의된 State 천이를 위해 지정한 이벤트를 발생시키는 함수
     * @param event 발생할 이벤트 이름
     * @param stateUnit State unit
     * @param params CallBack 가변 매개변수
     * @return 성공 시 지정한 결과값 반환, 실패 시 failState 반환
     */
    public String fire (String event, StateUnit stateUnit, Object... params) {
        return stateEventManager.nextState(this, event, stateUnit, params);
    }

    /**
     * @fn public StateEvent findToStateFromEvent(String event)
     * @brief 지정한 이벤트에 등록된 StateEvent 을 찾아서 반환하는 함수
     * @param event 이벤트 이름
     * @return 성공 시 StateEvent, 실패 시 null 반환
     */
    public StateEvent findStateEventFromEvent(String event) {
        return stateEventManager.getStateEventByEvent(event);
    }

}
