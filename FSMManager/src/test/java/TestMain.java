import base.akka.media.AkkaMediaStateTest;
import base.basic.media.BasicMediaStateTest;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @class public class TestMain
 * @brief Test Main class
 */
public class TestMain {

    @BeforeClass
    public static void setUp () {

    }

    @Test
    public void TotalTest () {

        ////////////////////////////////////////////////////////////////////////////////
        // # basic

        //BasicCallStateTest amfCallStateTest = new BasicCallStateTest();


        //amfCallStateTest.testStart();

        BasicMediaStateTest amfMediaStateTest = new BasicMediaStateTest();
        amfMediaStateTest.testStart();

        //BasicCallAndMediaStateTest amfCallAndMediaStateTest = new BasicCallAndMediaStateTest();
        //amfCallAndMediaStateTest.testStart();

        ////////////////////////////////////////////////////////////////////////////////
        // # Squirrel FSM

/*        SquirrelCallStateFsmTest amfCallStateFsmTest = new SquirrelCallStateFsmTest();
        amfCallStateFsmTest.testStart();

        SquirrelMediaStateFsmTest amfMediaStateFsmTest = new SquirrelMediaStateFsmTest();
        amfMediaStateFsmTest.testStart();

        SquirrelCallAndMediaStateFsmTest amfCallAndMediaStateFsmTest = new SquirrelCallAndMediaStateFsmTest();
        amfCallAndMediaStateFsmTest.testStart();*/

        ////////////////////////////////////////////////////////////////////////////////
        // # Akka FSM

        AkkaMediaStateTest akkaMediaStateTest = new AkkaMediaStateTest();
        akkaMediaStateTest.testStart();
    }

}
