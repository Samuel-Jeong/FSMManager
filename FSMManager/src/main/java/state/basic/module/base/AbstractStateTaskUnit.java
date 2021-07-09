package state.basic.module.base;

/**
 * @author jamesj
 * @class public abstract class AbstractTaskUnit implements Runnable
 * @brief Task Unit Abstract Class
 */
public abstract class AbstractStateTaskUnit implements Runnable {

    private int delay;

    ////////////////////////////////////////////////////////////////////////////////

    protected AbstractStateTaskUnit(int delay) {
        this.delay = delay;
    }

    ////////////////////////////////////////////////////////////////////////////////

    public int getDelay( ) {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}
