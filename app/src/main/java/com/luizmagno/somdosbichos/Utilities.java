package com.luizmagno.somdosbichos;

import java.util.ArrayList;

public class Utilities {

    public static ArrayList<Integer> getListRawIds() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(R.raw.cachorro_latindo_1);
        list.add(R.raw.gato_miando_1);
        return list;
    }

    public static ArrayList<Integer> getListAnimalsIds() {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(R.id.caoId);
        list.add(R.id.gatoId);
        list.add(R.id.leaoId);
        list.add(R.id.macacoId);
        list.add(R.id.ovelhaId);
        list.add(R.id.vacaId);
        list.add(R.id.elefanteId);
        list.add(R.id.patoId);
        list.add(R.id.porcoId);
        list.add(R.id.galoId);
        list.add(R.id.abelhaId);
        list.add(R.id.galinhaId);
        list.add(R.id.baleiaId);
        list.add(R.id.golfinhoId);
        list.add(R.id.pintoId);
        list.add(R.id.cavaloId);
        list.add(R.id.sapoId);
        list.add(R.id.passaroId);
        list.add(R.id.ratoId);

        return list;
    }

    public static int[] getIdsAnimal(int pos) {

        int[] animal = {0, 0, 0, 0};

        switch (pos) {
            case 0:
                animal[0] = R.string.cao;
                animal[1] = R.raw.cao;
                animal[2] = R.raw.cachorro_desc;
                animal[3] = R.id.caoId;
                break;
            case 1:
                animal[0] = R.string.gato;
                animal[1] = R.raw.gato_miando;
                animal[2] = R.raw.gato_desc;
                animal[3] = R.id.gatoId;
                break;
            case 2:
                animal[0] = R.string.leao;
                animal[1] = R.raw.leao;
                animal[2] = R.raw.leao_desc;
                animal[3] = R.id.leaoId;
                break;
            case 3:
                animal[0] = R.string.macaco;
                animal[1] = R.raw.macaco;
                animal[2] = R.raw.macaco_desc;
                animal[3] = R.id.macacoId;
                break;
            case 4:
                animal[0] = R.string.ovelha;
                animal[1] = R.raw.ovelha;
                animal[2] = R.raw.ovelha_desc;
                animal[3] = R.id.ovelhaId;
                break;
            case 5:
                animal[0] = R.string.vaca;
                animal[1] = R.raw.vaca;
                animal[2] = R.raw.vaca_desc;
                animal[3] = R.id.vacaId;
                break;
            case 6:
                animal[0] = R.string.elefante;
                animal[1] = R.raw.elefante;
                animal[2] = R.raw.elefante_desc;
                animal[3] = R.id.elefanteId;
                break;
            case 7:
                animal[0] = R.string.pato;
                animal[1] = R.raw.pato;
                animal[2] = R.raw.pato_desc;
                animal[3] = R.id.patoId;
                break;
            case 8:
                animal[0] = R.string.porco;
                animal[1] = R.raw.porco;
                animal[2] = R.raw.porco_desc;
                animal[3] = R.id.porcoId;
                break;
            case 9:
                animal[0] = R.string.galo;
                animal[1] = R.raw.galo;
                animal[2] = R.raw.galo_desc;
                animal[3] = R.id.galoId;
                break;
            case 10:
                animal[0] = R.string.abelha;
                animal[1] = R.raw.abelha;
                animal[2] = R.raw.abelha_desc;
                animal[3] = R.id.abelhaId;
                break;
            case 11:
                animal[0] = R.string.galinha;
                animal[1] = R.raw.galinha;
                animal[2] = R.raw.galinha_desc;
                animal[3] = R.id.galinhaId;
                break;
            case 12:
                animal[0] = R.string.baleia;
                animal[1] = R.raw.baleia;
                animal[2] = R.raw.baleia_desc;
                animal[3] = R.id.baleiaId;
                break;
            case 13:
                animal[0] = R.string.golfinho;
                animal[1] = R.raw.golfinho;
                animal[2] = R.raw.golfinho_desc;
                animal[3] = R.id.golfinhoId;
                break;
            case 14:
                animal[0] = R.string.pintinho;
                animal[1] = R.raw.pinto;
                animal[2] = R.raw.pinto_desc;
                animal[3] = R.id.pintoId;
                break;
            case 15:
                animal[0] = R.string.cavalo;
                animal[1] = R.raw.cavalo;
                animal[2] = R.raw.cavalo_desc;
                animal[3] = R.id.cavaloId;
                break;
            case 16:
                animal[0] = R.string.sapo;
                animal[1] = R.raw.sapo;
                animal[2] = R.raw.sapo_desc;
                animal[3] = R.id.sapoId;
                break;
            case 17:
                animal[0] = R.string.passaro;
                animal[1] = R.raw.passaro;
                animal[2] = R.raw.passarinho_desc;
                animal[3] = R.id.passaroId;
                break;
            case 18:
                animal[0] = R.string.rato;
                animal[1] = R.raw.rato;
                animal[2] = R.raw.rato_desc;
                animal[3] = R.id.ratoId;
                break;
            default:
                animal[0] = R.string.erro;
                break;

        }

        return animal;
    }
}
