package crm_project_22.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crm_project_22.config.MysqlConfig;
import crm_project_22.entity.LoaiThanhVien;
import crm_project_22.entity.NguoiDung;

public class LoaiThanhVienRepository {

	public int Insert(String ten, String mota) {
		
		//chuẩn bị câu query
		String query ="INSERT INTO LoaiThanhVien (ten,mota) VALUES (?, ?)";
		
		//Mở kết nối tới CSDL
		Connection connection = MysqlConfig.getConnection();
		
//		List<LoaiThanhVien> listThanhVien = new ArrayList<LoaiThanhVien>();
		
        int count = 0;    
		try {
//			Truyền câu query vào Connection
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, ten);
			statement.setString(2, mota);
			
//			thực thi câu query
			/**
			 * executeQuery : Khi câu truy vấn là câu lấy dữ liệu Select
			 * executeUpdate : Không phải là câu lấy dữ liệu. Insert, Delete, Update ...
			 */
			 count = statement.executeUpdate();
			
//			duyệt dữ liệu từ resultSet
//			while(resultset.next()) {
//				LoaiThanhVien loaithanhvien = new LoaiThanhVien();
//				loaithanhvien.setId(resultset.getInt("id"));
//				loaithanhvien.setTen(resultset.getString("ten"));
//				loaithanhvien.setMota(resultset.getString("mota"));
//				
//				listThanhVien.add(loaithanhvien);
//			}
			
		} catch (SQLException e) {
			System.out.println("Lỗi thực thi câu query" + e.getLocalizedMessage());
		} finally {
			
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					
					System.out.println("Lỗi đóng kết nối" + e.getLocalizedMessage());
				}
			}
		}
	
		 return count;
	}
	
	public ArrayList<LoaiThanhVien> getAllLoaiThanhVien(String tenQuyen, String moTa){
		
//		chuẩn bị câu query 
		String query = "SELECT * \r\n"
				+ "FROM LoaiThanhVien ltv\r\n"
				+ "WHERE ltv.ten= ? AND ltv.mota= ?";
		
//		Mở kết nối
		Connection connection = MysqlConfig.getConnection();
		List<LoaiThanhVien> listLoaiThanhVien = new ArrayList<LoaiThanhVien>();
		
		try {
//			Truyền câu query vào Connection
			PreparedStatement statement = connection.prepareStatement(query);
			
//			Truyền giá trị tham số vào câu query nếu có
			statement.setString(1, tenQuyen); //Lưu ý: setString, setInt ... phải tùy vào kiểu dữ liệu của cột đang so sánh tham số
			statement.setString(2, moTa);
			
//			thực thi câu query
			/**
			 * executeQuery : Khi câu truy vấn là câu lấy dữ liệu Select
			 * executeUpdate : Không phải là câu lấy dữ liệu. Insert, Delete, Update ...
			 */
			ResultSet resultset = statement.executeQuery();
			
//			duyệt dữ liệu từ resultSet
			while(resultset.next()) {
				LoaiThanhVien loaiThanhVien  = new LoaiThanhVien();
				//int id  = resultset.getInt("id"); //lấy giá trị của cột id trong CSDL khi duyệt qua từng dòng
				loaiThanhVien.setId(resultset.getInt("id"));
				loaiThanhVien.setTen(resultset.getString("ten"));
				loaiThanhVien.setMota(resultset.getString("mota"));
				
				listLoaiThanhVien.add(loaiThanhVien);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Lỗi thực thi câu query" + e.getLocalizedMessage());
		} finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Lỗi đóng kết nối" + e.getLocalizedMessage());
				}
			}
		 } 
		
		return (ArrayList<LoaiThanhVien>) listLoaiThanhVien;
	} 
	
}
