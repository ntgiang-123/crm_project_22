package crm_project_22.service;

import java.util.List;

import crm_project_22.entity.LoaiThanhVien;
import crm_project_22.repository.LoaiThanhVienRepository;

public class RoleService {

	 private LoaiThanhVienRepository loaiThanhVienRepository = new LoaiThanhVienRepository();
	 
	 public boolean checkRole(String ten, String mota) {
		 
		 int count = loaiThanhVienRepository.Insert(ten, mota);
		 
		 return count > 0;
	 }
}
