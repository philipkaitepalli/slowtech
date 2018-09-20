package org.jc.kp.service;

import java.util.List;

import org.jc.kp.dao.VoucherDao;
import org.jc.kp.model.Customer;
import org.jc.kp.model.Voucher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("voucherService")
public class VoucherServiceImpl implements VoucherService {

	@Autowired
    private VoucherDao voucherDao;
	
	@Override
	public String createVoucher(Voucher voucher) {
		// TODO Auto-generated method stub
		String ss=voucherDao.createVoucher(voucher);
		return ss;
	}

	@Override
	public void updateVoucher(Voucher voucher) {
		// TODO Auto-generated method stub
		voucherDao.updateVoucher(voucher);
		
	}

	@Override
	public void deleteVoucher(Integer pbId) {
		// TODO Auto-generated method stub
		
		voucherDao.deleteVoucher(pbId);
		
	}

	@Override
	public List<Voucher> findVoucher(Integer pId) {
		// TODO Auto-generated method stub
		return voucherDao.findVoucher(pId);
	}

	@Override
	public List<Voucher> getAll(Long billId) {
		// TODO Auto-generated method stub
		return voucherDao.getAll( billId);
	}

	@Override
	public void deleteVoucher(Customer customer){
		// TODO Auto-generated method stub
		voucherDao.deleteVoucher(customer);
	}

	@Override
	public List<Voucher> getCustBill(Customer customer) {
		// TODO Auto-generated method stub
		return voucherDao.getCustBill(customer);
	}

	@Override
	public List<Voucher> getAll() {
		// TODO Auto-generated method stub
		return voucherDao.getAll();
	}

	@Override
	public Voucher find(Integer pId) {
		// TODO Auto-generated method stub
		return voucherDao.find(pId);
	}

	@Override
	public List<Voucher> findDynamiVoucher(Long billId) {
		// TODO Auto-generated method stub
		return voucherDao.findDynamiVoucher(billId);
	}

}
