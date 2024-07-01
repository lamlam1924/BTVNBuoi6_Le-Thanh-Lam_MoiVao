package kiemtradinhki;

import java.util.ArrayList;

public class KhachSan {

    private ArrayList<Nguoi> danhSachNguoiThuePhong;
    private int soNgayThue;
    private String loaiPhong;

    public KhachSan( int soNgayThue, String loaiPhong) {
        this.soNgayThue = soNgayThue;
        this.loaiPhong = loaiPhong;
        this.danhSachNguoiThuePhong = new ArrayList<>();
    }

    public int getSoNgayThue() {
        return soNgayThue;
    }

    public void setSoNgayThue(int soNgayThue) {
        this.soNgayThue = soNgayThue;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public ArrayList<Nguoi> getDanhSachNguoiThuePhong() {
        return danhSachNguoiThuePhong;
    }

    public void setDanhSachNguoiThuePhong(ArrayList<Nguoi> danhSachNguoiThuePhong) {
        this.danhSachNguoiThuePhong = danhSachNguoiThuePhong;
    }
    
    public void addPerson(Nguoi person){
        this.danhSachNguoiThuePhong.add(person);
    }

    @Override
    public String toString() {
        return "KhachSan{" + "Danh sach nguoi thue phong = " + danhSachNguoiThuePhong + ", So ngay thue = " + soNgayThue + ", Loai phong = " + loaiPhong + '}';
    }

}
