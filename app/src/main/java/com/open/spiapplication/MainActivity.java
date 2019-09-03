package com.open.spiapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.open.borrowmodule.BorrowPlugin;
import com.open.usermodule.UserPlugin;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnUser, btnBorrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUser = findViewById(R.id.btnUser);
        btnBorrow = findViewById(R.id.btnBorrow);

        btnUser.setOnClickListener(this);
        btnBorrow.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnUser:
                UserPlugin plugin = PluginFactory.getSingleton().getPlugin(UserPlugin.class);
                Log.e("MainActivity", "plugin===" + plugin.pluginName());
                plugin.toLogin();
                break;
            case R.id.btnBorrow:
                BorrowPlugin plugin2 = PluginFactory.getSingleton().getPlugin(BorrowPlugin.class);
                Log.e("MainActivity", "plugin2===" + plugin2.pluginName());
                plugin2.toBorrow();
                break;
        }
    }
}
