package id.sch.smktelkom_mlg.project2.xirpl30717233235.expinder.Model;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by Shelin on 26/03/2017.
 */

public class Item extends SugarRecord {
    String namaItem;
    Date tanggalBeli;
    Date tanggalExpired;
    Boolean diArsipkan;
    Boolean diFavorit;

    public Item() {

    }

    public Item(String namaItem, Date tanggalBeli, Date tanggalExpired, Boolean diFavorit) {
        this.namaItem = namaItem;
        this.tanggalBeli = tanggalBeli;
        this.tanggalExpired = tanggalExpired;
        this.diArsipkan = false;
        this.diFavorit = diFavorit;
    }
}
