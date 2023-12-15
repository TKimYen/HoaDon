/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyhoadon;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class HoaDon {
    //SUA THANH TRUYEN DOI SO
//    DanhSachNhanVien nv = new DanhSachNhanVien();
//    DanhSachKhachHang kh = new DanhSachKhachHang();
    private String maHoaDon;
    private ChiTietHoaDon cthd[];
    private int slCTHD;
    private String ngayLap;
    private String maNhanVien;
    private String hoNhanVien;
    private String tenNhanVien;
    private String maKhachHang;
    private String hoKhachHang;
    private String tenKhachHang;
    private double tongTien;
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    Scanner sc = new Scanner(System.in);
    
    public HoaDon() {
    }

    public HoaDon(String maHoaDon, String ngayLap, String maNhanVien, String hoNhanVien, String tenNhanVien, String maKhachHang, String hoKhachHang, String tenKhachHang, Double tongTien, ChiTietHoaDon cthd[]) {
        this.maHoaDon = maHoaDon;
        this.ngayLap = ngayLap;
        this.maNhanVien = maNhanVien;
        this.hoNhanVien = hoNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.maKhachHang = maKhachHang;
        this.hoKhachHang = hoKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.tongTien = tongTien;
        this.cthd = cthd;
    }
    
    public HoaDon(HoaDon hd) {
        this.maHoaDon = hd.maHoaDon;
        this.ngayLap = hd.ngayLap;
        this.slCTHD = hd.slCTHD;
        this.cthd = hd.cthd;
        this.maNhanVien = hd.maNhanVien;
        this.hoNhanVien = hd.hoNhanVien;
        this.tenNhanVien = hd.tenNhanVien;
        this.maKhachHang = hd.maKhachHang;
        this.hoKhachHang = hd.hoKhachHang;
        this.tenKhachHang = hd.tenKhachHang;
        this.tongTien = hd.tongTien;
    }

    
    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public HoaDon(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
////////////// Ham nhap 
    //SUA HAM NHAP: TRUYEN DOI SO, NHAP CTHD
    
    public void nhap(DanhSachHoaDon hd, DanhSachSanPham sp, DanhSachNhanVien nv, DanhSachKhachHang kh){
        HoaDon [] dshd = hd.getHd();
        int stt = 0;
        for(int i = 0; i < dshd.length; i++){
            try{
                if(dshd[i].getMaHoaDon() != null){
                stt++;
                }
            }
            catch(NullPointerException npe){
            }
        }
        maHoaDon = String.format("HD%03d", stt + 1);

        System.out.println("Mã hóa đơn là: " + maHoaDon);
//        System.out.println("Định dạng mã sản phẩm: HD + [XX]");
//        do{
//            System.out.print("Nhập mã hóa đơn: ");
//            maHoaDon = sc.nextLine();
//            if(!maHoaDon.matches("^HD[0-9]{2}$"))
//                System.out.println("Sai số lượng kí tự.");
//        }
//        while(!maHoaDon.matches("^HD[0-9]{2}$"));
        
        System.err.println("\nNgày nhập hoá đơn phải hợp lệ theo cú pháp dd/MM/yyyy. Nếu không sẽ báo lỗi");
		System.err.println();
		do {
			System.out.print("\nNgày lập hoá đơn: ");
			ngayLap = sc.nextLine();
			
			if(!CheckDate(ngayLap)) {
				System.err.println("Ngày tháng năm không hợp lệ. Xin mời nhập lại!");
//				System.err.println();
			}	
		}while(!CheckDate(ngayLap));
                
//      NHẬP MÃ NV VÀ TRUYỀN HỌ TÊN VÀO
        do {
//            nv.DocFileJava("NhanVien.txt");
            nv.XuatDanhSachNV();
            System.out.print("Nhập mã nhân viên phụ trách: ");
            maNhanVien = sc.nextLine();
            if(nv.Search_Exist(maNhanVien)) {
                hoNhanVien = nv.TruyenDuLieu_NV_Ho(maNhanVien);
                tenNhanVien = nv.TruyenDuLieu_NV_Ten(maNhanVien);
            }
            else{
                System.err.println("\nMã nhân viên không có trong danh sách!");
            }
	}while(nv.Search_Exist(maNhanVien) != true);
        
//      NHẬP MÃ KH VÀ TRUYỀN HỌ TÊN VÀO 
	do {
//            kh.DocFileJava("KhachHang.txt");
            kh.XuatDanhSach();
            System.out.print("Nhập mã khách hàng: ");
            maKhachHang = sc.nextLine();
            tenKhachHang = kh.TruyenDuLieu_KH_Ten(maKhachHang);
            if(kh.Search_Exist(maKhachHang)){
                tenKhachHang = kh.TruyenDuLieu_KH_Ten(maKhachHang);
                hoKhachHang = kh.TruyenDuLieu_KH_Ho(maKhachHang);
            }
            else
		System.err.println("\nMã khách hàng mà bạn vừa nhập không có trong danh sách!");
	}while(kh.Search_Exist(maKhachHang) != true);
        
        System.out.println("Nhập số lượng chi tiết hóa đơn");
        slCTHD = sc.nextInt();
        sc.nextLine();
        cthd = new ChiTietHoaDon[slCTHD];
        for(int i = 0; i < slCTHD; i++){
            cthd[i] = new ChiTietHoaDon();
            cthd[i].nhap(sp, maHoaDon);
        }
        tinhTongTien();
    }
    
    public boolean CheckDate(String date) {
        df.setLenient(false);
	try {
            df.parse(date);
	}
        catch(ParseException e) {
            return false;
	}
	return true;
    }
    
    public void xuat() {
		System.out.format(" %10s | %13s | %30s | %25s | %15s | %15s ||\n", maHoaDon, maKhachHang, tenKhachHang, maNhanVien, ngayLap, tongTien);
                System.out.println("Thông tin chi tiết hóa đơn:");
                                    System.out.format("|| %4s | %10s | %10s | %30s | %25s | %15s ||\n", "STT", "MÃ HOÁ ĐƠN", "MÃ SẢN PHẨM", "SỐ LƯỢNG", "ĐƠN GIÁ", "THÀNH TIỀN");
                                    for(int j = 0; j < slCTHD; j++) {
                                        System.out.format("|| %4s |", (j + 1));
                                        if(cthd[j] != null);
                                            cthd[j].xuat();
                                    }       
        }
        
        public void tinhTongTien(){
            for(int i = 0; i < slCTHD; i++)
                tongTien += cthd[i].getThanhTien();
        }
 
    public void GhiFile(String filename) throws IOException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename, Boolean.TRUE));
		dos.writeUTF(maHoaDon);
                dos.writeUTF(ngayLap);
                dos.writeUTF(maNhanVien);
                dos.writeUTF(hoNhanVien);
                dos.writeUTF(tenNhanVien);
		dos.writeUTF(maKhachHang);
                dos.writeUTF(hoKhachHang);
                dos.writeUTF(tenKhachHang);
                dos.writeDouble(tongTien);
                dos.writeInt(slCTHD);
                for(int i = 0; i < slCTHD; i++)
                    cthd[i].GhiFile(filename);       
		dos.close();
    }
    
}
