package librarysystem.business.usecase;

import librarysystem.domain.CheckOutRecord;

public interface PrintCheckOutRecordUseCase {
	public CheckOutRecord getCheckOutRecord(String memberId);
}
