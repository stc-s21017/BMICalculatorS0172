package jp.suntech.s21017.bmicalculators017;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btcalcu = findViewById(R.id.bt_calcu);
        CheckListener listener = new CheckListener();
        btcalcu.setOnClickListener(listener);

        Button btclear = findViewById(R.id.bt_clear);
        btclear.setOnClickListener(listener);

    }

    private class CheckListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            EditText high = findViewById(R.id.edhigh);
            EditText weight = findViewById(R.id.edweight);
            EditText old = findViewById(R.id.edold);
            TextView reBMI = findViewById(R.id.return_BMI);
            TextView reWEIGHT = findViewById(R.id.return_weight);
            TextView tv_1 = findViewById(R.id.text_1);
            TextView tv_2 = findViewById(R.id.text_2);
            TextView tv_3 = findViewById(R.id.textview3);


            String highstr = high.getText().toString();
            String weightstr = weight.getText().toString();
            String oldstr = old.getText().toString();

            Float highfoat;
            Float weightfloat;
            Float oldfloat ;

            int id = view.getId();

            switch (id) {
                case R.id.bt_calcu:



                    if (TextUtils.isEmpty(highstr)||TextUtils.isEmpty(weightstr)||TextUtils.isEmpty(oldstr)) {

                        Toast.makeText(MainActivity.this, "すべての値を入力してください", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    else {

                        highfoat = Float.parseFloat(highstr);
                        weightfloat = Float.parseFloat(weightstr);
                        oldfloat = Float.parseFloat(oldstr);
                        }
                        tv_1.setText(R.string.tv1);
                        tv_2.setText(R.string.tv2);
                        tv_3.setText(R.string.KG);
                        Float BMI;
                        Double gweight;
                        int BMIround;


                        if (oldfloat < 6) {
                            BMI = (weightfloat / (highfoat * highfoat / 10000));
                            DialogMaker dialogflagment = new DialogMaker();
                            dialogflagment.show(getSupportFragmentManager(), "DialogMaker");

                            if (oldfloat <= 1) {
                                if (BMI < 15.5) {
                                    reBMI.setText("低体重");
                                    reBMI.setTextColor(Color.parseColor("#191970"));
                                } else if (17.5 <= BMI) {
                                    reBMI.setText("太り気味");
                                    reBMI.setTextColor(Color.parseColor("#ff0000"));
                                } else {
                                    reBMI.setText("普通体重");
                                    reBMI.setTextColor(Color.parseColor("#008000"));
                                }
                                gweight = (highfoat * highfoat / 10000) * 16.5;
                                reWEIGHT.setText(String.format("%.1f", gweight));
                            }

                            if (1 < oldfloat && oldfloat <= 2) {
                                if (BMI < 15.0) {
                                    reBMI.setText("低体重");
                                    reBMI.setTextColor(Color.parseColor("#191970"));
                                } else if (17.0 <= BMI) {
                                    reBMI.setText("太り気味");
                                    reBMI.setTextColor(Color.parseColor("#ff0000"));
                                } else {
                                    reBMI.setText("普通体重");
                                    reBMI.setTextColor(Color.parseColor("#008000"));
                                }
                                gweight = (highfoat * highfoat / 10000) * 16.0;
                                reWEIGHT.setText(String.format("%.1f", gweight));
                            }

                            if (2 < oldfloat) {
                                if (BMI < 14.5) {
                                    reBMI.setText("低体重");
                                    reBMI.setTextColor(Color.parseColor("#191970"));
                                } else if (16.5 <= BMI) {
                                    reBMI.setText("太り気味");
                                    reBMI.setTextColor(Color.parseColor("#ff0000"));
                                } else {
                                    reBMI.setText("普通体重");
                                    reBMI.setTextColor(Color.parseColor("#008000"));
                                }
                                gweight = (highfoat * highfoat / 10000) * 15.5;
                                reWEIGHT.setText(String.format("%.1f", gweight));
                            }

                        } else if (6 <= oldfloat && oldfloat < 16) {
                            BMI = weightfloat / (highfoat * highfoat * highfoat) * 10000000;
                            BMIround = Math.round(BMI * 10) / 10;

                            DialogMaker dialogflagment = new DialogMaker();
                            dialogflagment.show(getSupportFragmentManager(), "DialogMaker");


                            if (BMIround < 100) {
                                reBMI.setText("やせすぎ");
                                reBMI.setTextColor(Color.parseColor("#191970"));
                            } else if ((100 <= BMIround) && (BMIround < 115)) {
                                reBMI.setText("やせ気味");
                                reBMI.setTextColor(Color.parseColor("#0000ff"));
                            } else if ((115 <= BMIround) && (BMIround < 145)) {
                                reBMI.setText("標準体重");
                                reBMI.setTextColor(Color.parseColor("#008000"));
                            } else if ((145 <= BMIround) && (BMIround < 160)) {

                                reBMI.setText("太り気味");
                                reBMI.setTextColor(Color.parseColor("#ffd700"));

                            } else {
                                reBMI.setText("太りすぎ");
                                reBMI.setTextColor(Color.parseColor("#ff0000"));
                            }

                            gweight = (double) ((highfoat * highfoat * highfoat) / 10000000 * 130);
                            reWEIGHT.setText(String.format("%.1f", gweight));
                        } else {
                            BMI = (weightfloat / (highfoat * highfoat / 10000));
                            gweight = (highfoat * highfoat / 10000) * 22.0;

                            if (BMI < 18.5) {
                                reBMI.setText("低体重");
                                reBMI.setTextColor(Color.parseColor("#191970"));
                            } else if (18.5 <= BMI && BMI < 25.0) {
                                reBMI.setText("普通体重");
                                reBMI.setTextColor(Color.parseColor("#008000"));
                            } else if (25.0 <= BMI && BMI < 30.0) {
                                reBMI.setText("肥満(1度)");
                                reBMI.setTextColor(Color.parseColor("#ffff00"));
                            } else if (30.0 <= BMI && BMI < 35.0) {
                                reBMI.setText("肥満(2度)");
                                reBMI.setTextColor(Color.parseColor("#ffd700"));
                            } else if (35.0 <= BMI && BMI < 40.0) {
                                reBMI.setText("肥満(3度)");
                                reBMI.setTextColor(Color.parseColor("#ffa500"));
                            } else {
                                reBMI.setText("肥満(4度)");
                                reBMI.setTextColor(Color.parseColor("#ff0000"));
                            }
                            reWEIGHT.setText(String.format("%.1f", gweight));

                        }

                        break;



                case R.id.bt_clear:
                    high.setText("");
                    weight.setText("");
                    old.setText("");
                    reBMI.setText("");
                    reWEIGHT.setText("");
                    tv_1.setText("");
                    tv_2.setText("");
                    tv_3.setText("");
                    break;
            }


        }
     }
    }
