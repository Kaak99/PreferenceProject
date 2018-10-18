package com.example.kaak.preferenceproject;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textview);
        for (int i = 0; i <= 1000; i++) {
            savePref(i);
        }

        int valeur = getFromPrefs("identifiant"+1000);
        textView.setText("Pour identifiant 1000 la valeur associée est = " + valeur);

        int[] tableau = {100, 200, 300, 400, 500};
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(100); // pos 0
        arrayList.add(200);
        arrayList.add(300);
        arrayList.add(400); // position 3

        arrayList.add(1, 150);
        arrayList.remove(2);
        arrayList.set(1, 201);

        String resultat = "";
        for (int i = 0; i < arrayList.size(); i++) {
            resultat += arrayList.get(i) + "\n";
        }
        textView.setText(resultat);
    }

    private void savePref(int number) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("identifiant"+number, number);
        editor.apply();
    }

    private int getFromPrefs(String key) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        return prefs.getInt(key, -5);
    }
}
