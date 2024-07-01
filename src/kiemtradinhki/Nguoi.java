package kiemtradinhki;

public class Nguoi {

    private String hoten;
    private int tuoi;
    private String cmnd;

    public Nguoi(String hoten, int tuoi, String cmnd) {
        this.hoten = hoten;
        this.tuoi = tuoi;
        this.cmnd = cmnd;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    @Override
    public String toString() {
        return " Ho ten = " + hoten + ", Tuoi = " + tuoi + ", CMND = " + cmnd;
    }

}
