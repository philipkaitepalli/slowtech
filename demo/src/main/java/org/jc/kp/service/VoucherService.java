package org.jc.kp.service;

import java.util.List;

import org.jc.kp.model.Customer;
import org.jc.kp.model.Voucher;

public interface VoucherService {
	public String createVoucher(Voucher voucher);
    public void updateVoucher(Voucher voucher);
	public void deleteVoucher(Integer pId);
	public Voucher find(Integer pId);
	public List<Voucher> findVoucher(Integer pId);
	public List<Voucher> getAll(Long billId);
	/**
	 * returns customer based voucher
	 * customer
	 * @param customerId
	 */
	public void deleteVoucher(Customer customer);
	/**
	 * returns list of voucher 
	 * performs delete operation and edit operation
	 * @return
	 */
	public List<Voucher> getAll() ;

	public List<Voucher> getCustBill(Customer customer);
}
