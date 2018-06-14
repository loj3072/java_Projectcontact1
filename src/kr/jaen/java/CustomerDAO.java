package kr.jaen.java;

import java.util.*;
import java.io.*;
/** ���� ����Ÿ�� ����, �����ϴ� Ŭ���� */
public class  CustomerDAO{
	private List<Customer> list;
	public CustomerDAO(){
		list=new ArrayList<Customer>(); 
	}

/** ���޵� ���� ������ �߰��Ѵ�.
 * @throws Exception */
	public void addCust( String name,String phone,int hotKey) throws DupException{//���⵵ DupException���� �ٲ��
		Customer c=search(hotKey);
		if (c==null) {
			list.add(new Customer(name, phone, hotKey));
		}else {
			throw new DupException(); //���� �߻�. ������ Ŭ����! VM���� �ƴ϶� �����ڵ� ������ �߻���ų �� �ִ�! -throws�� �˸���~~ //�ٵ� Exception�� �ʹ� super���� ��ȣ�ѵ�... Exception�� ��ӹ޾� ���� �ʿ��� �͸� ����! => DupException
		}
	}
/** ���� ��� ������ �����Ѵ�.*/
	public List<Customer> allCust(){
		return list;
	}
	/** �̸� �˻� �޼ҵ�*/
	public Customer search(String name){
		for(Customer c: list) {
			if(name.equals(c.getName())) return c;
		}
		return null;
	}
	/** ����Ű �˻� �޼ҵ�*/
	public Customer search(int hotKey){ //�����ε�(�޼��� �̸��� ���� �Ķ���Ͱ� Ʋ��)
		for(Customer c: list) {
			if(hotKey==c.getHotKey()) return c;
		}
		return null;
	}
	/** �̸� �˻�, ���� �޼ҵ� */
	public void delete(String name){
		Customer cu=search(name);
		list.remove(cu);
	}
	/** ����Ű�� �˻�, ���� �޼ҵ�*/
	public void delete(int hotKey){
		Customer cu=search(hotKey);
		list.remove(cu);
	}
	/** �̸� �˻��Ͽ� ��ȣ�� �����Ѵ�. �������� ���� ����*/
	public void updateCust( String name,String phone,int hotKey){
		Customer cu=search(name);
		cu.setPhone(phone);
	}
}
