package spslibsys.dom;

import java.io.Serializable;
import java.util.*;

public class CheckOutRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	private LibraryMember member;
	private List<CheckOutRecordEntry> checkOutRecordEntries;

	public CheckOutRecord(LibraryMember member, List<CheckOutRecordEntry> checkOutRecordEntries) {
		this.member = member;
		this.checkOutRecordEntries = checkOutRecordEntries;
	}

	public LibraryMember getMember() {
		return member;
	}

	public List<CheckOutRecordEntry> getCheckOutRecordEntries() {
		return checkOutRecordEntries;
	}

	public void addCheckOutRecordEntry(CheckOutRecordEntry entry) {
		if (checkOutRecordEntries == null)
			checkOutRecordEntries = new ArrayList<>();
		this.checkOutRecordEntries.add(entry);
	}

	public void setCheckOutRecordEntries(List<CheckOutRecordEntry> checkOutRecordEntries) {
		this.checkOutRecordEntries = checkOutRecordEntries;
	}

}
