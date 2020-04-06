package io.hei.megaboss.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Player {
    //Constructeur du joueur

    private int idPlayer;
    private String pseudo;



    public Player(int _idPlayer, String _pseudo){
        this.idPlayer=_idPlayer;
        this.pseudo=_pseudo;
    }
}
