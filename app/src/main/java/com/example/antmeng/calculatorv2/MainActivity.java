package com.example.antmeng.calculatorv2;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b, clear, igual;
    TextView tac, tres;
    String text = "", num1 = "", num2 = "";
    Double result = 0.0;
    int position = 0, acsin = 0, accos = 0, actan = 0, acpow = 0, acfac = 0,
        acsqr = 0, acmul = 0, acdiv = 0, acsum = 0, acres = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tac = (TextView)findViewById(R.id.tac);
        tres = (TextView)findViewById(R.id.tres);
        clear = (Button)findViewById(R.id.clear);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "";
                tac.setText("");
                acmul = 0;
                acdiv = 0;
                acsum = 0;
                acres = 0;
                acsin = 0;
                accos = 0;
                actan = 0;
                acpow = 0;
                acsqr = 0;
                acmul = 0;
                acdiv = 0;
                acsum = 0;
                acres = 0;
                acfac = 0;
            }
        });

    }
    public void click (View v) {
        b = (Button)v;
        switch (b.getText().toString()) {
            case "n":
                acfac += 1;
                break;
            case "^":
                acpow += 1;
                break;
            case "sin":
                acsin += 1;
                break;
            case "cos":
                accos += 1;
                break;
            case "tan":
                actan += 1;
                break;
            case "√":
                acsqr += 1;
                break;
            case "x":
                acmul += 1;
                break;
            case "/":
                acdiv += 1;
                break;
            case "-":
                acres += 1;
                break;
            case "+":
                acsum += 1;
                break;
        }
        if (b.getText().equals("=")) {
            oper(text);
            text = "";
            num1 = "";
            num2 = "";
        } else {
            text += b.getText().toString();
            tac.setText(text);
        }
    }

    int rot;
    char com;
    int pi, pf;
    public void oper (String text) {
        char operation[] = text.toCharArray();
        if (acpow > 0) {
            rot = acpow;
            com = '^';
        } else if (actan > 0) {
            rot = actan;
            com = 't';
        } else if (accos > 0) {
            rot = accos;
            com = 'c';
        } else if (acsin > 0) {
            rot = acsin;
            com = 's';
        } else if (acsqr > 0) {
            rot = acsqr;
            com = '√';
        } else if (acmul > 0) {
            rot = acmul;
            com = 'x';
        } else if (acres > 0 && operation[0] != '-') {
            rot = acres;
            com = '-';
        } else if (acsum > 0) {
            rot = acsum;
            com = '+';
        } else if (acdiv > 0) {
            rot = acdiv;
            com = '/';
        }
        for (int o = rot; o >= 0; o--) {
            for (int i = 0; i < operation.length; i++) {
                if (operation[i] == com) {
                    if (com == 'n') {
                        position = i + 1;
                        while (
                            position < operation.length &&
                            operation[position] != '+' &&
                            operation[position] != '-' &&
                            operation[position] != 'x' &&
                            operation[position] != '/' &&
                            operation[position] != '='
                        ) {
                            num1 += operation[position];
                            num2 = "fac";
                            pi = i;
                            pf = position;
                            position++;
                        }
                    } else if (com == '^') {
                        position = i - 1;
                        while (
                            position >= 0 &&
                            operation[position] != '+' &&
                            operation[position] != 'x' &&
                            operation[position] != '/' &&
                            operation[position] != '-' &&
                            operation[position] != '^'
                        ) {
                            num1 += operation[position];
                            pi = position;
                            position--;
                        }
                        num1 = new StringBuffer(num1).reverse().toString();
                        position = i + 1;
                        while (
                            position < operation.length &&
                            operation[position] != '+' &&
                            operation[position] != '-' &&
                            operation[position] != 'x' &&
                            operation[position] != '/' &&
                            operation[position] != '=' &&
                            operation[position] != '^'
                        ) {
                            num2 += operation[position];
                            pf = position;
                            position++;
                        }
                    } else if (com == 's' || com == 'c' || com == 't') {
                        position = i + 3;
                        while (
                            position < operation.length &&
                            operation[position] != '+' &&
                            operation[position] != '-' &&
                            operation[position] != 'x' &&
                            operation[position] != '/' &&
                            operation[position] != '='
                        ) {
                            num1 += operation[position];
                            num2 = "sin";
                            pi = i;
                            pf = position;
                            position++;
                        }
                    } else if (com == '√') {
                        position = i + 1;
                        while (
                            position < operation.length &&
                            operation[position] != '+' &&
                            operation[position] != '-' &&
                            operation[position] != 'x' &&
                            operation[position] != '/' &&
                            operation[position] != '='
                        ) {
                            num1 += operation[position];
                            num2 = "raiz";
                            pi = i;
                            pf = position;
                            position++;
                        }
                    } else {
                        position = i - 1;
                        while (
                            position >= 0 &&
                            operation[position] != '+' &&
                            operation[position] != '-' &&
                            operation[position] != 'x' &&
                            operation[position] != '/' &&
                            operation[position] != '='
                        ) {
                            num1 += operation[position];
                            if (position == 1 && operation[position-1] == '-') {
                                num1 += operation[position-1];
                            }
                            System.out.println(num1);
                            pi = position;
                            position--;
                        }
                        num1 = new StringBuffer(num1).reverse().toString();
                        position = i + 1;
                        while (
                            position < operation.length &&
                            operation[position] != '+' &&
                            operation[position] != '-' &&
                            operation[position] != 'x' &&
                            operation[position] != '/' &&
                            operation[position] != '='
                        ) {
                            num2 += operation[position];
                            pf = position;
                            position++;
                        }
                    }
                    if (num1.equals("") || num2.equals("")) {

                    } else {
                        if (com == '^') {
                            result = Math.pow(Double.parseDouble(num1), Double.parseDouble(num2));
                            acpow--;
                        } else if (com == 'n') {
                            int valorCalcular=0;
                            while(valorCalcular<1) {
                                try {
                                    valorCalcular=Integer.parseInt(num1);
                                    if(valorCalcular<1)
                                        valorCalcular = 1;
                                        System.out.println("El valor tiene que ser superior a 0");
                                }catch(NumberFormatException e) {
                                    System.out.println("El valor tiene que ser numerico...");
                                }
                            }

                            result = 1.0;
                            for(int n=valorCalcular;n>0;n--) {
                                result=result*n;
                            }
                            acfac--;
                        } else if (com == 't') {
                            result = Math.tan(Double.parseDouble(num1));
                            actan--;
                        } else if (com == 'c') {
                            result = Math.cos(Double.parseDouble(num1));
                            accos--;
                        } else if (com == 's') {
                            result = Math.sin(Double.parseDouble(num1));
                            acsin--;
                        } else if (com == '√') {
                            result = Math.sqrt(Double.parseDouble(num1));
                            acsqr--;
                        } else if (com == 'x') {
                            result = Double.parseDouble(num1) * Double.parseDouble(num2);
                            acmul--;
                        } else if (com == '/') {
                            result = Double.parseDouble(num1) / Double.parseDouble(num2);
                            acdiv--;
                        } else if (com == '-') {
                            result = Double.parseDouble(num1) - Double.parseDouble(num2);
                            acres--;
                        } else if (com == '+') {
                            System.out.println(num1 + " seg " + num2);
                            result = Double.parseDouble(num1) + Double.parseDouble(num2);
                            acsum--;
                        }
                        text = "";
                        for (int j = 0; j < operation.length; j++) {
                            if (pi == j) {
                                text += "" + result;
                                j = pf;
                            } else {
                                text += operation[j];
                            }

                            System.out.println(text);
                        }
                        num1 = "";
                        num2 = "";
                        i = operation.length;
                        operation = text.toCharArray();
                    }
                }
            }
            if (acfac > 0) {
                o = acfac;
                com = 'n';
            } else if (acpow > 0) {
                o = acpow;
                com = '^';
            } else if (actan > 0) {
                o = actan;
                com = 't';
            } else if (accos > 0) {
                o = accos;
                com = 'c';
            } else if (acsin > 0) {
                o = acsin;
                com = 's';
            } else if (acsqr > 0) {
                o = acsqr;
                com = '√';
            } else if (acmul > 0) {
                o = acmul;
                com = 'x';
            } else if (acdiv > 0) {
                o = acdiv;
                com = '/';
            } else if (acres > 0) {
                o = acres;
                com = '-';
            } else if (acsum > 0) {
                o = acsum;
                com = '+';
            }
        }
        //tres.setText("= " + result + " pi:" + pi + " " + pf);
        tres.setText("= " + text);
        acsin = 0;
        accos = 0;
        actan = 0;
        acpow = 0;
        acsqr = 0;
        acmul = 0;
        acdiv = 0;
        acsum = 0;
        acres = 0;
        int acum = 0;
    }
}
