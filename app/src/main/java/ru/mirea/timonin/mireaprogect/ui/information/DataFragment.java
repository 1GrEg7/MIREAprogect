package ru.mirea.timonin.mireaprogect.ui.information;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.Random;

import ru.mirea.timonin.mireaprogect.R;
import ru.mirea.timonin.mireaprogect.databinding.FragmentInformationBinding;


public class DataFragment extends Fragment {
    private FragmentInformationBinding binding;
    private String[] compliments;
    private TextView text1;
    private TextView text2;
    private Button btnCompliment;
    private Button btnNumber;
    private Button btnClear;
    private Button btnMeme;
    private ImageView meme;
    private int[] memes;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        compliments = new String[6];
        compliments[0]="Ты просто совершенство!";
        compliments[1]="Ваша точка зрения, как глоток свежего воздуха!";
        compliments[2]="Ты озаряешь пространство!";
        compliments[3]="Ваш творческий потенциал просто неиссякаем!";
        compliments[4]="Рядом с тобой все становится лучше";
        compliments[5]="Жизнь была бы намного лучше, если бы больше людей были такими, как ты!";


        memes = new int[5];
        memes[0]=  R.drawable.popugmeme;
        memes[1]=  R.drawable.memepicture;
        memes[2]=  R.drawable.simpsomeme;
        memes[3]=  R.drawable.programmeme;
        memes[4]=  R.drawable.mindmeme;

        //binding = FragmentInformationBinding.inflate(getLayoutInflater(), container,false);

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_information, container, false);


        text1 = (TextView)v.findViewById(R.id.text1);
        text2 = (TextView)v.findViewById(R.id.text2);
        btnCompliment=(Button)v.findViewById(R.id.materialButton111);
        btnNumber = (Button)v.findViewById(R.id.materialButton2) ;
        btnClear = (Button)v.findViewById(R.id.materialButton4);
        meme = (ImageView)v.findViewById(R.id.meme) ;
        btnMeme = (Button)v.findViewById(R.id.materialButton3) ;

        //meme.setVisibility(View.GONE);



        View.OnClickListener onClickCompliment = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rnd = new Random(System.currentTimeMillis());
                int number =  rnd.nextInt(5  + 1);
                text1.setText(compliments[number]);

            }
        };
        btnCompliment.setOnClickListener(onClickCompliment);


        View.OnClickListener onClickNumber = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rnd = new Random(System.currentTimeMillis());
                int number = rnd.nextInt(99 + 1);
                String num= Integer.toString(number);
                text2.setText(num);

            }
        };
        btnNumber.setOnClickListener(onClickNumber);


        View.OnClickListener onClickMeme = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rnd = new Random(System.currentTimeMillis());
                int number = rnd.nextInt(4+ 1);
                meme.setImageResource(memes[number]);
                meme.setVisibility(View.VISIBLE);

            }
        };
        btnMeme.setOnClickListener(onClickMeme);


        View.OnClickListener onClickClear = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText("");
                text2.setText("");
                meme.setVisibility(View.GONE);
            }
        };
        btnClear.setOnClickListener(onClickClear);

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

   /* public void onClickCompliment(View view){
        Random rnd = new Random(System.currentTimeMillis());
        int number =  rnd.nextInt(5  + 1);
        text1.setText(compliments[number]);
    }
    public void onClickNumber(View view){
        Random rnd = new Random(System.currentTimeMillis());
        int number = rnd.nextInt(99 + 1);
        String num= Integer.toString(number);
        text1.setText(num);
    }
    public void onClickClear(View view){
        text1.setText("");
        text2.setText("");
    }*/

}
