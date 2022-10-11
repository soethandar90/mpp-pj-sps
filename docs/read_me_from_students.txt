1. According to the problem requirements, when we run the app it opens the login page and from there user
    can enter his ID and password. Then he presses submit which causes the system to search the credentials
    from the data store. If this user exists it opens the next page, otherwise it shows error.

2. User can be Librarian, Admin or Both. If you want to be admin you should submit with ID: admin, and password: 123
    then, you can add new member and new book to the system, but can not check out book. If the user is both admin and
    librarian he/she can also check out. If you want to be librarian you should submit with ID: member and password: 123456
    he can check out books.

3. Librarian can check out books if he enters the member ID and ISBN number correctly, otherwise system presents error.
    If the requested book and member ID are found then librarian can create new record entry to this member.

4.  Admin can add new copies to the existing book by looking for the ISBN of that book.

    Extra Use Cases:
5. Admin can add new book to the library collection by pressing addBook section in Books page. Then he will be asked for
    the necessary fields for adding new book.

6. When user logins as a Librarian he can print the checkout record for a particular user by entering his/her member ID
    in a checkout record page, the system searches for ID and shows the record. If librarian prints this record it prints
    in a console.
    
    github url: https://github.com/winongit/mpp-library-project
    