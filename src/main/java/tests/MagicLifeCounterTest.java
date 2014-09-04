package tests;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;
import android.widget.TextView;

import com.smusings.rollofthedie.MagicLifeCounter;
import com.smusings.rollofthedie.Player1LifeCounterFragment;
import com.smusings.rollofthedie.Player2LifeCounterFragment;
import com.smusings.rollofthedie.R;

public class MagicLifeCounterTest
        extends ActivityInstrumentationTestCase2<MagicLifeCounter> {

    public MagicLifeCounterTest() {
        super(MagicLifeCounter.class);
    }

    MagicLifeCounter mMagicLC;
    Player1LifeCounterFragment mP1LifeCounter;
    Player2LifeCounterFragment mP2LifeCounter;

    @Override
    protected void setUp() throws Exception{
        super.setUp();
        setActivityInitialTouchMode(true);

        mMagicLC = getActivity();
        mP1LifeCounter = mMagicLC.player1LC;
        mP2LifeCounter = mMagicLC.player2LC;
    }

    public void testPreconditions(){
        assertNotNull("Activity is null", mMagicLC);
        assertNotNull("Player 1 is null", mP1LifeCounter);
        assertNotNull("Player 2 is null", mP2LifeCounter);
    }

    @MediumTest
    public void testPlusOne_PlayerOne(){
        TextView tv1 = mP1LifeCounter.playerhealth;
        Button add1p1 = mP1LifeCounter.p1plus1;

        int p1health = Integer.valueOf(tv1.getText().toString());
        int health = p1health + 1;
        String str = Integer.toString(health);

        TouchUtils.clickView(this, add1p1);
        assertEquals(str, tv1.getText());
    }

    @MediumTest
    public void testPlusOne_PlayerTwo(){
        TextView tv2 = mP2LifeCounter.playerhealth;
        Button add1p2 = mP2LifeCounter.p2plus1;

        int p1health = Integer.valueOf(tv2.getText().toString());
        int health = p1health + 1;
        String str = Integer.toString(health);

        TouchUtils.clickView(this, add1p2);
        assertEquals(str,tv2.getText());
    }
=
    @MediumTest
    public void testMenuReset(){

        TextView tv1 = mP1LifeCounter.playerhealth;
        TextView tv2 = mP2LifeCounter.playerhealth;

        getInstrumentation().invokeMenuActionSync(mMagicLC, R.id.menu_clear, 0);
        assertEquals("20", tv1.getText().toString());
        assertEquals("20", tv2.getText().toString());
    }
}
