package io.github.chncs23.cooldownbutton.sample;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import io.github.chncs23.cooldownbutton.CooldownButton;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final CooldownButton cooldownButton = (CooldownButton) findViewById(R.id.cooldown);
    cooldownButton.setDelayInSeconds(3);
    cooldownButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
      }
    });

    cooldownButton.setOnPostDelayListener(new CooldownButton.OnPostDelayListener() {
      @Override public void onPostDelay() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Title");
        builder.setMessage("hello");
        builder.show();
      }
    });
  }
}
