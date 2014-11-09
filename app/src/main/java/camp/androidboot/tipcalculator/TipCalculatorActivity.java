package camp.androidboot.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 *
 */
public class TipCalculatorActivity extends Activity {

  private static final double TIP1_PERCENTAGE = 0.15;
  private static final double TIP2_PERCENTAGE = 0.20;
  private static final double TIP3_PERCENTAGE = 0.25;

  private EditText billAmountField;
  private Button tip1Button;
  private Button tip2Button;
  private Button tip3Button;
  private TextView tipAmountUi;
  private TextView totalAmountUi;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_tip_calculator);

    findViews();
    wireButtons();
  }

  /**
   *
   */
  private void findViews() {
    billAmountField = (EditText) findViewById(R.id.bill_amount);
    tip1Button = (Button) findViewById(R.id.tip1_button);
    tip2Button = (Button) findViewById(R.id.tip2_button);
    tip3Button = (Button) findViewById(R.id.tip3_button);
    tipAmountUi = (TextView) findViewById(R.id.tip_amount);
    totalAmountUi = (TextView) findViewById(R.id.total_amount);
  }

  /**
   *
   */
  private void wireButtons() {
    tip1Button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        calculateAndUpdateUi(TIP1_PERCENTAGE);
      }
    });
    tip2Button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        calculateAndUpdateUi(TIP2_PERCENTAGE);
      }
    });
    tip3Button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        calculateAndUpdateUi(TIP3_PERCENTAGE);
      }
    });
  }

  /**
   *
   * @param tipPercentage
   */
  private void calculateAndUpdateUi(double tipPercentage) {
    double billAmount = getBillAmountFromField();
    double tipAmount = calculateTipAmount(billAmount, tipPercentage);
    double totalAmount = billAmount + tipAmount;

    updateUiWithAmounts(tipAmount, totalAmount);
  }

  /**
   *
   * @return
   */
  private double getBillAmountFromField() {
    try {
      return Double.parseDouble(billAmountField.getText().toString());
    } catch (NumberFormatException e) {
      return 0;
    }
  }

  /**
   *
   *
   * @param billAmount
   * @param tipPercentage
   * @return
   */
  private double calculateTipAmount(double billAmount, double tipPercentage) {
    return billAmount * tipPercentage;
  }

  /**
   *
   * @param tipAmount
   * @param totalAmount
   */
  private void updateUiWithAmounts(double tipAmount, double totalAmount) {
    tipAmountUi.setText(getString(R.string.amount_format, tipAmount));
    totalAmountUi.setText(getString(R.string.amount_format, totalAmount));
  }
}
