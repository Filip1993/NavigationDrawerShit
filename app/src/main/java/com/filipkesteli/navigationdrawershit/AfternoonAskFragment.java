package com.filipkesteli.navigationdrawershit;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AfternoonAskFragment extends Fragment {

    //ove private varijable zive samo unutar ove klase

    private CardView cvMorningFeel;
    private CardView cvMorningMotivated;
    private CardView cvMorningPlans;
    private CardView cvMorningHappy;
    private CardView cvMorningAdventure;

    private SwitchCompat swMorningFeel;
    private SwitchCompat swMorningMotivated;
    private SwitchCompat swMorningPlans;
    private SwitchCompat swMorningHappy;
    private SwitchCompat swMorningAdventure;

    private TextView tvMorningFeel;
    private TextView tvMorningMotivated;
    private TextView tvMorningPlans;
    private TextView tvMorningHappy;
    private TextView tvMorningAdventure;

    private AppCompatSeekBar sbMorningFeel;
    private AppCompatSeekBar sbMorningMotivated;
    private AppCompatSeekBar sbMorningPlans;
    private AppCompatSeekBar sbMorningHappy;
    private AppCompatSeekBar sbMorningAdventure;

    public AfternoonAskFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_morning_ask, container, false);

        initWidgets(v);
        setupListeners();

        return v;
    }

    private void initWidgets(View v) {
        cvMorningFeel = (CardView) v.findViewById(R.id.cvAfternoonFeel);
        cvMorningMotivated = (CardView) v.findViewById(R.id.cvAfternoonMotivated);
        cvMorningPlans = (CardView) v.findViewById(R.id.cvAfternoonPlans);
        cvMorningHappy = (CardView) v.findViewById(R.id.cvAfternoonHappy);
        cvMorningAdventure = (CardView) v.findViewById(R.id.cvAfternoonAdventure);

        swMorningFeel = (SwitchCompat) v.findViewById(R.id.swAfternoonFeel);
        swMorningMotivated = (SwitchCompat) v.findViewById(R.id.swAfternoonMotivated);
        swMorningPlans = (SwitchCompat) v.findViewById(R.id.swAfternoonPlans);
        swMorningHappy = (SwitchCompat) v.findViewById(R.id.swAfternoonHappy);
        swMorningAdventure = (SwitchCompat) v.findViewById(R.id.swEveningAdventure);

        tvMorningFeel = (TextView) v.findViewById(R.id.tvAfternoonFeel);
        tvMorningMotivated = (TextView) v.findViewById(R.id.tvAfternoonMotivated);
        tvMorningPlans = (TextView) v.findViewById(R.id.tvAfternoonPlans);
        tvMorningHappy = (TextView) v.findViewById(R.id.tvAfternoonHappy);
        tvMorningAdventure = (TextView) v.findViewById(R.id.tvAfternoonAdventure);

        sbMorningFeel = (AppCompatSeekBar) v.findViewById(R.id.sbAfternoonFeel);
        sbMorningMotivated = (AppCompatSeekBar) v.findViewById(R.id.sbAfternoonMotivated);
        sbMorningPlans = (AppCompatSeekBar) v.findViewById(R.id.sbAfternoonPlans);
        sbMorningHappy = (AppCompatSeekBar) v.findViewById(R.id.sbAfternoonHappy);
        sbMorningAdventure = (AppCompatSeekBar) v.findViewById(R.id.sbAfternoonAdventure);
    }

    private void setupListeners() {
        //imamo 2 dijela koja treba obaviti:
        //(1)SwitchCompat -> na pritisak gumba, treba se promijeniti boja CardView-a
        //(2)AppCompatSeekBar -> na promjenu progress-a, treba se promijeniti TextView
        swMorningFeel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cvMorningFeel.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    //cvMorningFeel.setCardBackgroundColor(getResources().getColor(R.color.amber_50, null));
                } else if (!isChecked){
                    cvMorningFeel.setCardBackgroundColor(Color.parseColor("#FFCDD2"));
                    sbMorningFeel.setProgress(0);
                    tvMorningFeel.setText("");
                }
            }
        });
        sbMorningFeel.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //minimalan progress je 0, a maksimalan 100...
                // ajmo to i ovdje eksplicitno napisati da nismo vezani uz xml sto se tice toga
                sbMorningFeel.setMax(100);
                if (swMorningFeel.isChecked() == true) {
                    if (progress < 20) {
                        tvMorningFeel.setText(getResources().getString(R.string.crappy));
                    } else if (progress >= 20 && progress < 40) {
                        tvMorningFeel.setText(getResources().getString(R.string.so_so));
                    } else if (progress >= 40 && progress < 60) {
                        tvMorningFeel.setText(getResources().getString(R.string.good));
                    } else if (progress >= 60 && progress < 80) {
                        tvMorningFeel.setText(getResources().getString(R.string.happy));
                    } else if (progress >= 80 && progress <= 100) {
                        tvMorningFeel.setText(getResources().getString(R.string.excited));
                    }
                } else if (!swMorningFeel.isChecked()) {
                    tvMorningFeel.setText("");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        swMorningMotivated.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cvMorningMotivated.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    //cvMorningFeel.setCardBackgroundColor(getResources().getColor(R.color.amber_50, null));
                } else if (!isChecked){
                    cvMorningMotivated.setCardBackgroundColor(Color.parseColor("#FFCDD2"));
                    sbMorningMotivated.setProgress(0);
                    tvMorningMotivated.setText("");
                }
            }
        });
        sbMorningMotivated.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //minimalan progress je 0, a maksimalan 100...
                // ajmo to i ovdje eksplicitno napisati da nismo vezani uz xml sto se tice toga
                sbMorningMotivated.setMax(100);
                if (swMorningMotivated.isChecked()) {
                    if (progress < 20) {
                        tvMorningMotivated.setText(getResources().getString(R.string.crappy));
                    } else if (progress >= 20 && progress < 40) {
                        tvMorningMotivated.setText(getResources().getString(R.string.so_so));
                    } else if (progress >= 40 && progress < 60) {
                        tvMorningMotivated.setText(getResources().getString(R.string.good));
                    } else if (progress >= 60 && progress < 80) {
                        tvMorningMotivated.setText(getResources().getString(R.string.happy));
                    } else if (progress >= 80 && progress <= 100) {
                        tvMorningMotivated.setText(getResources().getString(R.string.excited));
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        swMorningPlans.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cvMorningPlans.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    //cvMorningFeel.setCardBackgroundColor(getResources().getColor(R.color.amber_50, null));
                } else if (!isChecked){
                    cvMorningPlans.setCardBackgroundColor(Color.parseColor("#FFCDD2"));
                    sbMorningPlans.setProgress(0);
                    tvMorningPlans.setText("");
                }
            }
        });
        sbMorningPlans.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //minimalan progress je 0, a maksimalan 100...
                // ajmo to i ovdje eksplicitno napisati da nismo vezani uz xml sto se tice toga
                sbMorningPlans.setMax(100);
                if (swMorningPlans.isChecked()) {
                    if (progress < 20) {
                        tvMorningPlans.setText(getResources().getString(R.string.crappy));
                    } else if (progress >= 20 && progress < 40) {
                        tvMorningPlans.setText(getResources().getString(R.string.so_so));
                    } else if (progress >= 40 && progress < 60) {
                        tvMorningPlans.setText(getResources().getString(R.string.good));
                    } else if (progress >= 60 && progress < 80) {
                        tvMorningPlans.setText(getResources().getString(R.string.happy));
                    } else if (progress >= 80 && progress <= 100) {
                        tvMorningPlans.setText(getResources().getString(R.string.excited));
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        swMorningHappy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cvMorningHappy.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    //cvMorningFeel.setCardBackgroundColor(getResources().getColor(R.color.amber_50, null));
                } else if (!isChecked){
                    cvMorningHappy.setCardBackgroundColor(Color.parseColor("#FFCDD2"));
                    sbMorningHappy.setProgress(0);
                    tvMorningHappy.setText("");
                }
            }
        });
        sbMorningHappy.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //minimalan progress je 0, a maksimalan 100...
                // ajmo to i ovdje eksplicitno napisati da nismo vezani uz xml sto se tice toga
                sbMorningHappy.setMax(100);
                if (swMorningHappy.isChecked()) {
                    if (progress < 20) {
                        tvMorningHappy.setText(getResources().getString(R.string.crappy));
                    } else if (progress >= 20 && progress < 40) {
                        tvMorningHappy.setText(getResources().getString(R.string.so_so));
                    } else if (progress >= 40 && progress < 60) {
                        tvMorningHappy.setText(getResources().getString(R.string.good));
                    } else if (progress >= 60 && progress < 80) {
                        tvMorningHappy.setText(getResources().getString(R.string.happy));
                    } else if (progress >= 80 && progress <= 100) {
                        tvMorningHappy.setText(getResources().getString(R.string.excited));
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        swMorningAdventure.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cvMorningAdventure.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    //cvMorningFeel.setCardBackgroundColor(getResources().getColor(R.color.amber_50, null));
                } else if (!isChecked){
                    cvMorningAdventure.setCardBackgroundColor(Color.parseColor("#FFCDD2"));
                    sbMorningAdventure.setProgress(0);
                    tvMorningAdventure.setText("");
                }
            }
        });
        sbMorningAdventure.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //minimalan progress je 0, a maksimalan 100...
                // ajmo to i ovdje eksplicitno napisati da nismo vezani uz xml sto se tice toga
                sbMorningAdventure.setMax(100);
                if (swMorningAdventure.isChecked()) {
                    if (progress < 20) {
                        tvMorningAdventure.setText(getResources().getString(R.string.crappy));
                    } else if (progress >= 20 && progress < 40) {
                        tvMorningAdventure.setText(getResources().getString(R.string.so_so));
                    } else if (progress >= 40 && progress < 60) {
                        tvMorningAdventure.setText(getResources().getString(R.string.good));
                    } else if (progress >= 60 && progress < 80) {
                        tvMorningAdventure.setText(getResources().getString(R.string.happy));
                    } else if (progress >= 80 && progress <= 100) {
                        tvMorningAdventure.setText(getResources().getString(R.string.excited));
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
