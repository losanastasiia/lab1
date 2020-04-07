package example.my.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text = findViewById(R.id.textView4);   //find the textView element where we will show the result
        EditText edittext1 =findViewById(R.id.editText);    //find the first EditTex element
        EditText edittext2 =findViewById(R.id.editText2);   //find the second EditTex element

        Button multiplyButton = findViewById(R.id.button);
        multiplyButton.setOnClickListener(v -> {    //set event for button of multiplication
            if(checkNumb(edittext1, edittext2)){    //check that editText is not empty
                int num1 = Integer.parseInt(edittext1.getText().toString());    //get integer first number from editText1
                int num2 = Integer.parseInt(edittext2.getText().toString());    //get integer second number from editText2
                int result=num1*num2;   //multiply numbers
                text.setText(""+result);    //display result to the textView
            }
        });

        Button divideButton = findViewById(R.id.button2);
        divideButton.setOnClickListener(l -> {  //set event for button of division
            if(checkNumb(edittext1, edittext2)) {   //check that editText is not empty
                int num1 = Integer.parseInt(edittext1.getText().toString());    //get number 1 from editText1
                int num2 = Integer.parseInt(edittext2.getText().toString());    //get number 2 from editText2
                if(num2==0){       //check if num2 is  0. If num2 is  0, show error, else calculate the result and show it
                    text.setText("Error!");  //display error to the textView
                }
                else{
                    double result = num1/ 1.0 / num2; //divide numbers
                    //text.setText("" + result);
                    text.setText(new DecimalFormat("##.##").format(result));  ////display result to the textView in format ##.##
                }
            }
        });

        Button addButton = findViewById(R.id.button3);
        addButton.setOnClickListener(f -> { //set event for button of addition
            if(checkNumb(edittext1, edittext2)) {   //check that editText is not empty
                int num1 = Integer.parseInt(edittext1.getText().toString());    //get number 1 from editText1
                int num2 = Integer.parseInt(edittext2.getText().toString());    //get number 2 from editText2
                int result = num1 + num2; //add numbers
                text.setText("" + result);  //display result to the textView
            }
        });

        Button subtractButton = findViewById(R.id.button4);
        subtractButton.setOnClickListener(u -> {    //set event for button of subtraction
            if(checkNumb(edittext1, edittext2)) {   //check that editText is not empty
                int num1 = Integer.parseInt(edittext1.getText().toString());    //get number 1 from editText1
                int num2 = Integer.parseInt(edittext2.getText().toString());    //get number 2 from editText2
                int result = num1 - num2;  //subtract numbers
                text.setText("" + result);  //display result to the textView
            }
        });
    }

    /* function for checking if the EditText elements empty
        return false if one of them or both are empty, true if both aren't empty
     */
    public boolean checkNumb(EditText editText1, EditText editText2){
        String str1=editText1.getText().toString();
        String str2=editText2.getText().toString();
        if(TextUtils.isEmpty(str1) || TextUtils.isEmpty(str2)){
            return false;
        }
        else return true;
    }
}
