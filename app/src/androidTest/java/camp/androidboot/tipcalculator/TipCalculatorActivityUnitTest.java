package camp.androidboot.tipcalculator; 
 
 /*
  * Copyright Hooky, Inc.
  * Developer: tom
  * Date: 11/8/14
  * Time: 6:41 PM
  */

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivityUnitTest extends ActivityUnitTestCase<TipCalculatorActivity> {

  private TipCalculatorActivity activity;

  public TipCalculatorActivityUnitTest() {
    super(TipCalculatorActivity.class);
  }

  @Override
  public void setUp() throws Exception {
    super.setUp();

    Intent intent = new Intent(getInstrumentation().getTargetContext(), TipCalculatorActivity.class);
    startActivity(intent, null, null);
    activity = getActivity();
  }

  public void testBillAmountField_shouldBeEnabledFocusedAndHaveCorrectInputTypeAndHint() throws Exception {
    EditText billAmountField = (EditText) activity.findViewById(R.id.bill_amount);

    assertNotNull(billAmountField);
    assertTrue(billAmountField.isEnabled());
    assertTrue(billAmountField.isFocused());
    assertEquals(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL,
        billAmountField.getInputType());
    assertEquals(activity.getString(R.string.bill_amount_hint), billAmountField.getHint());
  }

  public void testTipButtons_shouldBeEnabledAndHaveCorrectText() throws Exception {
    Button tip1Button = (Button) activity.findViewById(R.id.tip1_button);
    Button tip2Button = (Button) activity.findViewById(R.id.tip2_button);
    Button tip3Button = (Button) activity.findViewById(R.id.tip3_button);

    assertNotNull(tip1Button);
    assertTrue(tip1Button.isEnabled());
    assertEquals("15%", tip1Button.getText());

    assertNotNull(tip2Button);
    assertTrue(tip2Button.isEnabled());
    assertEquals("20%", tip2Button.getText());

    assertNotNull(tip3Button);
    assertTrue(tip3Button.isEnabled());
    assertEquals("25%", tip3Button.getText());
  }

  public void testTipAmountUi_shouldHaveCorrectDefaultText() throws Exception {
    TextView tipAmountUi = (TextView) activity.findViewById(R.id.tip_amount);

    assertNotNull(tipAmountUi);
    assertEquals("$0.00", tipAmountUi.getText());
  }

  public void testTotalAmountUi_shouldHaveCorrectDefaultText() throws Exception {
    TextView totalAmountUi = (TextView) activity.findViewById(R.id.total_amount);

    assertNotNull(totalAmountUi);
    assertEquals("$0.00", totalAmountUi.getText());
  }
}
