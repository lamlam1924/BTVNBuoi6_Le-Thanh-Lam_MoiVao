package kiemtradinhki;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Main extends Menu {

    ArrayList<Nguoi> listPerson = new ArrayList<>();
    ArrayList<KhachSan> listKS = new ArrayList<>();
    static String[] mainArr = {"Them khach thue phong", "Xoa khach thue phong", "Tinh tien thue phong", "Nhap so khac de thoat"};
    Scanner sc = new Scanner(System.in);

    public Main() {
        super("Quan li khach san: ", mainArr);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                addNewPerson();
                System.out.println("");
                break;
            case 2:
                removePerson();
                System.out.println("");
                break;
            case 3:
                tinhTienPhong();
                System.out.println("");
                break;

        }
    }

    public static void main(String[] args) {
        Main test = new Main() {
        };
        test.run();
    }

    public void addNewPerson() {
        System.out.print("Nhap ho va ten: ");
        String ten = sc.nextLine();
        System.out.print("Nhap tuoi: ");
        Integer tuoi = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap so cmnd: ");
        String cmnd = sc.nextLine();

        Nguoi newperson = new Nguoi(ten, tuoi, cmnd);
        listPerson.add(newperson);

        System.out.print("Nhap so ngay thue: ");
        Integer snt = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap loai phong (A/B/C): ");
        String loai = sc.nextLine();

        KhachSan newKhach = new KhachSan(snt, loai);
        newKhach.addPerson(newperson);
        listKS.add(newKhach);
    }

    public void removePerson() {
        System.out.print("Nhap so CMND cua khach can xoa: ");
        String socmnd = sc.nextLine();
        Nguoi nguoiToRemove = null;
        for (Nguoi list : listPerson) {
            if (list.getCmnd().equals(socmnd)) {
                nguoiToRemove = list;
                break;
            }

        }
        if (nguoiToRemove != null) {
            listPerson.remove(nguoiToRemove);
            for (KhachSan list : listKS) {
                list.getDanhSachNguoiThuePhong().remove(nguoiToRemove);

            }
            listKS.removeIf(list -> list.getDanhSachNguoiThuePhong().isEmpty());
            System.out.println("Da xoa khach thue co CMND: " + socmnd);
        } else {
            System.out.println("Khong tim thay khach co CMND: " + socmnd);
        }
    }

    public void display() {
        if (listKS.isEmpty()) {
            System.out.println("Hien khong co ai thue phong.");
        } else {
            for (KhachSan list : listKS) {
                System.out.println(list);
            }
        }
    }

    public void tinhTienPhong() {
        System.out.print("Nhap so cmnd cua khach: ");
        String cmnd = sc.nextLine();
        boolean found = false;

        for (KhachSan listks : listKS) {
            for (Nguoi listng : listks.getDanhSachNguoiThuePhong()) {
                if (listng.getCmnd().equals(cmnd)) {
                    int tien = 0;

                    if (listks.getLoaiPhong().equals("A")) {
                        tien = listks.getSoNgayThue() * 500;
                    } else if (listks.getLoaiPhong().equals("B")) {
                        tien = listks.getSoNgayThue() * 300;
                    } else {
                        tien = listks.getSoNgayThue() * 100;
                    }

                    System.out.println("Tien thue phong cua khach la: " + tien+"$");
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay khach co CMND: " + cmnd);
        }
    }
}
