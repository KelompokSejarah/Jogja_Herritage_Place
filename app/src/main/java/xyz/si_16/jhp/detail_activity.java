package xyz.si_16.jhp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class detail_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_activity);

        TextView wisataTilte = (TextView)findViewById(R.id.detailJudul);
        ImageView wisataImage = (ImageView)findViewById(R.id.detailGambar);

        Drawable drawable = ContextCompat.getDrawable
                (this,getIntent().getIntExtra(wisataData.IMAGE_KEY,0));

        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.GRAY);

        if (drawable!==null){
            gradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicWidth());
        }

        wisataTilte.setText(getIntent().getStringExtra(wisataData.NAME_KEY));

        Glide.with(this).load(getIntent().getIntExtra(wisataData.IMAGE_KEY,0))
                .placeholder(gradientDrawable).into(wisataImage);
    }
}
