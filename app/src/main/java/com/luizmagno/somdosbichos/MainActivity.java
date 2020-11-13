package com.luizmagno.somdosbichos;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.res.ResourcesCompat;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private MediaPlayer mp;
    private ArrayList<Integer> animals;
    private ImageView buttonMute;
    private boolean mute = false;
    private RadioButton radioBtnSom;
    private CoordinatorLayout mainCoordinator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Coordinator
        mainCoordinator = findViewById(R.id.mainCoordinatorId);

        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbarInMainId);
        setSupportActionBar(toolbar);

        //CollapseToolbar
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapseToolbaInMainId);
        collapsingToolbarLayout.setExpandedTitleColor(Color.TRANSPARENT);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);

        //Mute
        buttonMute = findViewById(R.id.buttonMuteId);
        buttonMute.setOnClickListener(view -> {
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

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        
        //Se não estiver mudo
        if (!mute) {

            //Prepare Player, ao completar tocar
            mp.setOnPreparedListener(MediaPlayer::start);

            try {

                //Se estiver tocando, pare
                if (mp.isPlaying()) {
                    mp.stop();
                }

                //Reset Player
                mp.reset();

                //Descritor de arquivo
                AssetFileDescriptor afd;

                //Id's id[0] = Nome, id[1] = Raw Som, id[2] = Raw Descrição
                int[] id = getNameSoundAnimal(v);

                //Se Som ativo, executa som do animal
                if (radioBtnSom.isChecked()){
                    afd = getResources().openRawResourceFd(id[1]);
                } else {
                    //Se não, descrição
                    afd = getResources().openRawResourceFd(id[2]);
                }

                //Set Data e PrepareAsync
                if (afd != null) {
                    mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                    mp.prepareAsync();
                }

                //Show SnackBar
                Snackbar.make(mainCoordinator, id[0], Snackbar.LENGTH_SHORT).show();


            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            //Mudo
            Snackbar.make(mainCoordinator, R.string.is_mute, Snackbar.LENGTH_SHORT).show();
        }

        LottieAnimationView lottieAnimationView = findViewById(R.id.caoId);
        lottieAnimationView.playAnimation();
        
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

    @SuppressLint("NonConstantResourceId")
    private int[] getNameSoundAnimal(View animalView) {

        int[] animal = {0, 0, 0, 0};

        switch (animalView.getId()) {
            case R.id.caoId:
                animal[0] = R.string.cao;
                animal[1] = R.raw.cao;
                animal[2] = R.raw.cachorro_desc;
                animal[3] = R.id.caoId;
                break;
            case R.id.gatoId:
                animal[0] = R.string.gato;
                animal[1] = R.raw.gato;
                animal[2] = R.raw.gato_desc;
                animal[3] = R.id.gatoId;
                break;
            case R.id.leaoId:
                animal[0] = R.string.leao;
                animal[1] = R.raw.leao;
                animal[2] = R.raw.leao_desc;
                animal[3] = R.id.leaoId;
                break;
            case R.id.macacoId:
                animal[0] = R.string.macaco;
                animal[1] = R.raw.macaco;
                animal[2] = R.raw.macaco_desc;
                animal[3] = R.id.macacoId;
                break;
            case R.id.ovelhaId:
                animal[0] = R.string.ovelha;
                animal[1] = R.raw.ovelha;
                animal[2] = R.raw.ovelha_desc;
                animal[3] = R.id.ovelhaId;
                break;
            case R.id.vacaId:
                animal[0] = R.string.vaca;
                animal[1] = R.raw.vaca;
                animal[2] = R.raw.vaca_desc;
                animal[3] = R.id.vacaId;
                break;
            case R.id.elefanteId:
                animal[0] = R.string.elefante;
                animal[1] = R.raw.elefante;
                animal[2] = R.raw.elefante_desc;
                animal[3] = R.id.elefanteId;
                break;
            case R.id.patoId:
                animal[0] = R.string.pato;
                animal[1] = R.raw.pato;
                animal[2] = R.raw.pato_desc;
                animal[3] = R.id.patoId;
                break;
            case R.id.porcoId:
                animal[0] = R.string.porco;
                animal[1] = R.raw.porco;
                animal[2] = R.raw.porco_desc;
                animal[3] = R.id.porcoId;
                break;
            case R.id.galoId:
                animal[0] = R.string.galo;
                animal[1] = R.raw.galo;
                animal[2] = R.raw.galo_desc;
                animal[3] = R.id.galoId;
                break;
            case R.id.abelhaId:
                animal[0] = R.string.abelha;
                animal[1] = R.raw.abelha;
                animal[2] = R.raw.abelha_desc;
                animal[3] = R.id.abelhaId;
                break;
            case R.id.galinhaId:
                animal[0] = R.string.galinha;
                animal[1] = R.raw.galinha;
                animal[2] = R.raw.galinha_desc;
                animal[3] = R.id.galinhaId;
                break;
            case R.id.baleiaId:
                animal[0] = R.string.baleia;
                animal[1] = R.raw.baleia;
                animal[2] = R.raw.baleia_desc;
                animal[3] = R.id.baleiaId;
                break;
            case R.id.golfinhoId:
                animal[0] = R.string.golfinho;
                animal[1] = R.raw.golfinho;
                animal[2] = R.raw.golfinho_desc;
                animal[3] = R.id.golfinhoId;
                break;
            case R.id.pintoId:
                animal[0] = R.string.pintinho;
                animal[1] = R.raw.pinto;
                animal[2] = R.raw.pinto_desc;
                animal[3] = R.id.pintoId;
                break;
            case R.id.cavaloId:
                animal[0] = R.string.cavalo;
                animal[1] = R.raw.cavalo;
                animal[2] = R.raw.cavalo_desc;
                animal[3] = R.id.cavaloId;
                break;
            case R.id.sapoId:
                animal[0] = R.string.sapo;
                animal[1] = R.raw.sapo;
                animal[2] = R.raw.sapo_desc;
                animal[3] = R.id.sapoId;
                break;
            case R.id.passaroId:
                animal[0] = R.string.passaro;
                animal[1] = R.raw.passaro;
                animal[2] = R.raw.passarinho_desc;
                animal[3] = R.id.passaroId;
                break;
            case R.id.ratoId:
                animal[0] = R.string.rato;
                animal[1] = R.raw.rato;
                animal[2] = R.raw.rato_desc;
                animal[3] = R.id.ratoId;
                break;
            default:
                animal[0] = R.string.erro;
                animal[1] = 0;
                animal[2] = 0;
                animal[3] = 0;
                break;

        }

        return animal;
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            mainCoordinator.setBackgroundResource(R.drawable.folhagem_b);
        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            mainCoordinator.setBackgroundResource(R.drawable.folhagem_a);
        }
    }
}
