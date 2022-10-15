package spslibsys.businessLogic.ifusecase;

import syslibsys.dom.CheckOutRecord;

public interface PrintCheckOutRecordUseCase {
	public CheckOutRecord getCheckOutRecord(String memberId);
}
