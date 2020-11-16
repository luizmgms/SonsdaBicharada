package com.luizmagno.somdosbichos.adapters;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.snackbar.Snackbar;
import com.luizmagno.somdosbichos.MainActivity;
import com.luizmagno.somdosbichos.R;

import java.util.ArrayList;

import static com.luizmagno.somdosbichos.Utilities.getIdsAnimal;

public class AdapterAnimal extends RecyclerView.Adapter<AdapterAnimal.ItemAnimalViewHolder> {

    private final ArrayList<Integer> listIdsAnimals;
    private final MainActivity mainActivity;

    //INNER CLASS
    public static class ItemAnimalViewHolder extends RecyclerView.ViewHolder{

        LottieAnimationView lottieAnimationView;
        public ItemAnimalViewHolder(View view) {
            super(view);
            lottieAnimationView = view.findViewById(R.id.imageAnimalId);
        }

    }

    public AdapterAnimal(ArrayList<Integer> list, MainActivity mActivity) {
        this.listIdsAnimals = list;
        this.mainActivity = mActivity;
    }

    @NonNull
    @Override
    public ItemAnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_animals, parent, false);

        return new ItemAnimalViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAnimalViewHolder holder, int position) {

        //PEGAR ID DO RAW RES. A LISTA DEVE CONTER OS IDS DOS RAWS
        holder.lottieAnimationView.setAnimation(R.raw.cachorro_latindo_1);
        holder.lottieAnimationView.setOnClickListener(v -> play(v, position));
    }

    @Override
    public int getItemCount() {
        return listIdsAnimals.size();
    }

    private void play(View v, int pos) {
        MediaPlayer mp = mainActivity.mp;

        if (!mainActivity.mute) {

            try {

                //Se estiver tocando, pare
                if (mp.isPlaying()) {
                    mp.stop();
                }

                //Reset Player
                mp.reset();

                //Descritor de arquivo
                AssetFileDescriptor afd;

                //Id's id[0] = Nome, id[1] = Raw Som, id[2] = Raw Descrição, id[3] = id da View
                int[] id = getIdsAnimal(pos);

                //Se Som ativo, executa som do animal
                if (mainActivity.radioBtnSom.isChecked()) {
                    afd = mainActivity.getResources().openRawResourceFd(id[1]);
                    //Start Animação
                    ((LottieAnimationView) v).playAnimation();
                } else {
                    //Se não, descrição
                    afd = mainActivity.getResources().openRawResourceFd(id[2]);
                }

                //Set Data e PrepareAsync
                if (afd != null) {
                    mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                    mp.prepareAsync();
                }

                //Show SnackBar
                Snackbar.make(mainActivity.mainCoordinator, id[0], Snackbar.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            //Mudo
            Snackbar.make(mainActivity.mainCoordinator, R.string.is_mute, Snackbar.LENGTH_SHORT)
                    .show();
        }
    }
}
