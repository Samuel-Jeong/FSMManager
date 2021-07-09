package base.basic.call.base.condition;

import state.basic.event.base.StateEvent;
import state.basic.module.base.EventCondition;

/**
 * @class public class InactiveStopEventCondition extends EventCondition
 * @brief InactiveStopEventCondition class
 */
public class InactiveStopEventCondition extends EventCondition {

    public InactiveStopEventCondition(StateEvent stateEvent) {
        super(stateEvent);
    }

    @Override
    public boolean checkCondition () {
        return true;
    }

}