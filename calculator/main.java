package com.bit.simplecalculator;


import android.os.Bundle;

import android.view.View;

import android.widget.EditText;

import android.widget.TextView;

import android.widget.Toast;


import androidx.activity.EdgeToEdge;

import androidx.appcompat.app.AppCompatActivity;

import androidx.core.graphics.Insets;

import androidx.core.view.ViewCompat;

import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {


   EditText number1, number2;

   TextView res;

   char op;


   @Override

   protected void onCreate(Bundle savedInstanceState) {

       super.onCreate(savedInstanceState);

       EdgeToEdge.enable(this);

       setContentView(R.layout.activity_main);

       number1=findViewById(R.id.num1);

       number2=findViewById(R.id.num2);

       res=findViewById(R.id.result);


       ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {

           Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());

           v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

           return insets;

       });


   }


   public void one(View v){


       if(number1.hasFocus()){

           number1.append("1");

       }

       else if(number2.hasFocus()){

           number2.append("1");

       }

       else{

           Toast.makeText(this, "Please get the focus of First/second number field", Toast.LENGTH_LONG).show();

       }

   }

   public void two(View v){


       if(number1.hasFocus()){

           number1.append("2");

       }

       else if(number2.hasFocus()){

           number2.append("2");

       }

       else{

           Toast.makeText(this, "Please get the focus of First/second number field", Toast.LENGTH_LONG).show();

       }

   }


   public void three(View v){


       if(number1.hasFocus()){

           number1.append("3");

       }

       else if(number2.hasFocus()){

           number2.append("3");

       }

       else{

           Toast.makeText(this, "Please get the focus of First/second number field", Toast.LENGTH_LONG).show();

       }

   }


   public void four(View v){


       if(number1.hasFocus()){

           number1.append("4");

       }

       else if(number2.hasFocus()){

           number2.append("4");

       }

       else{

           Toast.makeText(this, "Please get the focus of First/second number field", Toast.LENGTH_LONG).show();

       }

   }


   public void five(View v){


       if(number1.hasFocus()){

           number1.append("5");

       }

       else if(number2.hasFocus()){

           number2.append("5");

       }

       else{

           Toast.makeText(this, "Please get the focus of First/second number field", Toast.LENGTH_LONG).show();

       }

   }

   public void six(View v){


       if(number1.hasFocus()){

           number1.append("6");

       }

       else if(number2.hasFocus()){

           number2.append("6");

       }

       else{

           Toast.makeText(this, "Please get the focus of First/second number field", Toast.LENGTH_LONG).show();

       }

   }


   public void seven(View v){


       if(number1.hasFocus()){

           number1.append("7");

       }

       else if(number2.hasFocus()){

           number2.append("7");

       }

       else{

           Toast.makeText(this, "Please get the focus of First/second number field", Toast.LENGTH_LONG).show();

       }

   }


   public void eight(View v){


       if(number1.hasFocus()){

           number1.append("8");

       }

       else if(number2.hasFocus()){

           number2.append("8");

       }

       else{

           Toast.makeText(this, "Please get the focus of First/second number field", Toast.LENGTH_LONG).show();

       }

   }

   public void nine(View v){


       if(number1.hasFocus()){

           number1.append("9");

       }

       else if(number2.hasFocus()){

           number2.append("9");

       }

       else{

           Toast.makeText(this, "Please get the focus of First/second number field", Toast.LENGTH_LONG).show();

       }

   }


   public void zero(View v){


       if(number1.hasFocus()){

           number1.append("0");

       }

       else if(number2.hasFocus()){

           number2.append("0");

       }

       else{

           Toast.makeText(this, "Please get the focus of First/second number field", Toast.LENGTH_LONG).show();

       }

   }



   public void divide(View v){

       op='/';

   }


   public void multiply(View v){

       op='*';

   }


   public void plus(View v){

       op='+';

   }


   public void minus(View v){

       op='-';

   }


   public void compute(View v){

       float n1, n2, r;

       switch (op){

           case '+':

               n1=Float.parseFloat(number1.getText().toString());

               n2=Float.parseFloat(number2.getText().toString());

               r=n1+n2;


               res.setText(n1+"+"+n2+"="+r);

               break;


           case '-':

               n1=Float.parseFloat(number1.getText().toString());

               n2=Float.parseFloat(number2.getText().toString());

               r=n1-n2;


               res.setText(n1+"-"+n2+"="+r);

               break;


           case '*':

               n1=Float.parseFloat(number1.getText().toString());

               n2=Float.parseFloat(number2.getText().toString());

               r=n1*n2;


               res.setText(n1+"*"+n2+"="+r);

               break;


           case '/':

               n1=Float.parseFloat(number1.getText().toString());

               n2=Float.parseFloat(number2.getText().toString());

               r=n1/n2;


               res.setText(n1+"/"+n2+"="+r);

               break;

       }

   }


   public void allClear(View v){


       number1.setText("");

       number2.setText("");

       res.setText("");

   }


   public void clearsField(View v){


       if(number1.hasFocus()){

           number1.setText("");

           res.setText("");

       } else if (number2.hasFocus()) {

           number2.setText("");

           res.setText("");

       }

       else {

           Toast.makeText(this, "Please click on Fields", Toast.LENGTH_LONG).show();

       }

   }


   public void clearsOneDigit(View v){


       String temp;

       if(number1.hasFocus()){

           temp=number1.getText().toString();

           temp=temp.substring(0,number1.length()-1);

           number1.setText(temp);



       } else if (number2.hasFocus()) {

           temp=number2.getText().toString();

           temp=temp.substring(0,number2.length()-1);

           number2.setText(temp);

       }

       else {

           Toast.makeText(this, "Please click on Fields", Toast.LENGTH_LONG).show();

       }

   }


   public void showToast(View v){

       Toast.makeText(this, "Please click on the Fields", Toast.LENGTH_SHORT).show();

       Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

   }



}

