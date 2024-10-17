package com.example.sixteen;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView text;
    private Button but;
    private Button bgButton;
    public RelativeLayout relativeLayout;
    Context context;

    private CharSequence[] items; // Moved outside the onClick method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // Deprecated, check for a better approach
        setContentView(R.layout.activity_main);
        TextView text = findViewById(R.id.Dialog);
but=findViewById(R.id.button);
        bgButton = findViewById(R.id.background_button);
        relativeLayout = findViewById(R.id.relativelayout);
        context = MainActivity.this;

        // Initialize items array here
        items = new CharSequence[]{
                getText(R.string.red), getText(R.string.yellow), getText(R.string.green),"EEEEEEE"
        };
but.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
    }
});
        bgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(R.string.message);
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item) {
                            case 0:
                                relativeLayout.setBackgroundResource(R.color.redColor);
                                text.bringToFront();
                                Toast.makeText(context, R.string.red, Toast.LENGTH_LONG).show();
                                break;
                            case 1:
                                relativeLayout.setBackgroundResource(R.color.yellowColor);
                                text.bringToFront();
                                Toast.makeText(context, R.string.yellow, Toast.LENGTH_LONG).show();
                                break;
                            case 2:
                                relativeLayout.setBackgroundResource(R.color.greenColor);
                                text.bringToFront();
                                Toast.makeText(context, R.string.green, Toast.LENGTH_LONG).show();
                                break;
                            case 3:
                                relativeLayout.setBackgroundResource(R.drawable.n);
                                text.bringToFront();
                                Toast.makeText(context,"NIGGA?", Toast.LENGTH_LONG).show();
                                break;
                        }
                    }
                });

                AlertDialog alert = builder.create();
                alert.show(); // Only show dialog when the button is clicked
            }
        });

        // Handling system window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
