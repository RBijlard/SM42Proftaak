package com.example.roel.qstudent;

import android.support.annotation.Nullable;

import java.util.List;

/**
 * Created by Roel on 02/06/2016.
 */
public class Cijfer {
    public String naamVak;
    public String onderwerp;
    public List<Cijfer> deelcijfers;

    public Cijfer(String naamVak, String onderwerp, @Nullable List<Cijfer> deelcijfers) {
        this.naamVak = naamVak;
        this.onderwerp = onderwerp;

        if (deelcijfers != null) {
            this.deelcijfers = deelcijfers;
        }
    }

    public String getNaamVak() {
        return naamVak;
    }

    public void setNaamVak(String naamVak) {
        this.naamVak = naamVak;
    }

    public String getOnderwerp() {
        return onderwerp;
    }

    public void setOnderwerp(String onderwerp) {
        this.onderwerp = onderwerp;
    }

    public List<Cijfer> getDeelcijfers() {
        return deelcijfers;
    }

    public void setDeelcijfers(List<Cijfer> deelcijfers) {
        this.deelcijfers = deelcijfers;
    }
}
