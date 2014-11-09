package camp.androidboot.tipcalculator;

import android.test.ActivityInstrumentationTestCase2;

public class TipCalculatorActivityInstrumentationTest
    extends ActivityInstrumentationTestCase2<TipCalculatorActivity> {

  private TipCalculatorActivity activity;

  public TipCalculatorActivityInstrumentationTest() {
    super(TipCalculatorActivity.class);
  }

  @Override
  public void setUp() throws Exception {
    super.setUp();

    activity = getActivity();
  }
}
