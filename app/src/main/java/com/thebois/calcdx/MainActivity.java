package com.thebois.calcdx;

import android.app.Fragment;
import android.bluetooth.BluetoothClass;
import android.content.res.Configuration;
import android.media.Image;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.TextView;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends FragmentActivity {


    private static final String ID = "CalcDX2";
    private static final String STRINGIDO = "OStringId";
    private static final String STRINGIDR = "RStringId";

    // store the expressions
    private ArrayList<String> outFunction;
    private ArrayList<String> realFunction;

    // buttons
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;
    private Button b0;
    private Button decimal;
    private Button devide;
    private Button enter;
    private Button add;
    private Button multiply;
    private ImageButton backspace;
    private Button subtract;
    private Button openP;
    private Button closeP;
    private Button bXtoN1;
    private Button sin;
    private Button cos;
    private Button tan;
    private Button factorial;
    private Button sqrt;
    private Button log;
    private Button e;
    private Button pi;
    private Button square;
    private Button pow;
    private Button E;
    private Button second;
    private Boolean isRadian;
    private TextView output;
    private Button mod;
    private Button Radian;
    private boolean isSecond;
    private boolean newP = true;
    private double currentMemory;


//make it impossible for syntax error

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outFunction = new ArrayList<>();
        realFunction = new ArrayList<>();
        isSecond = true;

        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);
        b8 = (Button) findViewById(R.id.b8);
        b9 = (Button) findViewById(R.id.b9);
        b0 = (Button) findViewById(R.id.b0);
        second = (Button) findViewById(R.id.second);
        bXtoN1 = (Button) findViewById(R.id.bXtoN1);
        sin = (Button) findViewById(R.id.sin);
        mod = (Button) findViewById(R.id.mod);
        Radian = (Button) findViewById(R.id.radian);
        cos = (Button) findViewById(R.id.cos);
        tan = (Button) findViewById(R.id.tan);
        log = (Button) findViewById(R.id.log);
        square = (Button) findViewById(R.id.square);
        sqrt = (Button) findViewById(R.id.sqrt);
        pi = (Button) findViewById(R.id.pi);
        e = (Button) findViewById(R.id.e);
        pow = (Button) findViewById(R.id.pow);
        factorial = (Button) findViewById(R.id.factorial);
        E = (Button) findViewById(R.id.E);


        openP = (Button) findViewById(R.id.openP);
        closeP = (Button) findViewById(R.id.closeP);
        decimal = (Button) findViewById(R.id.decimal);
        devide = (Button) findViewById(R.id.devide);
        enter = (Button) findViewById(R.id.enter);
        add = (Button) findViewById(R.id.add);
        multiply = (Button) findViewById(R.id.multiply);
        backspace = (ImageButton) findViewById(R.id.backspace);
        subtract = (Button) findViewById(R.id.subtract);
        output = (TextView) findViewById(R.id.output);

        if (savedInstanceState != null) {
            outFunction = savedInstanceState.getStringArrayList(STRINGIDO);
            realFunction = savedInstanceState.getStringArrayList(STRINGIDR);
            output.setText(outFunction.toString().substring(1, outFunction.toString().length() - 1).replace(",", ""));
        }

        // second button press changes the stuff
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            second.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    isSecond = !isSecond;

                    if(isSecond)
                    {
                        sin.setText("sin⁻¹");
                        cos.setText("cos⁻¹");
                        tan.setText("tan⁻¹");
                    }
                    else
                    {
                        sin.setText("sin");
                        cos.setText("cos");
                        tan.setText("tan");
                    }

                }
            });



            sin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(isSecond) {
                        if (newP) {
                            outFunction.add("sin(");
                            output.setText("sin(");
                        } else {
                            outFunction.add("sin(");
                            output.setText(output.getText() + "sin(");
                        }
                    }
                    else {
                        if (newP) {
                            outFunction.add("asin(");
                            output.setText("sin⁻¹(");
                        } else {
                            outFunction.add("asin(");
                            output.setText(output.getText() + "sin⁻¹(");
                        }
                    }

                    newP = false;

                }
            });

            cos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(isSecond) {
                        if (newP) {
                            outFunction.add("cos(");
                            output.setText("cos(");
                        } else {
                            outFunction.add("cos(");
                            output.setText(output.getText() + "cos(");
                        }
                    }
                    else
                    {
                        if (newP) {
                            outFunction.add("acos(");
                            output.setText("cos⁻¹(");
                        } else {
                            outFunction.add("acos(");
                            output.setText(output.getText() + "cos⁻¹(");
                        }

                    }
                    newP = false;

                }
            });

            tan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(isSecond) {
                        if (newP) {
                            outFunction.add("tan(");
                            output.setText("tan(");
                        } else {
                            outFunction.add("tan(");
                            output.setText(output.getText() + "tan(");
                        }
                    }
                    else
                    {
                        if (newP) {
                            outFunction.add("atan(");
                            output.setText("tan⁻¹(");
                        } else {
                            outFunction.add("atan(");
                            output.setText(output.getText() + "tan⁻¹(");
                        }

                    }
                    newP = false;

                }
            });


            bXtoN1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (newP) {
                        if (outFunction.size() > 0) {
                            outFunction.add(outFunction.size() - 1, "1/");
                        }
                        output.setText("⁻¹");
                    } else {
                        if (outFunction.size() > 0) {
                            outFunction.add(outFunction.size() - 1, "1/");
                        }
                        output.setText(output.getText() + "⁻¹");
                    }

                    newP = false;

                }
            });

            factorial.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    if (outFunction.size() > 0 && !outFunction.get(outFunction.size() - 1).equals("!")) {
                        outFunction.add("!");
                        output.setText(output.getText() + "!");
                    }
                }
            });

            sqrt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (newP) {
                        outFunction.add("sqrt(");
                        output.setText("√(");
                    } else {
                        outFunction.add("sqrt(");
                        output.setText(output.getText() + "√(");
                    }

                    newP = false;

                }
            });

            log.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (newP) {
                        outFunction.add("log10(");
                        output.setText("log(");
                    } else {
                        outFunction.add("log10(");
                        output.setText(output.getText() + "log(");
                    }

                    newP = false;

                }
            });

            e.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (newP) {
                        outFunction.add("" + Math.E);
                        output.setText("e");
                    } else {
                        outFunction.add("" + Math.E);
                        output.setText(output.getText() + "e");
                    }

                    newP = false;

                }
            });
            pi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (newP) {
                        outFunction.add("" + Math.PI);
                        output.setText("π");
                    } else {
                        outFunction.add("" + Math.PI);
                        output.setText(output.getText() + "π");
                    }

                    newP = false;

                }
            });
            pow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (outFunction.size() > 0 && !outFunction.get(outFunction.size() - 1).equals("^")) {
                        outFunction.add("^");
                        output.setText(output.getText() + "^");
                    }
                }
            });

            square.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (outFunction.size() > 0) {
                        outFunction.add("^2");
                        output.setText(output.getText() + "^2");
                    }
                }
            });

            E.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (outFunction.size() > 0 && !outFunction.get(outFunction.size() - 1).equals("+")) {
                        outFunction.add("e");
                        output.setText(output.getText() + "E");
                    }
                }
            });
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (newP) {
                    outFunction.add("1");
                    output.setText("1");
                } else {
                    outFunction.add("1");
                    output.setText(output.getText() + "1");
                }

                newP = false;

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (newP) {
                    outFunction.add("2");
                    output.setText("2");
                } else {
                    outFunction.add("2");
                    output.setText(output.getText() + "2");
                }

                newP = false;

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (newP) {
                    outFunction.add("3");
                    output.setText("3");
                } else {
                    outFunction.add("3");
                    output.setText(output.getText() + "3");
                }

                newP = false;
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (newP) {
                    outFunction.add("4");
                    output.setText("4");
                } else {
                    outFunction.add("4");
                    output.setText(output.getText() + "4");
                }
                newP = false;
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (newP) {
                    outFunction.add("5");
                    output.setText("5");
                } else {
                    outFunction.add("5");
                    output.setText(output.getText() + "5");
                }
                newP = false;
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (newP) {
                    outFunction.add("6");
                    output.setText("6");
                } else {
                    outFunction.add("6");
                    output.setText(output.getText() + "6");
                }
                newP = false;
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (newP) {
                    outFunction.add("7");
                    output.setText("7");
                } else {
                    outFunction.add("7");
                    output.setText(output.getText() + "7");
                }
                newP = false;
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (newP) {
                    outFunction.add("8");
                    output.setText("8");
                } else {
                    outFunction.add("8");
                    output.setText(output.getText() + "8");
                }
                newP = false;
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (newP) {
                    outFunction.add("9");
                    output.setText("9");
                } else {
                    outFunction.add("9");
                    output.setText(output.getText() + "9");
                }
                newP = false;
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (newP) {
                    outFunction.add("0");
                    output.setText("0");
                } else {
                    outFunction.add("0");
                    output.setText(output.getText() + "0");
                }
                newP = false;
            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                outFunction.add("-");
                output.setText(output.getText() + "-");


            }
        });
        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (outFunction.size() > 0 && !outFunction.get(outFunction.size() - 1).equals("%")) {
                    outFunction.add("%");
                    output.setText(output.getText() + "%");
                }
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (outFunction.size() > 0 && !outFunction.get(outFunction.size() - 1).equals("+")) {
                    outFunction.add("+");
                    output.setText(output.getText() + "+");
                }
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (outFunction.size() > 0 && !outFunction.get(outFunction.size() - 1).equals("*")) {
                    outFunction.add("*");
                    output.setText(output.getText() + "x");
                }
            }
        });
        devide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (outFunction.size() > 0 && !outFunction.get(outFunction.size() - 1).equals("/")) {
                    outFunction.add("/");
                    output.setText(output.getText() + "÷");
                }
            }
        });
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (outFunction.size() > 0) {
                    outFunction.remove(outFunction.size() - 1);
                    //MAKE THIS OUTPUT CORRECYLY
                    output.setText(outFunction.toString().substring(1, outFunction.toString().length() - 1).replaceAll(", ", ""));
                }

            }
        });
        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                outFunction.add(".");
                output.setText(output.getText() + ".");


            }
        });


        backspace.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                outFunction.clear();
                output.setText("");
                return false;
            }

        });
        openP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                outFunction.add("(");
                output.setText(output.getText() + "(");

            }
        });
        closeP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberOf("(") > numberOf(")")) {
                    outFunction.add(")");
                    output.setText(output.getText() + ")");
                }
            }
        });


        // solve it
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });



    }



    public int numberOf(String str)
    {
        int cnt =0;
        for (String i : outFunction)
        {
            cnt += i.indexOf(str) != -1 ? 1 :0;
        }
        return cnt;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList(STRINGIDO , outFunction);
        outState.putStringArrayList(STRINGIDR , realFunction);

    }
}