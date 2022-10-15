package spslibsys.businessLogic.ifusecase;

import spslibsys.dom.CheckOutRecord;

public interface PrintCheckOutRecordUseCase {
	public CheckOutRecord getCheckOutRecord(String memberId);
}
