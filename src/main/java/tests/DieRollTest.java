package tests;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.smusings.rollofthedie.DieRoll;
import com.smusings.rollofthedie.DieRollFragment;
import com.smusings.rollofthedie.RollListFragment;

public class DieRollTest
        extends ActivityInstrumentationTestCase2<DieRoll> {

    public DieRollTest() {
        super(DieRoll.class);
    }

    DieRoll mDieRoll;
    DieRollFragment mDieRollFrag;
    RollListFragment mRollListFrag;

    @Override
    protected void setUp() throws Exception{
        super.setUp();

        mDieRoll=getActivity();
        mDieRollFrag=getActivity().dieRollFragment;
        mRollListFrag=getActivity().rollListFragment;
    }

    public void testPreconditions(){
        assertNotNull("Activity is null", mDieRoll);
        assertNotNull("Buttons are null", mDieRollFrag);
        assertNotNull("List is null", mRollListFrag);
    }

    @MediumTest
    public void testButton4(){
        Button d4frag=mDieRollFrag.die4;
        ArrayAdapter<String> aafrag=mDieRoll.aa;
        String skree=mDieRoll.skr;


        TouchUtils.clickView(this, d4frag);
        assertEquals(skree, aafrag.getItem(0));
    }
}
