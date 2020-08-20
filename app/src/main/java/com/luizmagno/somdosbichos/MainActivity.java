package com.luizmagno.somdosbichos;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;
import java.util.ArrayList;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private MediaPlayer mp;
    private ArrayList<Integer> animals;
    private ImageView buttonMute;
    private boolean mute = false;
    private RadioButton radioBtnSom;
    private FrameLayout adContainerView;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Anúncio
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        adContainerView = findViewById(R.id.ad_view_container);
        adContainerView.post(new Runnable() {
            @Override
            public void run() {
                loadBanner();
            }
        });


        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbarInMainId);
        setSupportActionBar(toolbar);

        //CollapseToolbar
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapseToolbaInMainId);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(android.R.color.white));

        //Mute
        buttonMute = findViewById(R.id.buttonMuteId);
        buttonMute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mute) {
                    buttonMute.setImageDrawable(
                        ResourcesCompat.getDrawable(
                            getResources(), R.drawable.ic_sound,null));
                } else {
                    buttonMute.setImageDrawable(
                        ResourcesCompat.getDrawable(
                            getResources(), R.drawable.ic_volume_off,null));
                    if (mp.isPlaying()) {
                        mp.stop();
                    }
                }
                mute = !mute;
            }
        });

        //Audio
        radioBtnSom = findViewById(R.id.radio_som);
        radioBtnSom.setChecked(true);

        //Animais
        animals = new ArrayList<>();
        fillArray();
        //Player
        mp = new MediaPlayer();

        setClickArray();

    }

    private void setClickArray() {
        for (int IdAnimal: animals) {
            findViewById(IdAnimal).setOnClickListener(this);
        }
    }

    private void fillArray() {
        animals.add(R.id.caoId);
        animals.add(R.id.gatoId);
        animals.add(R.id.leaoId);
        animals.add(R.id.macacoId);
        animals.add(R.id.ovelhaId);
        animals.add(R.id.vacaId);
        animals.add(R.id.elefanteId);
        animals.add(R.id.patoId);
        animals.add(R.id.porcoId);
        animals.add(R.id.galoId);
        animals.add(R.id.abelhaId);
        animals.add(R.id.galinhaId);
        animals.add(R.id.baleiaId);
        animals.add(R.id.golfinhoId);
        animals.add(R.id.pintoId);
        animals.add(R.id.cavaloId);
        animals.add(R.id.sapoId);
        animals.add(R.id.passaroId);
        animals.add(R.id.ratoId);
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
    public void onClick(View v) {
        
        //Se não estiver mudo
        if (!mute) {

            //Prepare Player
            mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });

            try {
                if (mp.isPlaying()) {
                    mp.stop();
                }

                mp.reset();

                AssetFileDescriptor afd = null;

                switch (v.getId()) {
                    case R.id.caoId:
                        if (radioBtnSom.isChecked()){
                            afd = getResources().openRawResourceFd(R.raw.cao);
                        } else {
                            afd = getResources().openRawResourceFd(R.raw.cachorro_desc);
                        }
                        Toast.makeText(this, R.string.cao, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.gatoId:
                        if (radioBtnSom.isChecked()){
                            afd = getResources().openRawResourceFd(R.raw.gato);
                        } else {
                            afd = getResources().openRawResourceFd(R.raw.gato_desc);
                        }
                        Toast.makeText(this, R.string.gato, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.leaoId:
                        if (radioBtnSom.isChecked()){
                            afd = getResources().openRawResourceFd(R.raw.leao);
                        } else {
                            afd = getResources().openRawResourceFd(R.raw.leao_desc);
                        }
                        Toast.makeText(this, R.string.leao, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.macacoId:
                        if (radioBtnSom.isChecked()){
                            afd = getResources().openRawResourceFd(R.raw.macaco);
                        } else {
                            afd = getResources().openRawResourceFd(R.raw.macaco_desc);
                        }
                        Toast.makeText(this, R.string.macaco, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.ovelhaId:
                        if (radioBtnSom.isChecked()){
                            afd = getResources().openRawResourceFd(R.raw.ovelha);
                        } else {
                            afd = getResources().openRawResourceFd(R.raw.ovelha_desc);
                        }
                        Toast.makeText(this, R.string.ovelha, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.vacaId:
                        if (radioBtnSom.isChecked()){
                            afd = getResources().openRawResourceFd(R.raw.vaca);
                        } else {
                            afd = getResources().openRawResourceFd(R.raw.vaca_desc);
                        }
                        Toast.makeText(this, R.string.vaca, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.elefanteId:
                        if (radioBtnSom.isChecked()){
                            afd = getResources().openRawResourceFd(R.raw.elefante);
                        } else {
                            afd = getResources().openRawResourceFd(R.raw.elefante_desc);
                        }
                        Toast.makeText(this, R.string.elefante, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.patoId:
                        if (radioBtnSom.isChecked()){
                            afd = getResources().openRawResourceFd(R.raw.pato);
                        } else {
                            afd = getResources().openRawResourceFd(R.raw.pato_desc);
                        }
                        Toast.makeText(this, R.string.pato, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.porcoId:
                        if (radioBtnSom.isChecked()){
                            afd = getResources().openRawResourceFd(R.raw.porco);
                        } else {
                            afd = getResources().openRawResourceFd(R.raw.porco_desc);
                        }
                        Toast.makeText(this, R.string.porco, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.galoId:
                        if (radioBtnSom.isChecked()){
                            afd = getResources().openRawResourceFd(R.raw.galo);
                        } else {
                            afd = getResources().openRawResourceFd(R.raw.galo_desc);
                        }
                        Toast.makeText(this, R.string.galo, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.abelhaId:
                        if (radioBtnSom.isChecked()){
                            afd = getResources().openRawResourceFd(R.raw.abelha);
                        } else {
                            afd = getResources().openRawResourceFd(R.raw.abelha_desc);
                        }
                        Toast.makeText(this, R.string.abelha, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.galinhaId:
                        if (radioBtnSom.isChecked()){
                            afd = getResources().openRawResourceFd(R.raw.galinha);
                        } else {
                            afd = getResources().openRawResourceFd(R.raw.galinha_desc);
                        }
                        Toast.makeText(this, R.string.galinha, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.baleiaId:
                        if (radioBtnSom.isChecked()){
                            afd = getResources().openRawResourceFd(R.raw.baleia);
                        } else {
                            afd = getResources().openRawResourceFd(R.raw.baleia_desc);
                        }
                        Toast.makeText(this, R.string.baleia, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.golfinhoId:
                        if (radioBtnSom.isChecked()){
                            afd = getResources().openRawResourceFd(R.raw.golfinho);
                        } else {
                            afd = getResources().openRawResourceFd(R.raw.golfinho_desc);
                        }
                        Toast.makeText(this, R.string.golfinho, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.pintoId:
                        if (radioBtnSom.isChecked()){
                            afd = getResources().openRawResourceFd(R.raw.pinto);
                        } else {
                            afd = getResources().openRawResourceFd(R.raw.pinto_desc);
                        }
                        Toast.makeText(this, R.string.pintinho, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.cavaloId:
                        if (radioBtnSom.isChecked()){
                            afd = getResources().openRawResourceFd(R.raw.cavalo);
                        } else {
                            afd = getResources().openRawResourceFd(R.raw.cavalo_desc);
                        }
                        Toast.makeText(this, R.string.cavalo, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.sapoId:
                        if (radioBtnSom.isChecked()){
                            afd = getResources().openRawResourceFd(R.raw.sapo);
                        } else {
                            afd = getResources().openRawResourceFd(R.raw.sapo_desc);
                        }
                        Toast.makeText(this, R.string.sapo, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.passaroId:
                        if (radioBtnSom.isChecked()){
                            afd = getResources().openRawResourceFd(R.raw.passaro);
                        } else {
                            afd = getResources().openRawResourceFd(R.raw.passarinho_desc);
                        }
                        Toast.makeText(this, R.string.passaro, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.ratoId:
                        if (radioBtnSom.isChecked()){
                            afd = getResources().openRawResourceFd(R.raw.rato);
                        } else {
                            afd = getResources().openRawResourceFd(R.raw.rato_desc);
                        }
                        Toast.makeText(this, R.string.rato, Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(this, "Ocorreu um Erro!", Toast.LENGTH_SHORT).show();
                        break;
                }

                if (afd != null) {
                    mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                    mp.prepareAsync();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(this, "Está mudo!", Toast.LENGTH_LONG).show();
        }
        
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
        Intent shareIntent = Intent.createChooser(sendIntent, null);
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

        btnSharedApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startShared(getResources().getString(R.string.text_share_link));
            }
        });

        btnAvaliarApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl(getResources().getString(R.string.link_to_avalie));
            }
        });
    }

    private void openUrl (String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    private AdSize getAdSize() {
        // Step 2 - Determine the screen width (less decorations) to use for the ad width.
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float widthPixels = outMetrics.widthPixels;
        float density = outMetrics.density;

        int adWidth = (int) (widthPixels / density);

        // Step 3 - Get adaptive ad size and return for setting on the ad view.
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, adWidth);
    }

    private void loadBanner() {
        mAdView = new AdView(this);
        mAdView.setAdUnitId(Developer.ID_OF_ANUN);
        adContainerView.removeAllViews();
        adContainerView.addView(mAdView);

        AdSize adSize = getAdSize();
        mAdView.setAdSize(adSize);

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

}
