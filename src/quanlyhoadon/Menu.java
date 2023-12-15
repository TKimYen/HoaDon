/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyhoadon;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Menu {
    private DanhSachHoaDon dshd;
    private DanhSachSanPham dssp;
    private DanhSachNhanVien dsnv;
    private DanhSachKhachHang dskh;
    private DanhSachNhaCungCap dsncc;
    private DanhSachPhieuNhapHang dspn;
    Scanner sc = new Scanner(System.in);

    public Menu() {
        dshd = new DanhSachHoaDon();
        dssp = new DanhSachSanPham();
        dsnv = new DanhSachNhanVien();
        dskh = new DanhSachKhachHang();
        dsncc = new DanhSachNhaCungCap(); 
        dspn = new DanhSachPhieuNhapHang();
    }
    
    public void docFileTongHop() throws FileNotFoundException{
        dshd.DocFileJava("HoaDon.txt");
        dsnv.DocFileJava("nhanvien.txt");
        dskh.DocFileJava("khachhang.txt");
        dsncc.DocFileJava("nhacungcap.txt");
        dspn.DocFileJava("PhieuNhapHang.txt");
    }
    
    public void ghiFileTongHop() throws FileNotFoundException{
        dshd.GhiFileJava("HoaDon.txt");
        dsnv.GhiFileJava("nhanvien.txt");
        dskh.GhiFileJava("khachhang.txt");
        dsncc.GhiFileJava("nhacungcap.txt");
        dspn.GhiFileJava("PhieuNhapHang.txt");
    }
    
    public void menu() throws FileNotFoundException{
        docFileTongHop(); //đọc toàn bộ dữ liệu vào các mảng để thực hiện quản lý
        int luaChon;
        loop:
            while(true){
                System.out.println("\t\t\t\t\t======BẢNG LỰA CHỌN======");
                System.out.println("\t\t\t\t\t1. Quản lý sản phẩm.");
                System.out.println("\t\t\t\t\t2. Quản lý nhân viên.");
                System.out.println("\t\t\t\t\t3. Quản lý khách hàng.");
                System.out.println("\t\t\t\t\t4. Quản lý nhà cung cấp.");
                System.out.println("\t\t\t\t\t5. Quản lý hóa đơn.");
                System.out.println("\t\t\t\t\t6. Quản lý nhập hàng.");
                System.out.println("\t\t\t\t\t7. Thoát khỏi chương trình.");
                System.out.print("Mời nhập lựa chọn của bạn: ");
                luaChon = sc.nextInt();
                sc.nextLine();
                switch(luaChon){
                    case 1:
                        dssp.ThaoTac();
                        break;
                    case 2:
                        dsnv.ThaoTac();
                        break;
                    case 3:
                        dskh.ThaoTac();
                        break;
                    case 4:
                        dsncc.ThaoTac();
                        break;
                    case 5:
                        dshd.quanLy(dshd, dssp, dsnv, dskh);
                        break;
                    case 6:
                        dspn.ThaoTac();
                        break;
                    case 7:
                        ghiFileTongHop();
                        break loop;
                    default:
                        System.out.println("Bạn đã nhập sai lựa chọn!");
                        break;  
                }                
            }
        
    }
}
