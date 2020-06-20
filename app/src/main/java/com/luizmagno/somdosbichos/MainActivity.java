package com.luizmagno.somdosbichos;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener{

    private ImageView cao;
    private ImageView gato;
    private ImageView leao;
    private ImageView macaco;
    private ImageView ovelha;
    private ImageView vaca;
    private ImageView elefante;
    private ImageView pato;
    private ImageView porco;
    private ImageView galo;
    private ImageView abelha;
    private ImageView galinha;
    private ImageView baleia;
    private ImageView golfinho;
    private ImageView pintinho;
    private ImageView cavalo;
    private ImageView sapo;
    private ImageView passaro;
    private ImageView rato;
    private MediaPlayer mp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp = new MediaPlayer();
        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });

        cao = findViewById(R.id.caoId);
        gato = findViewById(R.id.gatoId);
        leao = findViewById(R.id.leaoId);
        macaco = findViewById(R.id.macacoId);
        ovelha = findViewById(R.id.ovelhaId);
        /*vaca = findViewById(R.id.vacaId);
        elefante = findViewById(R.id.elefanteId);
        pato = findViewById(R.id.patoId);
        porco = findViewById(R.id.porcoId);
        galo = findViewById(R.id.galoId);
        abelha =findViewById(R.id.abelhaId);
        galinha = findViewById(R.id.galinhaId);
        baleia = findViewById(R.id.baleiaId);
        golfinho = findViewById(R.id.golfinhoId);
        pintinho = findViewById(R.id.pintinhoId);
        cavalo = findViewById(R.id.cavaloId);
        sapo = findViewById(R.id.sapoId);
        passaro = findViewById(R.id.passaroId);
        rato = findViewById(R.id.ratoId);*/

        cao.setOnClickListener(this);
        gato.setOnClickListener(this);
        leao.setOnClickListener(this);
        macaco.setOnClickListener(this);
        ovelha.setOnClickListener(this);
        /*vaca.setOnClickListener(this);
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
*/
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
                /*case R.id.vacaId:
                    afd = getResources().openRawResourceFd(R.raw.vaca);
                    Toast.makeText(this, R.string.vaca_str, Toast.LENGTH_SHORT).show();
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
                case R.id.pintinhoId:
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
                    break;*/
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
}
