package com.luizmagno.somdosbichos;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbarInMainId);
        setSupportActionBar(toolbar);

        //CollapseToolbar
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapseToolbaInMainId);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(android.R.color.white));

        mp = new MediaPlayer();
        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });

        ImageView cao = findViewById(R.id.caoId);
        ImageView gato = findViewById(R.id.gatoId);
        ImageView leao = findViewById(R.id.leaoId);
        ImageView macaco = findViewById(R.id.macacoId);
        ImageView ovelha = findViewById(R.id.ovelhaId);
        ImageView vaca = findViewById(R.id.vacaId);
        ImageView elefante = findViewById(R.id.elefanteId);
        ImageView pato = findViewById(R.id.patoId);
        ImageView porco = findViewById(R.id.porcoId);
        ImageView galo = findViewById(R.id.galoId);
        ImageView abelha =findViewById(R.id.abelhaId);
        ImageView galinha = findViewById(R.id.galinhaId);
        ImageView baleia = findViewById(R.id.baleiaId);
        ImageView golfinho = findViewById(R.id.golfinhoId);
        ImageView pintinho = findViewById(R.id.pintoId);
        ImageView cavalo = findViewById(R.id.cavaloId);
        ImageView sapo = findViewById(R.id.sapoId);
        ImageView passaro = findViewById(R.id.passaroId);
        ImageView rato = findViewById(R.id.ratoId);

        cao.setOnClickListener(this);
        gato.setOnClickListener(this);
        leao.setOnClickListener(this);
        macaco.setOnClickListener(this);
        ovelha.setOnClickListener(this);
        vaca.setOnClickListener(this);
        elefante.setOnClickListener(this);
        pato.setOnClickListener(this);
        porco.setOnClickListener(this);
        galo.setOnClickListener(this);
        abelha.setOnClickListener(this);
        galinha.setOnClickListener(this);
        baleia.setOnClickListener(this);
        golfinho.setOnClickListener(this);
        pintinho.setOnClickListener(this);
        cavalo.setOnClickListener(this);
        sapo.setOnClickListener(this);
        passaro.setOnClickListener(this);
        rato.setOnClickListener(this);

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

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        try {
            if(mp.isPlaying()) {
                mp.stop();
            }
            
            mp.reset();

            AssetFileDescriptor afd = null;

            switch (v.getId()){
                case R.id.caoId:
                    afd = getResources().openRawResourceFd(R.raw.cao);
                    Toast.makeText(this, R.string.cao, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.gatoId:
                    afd = getResources().openRawResourceFd(R.raw.gato);
                    Toast.makeText(this, R.string.gato, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.leaoId:
                    afd = getResources().openRawResourceFd(R.raw.leao);
                    Toast.makeText(this, R.string.leao, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.macacoId:
                    afd = getResources().openRawResourceFd(R.raw.macaco);
                    Toast.makeText(this, R.string.macaco, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.ovelhaId:
                    afd = getResources().openRawResourceFd(R.raw.ovelha);
                    Toast.makeText(this, R.string.ovelha, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.vacaId:
                    afd = getResources().openRawResourceFd(R.raw.vaca);
                    Toast.makeText(this, R.string.vaca, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.elefanteId:
                    afd = getResources().openRawResourceFd(R.raw.elefante);
                    Toast.makeText(this, R.string.elefante, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.patoId:
                    afd = getResources().openRawResourceFd(R.raw.pato);
                    Toast.makeText(this, R.string.pato, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.porcoId:
                    afd = getResources().openRawResourceFd(R.raw.porco);
                    Toast.makeText(this, R.string.porco, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.galoId:
                    afd = getResources().openRawResourceFd(R.raw.galo);
                    Toast.makeText(this, R.string.galo, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.abelhaId:
                    afd = getResources().openRawResourceFd(R.raw.abelha);
                    Toast.makeText(this, R.string.abelha, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.galinhaId:
                    afd = getResources().openRawResourceFd(R.raw.galinha);
                    Toast.makeText(this, R.string.galinha, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.baleiaId:
                    afd = getResources().openRawResourceFd(R.raw.baleia);
                    Toast.makeText(this, R.string.baleia, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.golfinhoId:
                    afd = getResources().openRawResourceFd(R.raw.golfinho);
                    Toast.makeText(this, R.string.golfinho, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.pintoId:
                    afd = getResources().openRawResourceFd(R.raw.pinto);
                    Toast.makeText(this, R.string.pintinho, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.cavaloId:
                    afd = getResources().openRawResourceFd(R.raw.cavalo);
                    Toast.makeText(this, R.string.cavalo, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.sapoId:
                    afd = getResources().openRawResourceFd(R.raw.sapo);
                    Toast.makeText(this, R.string.sapo, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.passaroId:
                    afd = getResources().openRawResourceFd(R.raw.passaro);
                    Toast.makeText(this, R.string.passaro, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.ratoId:
                    afd = getResources().openRawResourceFd(R.raw.rato);
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
}
