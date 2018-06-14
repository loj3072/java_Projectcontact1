package kr.jaen.java;

import java.util.*;
import java.io.*;
/** 고객의 데이타를 관리, 저장하는 클래스 */
public class  CustomerDAO{
	private List<Customer> list;
	public CustomerDAO(){
		list=new ArrayList<Customer>(); 
	}

/** 전달된 고객의 정보를 추가한다.
 * @throws Exception */
	public void addCust( String name,String phone,int hotKey) throws DupException{//여기도 DupException으로 바꿔야
		Customer c=search(hotKey);
		if (c==null) {
			list.add(new Customer(name, phone, hotKey));
		}else {
			throw new DupException(); //에러 발생. 에러도 클래스! VM만이 아니라 개발자도 에러를 발생시킬 수 있다! -throws로 알리기~~ //근데 Exception은 너무 super여서 모호한데... Exception을 상속받아 내가 필요한 것만 쓰자! => DupException
		}
	}
/** 고객의 모든 정보를 리턴한다.*/
	public List<Customer> allCust(){
		return list;
	}
	/** 이름 검색 메소드*/
	public Customer search(String name){
		for(Customer c: list) {
			if(name.equals(c.getName())) return c;
		}
		return null;
	}
	/** 단축키 검색 메소드*/
	public Customer search(int hotKey){ //오버로딩(메서드 이름이 같고 파라미터가 틀린)
		for(Customer c: list) {
			if(hotKey==c.getHotKey()) return c;
		}
		return null;
	}
	/** 이름 검색, 제거 메소드 */
	public void delete(String name){
		Customer cu=search(name);
		list.remove(cu);
	}
	/** 단축키를 검색, 제거 메소드*/
	public void delete(int hotKey){
		Customer cu=search(hotKey);
		list.remove(cu);
	}
	/** 이름 검색하여 번호를 수정한다. 동명이인 없음 가정*/
	public void updateCust( String name,String phone,int hotKey){
		Customer cu=search(name);
		cu.setPhone(phone);
	}
}
