package com.example.esamefinaleandroid.entitita;

import android.os.Parcel;
import android.os.Parcelable;

public class Persona implements Parcelable {

    private String nome;
    private String cognome;
    private Integer eta;
    private String telefono;
    private Character sesso;
    Citta citta;

    public Persona(String nome, String cognome, Integer eta, String telefono, Character sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.telefono = telefono;
        this.sesso = sesso;
    }

    public Persona(String nome, String cognome, Integer eta, String telefono, Character sesso, Citta citta) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.telefono = telefono;
        this.sesso = sesso;
        this.citta = citta;
    }

    protected Persona(Parcel in) {
        nome = in.readString();
        cognome = in.readString();
        if (in.readByte() == 0) {
            eta = null;
        } else {
            eta = in.readInt();
        }
        telefono = in.readString();
        int tmpSesso = in.readInt();
        sesso = tmpSesso != Integer.MAX_VALUE ? (char) tmpSesso : null;
        citta = in.readParcelable(Citta.class.getClassLoader());
    }

    public static final Creator<Persona> CREATOR = new Creator<Persona>() {
        @Override
        public Persona createFromParcel(Parcel in) {
            return new Persona(in);
        }

        @Override
        public Persona[] newArray(int size) {
            return new Persona[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Integer getEta() {
        return eta;
    }

    public void setEta(Integer eta) {
        this.eta = eta;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Character getSesso() {
        return sesso;
    }

    public void setSesso(Character sesso) {
        this.sesso = sesso;
    }

    public Citta getCitta() {
        return citta;
    }

    public void setCitta(Citta citta) {
        this.citta = citta;
    }

    public static Creator<Persona> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nome);
        parcel.writeString(cognome);
        if (eta == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(eta);
        }
        parcel.writeString(telefono);
        parcel.writeInt(sesso != null ? (int) sesso : Integer.MAX_VALUE);
        parcel.writeParcelable(citta, i);
    }
}
