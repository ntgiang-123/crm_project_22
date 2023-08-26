package crm_project_22.service;

import java.util.List;

import crm_project_22.entity.NguoiDung;
import crm_project_22.repository.NguoiDungRepository;

/**
 * 
 * @author ntgiang
 * Tên Class của Service phải thể hiện nó xử lý logic code cho controller nào
 * ví dụ: LoginController thì sẽ có LoginService
 * 
 * -Tên hàm trong Service phải đặt gợi nhớ tính năng đang xử lý
 */
public class LoginService {
	
	private NguoiDungRepository nguoiDungRepository = new NguoiDungRepository();

	public boolean checkLogin(String email, String password) {
		List<NguoiDung> listNguoiDung = nguoiDungRepository.findByEmailAndPassword(email, password);
		
		return listNguoiDung.size() > 0;
	}
}
