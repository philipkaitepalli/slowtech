package org.jc.kp.dao;

import java.util.List;

import org.jc.kp.model.Customer;
import org.jc.kp.model.Voucher;

public interface VoucherDao {
	public String createVoucher(Voucher voucher);
    public void updateVoucher(Voucher voucher);
	public void deleteVoucher(Integer pId);
	public Voucher find(Integer pId);
	public List<Voucher> findVoucher(Integer pId);
	public List<Voucher> getAll(Long billId);
	public void deleteVoucher(Customer customer);
	public List<Voucher> getAll() ;
	public List<Voucher> getCustBill(Customer customer);
}
