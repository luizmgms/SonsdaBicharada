package com.luizmagno.somdosbichos;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.luizmagno.somdosbichos.adapters.AdapterAnimal;

import java.util.ArrayList;

import static com.luizmagno.somdosbichos.Utilities.getListAnimalsIds;
import static com.luizmagno.somdosbichos.Utilities.getListRawIds;

public class MainActivity extends AppCompatActivity {

    public MediaPlayer mp;
    public ImageView buttonMute;
    public boolean mute = false;
    public RadioButton radioBtnSom;
    public CoordinatorLayout mainCoordinator;
    private AppBarLayout appBarLayout;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Coordinator
        mainCoordinator = findViewById(R.id.mainCoordinatorId);

        //appBarLayout
        appBarLayout = findViewById(R.id.appBarLayoutId);

        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbarInMainId);
        setSupportActionBar(toolbar);

        //CollapseToolbar
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapseToolbaInMainId);
        collapsingToolbarLayout.setExpandedTitleColor(Color.TRANSPARENT);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);

        //Mute
        buttonMute = findViewById(R.id.buttonMuteId);
        buttonMute.setOnClickListener(view -> toggleMute());

        //Audio
        radioBtnSom = findViewById(R.id.radio_som);
        radioBtnSom.setChecked(true);

        //Lista das Ids das raw's de animaçãoes dos animais
        ArrayList<Integer> animals = getListRawIds();

        //Player
        mp = new MediaPlayer();
        //Prepare Player, ao completar tocar
        mp.setOnPreparedListener(MediaPlayer::start);

        //RecyclerView dos animais
        recyclerView = findViewById(R.id.listViewId);
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        }

        //Adapter do RecyclerView
        AdapterAnimal adapterAnimal = new AdapterAnimal(animals, this);
        recyclerView.setAdapter(adapterAnimal);
        recyclerView.setHasFixedSize(true);

    }

    private void toggleMute() {
        if (mute) {
            buttonMute.setImageResource(R.drawable.ic_sound);
        } else {
            buttonMute.setImageResource(R.drawable.ic_volume_off);
            if (mp.isPlaying()) {
                mp.stop();
            }
        }
        mute = !mute;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_share) {

            startShared(getResources().getString(R.string.text_share_link));

        } else if (id == R.id.menu_about) {

            showDialogAbout();

        } else if (id == R.id.menu_policy) {

            openUrl(getResources().getString(R.string.link_policy));

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mp.isPlaying()) {
            mp.stop();
        }
        mp.release();
    }

    private void startShared(String str_to_share) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, str_to_share);
        sendIntent.setType("text/plain");
        Intent shareIntent = Intent.createChooser(sendIntent,
                getResources().getString(R.string.title_shared));
        startActivity(shareIntent);
    }

    private void showDialogAbout(){

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View inflate = inflater.inflate(R.layout.layout_about, null);
        builder.setView(inflate);
        builder.create();
        builder.show();

        //Buttons
        Button btnAvaliarApp = inflate.findViewById(R.id.buttonAvalieInAboutId);
        Button btnSharedApp = inflate.findViewById(R.id.buttonShareInAboutId);

        btnSharedApp.setOnClickListener(v -> startShared(
                getResources().getString(R.string.text_share_link)));

        btnAvaliarApp.setOnClickListener((View v) -> openUrl(
                getResources().getString(R.string.link_to_avalie)));
    }

    private void openUrl (String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            mainCoordinator.setBackgroundResource(R.drawable.folhagem_b);
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            mainCoordinator.setBackgroundResource(R.drawable.folhagem_a);
            recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
            appBarLayout.setExpanded(false, true);
        }
    }
}
