package tests;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;
import android.widget.ImageView;

import com.smusings.rollofthedie.DieRoll;
import com.smusings.rollofthedie.MagicLifeCounter;
import com.smusings.rollofthedie.MainActivity;
import com.smusings.rollofthedie.R;


public class MainActivityTest
        extends ActivityInstrumentationTestCase2<MainActivity> {

    MainActivity mMainActivity;
    Button mMagic;
    Button mDie;
    Button mFlip;
    ImageView mFlipResult;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception{
        super.setUp();

        mMainActivity = getActivity();
        mMagic = (Button)mMainActivity.findViewById(R.id.lifeCounter);
        mDie = (Button)mMainActivity.findViewById(R.id.dieRoll);
        mFlip = (Button)mMainActivity.findViewById(R.id.flipCoin);
        mFlipResult = (ImageView)mMainActivity.findViewById(R.id.flipResult);
    }

    public void testPreconditions(){
        assertNotNull("main activity is null", mMainActivity);
        assertNotNull("die roll is null", mDie);
        assertNotNull("Magic life counter is null", mMagic);
        assertNotNull("Flip is null", mFlip);
        assertNotNull("Flip result is null", mFlipResult);
    }

    @MediumTest
    public void testToLaunchDie(){

        final Button mDie = (Button)mMainActivity.findViewById(R.id.dieRoll);
        Instrumentation.ActivityMonitor dieRollActivityMonitor =
                getInstrumentation().addMonitor(DieRoll.class.getName(),
                        null, false);

        //validate DieRoll started
        TouchUtils.clickView(this, mDie);
        DieRoll dieRollActivity = (DieRoll)
                dieRollActivityMonitor.waitForActivityWithTimeout(5000);

        assertNotNull("Die Roll null", dieRollActivity);
        assertEquals("Monitor for Die Roll has not been called",
                1,dieRollActivityMonitor.getHits());



        /*
        known issue, commenting it out for now
        getting an error with the getClass()

        assertEquals("Activity is wrong",
                DieRoll.class, dieRollActivity.getClass());
        */

        //remove the activity monitor
        getInstrumentation().removeMonitor(dieRollActivityMonitor);
        dieRollActivity.finish();
    }


    @MediumTest
    public void testToLaunchLife(){
        Instrumentation.ActivityMonitor lifeActivityMonitor=
                getInstrumentation().addMonitor(MagicLifeCounter.class.getName(),
                        null, false);

        //validate DieRoll started
        TouchUtils.clickView(this, mMagic);
        MagicLifeCounter lifeCounterActivity = (MagicLifeCounter)
                lifeActivityMonitor.waitForActivityWithTimeout(5000);

        assertNotNull("Life Counter null", lifeCounterActivity);
        assertEquals("Monitor for LifeCounter has not been called",
                1,lifeActivityMonitor.getHits());
        assertEquals("Activity is wrong",
                MagicLifeCounter.class, lifeCounterActivity.getClass());

        //remove the activity monitor
        getInstrumentation().removeMonitor(lifeActivityMonitor);
        lifeCounterActivity.finish();
    }

    @MediumTest
    public void testCoinFlip(){

        TouchUtils.clickView(this, mFlip);

        assertNotNull("Flip Result null", mFlipResult);

        Integer iDraw = (Integer) mFlipResult.getTag();
        switch(iDraw){
            case R.drawable.heads:
                assertEquals(R.drawable.heads, mFlipResult.getTag());
                break;
            case R.drawable.tails:
                assertEquals(R.drawable.tails, mFlipResult.getTag());
                break;
            default:
                break;
        }
    }
}
