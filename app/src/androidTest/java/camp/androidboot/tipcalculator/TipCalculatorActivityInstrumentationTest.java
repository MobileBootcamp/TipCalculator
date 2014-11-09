package camp.androidboot.tipcalculator;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivityInstrumentationTest
    extends ActivityInstrumentationTestCase2<TipCalculatorActivity> {

  private static final double TIP1 = 0.15;
  private static final double TIP2 = 0.20;
  private static final double TIP3 = 0.25;

  private TipCalculatorActivity activity;

  private EditText billAmountField;
  private Button tip1Button;
  private Button tip2Button;
  private Button tip3Button;
  private TextView tipAmountUi;
  private TextView totalAmountUi;

  public TipCalculatorActivityInstrumentationTest() {
    super(TipCalculatorActivity.class);
  }

  @Override
  public void setUp() throws Exception {
    super.setUp();

    activity = getActivity();
    billAmountField = (EditText) activity.findViewById(R.id.bill_amount);
    tip1Button = (Button) activity.findViewById(R.id.tip1_button);
    tip2Button = (Button) activity.findViewById(R.id.tip2_button);
    tip3Button = (Button) activity.findViewById(R.id.tip3_button);
    tipAmountUi = (TextView) activity.findViewById(R.id.tip_amount);
    totalAmountUi = (TextView) activity.findViewById(R.id.total_amount);
  }

  public void testTipAndTotalCalculation() throws Exception {
    double[] billAmounts = new double[] { 0, 0.99, 5.33, 10.75, 50, 98.99, 125, 1059.33 };

    for (final double billAmount : billAmounts) {
      String expectedTip1 = activity.getString(R.string.amount_format, billAmount * TIP1);
      String expectedTip2 = activity.getString(R.string.amount_format, billAmount * TIP2);
      String expectedTip3 = activity.getString(R.string.amount_format, billAmount * TIP3);
      String expectedTotal1 = activity.getString(R.string.amount_format, billAmount * TIP1 + billAmount);
      String expectedTotal2 = activity.getString(R.string.amount_format, billAmount * TIP2 + billAmount);
      String expectedTotal3 = activity.getString(R.string.amount_format, billAmount * TIP3 + billAmount);

      activity.runOnUiThread(new Runnable() {
        @Override
        public void run() {
          billAmountField.setText(String.valueOf(billAmount));
        }
      });

      TouchUtils.clickView(this, tip1Button);
      assertEquals(expectedTip1, tipAmountUi.getText().toString());
      assertEquals(expectedTotal1, totalAmountUi.getText().toString());

      TouchUtils.clickView(this, tip2Button);
      assertEquals(expectedTip2, tipAmountUi.getText().toString());
      assertEquals(expectedTotal2, totalAmountUi.getText().toString());

      TouchUtils.clickView(this, tip3Button);
      assertEquals(expectedTip3, tipAmountUi.getText().toString());
      assertEquals(expectedTotal3, totalAmountUi.getText().toString());
    }
  }
}
