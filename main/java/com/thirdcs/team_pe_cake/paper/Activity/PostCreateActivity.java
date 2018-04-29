package com.thirdcs.team_pe_cake.paper.Activity;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.thirdcs.team_pe_cake.paper.R;

import me.myatminsoe.mdetect.MDetect;


/**
 * Created by minthihaaung on 4/10/18.
 */

public class PostCreateActivity extends AppCompatActivity implements View.OnClickListener {

    public final int PICK_IMAGE = 1;
    int radio = 5;

    ImageView ivCategory, ivImage, ivCross, ivMain, ivDeleteImage;
    TextView tvPost, tvChooseCategory;
    EditText etTitle, etContent;
    ScrollView scrollView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_creating);
        MDetect.INSTANCE.init(this);
        initUI();

        ivCategory.setOnClickListener(this);
        ivImage.setOnClickListener(this);
        ivCross.setOnClickListener(this);
        tvPost.setOnClickListener(this);
        ivDeleteImage.setOnClickListener(this);
        etContent.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            switch (requestCode) {

                case PICK_IMAGE:
                    Uri selectedImage = data.getData();
                    Glide.with(this).load(selectedImage).fitCenter().into(ivMain);
                    ivDeleteImage.setVisibility(View.VISIBLE);      // visible delete image
                    break;
            }

        }
    }

    @Override
    public void onBackPressed() {

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            Bundle bundle = ActivityOptions.makeCustomAnimation(this, R.anim.slide_in, R.anim.slide_out).toBundle();
            Intent i = new Intent(this, BaseActivity.class);
            startActivity(i, bundle);
            finish();
        }


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.ivCategory:
                alertDialog();
                break;

            case R.id.ivImage:
                Intent imageChooseIntent = new Intent();
                imageChooseIntent.setType("image/*");
                imageChooseIntent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(imageChooseIntent, "Select Photo"), PICK_IMAGE);
                break;

            case R.id.tvPost:
                Toast.makeText(this, "Post", Toast.LENGTH_LONG).show();
                break;

            case R.id.ivCross:
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {

                    Bundle bundle = ActivityOptions.makeCustomAnimation(this, R.anim.slide_in, R.anim.slide_out).toBundle();
                    Intent i = new Intent(this, BaseActivity.class);
                    startActivity(i, bundle);
                    finish();
                }
                break;

            case R.id.ivDeleteImage:
                ivMain.setImageDrawable(null);
                ivDeleteImage.setVisibility(View.INVISIBLE);      //invisible delete image
                break;

            case R.id.etContent:
                if (etContent.getText().toString().trim().length() == 0) {
                    scrollUp();
                }
                break;

        }

    }

    private void scrollUp() {
        scrollView.postDelayed(new Runnable() {
            @Override
            public void run() {
                View lastChild = scrollView.getChildAt(scrollView.getChildCount() - 1);
                int bottom = lastChild.getBottom() + scrollView.getPaddingBottom();
                int sy = scrollView.getScrollY();
                int sh = scrollView.getHeight();
                int delta = bottom - (sy + sh + 300);
                scrollView.smoothScrollBy(0, delta);
            }
        }, 200);
    }

    public void alertDialog() {
        final AlertDialog alertDialog;
        LayoutInflater inflater = this.getLayoutInflater();
        View layout = inflater.inflate(R.layout.category_alert, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(PostCreateActivity.this, R.style.MyDialogTheme);
        builder.setView(layout);

        RadioGroup radioGroup = layout.findViewById(R.id.radioGroup);
        RadioButton[] rbArray = {takeRButton(0, radioGroup), takeRButton(1, radioGroup),
                takeRButton(2, radioGroup), takeRButton(3, radioGroup), takeRButton(4, radioGroup),
                takeRButton(5, radioGroup)};
        rbArray[radio].setChecked(true);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.fiction:
                        radio = 0;
                        break;
                    case R.id.nonfiction:
                        radio = 1;
                        break;
                    case R.id.health:
                        radio = 2;
                        break;
                    case R.id.science:
                        radio = 3;
                        break;
                    case R.id.humor:
                        radio = 4;
                        break;
                    case R.id.general:
                        radio = 5;
                        break;
                }
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });

        alertDialog = builder.create();
        alertDialog.show();

    }

    public RadioButton takeRButton(int index, RadioGroup rg) {
        RadioButton rb = (RadioButton) rg.getChildAt(index);
        return rb;
    }

    public void initUI() {

        tvChooseCategory = findViewById(R.id.tvChooseCategory);
        ivCategory = findViewById(R.id.ivCategory);
        ivImage = findViewById(R.id.ivImage);
        ivCross = findViewById(R.id.ivCross);
        tvPost = findViewById(R.id.tvPost);
        ivMain = findViewById(R.id.ivMain);
        ivDeleteImage = findViewById(R.id.ivDeleteImage);
        etTitle = findViewById(R.id.etTitle);
        scrollView = findViewById(R.id.svPostCreate);
        etContent = findViewById(R.id.etContent);

        if (MDetect.INSTANCE.isUnicode()) {
            tvChooseCategory.setText("အမျိုးအစားရွေးပါ");
            etTitle.setHint("ခေါင်းစဉ်");
            etContent.setHint("အကြောင်းအရာ");
        } else {
            tvChooseCategory.setText("အမ်ိဳးအစားေရြးပါ");
            etTitle.setHint("ေခါင္းစဥ္");
            etContent.setHint("အေၾကာင္းအရာ");
        }

    }

}
