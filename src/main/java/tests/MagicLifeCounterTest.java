package tests;

import android.test.ActivityInstrumentationTestCase2;

import com.smusings.rollofthedie.MagicLifeCounter;
import com.smusings.rollofthedie.Player1LifeCounterFragment;
import com.smusings.rollofthedie.Player2LifeCounterFragment;

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

        mMagicLC=getActivity();
        mP1LifeCounter=mMagicLC.player1LC;
        mP2LifeCounter=mMagicLC.player2LC;
    }

    public void testPreconditions(){
        assertNotNull("Activity is null", mMagicLC);
        assertNotNull("Player 1 is null", mP1LifeCounter);
        assertNotNull("Player 2 is null", mP2LifeCounter);
    }
}
