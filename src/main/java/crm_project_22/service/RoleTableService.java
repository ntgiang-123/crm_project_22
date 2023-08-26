package crm_project_22.service;

import java.util.List;

import crm_project_22.entity.LoaiThanhVien;
import crm_project_22.repository.LoaiThanhVienRepository;

/**
 * 
 * @author ntgiang
 * Tên Class của Service phải thể hiện nó xử lý logic code cho controller nào
 * ví dụ: RoleTableController thì sẽ có RoleTableService
 * 
 * -Tên hàm trong Service phải đặt gợi nhớ tính năng đang xử lý
 */
public class RoleTableService {

	LoaiThanhVienRepository loaithanhvienRepository = new  LoaiThanhVienRepository();
	
	public boolean checkRoleTable(String ten, String mota) {
		
		List<LoaiThanhVien> listLoaiThanhVien = loaithanhvienRepository.getAllLoaiThanhVien(ten, mota);
		
		return listLoaiThanhVien.size() > 0;
	}
}
