package Codes;

import javax.swing.table.DefaultTableModel;

public class Sinema{

    public DefaultTableModel sinemaModel;
    private String Cinema_Ad;
    private String Cinema_type;
    private float Cinema_IMDB;
    private Integer Cinema_yil;
    private String Director;

    public Sinema(String ad,String type,float ımdb,Integer yil,String director){
        setCinema_Ad(ad);
        setCinema_type(type);
        setCinema_IMDB(ımdb);
        setCinema_yil(yil);
        setDirector(director);

    }
    public String getCinema_Ad() {
        return Cinema_Ad;
    }

    public void setCinema_Ad(String cinema_Ad) {
        Cinema_Ad = cinema_Ad;
    }

    public String getCinema_type() {
        return Cinema_type;
    }

    public void setCinema_type(String cinema_type) {
        Cinema_type = cinema_type;
    }

    public float getCinema_IMDB() {
        return Cinema_IMDB;
    }

    public void setCinema_IMDB(float cinema_IMDB) {
        Cinema_IMDB = cinema_IMDB;
    }

    public Integer getCinema_yil() {
        return Cinema_yil;
    }

    public void setCinema_yil(Integer cinema_yil) {
        Cinema_yil = cinema_yil;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }
}
