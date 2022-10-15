package spslibsys.businessLogic.implementation;

import spslibsys.businessLogic.ifusecase.AddBookUseCase;
import spslibsys.businessLogic.ifusecase.AddLibraryMemberUseCase;
import spslibsys.businessLogic.ifusecase.BookCopyUseCase;
import spslibsys.businessLogic.ifusecase.CheckMemberUseCase;
import spslibsys.businessLogic.ifusecase.CheckOutBookUseCase;
import spslibsys.businessLogic.ifusecase.GetAuthorUseCase;
import spslibsys.businessLogic.ifusecase.LogInUseCase;
import spslibsys.businessLogic.ifusecase.PrintCheckOutRecordUseCase;
import spslibsys.businessLogic.ifusecase.SearchBookUseCase;

public class ControllerFactory {
	private ControllerFactory() {
	}

	public static SearchBookUseCase createSearchBookUseCase() {
		SearchBookUseCase useCase = new BookController();
		return useCase;
	}

	public static AddBookUseCase createAddBookUseCase() {
		AddBookUseCase useCase = new BookController();
		return useCase;
	}

	// Added by WinWin
	public static GetAuthorUseCase createGetAuthorController() {
		GetAuthorUseCase useCase = new GetAuthorController();
		return useCase;
	}

	public static BookCopyUseCase createBookCopyUseCase() {
		BookCopyUseCase useCase = new BookCopyController();
		return useCase;
	}

	public static CheckOutBookUseCase createCheckOutBookUseCase() {
		CheckOutBookUseCase useCase = new CheckOutBookController();
		return useCase;
	}

	public static PrintCheckOutRecordUseCase createPrintCheckOutBookUseCase() {
		PrintCheckOutRecordUseCase useCase = new CheckOutBookController();
		return useCase;
	}

	public static CheckMemberUseCase createCheckMemberUseCase() {
		CheckMemberUseCase useCase = new LibraryMemberController();
		return useCase;
	}

	public static LogInUseCase createLogInUseCase() {
		LogInUseCase useCase = new LogInController();
		return useCase;

	}

	public static AddLibraryMemberUseCase createAddLibraryMemberUseCase() {
		AddLibraryMemberUseCase useCase = new LibraryMemberController();
		return useCase;
	}

}
